package Forms;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class frmCiudad extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

	}
}
