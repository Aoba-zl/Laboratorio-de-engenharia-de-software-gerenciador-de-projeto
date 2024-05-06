package com.fatec.LBEGerenciadorDeProjetoSimples.persistence;

import org.springframework.stereotype.Repository;

import com.fatec.LBEGerenciadorDeProjetoSimples.model.Login;
@Repository
public class LoginDao implements ILogin {
	private GenericDao gDao;
	public LoginDao (GenericDao gDao) {
		this.gDao = gDao;
	}
	@Override
	public boolean verificarLogin(Login login) {
		// TODO Auto-generated method stub
		return false;
	}

}
