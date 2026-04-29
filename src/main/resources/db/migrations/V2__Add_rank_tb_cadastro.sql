--V2: Migrations para adicionar a coluna RANK na tabela de cadastros

ALTER TABLE tb_cadastro_de_ninjas
ADD COLUMN rank VARCHAR(255);