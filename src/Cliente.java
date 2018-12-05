import javax.swing.JOptionPane;

public class Cliente extends Pessoa{
	
	public Cliente(String nome, String cpf) {
		this.setNome(nome);
		this.setCpf(cpf);
	}
	
	public static void cadastroCliente() {
		String nome = "";
		String cpf = "";
		Cliente cliente = new Cliente(nome, cpf);

		cliente.setNome(JOptionPane.showInputDialog("Informe o nome do Cliente"));
		cliente.setCpf(JOptionPane.showInputDialog("Informe o CPF do Cliente"));
	}

}
