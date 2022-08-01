package models;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	public Categoria() {}
	
	public Categoria(String valor) {
		this.setNome(valor);
	}
	public Long getId() {
		return this.id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setID(Long valor) {
		this.id=valor;
	}
	public void setNome(String valor) {
		this.nome = valor;
	}
	
	@Override
	public String toString() {
		return String.format(new Locale("pt", "BR"), "[ ID: %d , NOME: %S ]", this.id, this.nome);
	}
	
}
