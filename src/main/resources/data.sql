


INSERT INTO solucoes(data, usuario, resultado, aviso, descricao) VALUES('2019-05-05', 'Mauricio', 'Positivo', 1, 'Solicitação finalizada');
INSERT INTO solucoes(data, usuario, resultado, aviso, descricao) VALUES('2020-03-10', 'Jordana', 'Negativo', 0, 'Solicitação pendente');
INSERT INTO solucoes(data, usuario, resultado, aviso, descricao) VALUES('2021-02-06', 'Rutinaldo', 'Positivo', 0, 'Solicitação aguardando admin para solucionar');
INSERT INTO solucoes(data, usuario, resultado, aviso, descricao) VALUES('2019-05-05', 'Mauricio', 'Negativo', 0, 'Solicitação finalizada');
INSERT INTO solucoes(data, usuario, resultado, aviso, descricao) VALUES('2020-03-10', 'Jordana', 'Negativo', 0, 'Solicitação pendente');
INSERT INTO solucoes(data, usuario, resultado, aviso, descricao) VALUES('2021-02-06', 'Rutinaldo', 'Positivo', 1, 'Solicitação aguardando admin para solucionar');


INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2019-05-05', 'Mauricio', 'Iluminação de rua', 'Cibratel 1', 'José Augusto', 'ABERTO', 1, NULL, 'Problema na Avenida Raul Cury');
INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2018-04-02', 'Mauricio', 'Pavimentação de rua', 'Belas Artes', 'José Augusto', 'ABERTO', 0, NULL, 'Problema de pavimentação');
INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2014-02-25', 'Jordana', 'Poda de árvores', 'Umuarama', 'Carlos Oliveira', 'ABERTO', 0, NULL, 'Munícipe requisita poda de árvores');
INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2021-10-03', 'Rutinaldo', 'Iluminação de rua', 'Cibratel 2', 'Roberto Nebraska', 'ATRASADO', 1, NULL, 'Solicitação necessita de atenção');
INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2021-07-14', 'Jordana', 'Poda de árvores', 'Coronel', 'Leonardo da Paz', 'ATRASADO', 0, NULL, 'Solicitação necessita de atenção');
INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('1997-10-22', 'Rutinaldo', 'Iluminação de rua', 'Tropical', 'Jéssica Azevedo', 'ATRASADO', 0, NULL, 'Solicitação necessita de atenção');

INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2019-05-05', 'Mauricio', 'Iluminação de rua', 'Cibratel 1', 'José Augusto', 'FINALIZADO', 1, 1, 'Problema na Avenida Raul Cury');
INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2019-05-05', 'Mauricio', 'Pavimentação', 'Centro', 'Maria Ribeiro', 'PENDENTE', 0, 2, 'Problema na Avenida Raul Cury');
INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2019-05-05', 'Mauricio', 'Pavimentação', 'Tupy', 'Eunice de Souza', 'PENDENTE', 0, 3, 'Problema na Avenida Raul Cury');
INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2021-05-05', 'Mauricio', 'Barulhos na rua', 'Cibratel 1', 'Mario Sponton', 'FINALIZADO', 1, 4, 'Problema com vizinhos');
INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2019-07-14', 'Jordana', 'Pavimentação', 'Coronel', 'Fernando de Liz', 'FINALIZADO', 0, 5, 'Requisição de pavimentação');
INSERT INTO solicitacoes(data, usuario, assunto, bairro, municipe, status, indicado, solucao_id_fk, descricao) VALUES('2018-02-23', 'Oscar', 'Barulhos', 'Iemanja', 'Beatriz Lestrange', 'PENDENTE', 1, 6, 'Problema com vizinhos');


