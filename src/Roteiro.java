import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Roteiro {
	
	private int idRoteiro;
	
	private Date diaDeEntrega;
	
	private Motorista motorista;
	
	private Veiculo veiculo;
	
	private List<Objeto> objetos = new LinkedList<>();

	public int getIdRoteiro() {
		return idRoteiro;
	}

	public void setIdRoteiro(int idRoteiro) {
		this.idRoteiro = idRoteiro;
	}

	public Date getDiaDeEntrega() {
		return diaDeEntrega;
	}

	public void setDiaDeEntrega(Date diaDeEntrega) {
		this.diaDeEntrega = diaDeEntrega;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public List<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(List<Objeto> objetos) {
		this.objetos = objetos;
	}
	
	

}
