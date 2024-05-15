package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "projetista")
@NamedStoredProcedureQuery(
	    name = "Projetista.sp_upt_projetista",
	    procedureName = "sp_upt_projetista",
	    parameters = {
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "email", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "nome", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "usuario", type = String.class),
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "senha", type = String.class)
	    }
	)
@NamedStoredProcedureQuery(
	    name = "Projetista.sp_del_projetista",
	    procedureName = "sp_del_projetista",
	    parameters = {
	        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = Integer.class),
	    }
	)
public class Projetista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
    
	@OneToMany(mappedBy = "projetista")
	private Set<Equipe> equipe;
	
	@OneToOne(mappedBy = "projetista", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Login login;
	
	public Projetista(String email, String nome) {
		super();
		this.email = email;
		this.nome = nome;
	}


}
