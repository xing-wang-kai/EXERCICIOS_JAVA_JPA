package models;

import java.math.BigDecimal;
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
@Table(name = "items_pedidos")
public class ItensPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name="preco_unitario")
	public BigDecimal precoUnitario;
	public Long quantidade;

	@ManyToOne(fetch = FetchType.LAZY)
	public Pedido pedido;
	@ManyToOne(fetch = FetchType.LAZY)
	public Produto produto;

	public ItensPedido() {

	}

	public ItensPedido(Long quantidade, Pedido pedido, Produto produto) {
		this.setQuantidade(quantidade);
		this.setPedido(pedido);
		this.setProduto(produto);
		this.precoUnitario = this.produto.getPreco();
	}

	public BigDecimal getValor() {
		return this.precoUnitario.multiply(new BigDecimal(quantidade));
	}
	public Long getQuantidade() {
		return this.quantidade;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setQuantidade(Long valor) {
		this.quantidade = valor;
	}

	public void setPedido(Pedido valor) {
		this.pedido = valor;
	}

	public void setProduto(Produto valor) {
		this.produto = valor;
	}

	@Override
	public String toString() {
		return String.format(new Locale("pt", "BR"),
				"[ id: %d, preco unitario: %d, quantidade: %d, Pedido: %s, Produto: %s ]", this.id, this.precoUnitario,
				this.getQuantidade(), this.getPedido(), this.getProduto());
	}
}
