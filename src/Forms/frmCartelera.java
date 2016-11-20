package Forms;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class frmCartelera extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmCartelera frame = new frmCartelera();
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
	public frmCartelera() {
		setBounds(100, 100, 450, 300);

	}

}
