package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import controller.ProdutoDAO;
import model.Produto;

import java.awt.Color;
import javax.swing.JButton;

public class AdicionarProdutoTela {
	private JTextField txtNome;
	private JTextField txtQuant;
	private JTextField txtValorUnitario;
	private String nome;
	private int quant;
	private int valorUnitario;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void iniciarTela() {
		final JFrame frame = new JFrame("Adicionar Produto");
		frame.setSize(300,350);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adicionar Produto");
		lblNewLabel.setBounds(39, 5, 205, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 82, 85, 14);
		panel.add(lblNome);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 118, 85, 14);
		panel.add(lblQuantidade);
		
		JLabel lblVU = new JLabel("Valor Unit\u00E1rio:");
		lblVU.setBounds(10, 160, 122, 14);
		panel.add(lblVU);
		
		txtNome = new JTextField();
		txtNome.setBounds(129, 79, 145, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtQuant = new JTextField();
		txtQuant.setColumns(10);
		txtQuant.setBounds(129, 115, 145, 20);
		panel.add(txtQuant);
		
		txtValorUnitario = new JTextField();
		txtValorUnitario.setColumns(10);
		txtValorUnitario.setBounds(129, 157, 145, 20);
		panel.add(txtValorUnitario);
		
		final JLabel lblValidacao = new JLabel("");
		lblValidacao.setForeground(Color.RED);
		lblValidacao.setBounds(10, 205, 177, 14);
		panel.add(lblValidacao);
		
		JButton btnCadProduto = new JButton("Cadastrar Produto");
		
		ActionListener cadProd = new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					nome = txtNome.getText();
					quant = Integer.parseInt(txtNome.getText());
					valorUnitario = Integer.parseInt(txtValorUnitario.getText());
					
					if (nome.isEmpty() || txtNome.getText().isEmpty() || txtValorUnitario.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Faltam dados!");
					}else {
						ProdutoDAO dao = new ProdutoDAO();
						dao.cadastrarProduto(new Produto(nome, quant, valorUnitario));
						JOptionPane.showMessageDialog(null, "Produto Salvo com Sucesso!");
						frame.setVisible(false);
					}
				} catch (Exception e2) {
					lblValidacao.setText("Dados incorretos");
					System.out.println(e2);
				}
			}
		};
		btnCadProduto.addActionListener(cadProd);
		btnCadProduto.setBounds(129, 259, 145, 23);
		panel.add(btnCadProduto);
		frame.setVisible(true);
	}
}
