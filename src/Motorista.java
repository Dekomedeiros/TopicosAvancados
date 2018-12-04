import javax.swing.JOptionPane;

public class Motorista extends Pessoa {

	public Motorista(String nome, String CNH, String tipoCNH) {
		this.setNome(nome);
		this.setCNH(CNH);
		this.setTipoCNH(tipoCNH);
		
	}
	
	public static void cadastroMotorista() {
		String nome = "";
		String CNH = "";
		String tipoCNH = "";
		Motorista motorista = new Motorista(nome, CNH, tipoCNH);

		motorista.setNome(JOptionPane.showInputDialog("Informe o nome do motorista"));
		motorista.setCNH(JOptionPane.showInputDialog("Informe o número da CNH do motorista"));
		motorista.setTipoCNH(JOptionPane.showInputDialog("Informe o tipo de CNH do motorista"));
	}
}


