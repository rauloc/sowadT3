package Forms;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.entidades.PeliculaEL;
import com.entidades.UsuarioEL;
import com.negocio.PeliculaBL;
import com.negocio.UsuarioBL;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frmUsuario extends JInternalFrame {
	private JTextField txtCodigo;
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JScrollPane scrollPane;
	private JTable listaUsuarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmUsuario frame = new frmUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private void ListarUsuarios(){
		try {
			ArrayList<UsuarioEL> lista = UsuarioBL.Instancia().ListarUsuarios();
			for(int i=0;i<lista.size();i++){
				int idusuario = lista.get(i).getIdUsuario();
				String usuario= lista.get(i).getUsuario();
				String password = lista.get(i).getPassword();
				String nombres = lista.get(i).getNombre();
				String apellidos = lista.get(i).getApellido();		
				int dni = lista.get(i).getDNI();
				Object[] xyz = new Object[]{idusuario,usuario ,password, nombres,apellidos,dni};
				((DefaultTableModel)listaUsuarios.getModel()).addRow(xyz);
			}			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage(), 
					"Cine App", 
					JOptionPane.ERROR_MESSAGE);
		}		
	}
	
	/**
	 * Create the frame.
	 */
	public frmUsuario() {
		setClosable(true);
		setBounds(100, 100, 450, 466);
		getContentPane().setLayout(null);
		
		JLabel lblRegistroDeUsuarios = new JLabel("REGISTRO DE USUARIOS");
		lblRegistroDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegistroDeUsuarios.setBounds(141, 11, 189, 14);
		getContentPane().add(lblRegistroDeUsuarios);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(64, 54, 59, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(64, 79, 59, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(64, 104, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(139, 51, 217, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(139, 76, 217, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(139, 101, 217, 20);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(64, 129, 59, 14);
		getContentPane().add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(139, 126, 217, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(64, 155, 59, 14);
		getContentPane().add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(139, 152, 217, 20);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(64, 180, 46, 14);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(139, 177, 217, 20);
		getContentPane().add(txtDni);
		txtDni.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 380, 364, -154);
		getContentPane().add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		listaUsuarios = new JTable();
		listaUsuarios.setBounds(38, 380, 364, -154);
		listaUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Usuario", "Password", "Nombres", "Apellidos", "DNI"
			}
		));
		scrollPane.setViewportView(listaUsuarios);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{					
					String usuario = txtUsuario.getText();
			        String password = txtPassword.getText();
			        String nombres = txtNombres.getText();
			        String apellidos = txtApellidos.getText();
			        int dni = Integer.parseInt(txtDni.getText());			       
			        agregar(usuario,password,nombres,apellidos,dni);
			        limpiar();
			        ListarUsuarios();
				}catch(Exception ex){
					ex.printStackTrace();
				}				
			}
		});
		btnRegistrar.setBounds(26, 402, 89, 23);
		getContentPane().add(btnRegistrar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(125, 402, 89, 23);
		getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(224, 402, 89, 23);
		getContentPane().add(btnEliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(323, 402, 89, 23);
		getContentPane().add(btnLimpiar);

		ListarUsuarios();
	}
	
	public void limpiar(){
		txtCodigo.setText("");
		txtUsuario.setText("");
		txtPassword.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtDni.setText("");
	}
	
	//--------------------------------METODOS CRUD------------------------------------------------
    public void agregar(String usuario, String password, String nombres,String apellidos,int dni) throws Exception{
        UsuarioEL vo = new UsuarioEL();
       try{
        	vo.setUsuario(usuario);
            vo.setPassword(password);
            vo.setNombre(nombres);
            vo.setApellido(apellidos);
            vo.setDNI(dni);           
            boolean band=UsuarioBL.Instancia().InsertarUsuarioEmp(vo);            
            if(band==false){
				JOptionPane.showMessageDialog(null,"Error al insertar","Error",JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"Inserto correctamente","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
				limpiar();							
			}
        }catch(Exception ex){
        	throw ex;
        }             
    }
}


