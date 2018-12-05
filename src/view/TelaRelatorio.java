package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRelatorio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMotoristaRelatorio;
	private JTextField txtEnderecoRelatorio;
	private JTextField txtNumeroRelatorio;
	private JComboBox comboBoxDia;
	private JComboBox comboBoxMes;
	private JComboBox comboBoxAno;
	private JButton okButton;
	private JButton cancelButton;
	private JComboBox comboBoxTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaRelatorio dialog = new TelaRelatorio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaRelatorio() {

		montaTelaRelatorio();

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtEnderecoRelatorio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo Endereço é obrigatório", "AVISO",
							JOptionPane.WARNING_MESSAGE);
				}
				if (txtNumeroRelatorio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo Número é obrigatório", "AVISO",
							JOptionPane.WARNING_MESSAGE);
				}
				if (txtMotoristaRelatorio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "O campo Motorista é obrigatório", "AVISO",
							JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso", "Cadastro Realizado",
							JOptionPane.INFORMATION_MESSAGE);
					TelaRelatorio.this.dispose();
					TelaInicial inicio = new TelaInicial();
					inicio.setVisible(true);
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRelatorio.this.dispose();
				TelaInicial inicial = new TelaInicial();
				inicial.setVisible(true);
			}
		});
	}

	private void montaTelaRelatorio() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JLabel lblVeiculo = new JLabel("Veiculo");
		lblVeiculo.setBounds(10, 11, 89, 14);
		contentPanel.add(lblVeiculo);
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "Bau", "Carreta", "Van" }));
		comboBoxTipo.setBounds(10, 26, 89, 20);
		contentPanel.add(comboBoxTipo);
		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setBounds(263, 11, 133, 14);
		contentPanel.add(lblMotorista);
		txtMotoristaRelatorio = new JTextField();
		txtMotoristaRelatorio.setBounds(263, 26, 161, 20);
		contentPanel.add(txtMotoristaRelatorio);
		txtMotoristaRelatorio.setColumns(10);
		txtMotoristaRelatorio.setDocument(new teclasPermitidasTexto());
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(10, 134, 67, 14);
		contentPanel.add(lblData);

		comboBoxDia = new JComboBox();
		comboBoxDia.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBoxDia.setBounds(10, 151, 46, 20);
		contentPanel.add(comboBoxDia);
		comboBoxMes = new JComboBox();
		comboBoxMes.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBoxMes.setBounds(69, 151, 46, 20);
		contentPanel.add(comboBoxMes);
		comboBoxAno = new JComboBox();
		comboBoxAno.setModel(new DefaultComboBoxModel(new String[] { "2018" }));
		comboBoxAno.setBounds(125, 151, 49, 20);
		contentPanel.add(comboBoxAno);
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(10, 69, 116, 14);
		contentPanel.add(lblEndereco);
		txtEnderecoRelatorio = new JTextField();
		txtEnderecoRelatorio.setBounds(10, 90, 219, 20);
		contentPanel.add(txtEnderecoRelatorio);
		txtEnderecoRelatorio.setColumns(10);
		txtEnderecoRelatorio.setDocument(new teclasPermitidasTexto());
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(263, 69, 79, 14);
		contentPanel.add(lblNumero);
		txtNumeroRelatorio = new JTextField();
		txtNumeroRelatorio.setBounds(263, 90, 59, 20);
		contentPanel.add(txtNumeroRelatorio);
		txtNumeroRelatorio.setColumns(10);
		txtNumeroRelatorio.setDocument(new teclasPermitidasNumero());
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
