package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroVeiculos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtMarca;
	private JTextField txtModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroVeiculos dialog = new TelaCadastroVeiculos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaCadastroVeiculos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			txtMarca = new JTextField();
			txtMarca.setToolTipText("");
			txtMarca.setBounds(146, 112, 146, 20);
			contentPanel.add(txtMarca);
			txtMarca.setColumns(10);
			txtMarca.setDocument(new teclasPermitidasTexto());
		}
		{
			JLabel lblMarca = new JLabel("Marca");
			lblMarca.setBounds(146, 95, 46, 14);
			contentPanel.add(lblMarca);
		}
		{
			txtModelo = new JTextField();
			txtModelo.setToolTipText("");
			txtModelo.setBounds(146, 154, 146, 20);
			contentPanel.add(txtModelo);
			txtModelo.setColumns(10);
			txtModelo.setDocument(new teclasPermitidasTexto());
		}
		{
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(146, 138, 46, 14);
			contentPanel.add(lblModelo);
		}
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Van", "Bau", "Caminh\u00E3o"}));
		comboBox.setBounds(169, 64, 56, 20);
		contentPanel.add(comboBox);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(146, 67, 46, 14);
		contentPanel.add(lblTipo);
		{
			JLabel lblAno = new JLabel("Ano");
			lblAno.setBounds(146, 185, 46, 14);
			contentPanel.add(lblAno);
		}
		{
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960"}));
			comboBox_1.setBounds(169, 182, 56, 20);
			contentPanel.add(comboBox_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
							if(txtMarca.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "O campo Marca é obrigatório", "AVISO", JOptionPane.WARNING_MESSAGE);
								if(txtModelo.getText().equals("")) {
									JOptionPane.showMessageDialog(null, "O campo Modelo é obrigatório", "AVISO", JOptionPane.WARNING_MESSAGE);
								}
							}else {
								JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE);
								TelaCadastroVeiculos.this.dispose();
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
						TelaCadastroVeiculos.this.dispose();
						TelaInicial inicial = new TelaInicial();
						inicial.setVisible(true);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
				
			
		}
	}
}
