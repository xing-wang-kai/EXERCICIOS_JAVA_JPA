package models;

import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nome;

	public Cliente() {
	}
	
	public Cliente(String cpf, String nome) {
		this.setCpf(cpf);
		this.setNome(nome);
	}
	
	public String getCpf() {
		return this.cpf;
	}
	public String getNome() {
		return this.nome;
	}
	public void setCpf(String valor) {
		this.cpf = valor;
	}
	public void setNome(String valor) {
		this.nome = valor;
	}
	@Override
	public String toString() {
		return String.format(new Locale("pt", "BR"), "[ id: %d, nome: %s, CPF: %s ]", this.id, this.getNome(), this.getCpf() );
	}
}
