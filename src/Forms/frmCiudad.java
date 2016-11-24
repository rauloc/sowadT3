package Forms;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.entidades.CiudadEL;
import com.negocio.CiudadBL;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCiudad extends JInternalFrame {
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCiudad frame = new frmCiudad();
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
	public frmCiudad() {
		setBounds(100, 100, 450, 237);
		getContentPane().setLayout(null);
		
		JLabel lblRegistroDeCiudad = new JLabel("REGISTRO DE CIUDAD");
		lblRegistroDeCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistroDeCiudad.setBounds(146, 11, 157, 29);
		getContentPane().add(lblRegistroDeCiudad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(42, 62, 61, 29);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(120, 62, 200, 29);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					CiudadEL c=new CiudadEL();
					c.setNombre(txtNombre.getText());
					boolean band=CiudadBL.Instancia().InsertarCiudad(c);
					if(band==false){
						JOptionPane.showMessageDialog(null,"Error al insertar","Error",JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null,"Inserto correctamente","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
						txtNombre.setText("");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegistrar.setBounds(120, 131, 89, 23);
		getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				txtNombre.setText("");
			}
		});
		btnCancelar.setBounds(231, 131, 89, 23);
		getContentPane().add(btnCancelar);

	}
}
