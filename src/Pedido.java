import java.util.Date;
import java.util.Set;

public class Pedido {
	
	private int idPedido;
	
	private Pessoa cliente;
	
	private Set<Objeto> objetos;

	private Date dataEntradaPedido;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public Set<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(Set<Objeto> objetos) {
		this.objetos = objetos;
	}

	public Date getDataEntradaPedido() {
		return dataEntradaPedido;
	}

	public void setDataEntradaPedido(Date dataEntradaPedido) {
		this.dataEntradaPedido = dataEntradaPedido;
	}
	
	
	
	
	

}
