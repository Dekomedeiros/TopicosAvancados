package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMotorista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		
		textField = new JTextField();
		textField.setBounds(27, 78, 388, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(27, 61, 46, 14);
		contentPanel.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(27, 171, 388, 20);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(27, 156, 46, 14);
		contentPanel.add(lblEndereo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(460, 171, 116, 20);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(460, 156, 46, 14);
		contentPanel.add(lblNmero);
		
		textField_3 = new JTextField();
		textField_3.setBounds(104, 219, 132, 20);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(104, 202, 46, 14);
		contentPanel.add(lblBairro);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(27, 219, 57, 20);
		contentPanel.add(comboBox);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(27, 202, 46, 14);
		contentPanel.add(lblUf);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(27, 109, 46, 14);
		contentPanel.add(lblCpf);
		
		textField_4 = new JTextField();
		textField_4.setBounds(27, 125, 174, 20);
		contentPanel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(27, 269, 157, 20);
		contentPanel.add(textField_5);
		textField_5.setColumns(10);
		
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
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
