import javax.swing.JOptionPane;

public class Transportadora {

	public static void main(String[] args) {
		
		int menu2 = 1;

		while(menu2 != 0) {



			int menu = Integer.parseInt(
					JOptionPane.showInputDialog("BEM VINDO A TRANSPORTADORA ENTREGA RÁPIDA, FAVOR ESCOLHER UMA OPÇÃO \n\n"
							+ "1. Cadastrar nova pessoa\n" + "2. Cadastrar novo Veículo\n" + "0. Sair"));

			while(menu != 0) {


				switch (menu) {
				case 1:
					cadastroPessoa();
					menu = 0;
					break;
					
				case 0:
					

				default:
					break;
				}
			}

		}
	}

	public static void cadastroPessoa() {

		int opc = Integer
				.parseInt(JOptionPane.showInputDialog("INFORME O TIPO DE PESSOA QUE GOSTARIA DE CADASTRAR: \n\n"
						+ "1. Motorista\n" + "2. Cliente\n"));


		switch (opc) {
		case 1:
			cadastroMotorista();

			break;

		case 2:
			cadastroCliente();

			break;

		default:
			break;
		}




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

	public static void cadastroCliente() {
		String nome = "";
		String cpf = "";
		Cliente cliente = new Cliente(nome, cpf);

		cliente.setNome(JOptionPane.showInputDialog("Informe o nome do Cliente"));
		cliente.setCpf(JOptionPane.showInputDialog("Informe o CPF do Cliente"));
	}

}
