package models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate date = LocalDate.now();
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	@OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
	@Column(name="items")
	private List<ItensPedido> items = new ArrayList<>();
	@Column(name="valor_total")
	private BigDecimal valorTotal = this.setValorTotal(items);
	
	public Pedido() {

	}
	public Pedido(Cliente cliente) {
		this.setCliente(cliente);
	}
	
	public LocalDate getDate() {
		return this.date;
	}

	public BigDecimal getValorTotal() {
		return this.valorTotal;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public BigDecimal setValorTotal(List<ItensPedido> valor) {
		valor.stream().forEach(v ->{
			this.valorTotal = this.valorTotal.add(v.getProduto().getPreco());
		});
		return valorTotal;
	}

	public void setCliente(Cliente valor) {
		this.cliente = valor;
	}
	public void adicionarItens(ItensPedido item) {
		item.setPedido(this);
		this.items.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}

	@Override
	public String toString() {
		return String.format(new Locale("pt", "BR"), "[ ID: %d, valor Total: %d, DATA: $s, cliente ID: %d, pedidos: %s ]", this.id,
				this.getValorTotal(), this.getDate(), this.getCliente(), this.items);
	}
}
