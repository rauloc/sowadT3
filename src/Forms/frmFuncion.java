package Forms;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTable;

public class frmFuncion extends JInternalFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmFuncion frame = new frmFuncion();
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
	public frmFuncion() {
		setTitle("Cartelera");
		setBounds(250, 50, 850, 600);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccion de Lugar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(57, 37, 708, 126);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCiudad.setBounds(38, 53, 46, 14);
		panel.add(lblCiudad);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(94, 43, 107, 31);
		panel.add(comboBox);
		
		JLabel lblCine = new JLabel("Cine");
		lblCine.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCine.setBounds(276, 53, 46, 14);
		panel.add(lblCine);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(322, 43, 107, 31);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("Sala");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(520, 53, 46, 14);
		panel.add(lblNewLabel);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(567, 43, 107, 31);
		panel.add(comboBox_2);
		
		table = new JTable();
		table.setBounds(57, 476, 708, -244);
		getContentPane().add(table);

	}
}
