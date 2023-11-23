INSERT INTO tb_paciente(cpf, email, nome, telefone) VALUES ('123.123.123-4', 'joaovictordonato2@gmail.com', 'Ashnael Loke', '(11) 99443-2321');
INSERT INTO tb_paciente(cpf, email, nome, telefone) VALUES ('574.568.968-3', 'joaovictordonato2@gmail.com', 'Christina Loke', '(11) 99443-5423');
INSERT INTO tb_paciente(cpf, email, nome, telefone) VALUES ('134.159.357-2', 'joaovictordonato2@gmail.com', 'Elizeu Loke', '(11) 99443-6985');

INSERT INTO tb_hospital(nome, endereco) VALUES ('Sao Camilo', 'Avenida Pompeia, 1178');
INSERT INTO tb_hospital(nome, endereco) VALUES ('Hospital das Clinicas', ' Rua Dr. Ovídio Pires de Campos, 225');

INSERT INTO tb_funcionario(nome, telefone, tipo_funcionario, hospital_id) VALUES ('Jose Luiz Datena','MEDICO' ,'4002-8922', 1);

--INSERT INTO tb_consulta(exame, data_exame, diagnostico, receita, status, funcionario_id, hospital_id, paciente_cpf) VALUES ('Raio-X', '19-11-2023 00:00:00.0000', 'Ernea de Disco', 'Tramal', 'REALIZADO', 1, 1, '123.123.123-4');
--INSERT INTO tb_consulta(exame, data_exame, diagnostico, receita, status, funcionario_id, hospital_id, paciente_cpf) VALUES ('Raio-X', '13-11-2023 00:00:00.0000', 'Pneumonia', 'Lorazepan', 'MARCADO', 1, 2, '574.568.968-3');
