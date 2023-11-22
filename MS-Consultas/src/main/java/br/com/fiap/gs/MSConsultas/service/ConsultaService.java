package br.com.fiap.gs.MSConsultas.service;

import br.com.fiap.gs.MSConsultas.dto.ConsultaDTO;
import br.com.fiap.gs.MSConsultas.exception.ResourceNotFoundException;
import br.com.fiap.gs.MSConsultas.model.Consulta;
import br.com.fiap.gs.MSConsultas.model.StatusEnum;
import br.com.fiap.gs.MSConsultas.repository.ConsultaRepository;
import br.com.fiap.gs.MSConsultas.repository.FuncionarioRepository;
import br.com.fiap.gs.MSConsultas.repository.HospitalRepository;
import br.com.fiap.gs.MSConsultas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private HospitalRepository hospitalRepository;


    @Transactional(readOnly = true)
    public List<ConsultaDTO> findAll() {
        List<Consulta> consultas = consultaRepository.findAll();

        return consultas.stream().map(ConsultaDTO::new).collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public ConsultaDTO findById(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Objeto #" + id + " não encontrado"));

        return new ConsultaDTO(consulta);
    }

    @Transactional
    public ConsultaDTO insert(ConsultaDTO dto) {
        Consulta consulta = new Consulta();
        copyDtoToEntity(dto, consulta);

        funcionarioRepository.save(consulta.getFuncionario());
        pacienteRepository.save(consulta.getPaciente());
        hospitalRepository.save(consulta.getHospital());
        consulta = consultaRepository.save(consulta);


        return new ConsultaDTO(consulta);
    }

    @Transactional
    public ConsultaDTO update(Long id, ConsultaDTO dto) {
        try {
            Consulta entity = consultaRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = consultaRepository.save(entity);
            return new ConsultaDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Objeto #" + id + " não encontrado");
        }
    }

//    REALIZADO,
//    CANCELADO,

    @Transactional
    public void cancelarConsulta(Long id) {
        //recupera o pagamento no DB
        Optional<Consulta> consulta = consultaRepository.findById(id);
        //valida se existe o pagamento
        if (!consulta.isPresent()) {
            throw new ResourceNotFoundException("Recurso não encontrada");
        }
        //seta o status do pagamento como confirmado
        consulta.get().setStatus(StatusEnum.CANCELADO);
        //salva a alteração no DB
        consultaRepository.save(consulta.get());
    }

    @Transactional
    public void realizarConsulta(Long id) {
        //recupera o pagamento no DB
        Optional<Consulta> consulta = consultaRepository.findById(id);
        //valida se existe o pagamento
        if (!consulta.isPresent()) {
            throw new ResourceNotFoundException("Recurso não encontrada");
        }
        //seta o status do pagamento como confirmado
        consulta.get().setStatus(StatusEnum.REALIZADO);
        //salva a alteração no DB
        consultaRepository.save(consulta.get());
    }




    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!consultaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Objeto #" + id + " não encontrado");
        }
        try {
            consultaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ConsultaDTO dto, Consulta entity) {
        entity.setExame(dto.getExame());
        entity.setPaciente(dto.getPaciente());
        entity.setHospital(dto.getHospital());
        entity.setFuncionario(dto.getFuncionario());
        entity.setDataExame(dto.getDataExame());
        entity.setDiagnostico(dto.getDiagnostico());
        entity.setReceita(dto.getReceita());
        entity.setStatus(dto.getStatus());
    }

}
