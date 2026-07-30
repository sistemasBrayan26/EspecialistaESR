insert into cozinha (nome) values ('ITALIANA');
insert into cozinha (nome) values ('TAILANDESA');

insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Thai Gourmet', 10, 1, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Thai Delivery', 9.50, 1, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Tuk Tuk Comida Indiana',  15, 2, utc_timestamp, utc_timestamp);

insert into forma_pagamento (descricao) values ('A vista');
insert into forma_pagamento(descricao) values ('Cartão de Debito');
insert into forma_pagamento (descricao) values ('Cartão de Credito');
insert into forma_pagamento (descricao) values ('PIX');

insert into permissao (nome, descricao) values ('CADASTRAR_CIDADE', 'PERMISSÃO PARA CADASTRO DE CIDADE');
insert into permissao (nome, descricao) values ('CADASTRAR_ESTADO', 'PERMISSÃO PARA CADASTRO DE ESTADO');

insert into estado (nome) values ('GOÍAS');
insert into estado (nome) values ('SÃO PAULO');
insert into estado (nome) values ('RIO DE JANEIRO');
insert into estado (nome) values ('MINAS GERAIS');

insert into cidade (nome, estado_id) values ('ITUMBIARA', 1);
insert into cidade (nome, estado_id) values ('CENTRALINA', 1);
insert into cidade (nome, estado_id) values ('CALDAS NOVAS', 1);
insert into cidade (nome, estado_id) values ('GOIATUBA', 1)
insert into cidade (nome, estado_id) values ('SÃO PAULO', 2);
insert into cidade (nome, estado_id) values ('GUARULHOS', 2);
insert into cidade (nome, estado_id) values ('CAMPINAS', 2);
insert into cidade (nome, estado_id) values ('OSASCO', 2);

insert into cidade (nome, estado_id) values ('RIO DE JANEIRO', 3);
insert into cidade (nome, estado_id) values ('DUQUE DE CAXIAS', 3);
insert into cidade (nome, estado_id) values ('NITEROI', 3);
insert into cidade (nome, estado_id) values ('VOLTA REDONDA', 3);

insert into cidade (nome, estado_id) values ('ARAPORA', 4);
insert into cidade (nome, estado_id) values ('UBERLÃNDIA', 4);
insert into cidade (nome,estado_id) values ('TUPACIGUARA', 4);
insert into cidade (nome, estado_id) values ('CONTAGEM', 4);

insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1,1), (1,2), (1,3), (2,3), (3,2), (3,3);

update restaurante set end_logradouro = 'Rua teste', end_numero = '100', end_bairro = 'Centro', end_complemento = 'Dentro do shopping', end_cep = '75589-696', cidade_id = 1 where id = 1;
update restaurante set end_logradouro = 'Rua Alvorada', end_numero = '200', end_bairro = 'Primavera', end_complemento = 'Na esquina', end_cep = '56894-875', cidade_id = 5 where id = 2;
update restaurante set end_logradouro = 'Av. Castelo Branco', end_numero = '20', end_bairro = 'Alvorada', end_complemento = 'Avenida principal', end_cep = '75589-858', cidade_id = 8 where id = 3;