package com.fatec.LBEGerenciadorDeProjetoSimples.model;

import java.time.LocalDate;
import jakarta.persistence.StoredProcedureParameter;
import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ParameterMode;
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
@Table(name = "projeto")
@NamedStoredProcedureQuery(
		name = "Projeto.sp_del_projeto",
		procedureName = "sp_del_projeto",
		parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN,
					name = "id", type = Integer.class),
		}
)
@NamedNativeQuery(
		name = "Projeto_fn_projeto",
		query = "SELECT * FROM fn_projeto(?1)",
		resultClass = Projeto.class
)
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "nome",length = 40, nullable = false)
	private String nome;
	
	@Column(name = "dataInicial", nullable = false)
	private LocalDate dataInicial;
	
	@Column(name = "dataFinal", nullable = false)
	private LocalDate dataFinal;
	
	@Column(name = "descricao", length = 100,nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "projeto")
	private Set<Atividade> atividades;
	
	@OneToMany(mappedBy = "projeto")
	private Set<Equipe> equipe;
	
	public Projeto(String nome,LocalDate dataInicial, LocalDate dataFinal, String descricao) {
		super();
		this.nome = nome;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.descricao = descricao;
	}

	public Projeto(int id, String nome, LocalDate dataInicial, LocalDate dataFinal, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.descricao = descricao;
	}
	
}
