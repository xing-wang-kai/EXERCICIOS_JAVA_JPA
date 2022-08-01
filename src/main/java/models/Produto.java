package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "descircao")
	private String descricao;
	@Column(name = "preco")
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;

	public Produto() {
	}

	public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setPreco(preco);
		this.setCategoria(categoria);
	}

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setId(Long valor) {
		this.id = valor;
	}

	public void setNome(String valor) {
		this.nome = valor;
	}

	public void setDescricao(String valor) {
		this.descricao = valor;
	}

	public void setPreco(BigDecimal valor) {
		this.preco = valor;
	}

	public void setCategoria(Categoria valor) {
		this.categoria = valor;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public String toString() {
		return String.format(new Locale("pt", "BR"), 
				"ID: %d , NOME: %s , DESCRICAO: %s , PREÇO: %.2f ,DATACRIACAO: %s , CATEGORIA: %s  /n",
				this.id, this.nome, this.descricao, this.preco,this.dataCadastro, this.categoria);
	}
}
