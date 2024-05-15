		package com.fatec.LBEGerenciadorDeProjetoSimples.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.NamedNativeQuery;
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
@NamedNativeQuery(
		name = "Login_fn_login",
		query = "SELECT * FROM fn_login(?1)",
		resultClass = Login.class
)
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projetista_id", nullable = false)
    private int id;
	
	@Column(name = "usuario",length = 80, nullable = false, unique = true)
	private String usuario;
	
	@Column(name = "senha",length = 30, nullable = false)
	private String senha;
	
	@OneToOne
	@JoinColumn(name = "projetista_id")
	@MapsId
    private Projetista projetista;

	public Login(String usuario, String senha, Projetista projetista) {
		super();
		this.usuario = usuario;
		this.senha = senha;
		this.projetista = projetista;
	}
}
