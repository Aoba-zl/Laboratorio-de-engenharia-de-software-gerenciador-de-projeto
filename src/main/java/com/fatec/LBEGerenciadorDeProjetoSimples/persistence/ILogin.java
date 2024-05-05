package com.fatec.LBEGerenciadorDeProjetoSimples.persistence;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;

public interface ILogin {
	public boolean verificarLogin(Login login);
}
