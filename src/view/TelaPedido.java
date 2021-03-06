package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import transportadora.Objeto;
import transportadora.StatusObjeto;
import transportadora.dao.arquivo.ObjetoArquivo;

public class TelaPedido extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNomeRemetente;
	private JTextField txtEnderecoRemetente;
	private JTextField txtNomeDestinatario;
	private JTextField txtEnderecoDestinatario;
	private JTextField txtPeso;
	private JTextField txtCodigoLocalizador;
	private JButton okButton;
	private JButton cancelButton;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaPedido dialog = new TelaPedido();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaPedido() {

		montaTelaPedidos();
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtNomeDestinatario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo Nome do Destinat�rio � obrigat�rio", "AVISO",
							JOptionPane.WARNING_MESSAGE);
				}
				if (txtNomeRemetente.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo Nome do Remetente � obrigat�rio", "AVISO",
							JOptionPane.WARNING_MESSAGE);
				}
				if (txtEnderecoDestinatario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo Endere�o do Destinat�rio � obrigat�rio", "AVISO",
							JOptionPane.WARNING_MESSAGE);
				}
				if (txtEnderecoRemetente.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo Endere�o do Remetente � obrigat�rio", "AVISO",
							JOptionPane.WARNING_MESSAGE);
				}
				if (txtPeso.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo Peso � obrigat�rio", "AVISO",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Objeto objeto = new Objeto();
					
					objeto.setDataCadastro(new Date());
					
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					
					String dataDeposito = comboBox.getSelectedItem().toString() + "/" + comboBox_1.getSelectedItem().toString() + "/" + comboBox_2.getSelectedItem().toString();
					
					try {
						objeto.setDataDeposito(sdf.parse(dataDeposito));
					} catch (ParseException e) {
						e.printStackTrace();
					} 
					
					objeto.setNomeDestinatario(txtNomeDestinatario.getText());
					objeto.setEnderecoDestinatario(txtEnderecoDestinatario.getText());
					
					objeto.setNomeRemetente(txtEnderecoRemetente.getText());
					objeto.setEnderecoRemetente(txtEnderecoRemetente.getText());
					

					if (txtCodigoLocalizador.getText().equals("")) {
						txtCodigoLocalizador.setText(String.valueOf(new Date().getTime()));
					}
					
					objeto.setIdLocalizador(txtCodigoLocalizador.getText());
					
					objeto.setPeso(Double.parseDouble(txtPeso.getText()));
					objeto.setStatus(StatusObjeto.NOVO);
					
					//if(ARQUIVO) { //FIXME implementar um CHECKBOX para saber quando usar o arquivo e quando usar o banco
						ObjetoArquivo objetoArquivo = new ObjetoArquivo();
						objetoArquivo.inserirObjeto(objeto);
					//} else {
						//ObjetoDao objetoDao = new ObjetoDao();
						//objetoDao.inserirObjetoBanco(objeto);
					//}
					
					JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso", "Cadastro Realizado",
							JOptionPane.INFORMATION_MESSAGE);
					TelaPedido.this.dispose();
					TelaInicial inicio = new TelaInicial();
					inicio.setVisible(true);
				}
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPedido.this.dispose();
				TelaInicial inicial = new TelaInicial();
				inicial.setVisible(true);
			}
		});
	}

	private void montaTelaPedidos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNomeDoRemetente = new JLabel("Nome do Remetente");
		lblNomeDoRemetente.setBounds(10, 11, 134, 14);
		contentPanel.add(lblNomeDoRemetente);

		txtNomeRemetente = new JTextField();
		txtNomeRemetente.setBounds(10, 24, 131, 20);
		contentPanel.add(txtNomeRemetente);
		txtNomeRemetente.setColumns(10);
		txtNomeRemetente.setDocument(new teclasPermitidasTexto());

		JLabel lblEnderecoRemetente = new JLabel("Endere\u00E7o do Remetente");
		lblEnderecoRemetente.setBounds(10, 47, 131, 14);
		contentPanel.add(lblEnderecoRemetente);

		txtEnderecoRemetente = new JTextField();
		txtEnderecoRemetente.setBounds(10, 64, 131, 20);
		contentPanel.add(txtEnderecoRemetente);
		txtEnderecoRemetente.setColumns(10);
		txtEnderecoRemetente.setDocument(new teclasPermitidasTexto());

		JLabel lblNomeDoDestinatario = new JLabel("Nome do Destinatario");
		lblNomeDoDestinatario.setBounds(218, 11, 176, 14);
		contentPanel.add(lblNomeDoDestinatario);

		txtNomeDestinatario = new JTextField();
		txtNomeDestinatario.setBounds(215, 24, 134, 20);
		contentPanel.add(txtNomeDestinatario);
		txtNomeDestinatario.setColumns(10);
		txtNomeDestinatario.setDocument(new teclasPermitidasTexto());

		JLabel label = new JLabel("");
		label.setBounds(225, 64, 46, 14);
		contentPanel.add(label);

		JLabel lblEnderecoDestinario = new JLabel("Endereco do Destinatario");
		lblEnderecoDestinario.setBounds(218, 47, 164, 14);
		contentPanel.add(lblEnderecoDestinario);

		txtEnderecoDestinatario = new JTextField();
		txtEnderecoDestinatario.setBounds(218, 64, 131, 20);
		contentPanel.add(txtEnderecoDestinatario);
		txtEnderecoDestinatario.setColumns(10);
		txtEnderecoDestinatario.setDocument(new teclasPermitidasTexto());

		JLabel lblDataDepsito = new JLabel("Data Dep\u00F3sito");
		lblDataDepsito.setBounds(10, 110, 164, 14);
		contentPanel.add(lblDataDepsito);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox.setBounds(10, 124, 44, 20);
		contentPanel.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox_1.setBounds(64, 124, 57, 20);
		contentPanel.add(comboBox_1);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "2018" }));
		comboBox_2.setBounds(131, 124, 59, 20);
		contentPanel.add(comboBox_2);

		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 154, 46, 14);
		contentPanel.add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setBounds(10, 175, 46, 20);
		contentPanel.add(txtPeso);
		txtPeso.setColumns(10);
		txtPeso.setDocument(new teclasPermitidasNumero());

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(218, 124, 46, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblCdigoLocalizador = new JLabel("C\u00F3digo Localizador");
		lblCdigoLocalizador.setBounds(218, 110, 111, 14);
		contentPanel.add(lblCdigoLocalizador);

		txtCodigoLocalizador = new JTextField();
		txtCodigoLocalizador.setBounds(218, 125, 131, 17);
		contentPanel.add(txtCodigoLocalizador);
		txtCodigoLocalizador.setColumns(10);
		txtCodigoLocalizador.setDocument(new teclasPermitidasNumero());

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		okButton = new JButton("Salvar");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		cancelButton = new JButton("Cancelar");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
}
