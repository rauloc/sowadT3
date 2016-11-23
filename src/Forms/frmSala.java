package Forms;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import com.accesoadatos.SalaDL;
import com.entidades.CineEL;
import com.entidades.SalaEL;
import com.negocio.CineBL;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frmSala extends JInternalFrame {
	private JTextField txtNombreCine;
	private JTextField txtFilasCine;
	private JTextField txtButacasCine;
	private JComboBox cboCine;
	
		//llenar comboCine
		private void LlenarComboCine(){
			try {
				DefaultComboBoxModel x = new DefaultComboBoxModel();
				cboCine.setModel(x);
				ArrayList<CineEL> lista = CineBL.Instancia().ListarCboCine();
				for(int i=0;i<lista.size();i++){
					x.addElement(lista.get(i));
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
					e.getMessage(), "Registro Salas", JOptionPane.ERROR_MESSAGE);
			}		
		}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSala frame = new frmSala();
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
	public frmSala() {
		setBounds(100, 100, 450, 364);
		getContentPane().setLayout(null);
		
		JLabel lblRegistroSalas = new JLabel("REGISTRO SALAS");
		lblRegistroSalas.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegistroSalas.setBounds(177, 11, 120, 28);
		getContentPane().add(lblRegistroSalas);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(37, 63, 75, 38);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAsasd = new JLabel("Filas");
		lblAsasd.setBounds(37, 110, 69, 23);
		getContentPane().add(lblAsasd);
		
		JLabel lblButacasPorFilas = new JLabel("Butacas por Filas");
		lblButacasPorFilas.setBounds(37, 144, 126, 28);
		getContentPane().add(lblButacasPorFilas);
		
		txtNombreCine = new JTextField();
		txtNombreCine.setBounds(154, 68, 200, 28);
		getContentPane().add(txtNombreCine);
		txtNombreCine.setColumns(10);
		
		txtFilasCine = new JTextField();
		txtFilasCine.setBounds(154, 107, 200, 28);
		getContentPane().add(txtFilasCine);
		txtFilasCine.setColumns(10);
		
		txtButacasCine = new JTextField();
		txtButacasCine.setBounds(154, 144, 200, 28);
		getContentPane().add(txtButacasCine);
		txtButacasCine.setColumns(10);
		
		JLabel lblCine = new JLabel("Cine");
		lblCine.setBounds(37, 183, 75, 28);
		getContentPane().add(lblCine);
		
		cboCine = new JComboBox();
		cboCine.setBounds(154, 183, 200, 28);
		getContentPane().add(cboCine);
		
		JCheckBox chkEstado = new JCheckBox("Estado");
		chkEstado.setBounds(154, 230, 97, 23);
		getContentPane().add(chkEstado);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					SalaEL s=new SalaEL();
					s.setNombre(txtNombreCine.getText());
					s.setFilas(Integer.parseInt(txtFilasCine.getText()));
					s.setButacasporfila(Integer.parseInt(txtButacasCine.getText()));
						CineEL c=new CineEL();
						c.setIdCine(cboCine.getSelectedIndex());
					s.setCine(c);
					s.setEstado(chkEstado.isSelected());
					boolean band=SalaDL.Instancia().InsertarSala(s);
					if(band==false){
						JOptionPane.showMessageDialog(null,"Error al insertar","Error",JOptionPane.ERROR_MESSAGE);
					}
					else{
						JOptionPane.showMessageDialog(null,"Inserto correctamente","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
						txtNombreCine.setText("");
						txtButacasCine.setText("");
						txtFilasCine.setText("");
					}
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnRegistrar.setBounds(154, 277, 89, 23);
		getContentPane().add(btnRegistrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNombreCine.setText("");
				txtButacasCine.setText("");
				txtFilasCine.setText("");
				dispose();
				//frmPrincipal p=new frmPrincipal();
				//p.setVisible(true);
			}
		});
		btnCancelar.setBounds(265, 277, 89, 23);
		getContentPane().add(btnCancelar);

		
		LlenarComboCine();
	}
}
