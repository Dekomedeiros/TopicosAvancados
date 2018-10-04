package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMotorista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNomeMotorista;
	private JTextField txtEnderecoMotorista;
	private JTextField intNumeroMotorista;
	private JTextField txtBairroMotorista;
	private JTextField txtCpfMotorista;
	private JTextField intNumeroCnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaMotorista dialog = new TelaMotorista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaMotorista() {
		setBounds(100, 100, 616, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtNomeMotorista = new JTextField();
		txtNomeMotorista.setBounds(27, 78, 388, 20);
		contentPanel.add(txtNomeMotorista);
		txtNomeMotorista.setColumns(10);
		txtNomeMotorista.setDocument(new teclasPermitidasTexto());
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(27, 61, 46, 14);
		contentPanel.add(lblNome);
		
		txtEnderecoMotorista = new JTextField();
		txtEnderecoMotorista.setBounds(27, 171, 388, 20);
		contentPanel.add(txtEnderecoMotorista);
		txtEnderecoMotorista.setColumns(10);
		txtEnderecoMotorista.setDocument(new teclasPermitidasTexto());
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(27, 156, 223, 14);
		contentPanel.add(lblEndereo);
		
		intNumeroMotorista = new JTextField();
		intNumeroMotorista.setBounds(460, 171, 116, 20);
		contentPanel.add(intNumeroMotorista);
		intNumeroMotorista.setColumns(10);
		intNumeroMotorista.setDocument(new teclasPermitidasNumero());
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(460, 156, 46, 14);
		contentPanel.add(lblNmero);
		
		txtBairroMotorista = new JTextField();
		txtBairroMotorista.setBounds(104, 219, 132, 20);
		contentPanel.add(txtBairroMotorista);
		txtBairroMotorista.setColumns(10);
		txtBairroMotorista.setDocument(new teclasPermitidasTexto());
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(104, 202, 46, 14);
		contentPanel.add(lblBairro);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AC ", "AL ", "AP", "AM ", "BA ", "CE ", "DF ", "ES ", "GO ", "MA ", "MT ", "MS ", "MG ", "PA ", "PB ", "PR ", "PE ", "PI ", "RJ ", "RN ", "RS ", "RO ", "RR ", "SC ", "SP ", "SE ", "TO"}));
		comboBox.setBounds(27, 219, 57, 20);
		contentPanel.add(comboBox);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(27, 202, 46, 14);
		contentPanel.add(lblUf);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(27, 109, 46, 14);
		contentPanel.add(lblCpf);
		
		txtCpfMotorista = new JTextField();
		txtCpfMotorista.setBounds(27, 125, 174, 20);
		contentPanel.add(txtCpfMotorista);
		txtCpfMotorista.setColumns(10);
		txtCpfMotorista.setDocument(new teclasPermitidasCpf());
		
		intNumeroCnh = new JTextField();
		intNumeroCnh.setBounds(27, 269, 157, 20);
		contentPanel.add(intNumeroCnh);
		intNumeroCnh.setColumns(10);
		intNumeroCnh.setDocument(new teclasPermitidasNumero());
		
		JLabel lblNmeroCnh = new JLabel("N\u00FAmero CNH");
		lblNmeroCnh.setBounds(27, 255, 86, 14);
		contentPanel.add(lblNmeroCnh);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"B", "B, C", "C"}));
		comboBox_1.setBounds(243, 269, 57, 20);
		contentPanel.add(comboBox_1);
		
		JLabel lblTipoCnh = new JLabel("Tipo CNH");
		lblTipoCnh.setBounds(243, 255, 46, 14);
		contentPanel.add(lblTipoCnh);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(txtNomeMotorista.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo Nome é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
						if(txtCpfMotorista.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo CPF é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
						if(txtEnderecoMotorista.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo Endereço é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
						if(txtBairroMotorista.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo Bairro é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
						if(intNumeroMotorista.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo Número é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
						if(intNumeroCnh.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo Número da CNH é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "O Funcionário foi cadastrado", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE);
							TelaMotorista.this.dispose();
							TelaInicial inicio = new TelaInicial();
							inicio.setVisible(true);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						TelaMotorista.this.dispose();
						TelaCadastroPessoas pessoas = new TelaCadastroPessoas();
						pessoas.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
