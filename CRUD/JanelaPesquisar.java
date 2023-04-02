import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class JanelaPesquisar {

	JFrame frmPesquisarVeculo;
	private JTable tabela_listagem;
	private JTextField textField_placa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPesquisar window = new JanelaPesquisar();
					window.frmPesquisarVeculo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPesquisar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	CRUD executar = new CRUD();
	 public void Selecionando() {
		 ResultSet resultado = executar.Selecionar();
		 try {
			 while(resultado.next()) {
				 System.out.println(resultado.getString("marca" + "modelo" + "ano" + "km" + "preco"));
			 }
			 resultado.beforeFirst();
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 tabela_listagem.setModel(DbUtils.resultSetToTableModel(resultado));
	 }
	
	private void initialize() {
		frmPesquisarVeculo = new JFrame();
		frmPesquisarVeculo.getContentPane().setBackground(new Color(0, 0, 0));
		frmPesquisarVeculo.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vinic\\Desktop\\Untitled design.jpg"));
		frmPesquisarVeculo.setTitle("Pesquisar Veículo");
		frmPesquisarVeculo.setBounds(100, 100, 625, 366);
		frmPesquisarVeculo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPesquisarVeculo.getContentPane().setLayout(null);
		
		tabela_listagem = new JTable();
		tabela_listagem.setBounds(300, 23, 288, 269);
		frmPesquisarVeculo.getContentPane().add(tabela_listagem);
		
		JLabel lblNewLabel = new JLabel("Digite a placa do veículo");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(43, 117, 185, 24);
		frmPesquisarVeculo.getContentPane().add(lblNewLabel);
		
		textField_placa = new JTextField();
		textField_placa.setBounds(43, 144, 185, 20);
		frmPesquisarVeculo.getContentPane().add(textField_placa);
		textField_placa.setColumns(10);
		
		JButton btn_pesquisar = new JButton("Pesquisar");
		btn_pesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexao = null;
				PreparedStatement comando = null;
				ResultSet resultado = null;
				try {
					conexao = ClasseConexao.Conectar();
					String meu_sql = "SELECT * FROM cadastro";
					comando = conexao.prepareStatement(meu_sql,Statement.RETURN_GENERATED_KEYS);
					resultado = comando.executeQuery(meu_sql);
					while(resultado.next()) {
						System.out.println(resultado.getString("marca") + "   " + resultado.getString("modelo") + "   " + resultado.getString("ano") + "   " + resultado.getString("km") + "   " +resultado.getString("preco"));
					}
				}catch(SQLException e1) {
					e1.printStackTrace();
				}finally {
					ClasseConexao.FecharConexao(conexao);
					try {
						comando.close();
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btn_pesquisar.setFont(new Font("Arial", Font.PLAIN, 11));
		btn_pesquisar.setBackground(new Color(255, 255, 255));
		btn_pesquisar.setBounds(92, 175, 89, 23);
		frmPesquisarVeculo.getContentPane().add(btn_pesquisar);
	}
}
