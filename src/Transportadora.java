import javax.swing.JOptionPane;

public class Transportadora {

	public static void main(String[] args) {
		
		int menu2 = 1;

		while(menu2 != 0) {

			int menu = Integer.parseInt(
					JOptionPane.showInputDialog("BEM VINDO A TRANSPORTADORA ENTREGA RÁPIDA, FAVOR ESCOLHER UMA OPÇÃO \n\n"
							+ "1. Cadastrar nova pessoa\n" + "2. Cadastrar novo Veículo\n" + "3. Novo Pedido\n"+ "0. Sair"));
			if(menu == 0) {
				menu2 = 0;
			}

			while(menu != 0) {


				switch (menu) {
				case 1:
					cadastroPessoa();
					menu = 0;
					break;
					
				case 2:
					cadastroVeiculo();
					menu = 0;
					break;
					
				case 0:
					
					break;

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
			Motorista.cadastroMotorista();

			break;

		case 2:
			Cliente.cadastroCliente();

			break;

		default:
			break;
		}
	}
	

	public static void cadastroVeiculo() {
		
		int opc2 = Integer.parseInt(JOptionPane.showInputDialog("INFORME O VEÍCULO PARA CADASTRAR: \n\n"
				+ "1. Cadastrar Bau.\n"
				+ "2. Cadastrar Carreta.\n"
				+ "3. Cadastrar Van"));
		
		
		switch (opc2) {
		
		case 1:
			Veiculo2.cadastrarBau();
			break;
			
		case 2: 
			Veiculo2.cadastrarCarreta();
			break;
			
		case 3:
			Veiculo2.cadastrarVan();
			break;

		default:
			break;
		}
	}
}