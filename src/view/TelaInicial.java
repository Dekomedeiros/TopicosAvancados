package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCadastroDePessoas = new JButton("Cadastro de Pessoas");
		btnCadastroDePessoas.setBounds(89, 130, 186, 23);
		btnCadastroDePessoas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPessoas people = new TelaCadastroPessoas();
				people.setVisible(true);
				TelaInicial.this.dispose();
			}
		});
		
		JButton btnCadastroDeVeculos = new JButton("Cadastro de Ve\u00EDculos");
		btnCadastroDeVeculos.setBounds(89, 96, 186, 23);
		btnCadastroDeVeculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroVeiculos tela = new TelaCadastroVeiculos();
				tela.setVisible(true);
				TelaInicial.this.dispose();				
			}
		});
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(89, 62, 186, 23);
		
		JButton btnRelatrios = new JButton("Relat\u00F3rios");
		btnRelatrios.setBounds(89, 164, 186, 23);
		contentPane.setLayout(null);
		contentPane.add(btnCadastroDePessoas);
		contentPane.add(btnCadastroDeVeculos);
		contentPane.add(btnPedidos);
		contentPane.add(btnRelatrios);
	}

}
