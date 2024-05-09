package com.fatec.LBEGerenciadorDeProjetoSimples.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
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
@Table(name = "login")
public class Login {
	
	@Id
    @Column(name = "projetista_id")
    private int id;
	
	@Column(name = "usuario",length = 80, nullable = false)
	private String usuario;
	
	@Column(name = "senha",length = 30, nullable = false)
	private String senha;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "projetista_id")
    private Projetista projetista;
}
