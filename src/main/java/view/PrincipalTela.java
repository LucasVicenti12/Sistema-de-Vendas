package view;

import javax.swing.*;

import model.Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Olá " + login.getNome() + ", seja muito(a) bem vindo(a)!");
		lblBemVindo.setBounds(97, 50, 1350, 55);
		frame.getContentPane().add(lblBemVindo);
		lblBemVindo.setForeground(SystemColor.controlDkShadow);
		lblBemVindo.setFont(new Font("Arial Black", Font.PLAIN, 24));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 1368, 156);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(78, 239, 1197, 330);
		frame.getContentPane().add(panel_1);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(panel_1, popupMenu);
		
		JMenuItem menuAdicionarProd = new JMenuItem("Adicionar Produto");
		
		ActionListener addProd = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdicionarProdutoTela addProdT = new AdicionarProdutoTela();
				addProdT.iniciarTela();
			}
			
		};
		menuAdicionarProd.addActionListener(addProd);
		popupMenu.add(menuAdicionarProd);
		panel_1.setLayout(null);
		
		JMenu mnNewMenu = new JMenu("Banana");
		mnNewMenu.setBounds(0, 0, 115, 26);
		panel_1.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Editar");
		mnNewMenu.add(mntmNewMenuItem);
		
		JLabel lblProdutos = new JLabel("Produtos");
		lblProdutos.setForeground(SystemColor.controlDkShadow);
		lblProdutos.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblProdutos.setBounds(78, 173, 629, 55);
		frame.getContentPane().add(lblProdutos);
		
		JLabel lblVenda = new JLabel("Vendas");
		lblVenda.setForeground(SystemColor.controlDkShadow);
		lblVenda.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblVenda.setBounds(78, 591, 276, 55);
		frame.getContentPane().add(lblVenda);
		
		JButton btnCadVenda = new JButton("Cadastrar Venda");
		btnCadVenda.setBounds(364, 608, 181, 32);
		frame.getContentPane().add(btnCadVenda);
		
		JButton btnExtornarVenda = new JButton("Extornar Venda");
		btnExtornarVenda.setBounds(637, 608, 181, 32);
		frame.getContentPane().add(btnExtornarVenda);
		
		JLabel lblNewLabel = new JLabel("Sistema feito por Lucas Vicenti");
		lblNewLabel.setBounds(1156, 657, 184, 14);
		frame.getContentPane().add(lblNewLabel);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
