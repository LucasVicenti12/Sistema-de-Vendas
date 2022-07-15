package view;

import javax.swing.*;

import model.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalTela {
	/**
	 * @wbp.parser.entryPoint
	 */
	public void iniciarTela(Login login) {
		final JFrame frame = new JFrame("Tela Principal");
		frame.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuPerfil = new JMenu("Perfil");
		menuBar.add(menuPerfil);
		
		JMenuItem perfil = new JMenuItem("Ver meu perfil");
		menuPerfil.add(perfil);
		
		JMenuItem recibos = new JMenuItem("Recibos");
		menuPerfil.add(recibos);
		
		JMenuItem sair = new JMenuItem("Sair");
		
		ActionListener exit = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				frame.setVisible(false);
			}
			
		};
		sair.addActionListener(exit);
		menuPerfil.add(sair);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		frame.getContentPane().add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{41, 209, 0};
		gbl_panel.rowHeights = new int[]{76, 0, 61, 69, 78, 82, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblBemVindo = new JLabel("Olá " + login.getNome());
		lblBemVindo.setForeground(SystemColor.controlDkShadow);
		lblBemVindo.setFont(new Font("Arial Black", Font.PLAIN, 18));
		GridBagConstraints gbc_lblBemVindo = new GridBagConstraints();
		gbc_lblBemVindo.gridwidth = 2;
		gbc_lblBemVindo.insets = new Insets(0, 0, 5, 0);
		gbc_lblBemVindo.gridx = 0;
		gbc_lblBemVindo.gridy = 1;
		panel.add(lblBemVindo, gbc_lblBemVindo);
		
		JButton btnCadProduto = new JButton("Cadastrar Produto");
		GridBagConstraints gbc_btnCadProduto = new GridBagConstraints();
		gbc_btnCadProduto.anchor = GridBagConstraints.WEST;
		gbc_btnCadProduto.insets = new Insets(0, 0, 5, 0);
		gbc_btnCadProduto.gridx = 1;
		gbc_btnCadProduto.gridy = 3;
		panel.add(btnCadProduto, gbc_btnCadProduto);
		
		JButton btnCadVenda = new JButton("Cadastrar Venda");
		btnCadVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnCadVenda = new GridBagConstraints();
		gbc_btnCadVenda.anchor = GridBagConstraints.WEST;
		gbc_btnCadVenda.insets = new Insets(0, 0, 5, 0);
		gbc_btnCadVenda.gridx = 1;
		gbc_btnCadVenda.gridy = 4;
		panel.add(btnCadVenda, gbc_btnCadVenda);
		
		JButton btnVerProdutos = new JButton("Ver Produtos");
		GridBagConstraints gbc_btnVerProdutos = new GridBagConstraints();
		gbc_btnVerProdutos.anchor = GridBagConstraints.WEST;
		gbc_btnVerProdutos.gridheight = 2;
		gbc_btnVerProdutos.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerProdutos.gridx = 1;
		gbc_btnVerProdutos.gridy = 5;
		panel.add(btnVerProdutos, gbc_btnVerProdutos);
	}
}
