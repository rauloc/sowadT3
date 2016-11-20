package Forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class frmPrincipal extends JFrame {

	private JPanel contentPane;
	private JDesktopPane dspContenedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPrincipal frame = new frmPrincipal();
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
	public frmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 415);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMantenedores = new JMenu("Mantenedor");
		menuBar.add(mnMantenedores);
		
		JMenuItem mntmPelicula = new JMenuItem("Pelicula");
		mnMantenedores.add(mntmPelicula);
		
		JMenuItem mntmUsuario = new JMenuItem("Usuario");
		mnMantenedores.add(mntmUsuario);
		
		JMenu mnProgramacion = new JMenu("Programacion");
		menuBar.add(mnProgramacion);
		
		JMenuItem mntmCartelera = new JMenuItem("Cartelera");
		mntmCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCartelera fcartelera=new frmCartelera();
				dspContenedor.add(fcartelera);
				fcartelera.setVisible(true);
				//fcartelera.show();
			}
		});
		mnProgramacion.add(mntmCartelera);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		JMenuItem mntmCiudades = new JMenuItem("Ciudades");
		mnRegistro.add(mntmCiudades);
		
		JMenuItem mntmCines = new JMenuItem("Cines");
		mnRegistro.add(mntmCines);
		
		JMenuItem mntmSalas = new JMenuItem("Salas");
		mnRegistro.add(mntmSalas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dspContenedor = new JDesktopPane();
		dspContenedor.setBounds(0, 357, 506, -358);
		contentPane.add(dspContenedor);
		dspContenedor.setLayout(null);
	}
}
