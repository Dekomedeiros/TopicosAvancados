package transportadora;
import java.util.Date;

public class Objeto implements Comparable<Objeto>{
	
	private int idObjeto;
	
	private StatusObjeto status;
	
	private double peso;
	
	private Date dataEntrega;
	
	private Date dataCadastro;

	private String idLocalizador;
	
	private String nomeRemetente;

	private String enderecoRemetente;

	private String nomeDestinatario;

	private String enderecoDestinatario;

	private Date dataDeposito;

	public String getNomeRemetente() {
		return nomeRemetente;
	}

	public void setNomeRemetente(String nomeRemetente) {
		this.nomeRemetente = nomeRemetente;
	}

	public String getEnderecoRemetente() {
		return enderecoRemetente;
	}

	public void setEnderecoRemetente(String enderecoRemetente) {
		this.enderecoRemetente = enderecoRemetente;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getEnderecoDestinatario() {
		return enderecoDestinatario;
	}

	public void setEnderecoDestinatario(String enderecoDestinatario) {
		this.enderecoDestinatario = enderecoDestinatario;
	}

	public Date getDataDeposito() {
		return dataDeposito;
	}

	public void setDataDeposito(Date dataDeposito) {
		this.dataDeposito = dataDeposito;
	}

	public int getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(int idObjeto) {
		this.idObjeto = idObjeto;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getIdLocalizador() {
		return idLocalizador;
	}

	public void setIdLocalizador(String idLocalizador) {
		this.idLocalizador = idLocalizador;
	}

	public StatusObjeto getStatus() {
		return status;
	}

	public void setStatus(StatusObjeto status) {
		this.status = status;
	}

	@Override
	public int compareTo(Objeto o) {
		return getDataCadastro().compareTo(o.getDataCadastro());
	}
	
}