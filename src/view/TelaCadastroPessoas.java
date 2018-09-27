package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroPessoas extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaCadastroPessoas dialog = new TelaCadastroPessoas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaCadastroPessoas() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnFuncionrios = new JButton("Funcion\u00E1rio");
			btnFuncionrios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaFuncionario cadastroFuncionario = new TelaFuncionario();
					cadastroFuncionario.setVisible(true);
					TelaCadastroPessoas.this.dispose();
				}
			});
			btnFuncionrios.setBounds(115, 71, 180, 36);
			contentPanel.add(btnFuncionrios);
		}
		{
			JButton btnCliente = new JButton("Cliente");
			btnCliente.setBounds(115, 115, 180, 36);
			contentPanel.add(btnCliente);
		}
		{
			JButton btnMotorista = new JButton("Motorista");
			btnMotorista.setBounds(115, 158, 180, 36);
			contentPanel.add(btnMotorista);
		}
	}

}
