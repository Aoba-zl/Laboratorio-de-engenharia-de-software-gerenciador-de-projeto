

CREATE DATABASE gerenciador
GO
USE gerenciador

CREATE FUNCTION fn_count_id_atividade(@projetoId INT)
RETURNS INT
AS
BEGIN
	DECLARE @id INT
	
	IF NOT EXISTS (SELECT * FROM atividade WHERE projetoId = @projetoId)
	BEGIN 
		SET @id = 1
	END
	ELSE
	BEGIN
		SELECT TOP 1 @id = id FROM atividade WHERE projetoId = @projetoId	
		ORDER BY id DESC
		
		SET @id = @id + 1
	END
	
	RETURN @id
END

CREATE PROCEDURE sp_del_projeto (@id INT, @id_projetista INT) AS
    DELETE equipe WHERE projetistaId = @id_projetista
    IF NOT EXISTS(SELECT * FROM equipe e WHERE e.projetoId = @id) BEGIN
        DELETE atividade WHERE projetoId = @id
        DELETE projeto WHERE id = @id
    END

CREATE FUNCTION fn_login(@usuario VARCHAR (80))
RETURNS @tabela TABLE (
	projetista_id	INT,
	usuario			VARCHAR(80),
	senha			VARCHAR(30)
) AS BEGIN
	DECLARE @projetista_id	INT,
			@senha			VARCHAR(30)
	SELECT @projetista_id = l.projetista_id, @senha = l.senha
	FROM projetista p, login l
	WHERE p.id = l.projetista_id 
	AND l.usuario = @usuario
	INSERT INTO @tabela VALUES(@projetista_id, @usuario, @senha)
	RETURN
END

CREATE FUNCTION fn_projeto(@id INT)
RETURNS @tabela TABLE (
	id			   			 INT,
	nome			 VARCHAR(80),	
	dataInicial				DATE,
	dataFinal				DATE,
	descricao		 VARCHAR(30)
) AS BEGIN
	DECLARE @id_projeto				INT,
			@nome			VARCHAR(80),
			@dataInicial	DATE,
			@dataFinal		DATE,
			@descricao		VARCHAR(30)
			DECLARE c CURSOR FOR 
				SELECT po.id,po.nome, po.dataInicial, po.dataFinal, po.descricao
				FROM projeto po, projetista pa, equipe e
				WHERE po.id = e.projetoId
				AND e.projetistaId = pa.id
				AND pa.id = @id
			OPEN c
			FETCH NEXT FROM c INTO @id_projeto, @nome, @dataInicial, @dataFinal, @descricao
	WHILE @@FETCH_STATUS = 0 BEGIN

		INSERT INTO @tabela VALUES (@id_projeto, @nome, @dataInicial, @dataFinal, @descricao)

		FETCH NEXT FROM c INTO @id_projeto, @nome, @dataInicial, @dataFinal, @descricao
	END
	CLOSE c
	DEALLOCATE c
	RETURN
END

CREATE PROCEDURE sp_del_projetista (@id	INT)
AS
	DECLARE @id_projeto		 INT
	DECLARE c CURSOR FOR 
		SELECT e.projetoId
		FROM equipe e, projetista p
		WHERE e.projetistaId = @id
	OPEN c
	FETCH NEXT FROM c INTO @id_projeto
	DELETE equipe WHERE projetistaId = @id
	WHILE @@FETCH_STATUS = 0 BEGIN
		IF NOT EXISTS(SELECT * FROM equipe e WHERE e.projetoId = @id_projeto) BEGIN
			DELETE atividade WHERE projetoId = @id_projeto
			DELETE projeto WHERE id = @id_projeto
		END
		FETCH NEXT FROM c INTO @id_projeto
	END
	CLOSE c
	DEALLOCATE c
	DELETE login WHERE projetista_id = @id
	DELETE projetista WHERE id = @id


	
CREATE PROCEDURE sp_upt_projetista(@id INT, @email	VARCHAR(50),@nome VARCHAR(100), @usuario VARCHAR(80), @senha VARCHAR(30)) AS
	UPDATE login SET usuario = @usuario, senha = @senha WHERE projetista_id = @id
	UPDATE projetista SET email = @email, nome = @nome WHERE id = @id


