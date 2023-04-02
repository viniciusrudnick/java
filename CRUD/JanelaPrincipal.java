import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class JanelaPrincipal {

	private JFrame frmCadastroDeVeculos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
					window.frmCadastroDeVeculos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JanelaPrincipal() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeVeculos = new JFrame();
		frmCadastroDeVeculos.getContentPane().setForeground(Color.WHITE);
		frmCadastroDeVeculos.setTitle("Cadastro de Veículos R Schroeder");
		frmCadastroDeVeculos.getContentPane().setBackground(SystemColor.menuText);
		frmCadastroDeVeculos.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\vinic\\Desktop\\Untitled design.jpg"));
		frmCadastroDeVeculos.setBounds(200, 200, 450, 300);
		frmCadastroDeVeculos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeVeculos.getContentPane().setLayout(null);
		
		JButton inserir = new JButton("Inserir novo veículo");
		inserir.setForeground(new Color(255, 255, 255));
		inserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaInserir j2 = new JanelaInserir();
				j2.frmInserirVeculo.setVisible(true);

			}
		});
		inserir.setBackground(new Color(0, 0, 0));
		inserir.setFont(new Font("Arial", Font.BOLD, 12));
		inserir.setBounds(0, 0, 144, 51);
		frmCadastroDeVeculos.getContentPane().add(inserir);
		
		JButton procurar = new JButton("Pesquisar veículo");
		procurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaPesquisar j3 = new JanelaPesquisar();
				j3.frmPesquisarVeculo.setVisible(true);
			}
		});
		procurar.setForeground(new Color(255, 255, 255));
		procurar.setBackground(new Color(0, 0, 0));
		procurar.setFont(new Font("Arial", Font.BOLD, 12));
		procurar.setBounds(142, 0, 150, 51);
		frmCadastroDeVeculos.getContentPane().add(procurar);
		
		JButton apagar = new JButton("Excluir veículo");
		apagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaExcluir j4 = new JanelaExcluir();
				j4.frmExcluirVeculo.setVisible(true);
			}
		});
		apagar.setForeground(new Color(255, 255, 255));
		apagar.setBackground(new Color(0, 0, 0));
		apagar.setFont(new Font("Arial", Font.BOLD, 12));
		apagar.setBounds(290, 0, 144, 51);
		frmCadastroDeVeculos.getContentPane().add(apagar);
		
		JLabel lblNewLabel = new JLabel("R SCHROEDER COLLECTION");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\vinic\\Downloads\\Untitled_design-removebg-preview.png"));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(27, 86, 375, 100);
		frmCadastroDeVeculos.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione uma das opções no menu acima.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(79, 213, 282, 18);
		frmCadastroDeVeculos.getContentPane().add(lblNewLabel_1);
	}
}
