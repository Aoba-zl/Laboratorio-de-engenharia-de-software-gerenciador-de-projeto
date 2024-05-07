package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "email", length = 50, nullable = false)
	private String email;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
    @OneToMany(mappedBy = "projetista", targetEntity = Equipe.class)
    private List<Equipe> equipe;
	
    @OneToOne(mappedBy = "projetista",targetEntity = Login.class, cascade = CascadeType.ALL)
    private Login login;
}
