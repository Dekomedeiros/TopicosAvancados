import javax.swing.JOptionPane;

public class Veiculo2 {

	private int idVeiculo;

	private String tipo;

	private String marca;

	private String modelo;

	private int ano;

	private String placa;

	private int numeroObjetos;

	public enum TIPO {
		VAN, CARRETA, BAU
	};

	public Veiculo2() {

	}

	public Veiculo2(TIPO tipo) {
		if (tipo == TIPO.BAU) {
			numeroObjetos = 3;
		}
		if (tipo == TIPO.CARRETA) {
			numeroObjetos = 10;
		}
		if (tipo == TIPO.VAN) {
			numeroObjetos = 1;
		} else {
			JOptionPane.showMessageDialog(null, "Informe o tipo de veículo para cadastro", "AVISO",
					JOptionPane.INFORMATION_MESSAGE);
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

	public static void cadastrarBau() {

		Veiculo2 bau = new Veiculo2();

		bau.setMarca(JOptionPane.showInputDialog("Informe a marca do veículo"));
		bau.setModelo(JOptionPane.showInputDialog("Informe o modelo do veículo"));
		bau.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do veículo")));
		bau.setPlaca(JOptionPane.showInputDialog("Informe a placa do veículo"));
		bau.getTipo();
	}

	public static void cadastrarVan() {

		Veiculo2 van = new Veiculo2();

		van.setMarca(JOptionPane.showInputDialog("Informe a marca do veículo"));
		van.setModelo(JOptionPane.showInputDialog("Informe o modelo do veículo"));
		van.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do veículo")));
		van.setPlaca(JOptionPane.showInputDialog("Informe a placa do veículo"));
		van.getTipo();
	}

	public static void cadastrarCarreta() {

		Veiculo2 carreta = new Veiculo2();

		carreta.setMarca(JOptionPane.showInputDialog("Informe a marca do veículo"));
		carreta.setModelo(JOptionPane.showInputDialog("Informe o modelo do veículo"));
		carreta.setAno(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do veículo")));
		carreta.setPlaca(JOptionPane.showInputDialog("Informe a placa do veículo"));
		carreta.getTipo();
	}
}
