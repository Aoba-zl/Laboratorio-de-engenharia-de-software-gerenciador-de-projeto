package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
public class Projetista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
    @OneToOne(mappedBy = "projetista",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Login login;
    
	@OneToMany(mappedBy = "projetista")
	private Set<Equipe> equipe;
	
	public Projetista(String email, String nome) {
		super();
		this.email = email;
		this.nome = nome;
	}


}
