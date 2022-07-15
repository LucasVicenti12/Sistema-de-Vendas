package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import controller.LoginDAO;
import model.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class CadastrarTela {
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtCidade;
	private JTextField txtEmail;
	private JPasswordField pswSenha;
	private String nome, telefone, email, cidade, senha;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void iniciarTela(){
		final JFrame frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setSize(300, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("CADASTRAR USU\u00C1RIO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(31, 58, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Telefone:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(31, 97, 68, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Cidade:");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(31, 134, 68, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(31, 171, 46, 14);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(31, 213, 46, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(109, 55, 140, 20);
		panel_1.add(txtNome);
		txtNome.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(109, 94, 140, 20);
		panel_1.add(txtTelefone);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(109, 131, 140, 20);
		panel_1.add(txtCidade);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(109, 168, 140, 20);
		panel_1.add(txtEmail);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(109, 210, 140, 20);
		panel_1.add(pswSenha);
		
		JButton btnCadastrar = new JButton("cadastrar");
		btnCadastrar.setBounds(141, 268, 108, 23);
		
		ActionListener cadastrar = new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					nome = txtNome.getText();
					telefone = txtTelefone.getText();
					cidade = txtCidade.getText();
					email = txtEmail.getText();
					senha = pswSenha.getText();
					
					if (nome.isEmpty() || telefone.isEmpty() || cidade.isEmpty() || email.isEmpty() || senha.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Faltam dados!");
					}else {
						LoginDAO dao = new LoginDAO();
						dao.cadastrarUsuario(new Usuario(nome, telefone, cidade, email, senha));
						JOptionPane.showMessageDialog(null, "Usuario Salvo com Sucesso!");
						MainTela.main(null);
						frame.setVisible(false);
					}
					
				} catch (Exception e2) {
					System.out.println("Erro " + e);
				}
				
			}
		};
		btnCadastrar.addActionListener(cadastrar);
		panel_1.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("voltar");
		btnVoltar.setBounds(31, 268, 89, 23);
		
		ActionListener voltar = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MainTela.main(null);
				frame.setVisible(false);
			}
		};
		btnVoltar.addActionListener(voltar);
		panel_1.add(btnVoltar);
	}
	
	
}
