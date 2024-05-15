package com.fatec.LBEGerenciadorDeProjetoSimples.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
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
@Table(name = "equipe")
@IdClass(EquipeId.class)
public class Equipe {
	
	@Id
	@ManyToOne(targetEntity = Projetista.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "projetistaId", nullable = false)
	private Projetista projetista;
	
	@Id
	@ManyToOne(targetEntity = Projeto.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "projetoId", nullable = false)
	private Projeto projeto;
}
