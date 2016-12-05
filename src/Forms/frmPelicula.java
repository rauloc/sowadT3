package Forms;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.entidades.PeliculaEL;
import com.negocio.PeliculaBL;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class frmPelicula extends JInternalFrame {
	private JTextField txtTitulo;
	private JTextField txtDescripcion;
	private JTextField txtGenero;
	private JTextField txtruta;
	private JCheckBox chckbxEstado;
	private JTable listaPeliculas;
	private JScrollPane scrollPane;
	private JTextField txtIdPelicula;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPelicula frame = new frmPelicula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	public void ListarPeliculas(){
		try {
			//limpiando tabla
			DefaultTableModel modelo = (DefaultTableModel) listaPeliculas.getModel();
			while(modelo.getRowCount()>0)modelo.removeRow(0);		
			
			ArrayList<PeliculaEL> lista=new ArrayList<PeliculaEL>();
			lista = PeliculaBL.Instancia().ListarPeliculas();
			listaPeliculas.setDefaultRenderer(Object.class,new Render());
				PeliculaEL vo=new PeliculaEL();
				
				if(lista.size() > 0){
		            for(int i=0; i<lista.size(); i++){
		                Object fila[] = new Object[5];
		                vo = lista.get(i);
		                fila[0] = vo.getIdPelicula();
		                fila[1] = vo.getTitulo();
		                fila[2] = vo.getDescripcion();
		                fila[3] = vo.getGenero();
		                //fila[4] = vo.isEstado();
		                try{
		                    byte[] bi = vo.getImagen();
		                    BufferedImage image = null;
		                    InputStream in = new ByteArrayInputStream(bi);
		                    image = ImageIO.read(in);
		                    ImageIcon imgi = new ImageIcon(image.getScaledInstance(60, 60, 0));
		                    fila[4] = new JLabel(imgi);

		                }catch(Exception ex){
		                    fila[4] = new JLabel("No imagen");
		                }
		                ((DefaultTableModel)listaPeliculas.getModel()).addRow(fila);
		            }
		            listaPeliculas.setRowHeight(60);
			}			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage(), 
					"App Cine", 
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}		
	}
	
	
	/**
	 * Create the frame.
	 */
	public frmPelicula() {
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 766, 382);
		getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(39, 82, 46, 14);
		getContentPane().add(lblTitulo);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(39, 107, 105, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(39, 132, 46, 14);
		getContentPane().add(lblGenero);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(39, 160, 46, 14);
		getContentPane().add(lblImagen);
		
		JLabel lblRegistroPeliculas = new JLabel("REGISTRO PELICULAS");
		lblRegistroPeliculas.setBounds(307, 11, 146, 14);
		getContentPane().add(lblRegistroPeliculas);
		lblRegistroPeliculas.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(126, 79, 155, 20);
		getContentPane().add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(126, 104, 155, 20);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtGenero = new JTextField();
		txtGenero.setBounds(126, 129, 155, 20);
		getContentPane().add(txtGenero);
		txtGenero.setColumns(10);
		
		txtruta = new JTextField();
		txtruta.setEditable(false);
		txtruta.setBounds(126, 157, 155, 20);
		getContentPane().add(txtruta);
		txtruta.setColumns(10);
		
		JButton btnFoto = new JButton("+");
		btnFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser j = new JFileChooser();
			        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
			        j.setFileFilter(fil);
			        
			        int s = j.showOpenDialog(getContentPane());
			        if(s == JFileChooser.APPROVE_OPTION){
			            String ruta = j.getSelectedFile().getAbsolutePath();
			            txtruta.setText(ruta);
			        }
			}
		});
		btnFoto.setBounds(282, 157, 46, 20);
		getContentPane().add(btnFoto);
		
		chckbxEstado = new JCheckBox("Estado");
		chckbxEstado.setSelected(true);
		chckbxEstado.setBounds(124, 184, 97, 23);
		getContentPane().add(chckbxEstado);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(39, 229, 289, 99);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{					
					String titulo = txtTitulo.getText();
			        String descripcion = txtDescripcion.getText();
			        String genero = txtGenero.getText();
			        File ruta = new File(txtruta.getText());
			        boolean estado=chckbxEstado.isSelected();
			        agregar(titulo,descripcion,genero,ruta,estado);
			        limpiar();
			        ListarPeliculas();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnAgregar.setBounds(25, 11, 89, 23);
		panel.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=Integer.parseInt(txtIdPelicula.getText());
				String titulo = txtTitulo.getText();
		        String descripcion = txtDescripcion.getText();
		        String genero = txtGenero.getText();		        
		        File ruta = new File(txtruta.getText());
		        boolean estado=chckbxEstado.isSelected();
		        if(txtruta.getText().length()==0){		        	
		        	modificar2(id,titulo,descripcion,genero,estado);		           
		            limpiar();
		            ListarPeliculas();		            
		        }else{
		        	modificar(id,titulo, descripcion, genero, ruta,estado);
		            limpiar();
		            ListarPeliculas();
		        }
			}
		});
		btnModificar.setBounds(163, 11, 98, 23);
		panel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int id = Integer.parseInt(txtIdPelicula.getText());
			        int a = JOptionPane.showConfirmDialog(null, "Desea eliminar este pelicula","Mensaje",JOptionPane.OK_CANCEL_OPTION);
			        if(a == 0){
			            try {
							eliminar(id);
							ListarPeliculas();	
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			            limpiar();
			        }				
			}
		});
		btnEliminar.setBounds(25, 64, 89, 20);
		panel.add(btnEliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		btnLimpiar.setBounds(163, 64, 98, 20);
		panel.add(btnLimpiar);		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(338, 44, 401, 284);
		getContentPane().add(scrollPane_1);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		listaPeliculas = new JTable();
		listaPeliculas.setEnabled(false);
		listaPeliculas.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo","Titulo", "Descripcion", "Genero", "Imagen"
			}
		));
		scrollPane_1.setViewportView(listaPeliculas);
		listaPeliculas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				 	int clic = listaPeliculas.rowAtPoint(evt.getPoint());	
				 	int idPelicula =(Integer)listaPeliculas.getValueAt(clic, 0);
			        String titulo = ""+listaPeliculas.getValueAt(clic, 1);
			        String descripcion = ""+listaPeliculas.getValueAt(clic, 2);
			        String genero = ""+listaPeliculas.getValueAt(clic, 3);
			        //boolean estado = (boolean)listaPeliculas.getValueAt(clic, 3);		
			        txtIdPelicula.setText(String.valueOf(idPelicula));
			        txtTitulo.setText(String.valueOf(titulo));
			        txtDescripcion.setText(descripcion);
			        txtGenero.setText(String.valueOf(genero));			        
			        txtruta.setText("");
			}
		});
		listaPeliculas.setBounds(338, 45, 389, 260);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(39, 57, 46, 14);
		getContentPane().add(lblCodigo);
		
		txtIdPelicula = new JTextField();
		txtIdPelicula.setEditable(false);
		txtIdPelicula.setBounds(126, 54, 155, 20);
		getContentPane().add(txtIdPelicula);
		txtIdPelicula.setColumns(10);

		ListarPeliculas();
	}
	
	public void limpiar(){
		txtIdPelicula.setText("");
		txtTitulo.setText("");
		txtDescripcion.setText("");
		txtruta.setText("");
		txtGenero.setText("");
	}
	
	//--------------------------------METODOS CRUD------------------------------------------------
    public void agregar(String titulo, String descripcion, String genero,File ruta,boolean estado){
        PeliculaEL vo = new PeliculaEL();
       try{
        	vo.setTitulo(titulo);
            vo.setDescripcion(descripcion);
            vo.setGenero(genero);
            vo.setEstado(estado);
            
            byte[] imagen = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(imagen);
            vo.setImagen(imagen);
            boolean band=PeliculaBL.Instancia().InsertarPelicula(vo);            
            if(band==false){
				JOptionPane.showMessageDialog(null,"Error al insertar","Error",JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"Inserto correctamente","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
				limpiar();			
				//ListarPeliculas();
			}
        }catch(Exception ex){
        	vo.setImagen(null);
        }             
    }
    
    public void modificar(int id,String titulo, String descripcion, String genero, File ruta,boolean estado){
        PeliculaEL vo = new PeliculaEL();

        try{            
		    vo.setIdPelicula(id);
		    vo.setTitulo(titulo);
		    vo.setDescripcion(descripcion);
		    vo.setGenero(genero);
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            vo.setImagen(icono);
            vo.setEstado(estado);
            boolean band=PeliculaBL.Instancia().ModificarPelicula(vo);
            if(band==false){
    			JOptionPane.showMessageDialog(null,"Error al modificar","Error",JOptionPane.ERROR_MESSAGE);
    		}else{
    			JOptionPane.showMessageDialog(null,"Modificado correctamente","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
    			limpiar();			
    			//ListarPeliculas();
    		}
        }catch(Exception ex){
            vo.setImagen(null);
        }
    }
    
    public void modificar2(int id,String titulo, String descripcion, String genero,boolean estado){
    	PeliculaEL vo = new PeliculaEL();
    	try{ 
	    	vo.setIdPelicula(id);
		    vo.setTitulo(titulo);
		    vo.setDescripcion(descripcion);
		    vo.setGenero(genero);   
		    vo.setEstado(estado);
		    boolean band=PeliculaBL.Instancia().ModificarPelicula2(vo);
	        if(band==false){
				JOptionPane.showMessageDialog(null,"Error al modificar","Error",JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"Modificado correctamente","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
				limpiar();			
				//ListarPeliculas();
			}
    	}catch(Exception ex){
            vo.setImagen(null);
        }
    }
    
    public void eliminar(int id) throws Exception{
    	PeliculaEL vo = new PeliculaEL();               
    	try{ 
    		vo.setIdPelicula(id);
        
    		boolean band=PeliculaBL.Instancia().eliminarPelicula(id);
    		if(band==false){
				JOptionPane.showMessageDialog(null,"Error al Eliminar","Error",JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null,"Eliminado correctamente","Confirmacion",JOptionPane.INFORMATION_MESSAGE);
				limpiar();			
				//ListarPeliculas();
			}
    	}catch(Exception ex){
            throw ex;
        }
    }
}
