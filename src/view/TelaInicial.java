package view;

import java.awt.EventQueue;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import transportadora.Objeto;
import transportadora.Roteiro;
import transportadora.StatusObjeto;
import transportadora.Veiculo;
import transportadora.dao.arquivo.ObjetoArquivo;
import transportadora.dao.arquivo.RoteiroArquivo;
import transportadora.dao.arquivo.VeiculoArquivo;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRelatorios;
	private JButton btnPedidos;
	private JButton btnCadastroDeVeiculos;
	private JButton btnCadastroDePessoas;
	private JButton btnRoteiro;
	private JButton btnForaRoteiro;

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
		
		btnForaRoteiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ObjetoArquivo objetoArquivo = new ObjetoArquivo();
				LinkedList<Objeto> listaObjetos = objetoArquivo.listaObjetoNaoEntreguesPorPrioridade();
				
				String objetos = "";
				for (Objeto objeto : listaObjetos) {
					objetos = objetos + objeto.getIdObjeto() + "\n";
				}
				
				JOptionPane.showMessageDialog(null, objetos, "Objetos Fora do Roteiro", 1);
				
			}
		});
		
		btnRoteiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ObjetoArquivo objetoArquivo = new ObjetoArquivo();
				VeiculoArquivo veiculoArquivo = new VeiculoArquivo();
				
				LinkedList<Objeto> listaObjetos = objetoArquivo.listaObjetoNaoEntreguesPorPrioridade();
				
				LinkedList<Veiculo> veiculos = veiculoArquivo.listaVeiculosPorOrdemDeTamanho();
				
				LinkedList<Roteiro> roteiros = new LinkedList<>();
				
				for (Veiculo veiculo : veiculos) {
					Roteiro roteiro = new Roteiro();
					int qtdAtual = 0 ;
					
					roteiro.setVeiculo(veiculo);
					roteiro.setDataRoteiro(new Date());
					
					for (Objeto objeto : listaObjetos) {
						if(qtdAtual >= veiculo.getTipo().getQtdMaximaTransporte()) {
							break;
						}
						
						if (!objeto.getStatus().equals(StatusObjeto.EM_TRANSPORTE)) {
							objeto.setStatus(StatusObjeto.EM_TRANSPORTE);
							roteiro.getObjetos().add(objeto);
							
							objetoArquivo.alterarObjeto(objeto.getIdObjeto(), StatusObjeto.EM_TRANSPORTE);
						}
						
						qtdAtual++;
					}
					
					roteiros.add(roteiro);
				}

//				if(ARQUIVO) {
				RoteiroArquivo roteiroArquivo = new RoteiroArquivo();
//				roteiroArquivo.salvarRoteiros(roteiros);
//				} else {

				//				}
				
				
				
			}
		});
		
	}

	private void montaTelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 350);
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
		
		btnRoteiro = new JButton("Roteiro");
		btnRoteiro.setBounds(89, 198, 186, 23);
		
		btnForaRoteiro = new JButton("Objetos Fora  do Roteiro");
		btnForaRoteiro.setBounds(89, 232, 186, 23);
		
		contentPane.setLayout(null);
		contentPane.add(btnCadastroDePessoas);
		contentPane.add(btnCadastroDeVeiculos);
		contentPane.add(btnPedidos);
		contentPane.add(btnRelatorios);
		contentPane.add(btnRoteiro);
		contentPane.add(btnForaRoteiro);
	}

}
