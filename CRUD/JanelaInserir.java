import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ButtonGroup;

public class JanelaInserir {

	JFrame frmInserirVeculo;
	protected Object frmPesquisarVeculo;
	private JTextField textField_km;
	private JTextField textField_cor;
	private JTextField textField_preco;
	private JTextField textField_placa;
	private JTextField textModelo;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaInserir window = new JanelaInserir();
					window.frmInserirVeculo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaInserir() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInserirVeculo = new JFrame();
		frmInserirVeculo.getContentPane().setBackground(new Color(0, 0, 0));
		frmInserirVeculo.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vinic\\Desktop\\Untitled design.jpg"));
		frmInserirVeculo.setTitle("Inserir Veículo");
		frmInserirVeculo.setBounds(100, 100, 622, 506);
		frmInserirVeculo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInserirVeculo.getContentPane().setLayout(null);
		
		textField_km = new JTextField();
		textField_km.setColumns(10);
		textField_km.setBounds(216, 225, 244, 20);
		frmInserirVeculo.getContentPane().add(textField_km);
		
		textField_cor = new JTextField();
		textField_cor.setColumns(10);
		textField_cor.setBounds(216, 271, 244, 20);
		frmInserirVeculo.getContentPane().add(textField_cor);
		
		textField_preco = new JTextField();
		textField_preco.setColumns(10);
		textField_preco.setBounds(216, 314, 244, 20);
		frmInserirVeculo.getContentPane().add(textField_preco);
		
		textField_placa = new JTextField();
		textField_placa.setColumns(10);
		textField_placa.setBounds(216, 359, 244, 20);
		frmInserirVeculo.getContentPane().add(textField_placa);
		
		JComboBox comboBox_ano = new JComboBox();
		comboBox_ano.setBackground(new Color(255, 255, 255));
		comboBox_ano.setModel(new DefaultComboBoxModel(new String[] {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		comboBox_ano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox_ano.setBounds(216, 134, 244, 22);
		frmInserirVeculo.getContentPane().add(comboBox_ano);
		
		JComboBox comboBox_marca = new JComboBox();
		comboBox_marca.setModel(new DefaultComboBoxModel(new String[] {"Aston Martin", "Audi", "Bentley", "BMW", "Ferrari", "Jaguar", "Jeep", "Kia", "Lamborghini", "Land Rover", "Mercedes-Benz", "Mini", "Porsche", "Tesla", "VW", "Volvo"}));
		comboBox_marca.setBackground(new Color(255, 255, 255));
		comboBox_marca.setBounds(216, 46, 244, 22);
		frmInserirVeculo.getContentPane().add(comboBox_marca);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(216, 91, 244, 20);
		frmInserirVeculo.getContentPane().add(textModelo);
		
		JRadioButton rdbt_novo = new JRadioButton("Novo");
		rdbt_novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		buttonGroup.add(rdbt_novo);
		rdbt_novo.setBackground(new Color(255, 255, 255));
		rdbt_novo.setBounds(216, 178, 109, 23);
		frmInserirVeculo.getContentPane().add(rdbt_novo);
		
		JRadioButton rdbt_usado = new JRadioButton("Usado");
		buttonGroup.add(rdbt_usado);
		rdbt_usado.setBackground(new Color(255, 255, 255));
		rdbt_usado.setBounds(351, 178, 109, 23);
		frmInserirVeculo.getContentPane().add(rdbt_usado);
		
		JButton btinserir = new JButton("Inserir");
		btinserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexao = null;
				PreparedStatement comando = null;
				try {
					conexao = ClasseConexao.Conectar();
					String sql = "INSERT INTO cadastro(marca,modelo,ano,novo_usado,km,cor,preco,placa) VALUES(?,?,?,?,?,?,?,?)";
					comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					String leitura = comboBox_marca.getSelectedItem().toString();
					comando.setString(1, leitura);
					String leitura2 = textModelo.getText();
					comando.setString(2, leitura2);
					String leitura3 = comboBox_ano.getSelectedItem().toString();
					comando.setString(3, leitura3);
					if(rdbt_novo.isSelected())
					{
						comando.setString(4, "Novo");
					}
					if(rdbt_usado.isSelected())
					{
						comando.setString(4, "Usado");
					}
					String leitura5 = textField_km.getText();
					comando.setString(5, leitura5);
					String leitura6 = textField_cor.getText();
					comando.setString(6, leitura6);
					String leitura7 = textField_preco.getText();
					comando.setString(7, leitura7);
					String leitura8 = textField_placa.getText();
					comando.setString(8, leitura8);
					
					if(comando.executeUpdate()>0) {
						System.out.println("Dados gravados.");
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
		btinserir.setFont(new Font("Arial", Font.BOLD, 12));
		btinserir.setBackground(new Color(255, 255, 255));
		btinserir.setBounds(427, 407, 89, 23);
		frmInserirVeculo.getContentPane().add(btinserir);
		
		JLabel lblNewLabel = new JLabel("Marca");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(113, 48, 52, 14);
		frmInserirVeculo.getContentPane().add(lblNewLabel);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setForeground(Color.WHITE);
		lblModelo.setFont(new Font("Arial", Font.BOLD, 18));
		lblModelo.setBounds(113, 92, 64, 14);
		frmInserirVeculo.getContentPane().add(lblModelo);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ano");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(125, 136, 35, 14);
		frmInserirVeculo.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Quilometragem");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(70, 222, 136, 23);
		frmInserirVeculo.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Novo/Usado");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(86, 180, 109, 14);
		frmInserirVeculo.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Cor");
		lblNewLabel_1_3_1.setForeground(Color.WHITE);
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_3_1.setBounds(130, 272, 35, 14);
		frmInserirVeculo.getContentPane().add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Preço");
		lblNewLabel_1_3_2.setForeground(Color.WHITE);
		lblNewLabel_1_3_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_3_2.setBounds(122, 317, 52, 14);
		frmInserirVeculo.getContentPane().add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_3 = new JLabel("Placa");
		lblNewLabel_1_3_3.setForeground(Color.WHITE);
		lblNewLabel_1_3_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_3_3.setBounds(125, 360, 52, 14);
		frmInserirVeculo.getContentPane().add(lblNewLabel_1_3_3);
	}
}
