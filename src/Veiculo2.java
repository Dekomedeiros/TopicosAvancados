
public class Veiculo2 {

	private int idVeiculo;

	private String tipo;

	private String marca;

	private String modelo;

	private int ano;

	private String placa;
	
	private int numeroObjetos;
	
	public enum TIPO {VAN, CARRETA, BAU};

	public Veiculo2(TIPO tipo) {
		if(tipo == TIPO.BAU) {
			numeroObjetos = 5;
		}
	}
	
	public int getNumeroObjetos() {
		return numeroObjetos;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
