import java.util.Date;

public class Objeto {
	
	private int idObjeto;
	
	private Endereco enderecoDestinatario;
	
	private double peso;
	
	private String codigoLocalizador;
	
	private Date DataEntrega;

	public int getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(int idObjeto) {
		this.idObjeto = idObjeto;
	}

	public Endereco getEnderecoDestinatario() {
		return enderecoDestinatario;
	}

	public void setEnderecoDestinatario(Endereco enderecoDestinatario) {
		this.enderecoDestinatario = enderecoDestinatario;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getCodigoLocalizador() {
		return codigoLocalizador;
	}

	public void setCodigoLocalizador(String codigoLocalizador) {
		this.codigoLocalizador = codigoLocalizador;
	}

	public Date getDataEntrega() {
		return DataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		DataEntrega = dataEntrega;
	}
	
	

}