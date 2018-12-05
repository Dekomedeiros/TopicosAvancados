package transportadora;
import java.util.Date;
import java.util.LinkedList;

public class Roteiro {
	
	private int idRoteiro;
	
	private Veiculo veiculo;
	
	private Date dataRoteiro;
	
	private LinkedList<Objeto> objetos = new LinkedList<>();

	public int getIdRoteiro() {
		return idRoteiro;
	}

	public void setIdRoteiro(int idRoteiro) {
		this.idRoteiro = idRoteiro;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Date getDataRoteiro() {
		return dataRoteiro;
	}

	public void setDataRoteiro(Date dataRoteiro) {
		this.dataRoteiro = dataRoteiro;
	}

	public LinkedList<Objeto> getObjetos() {
		return objetos;
	}

	public void setObjetos(LinkedList<Objeto> objetos) {
		this.objetos = objetos;
	}
	
}
