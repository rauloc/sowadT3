package Forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entidades.UsuarioEL;
import com.negocio.UsuarioBL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(192, 28, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(58, 79, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(58, 128, 90, 14);
		contentPane.add(lblPassword);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(146, 76, 166, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(146, 125, 166, 20);
		contentPane.add(txtPassword);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				String Usuario = txtUsuario.getText(); 	
				String Password = txtPassword.getText();
				UsuarioEL u = UsuarioBL.Instancia().VerificarAcceso(Usuario, Password,2);
				frmPrincipal fprincipal=new frmPrincipal();
				fprincipal.show();
				dispose();
				JOptionPane.showMessageDialog(null, "Bienvenido a la Intranet de CineAPP");
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), 
							"Logoin", JOptionPane.WARNING_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
		btnIngresar.setBounds(167, 183, 107, 23);
		contentPane.add(btnIngresar);

	}
}
