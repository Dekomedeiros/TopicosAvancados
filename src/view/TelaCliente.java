package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEnd;
	private JTextField intNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaFuncionario dialog = new TelaFuncionario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setName("Cadastro de Funcionários");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaCliente() {
		setBounds(100, 100, 563, 453);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(82, 80, 281, 14);
		contentPanel.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(82, 98, 281, 20);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setDocument(new teclasPermitidasTexto());
		
		JLabel lblIdade = new JLabel("CPF");
		lblIdade.setBounds(82, 129, 281, 14);
		contentPanel.add(lblIdade);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(82, 148, 281, 20);
		contentPanel.add(txtCPF);
		txtCPF.setColumns(10);
		txtCPF.setDocument(new teclasPermitidasCpf());
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setBounds(82, 179, 281, 14);
		contentPanel.add(lblEndereo);
		
		txtEnd = new JTextField();
		txtEnd.setBounds(82, 200, 281, 20);
		contentPanel.add(txtEnd);
		txtEnd.setColumns(10);
		txtEnd.setDocument(new teclasPermitidasTexto());
		
		JLabel lblNmero = new JLabel("N\u00FAmero");
		lblNmero.setBounds(378, 179, 46, 14);
		contentPanel.add(lblNmero);
		
		
		intNum = new JTextField();
		intNum.setBounds(373, 200, 96, 20);
		contentPanel.add(intNum);
		intNum.setColumns(10);
		intNum.setDocument(new teclasPermitidasNumero());
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(82, 231, 281, 14);
		contentPanel.add(lblDataDeNascimento);
		
		JComboBox comboDia = new JComboBox();
		comboDia.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboDia.setBounds(73, 277, 37, 20);
		contentPanel.add(comboDia);
		
		JComboBox comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboMes.setBounds(120, 277, 40, 20);
		contentPanel.add(comboMes);
		
		JComboBox comboAno = new JComboBox();
		comboAno.setModel(new DefaultComboBoxModel(new String[] {"2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960"}));
		comboAno.setBounds(170, 277, 52, 20);
		contentPanel.add(comboAno);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(82, 256, 46, 14);
		contentPanel.add(lblDia);
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setBounds(120, 256, 46, 14);
		contentPanel.add(lblMs);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(170, 256, 46, 14);
		contentPanel.add(lblAno);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txtNome.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "O campo Nome é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
							
							if(txtCPF.getText().equals("")) {
								JOptionPane.showMessageDialog(null, "O campo CPF é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
							}
								if(txtEnd.getText().equals("")) {
									JOptionPane.showMessageDialog(null, "O campo Endereço é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
								}
									if(intNum.getText().equals("")) {
										JOptionPane.showMessageDialog(null, "O campo Número é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
									}
						}else {
							JOptionPane.showMessageDialog(null, "O Funcionário foi cadastrado", "Cadastro Realizado", JOptionPane.INFORMATION_MESSAGE);
							TelaCliente.this.dispose();
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
						TelaCliente.this.dispose();
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
