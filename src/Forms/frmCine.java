package Forms;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.entidades.CineEL;
import com.entidades.CiudadEL;
import com.negocio.CineBL;
import com.negocio.CiudadBL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmCine extends JInternalFrame {
	private JComboBox cboCiudad;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JComboBox cboID;

	
	//llenar comboCine
			private void LlenarComboCiudad(){
				try {
					DefaultComboBoxModel x = new DefaultComboBoxModel();
					cboCiudad.setModel(x);										
					DefaultComboBoxModel y = new DefaultComboBoxModel();
					cboID.setModel(y);
					
					ArrayList<CiudadEL> lista = CiudadBL.Instancia().ListarCiudad();
					for(int i=0;i<lista.size();i++){
						x.addElement(lista.get(i).getNombre());
						y.addElement(lista.get(i).getIdCiudad());
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
						e.getMessage(), "Registro Cines", JOptionPane.ERROR_MESSAGE);
				}		
			}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCine frame = new frmCine();
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
	public frmCine() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(63, 67, 56, 27);
		getContentPane().add(lblCiudad);
		
		JLabel lblRegistroDeCines = new JLabel("REGISTRO DE CINES");
		lblRegistroDeCines.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistroDeCines.setBounds(147, 11, 131, 34);
		getContentPane().add(lblRegistroDeCines);
		
		cboCiudad = new JComboBox();
		cboCiudad.setBounds(134, 67, 159, 27);
		getContentPane().add(cboCiudad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(63, 116, 88, 27);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(134, 116, 228, 27);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(63, 161, 75, 27);
		getContentPane().add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(134, 161, 228, 27);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					CineEL c=new CineEL();
						int index=cboCiudad.getSelectedIndex();
						cboID.setSelectedIndex(index);
						String valorindex=cboID.getSelectedItem().toString();						
						CiudadEL u=new CiudadEL();					
						u.setIdCiudad(Integer.parseInt(valorindex));												
					c.setCiudad(u);
					c.setNombreCine(txtNombre.getText());
					c.setDireccionCine(txtDireccion.getText());
					boolean band=CineBL.Instancia().InsertarCine(c);
					if(band==false){
						JOptionPane.showMessageDialog(null,"Error al insertar","Error",JOptionPane.ERROR_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null,"Inserto correctamente","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
						txtNombre.setText("");
						txtDireccion.setText("");						
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnRegistrar.setBounds(134, 211, 89, 23);
		getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				txtNombre.setText("");
				txtDireccion.setText("");
			}
		});
		
		cboID = new JComboBox();
		cboID.setVisible(false);
		cboID.setEnabled(false);
		cboID.setBounds(200, 70, 63, 20);
		getContentPane().add(cboID);
		btnCancelar.setBounds(273, 211, 89, 23);
		getContentPane().add(btnCancelar);

		
		LlenarComboCiudad();
	}
}
