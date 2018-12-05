package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRelatorios;
	private JButton btnPedidos;
	private JButton btnCadastroDeVeiculos;
	private JButton btnCadastroDePessoas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		
		montaTelaInicial();
		
		//Adiciona Ação Botão Cadastro de Pessoas
		btnCadastroDePessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPessoas people = new TelaCadastroPessoas();
				people.setVisible(true);
				TelaInicial.this.dispose();
			}
		});
		
		//Adiciona Ação Botão Cadastro de Veiculos
		btnCadastroDeVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroVeiculos tela = new TelaCadastroVeiculos();
				tela.setVisible(true);
				TelaInicial.this.dispose();				
			}
		});
		
		//Adiciona Ação Botão Cadastro de Pedidos
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPedido telaPedido = new TelaPedido();
				telaPedido.setVisible(true);
				TelaInicial.this.dispose();
			}
		});
		
		//Adiciona Ação Botão Cadastro de Relatórios
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRelatorio telaRelatorio = new TelaRelatorio();
				telaRelatorio.setVisible(true);
				TelaInicial.this.dispose();
			}
		});
		
	}

	private void montaTelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnCadastroDePessoas = new JButton("Cadastro de Pessoas");
		btnCadastroDePessoas.setBounds(89, 130, 186, 23);
		
		btnCadastroDeVeiculos = new JButton("Cadastro de Ve\u00EDculos");
		btnCadastroDeVeiculos.setBounds(89, 96, 186, 23);
		
		
		btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(89, 62, 186, 23);
		
		btnRelatorios = new JButton("Relat\u00F3rios");
		btnRelatorios.setBounds(89, 164, 186, 23);
		
		contentPane.setLayout(null);
		contentPane.add(btnCadastroDePessoas);
		contentPane.add(btnCadastroDeVeiculos);
		contentPane.add(btnPedidos);
		contentPane.add(btnRelatorios);
	}

}
