insert into cozinha (nome) values ('ITALIANA');
insert into cozinha (nome) values ('TAILANDESA');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana',  15, 2);

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