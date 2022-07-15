package view;
import javax.swing.*;

import controller.LoginDAO;
import model.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainTela {
	private static JPanel panel;
	private static JTextField txtUs;
	private static JPasswordField pswSenha;

	public static void main(String[] args) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dimension = kit.getScreenSize();
		int comprimento = dimension.width;
		int altura = dimension.height;
		
		final JFrame frame = new JFrame("Tela de Login");
		frame.setLocation(comprimento/3, altura/3);
		frame.setResizable(false);
		frame.setSize(300,350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel.setForeground(SystemColor.control);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(31, 57, 105, 14);
		panel_1.add(lblNewLabel_1);
		
		txtUs = new JTextField();
		txtUs.setBounds(125, 55, 129, 20);
		panel_1.add(txtUs);
		txtUs.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(31, 98, 77, 14);
		panel_1.add(lblNewLabel_1_1);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(125, 96, 129, 20);
		panel_1.add(pswSenha);
		
		JButton btnCadUs = new JButton("Se Cadastrar");
		btnCadUs.setBounds(31, 193, 115, 23);
		
		ActionListener cadastrar = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				CadastrarTela ca = new CadastrarTela();
				ca.iniciarTela();
				frame.setVisible(false);
			}
		};
		btnCadUs.addActionListener(cadastrar);
		panel_1.add(btnCadUs);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(165, 193, 89, 23);

		final JLabel lblEx = new JLabel("");
		lblEx.setForeground(Color.RED);
		lblEx.setBounds(31, 168, 223, 14);
		panel_1.add(lblEx);
		
		ActionListener login = new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String nome = txtUs.getText();
				String senha = pswSenha.getText();
				LoginDAO dao = new LoginDAO();
				
				try {
					if(dao.verificarLogin(new Login(nome, senha)) == true) {
						PrincipalTela tp = new PrincipalTela();
						tp.iniciarTela(new Login(nome, senha));
						frame.setVisible(false);
					}else {
						lblEx.setText("Usuário ou Senha inválido!");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		};
		btnLogin.addActionListener(login);
		panel_1.add(btnLogin);
		
	}
}
