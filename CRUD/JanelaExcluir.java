import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JanelaExcluir 
{

	JFrame frmExcluirVeculo;
	private JTextField textPlaca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					JanelaExcluir window = new JanelaExcluir();
					window.frmExcluirVeculo.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaExcluir() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frmExcluirVeculo = new JFrame();
		frmExcluirVeculo.getContentPane().setBackground(new Color(0, 0, 0));
		frmExcluirVeculo.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vinic\\Desktop\\Untitled design.jpg"));
		frmExcluirVeculo.setTitle("Excluir Veículo");
		frmExcluirVeculo.setBounds(100, 100, 450, 173);
		frmExcluirVeculo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmExcluirVeculo.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite a placa do veículo");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(105, 34, 221, 20);
		frmExcluirVeculo.getContentPane().add(lblNewLabel);
		
		textPlaca = new JTextField();
		textPlaca.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
				});
		textPlaca.setBounds(105, 65, 210, 20);
		frmExcluirVeculo.getContentPane().add(textPlaca);
		textPlaca.setColumns(10);
		
		JButton bt_excluir = new JButton("Excluir");
		bt_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexao = null;
				PreparedStatement comando = null;
				try {
					conexao = ClasseConexao.Conectar();
					String sql = "DELETE FROM cadastro WHERE placa=?";
					comando = conexao.prepareStatement(sql);
					String leitura = textPlaca.getText();
					comando.setString(1, leitura);
					
					if(comando.executeUpdate()>0) {
						System.out.println("Dados excluídos.");
					}
					
				}catch (SQLException e1) {
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
		bt_excluir.setBackground(Color.WHITE);
		bt_excluir.setForeground(Color.BLACK);
		bt_excluir.setFont(new Font("Arial", Font.PLAIN, 12));
		bt_excluir.setBounds(160, 96, 95, 23);
		frmExcluirVeculo.getContentPane().add(bt_excluir);
	}
}
