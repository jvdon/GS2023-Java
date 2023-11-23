package br.com.fiap.gs.MSConsultas.controller;

import br.com.fiap.gs.MSConsultas.dto.ConsultaDTO;
import br.com.fiap.gs.MSConsultas.model.Consulta;
import br.com.fiap.gs.MSConsultas.model.Paciente;
import br.com.fiap.gs.MSConsultas.service.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Path;
import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService service;

    @Operation(summary = "Lista consultas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de consultas ou array vazio caso não existam consultas")
    })
    @GetMapping
    ResponseEntity<List<ConsultaDTO>> findAll() {
        List<ConsultaDTO> dtos = service.findAll();

        return ResponseEntity.ok(dtos);
    }

    @Operation(summary = "Exibe consulta por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna informações sobre a consulta selecionada"),
            @ApiResponse(responseCode = "204", description = "Retorna erro caso a consulta não exista"),

    })
    @GetMapping("/{id}")
    ResponseEntity<ConsultaDTO> findById(@PathVariable @NotNull Long id) {
        ConsultaDTO consulta = service.findById(id);

        return ResponseEntity.ok(consulta);
    }

    @Operation(summary = "Exibe consulta por cpf")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna informações sobre a consulta selecionada"),
            @ApiResponse(responseCode = "204", description = "Retorna erro caso a consulta não exista"),

    })
    @GetMapping("/cpf/{cpf}")
    ResponseEntity<ConsultaDTO> findByPaciente(@PathVariable @NotNull String cpf) {
        ConsultaDTO consulta = service.findByPaciente(cpf);

        return ResponseEntity.ok(consulta);
    }

    @Operation(summary = "Exibe consulta por medico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna informações sobre a consulta selecionada"),
            @ApiResponse(responseCode = "204", description = "Retorna erro caso a consulta não exista"),

    })
    @GetMapping("/medico/{id}")
    ResponseEntity<ConsultaDTO> findByMedico(@PathVariable @NotNull Long id) {
        ConsultaDTO consulta = service.findByMedico(id);

        return ResponseEntity.ok(consulta);
    }

    @Operation(summary = "Insere uma nova consultas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de consultas ou array vazio caso não existam consultas"),
            @ApiResponse(responseCode = "400", description = "Retorna erro caso o erro da requisição esteja mau preenchido"),
    })
    @PostMapping
    ResponseEntity<ConsultaDTO> insert(@RequestBody @NotNull ConsultaDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @Operation(summary = "Atualiza uma consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A consulta foi atualizada"),
            @ApiResponse(responseCode = "400", description = "Retorna erro caso o erro da requisição esteja mau preenchido"),
            @ApiResponse(responseCode = "204", description = "Retorna erro caso a consulta não exista"),

    })
    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDTO> update(@PathVariable @NotNull @Valid Long id, @RequestBody @NotNull ConsultaDTO dto) {
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Cancela uma consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta marcada como cancelada"),
            @ApiResponse(responseCode = "204", description = "Retorna erro caso a consulta não exista"),

    })
    @PatchMapping("/{id}/cancelar")
    public void cancelarConsulta(@PathVariable Long id) {
        service.cancelarConsulta(id);
    }

    @Operation(summary = "Marca uma consulta como realizada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Consulta marcada como realizada"),
            @ApiResponse(responseCode = "204", description = "Retorna erro caso a consulta não exista"),

    })
    @PatchMapping("/{id}/realizar")
    public void realizarConsulta(@PathVariable Long id) {
        service.realizarConsulta(id);
    }

    @Operation(summary = "Deleta uma consulta")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
