package vista;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.filechooser.FileFilter;

import controllers.ControladorTipologiaSexo;
import model.TipologiaSexo;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class PanelDatosPersonales extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JLabel lblTitulo;
	
	private Runnable runnableGuardar;
	
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDNI;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JComboBox<TipologiaSexo> jcbTipoSexo;
	private JScrollPane scrollPane;
	public byte[] imagenEnArrayDeBytes;
	private JTextField jtfColor;
	JColorChooser jColorChooser;
	JPanel panel;
	
	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales() {
		setLayout(new BorderLayout(0, 0));
		
		
		
		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runnableGuardar.run();
			}
		});
		btnGuardar.setIcon(null);
		toolBar.add(btnGuardar);
		
		panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{96, 68, 0, 0, 0, 93};
		gbl_panel.rowHeights = new int[]{0, 38, 54, 28, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblTitulo = new JLabel("Titulo Del Componente");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridwidth = 5;
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panel.add(lblTitulo, gbc_lblTitulo);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 4;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 4;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 5;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		JLabel lblNewLabel = new JLabel("Apellido 1:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.gridwidth = 4;
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 3;
		panel.add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);
		
		JButton btnNewButton = new JButton("Busca Imagen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 3;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 2:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.gridwidth = 4;
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 4;
		panel.add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 5;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		jcbTipoSexo = new JComboBox<TipologiaSexo>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		panel.add(jcbTipoSexo, gbc_comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfDNI = new JTextField();
		GridBagConstraints gbc_jtfDNI = new GridBagConstraints();
		gbc_jtfDNI.gridwidth = 4;
		gbc_jtfDNI.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDNI.gridx = 1;
		gbc_jtfDNI.gridy = 6;
		panel.add(jtfDNI, gbc_jtfDNI);
		jtfDNI.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.gridwidth = 4;
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 7;
		panel.add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Color:");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 8;
		panel.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.gridwidth = 4;
		gbc_jtfColor.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 8;
		panel.add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);
		
		JButton btnColor = new JButton("Cambiar Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnColor.gridx = 5;
		gbc_btnColor.gridy = 8;
		panel.add(btnColor, gbc_btnColor);
		
		JLabel lblNewLabel_5 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 9;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.gridwidth = 4;
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 9;
		panel.add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 10;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.gridwidth = 4;
		gbc_jtfTelefono.insets = new Insets(0, 0, 0, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 10;
		panel.add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		cargarTodasLasTipologias();

	}
	
	
	
	public void setTitulo(String nuevoTitulo) {
		this.lblTitulo.setText(nuevoTitulo);
	}
	
	public Runnable getRunnableGuardar() {
		return runnableGuardar;
	}

	public void setRunnableGuardar(Runnable runnableGuardar) {
		this.runnableGuardar = runnableGuardar;
	}

	public void setNombre(String s) {
		this.jtfNombre.setText(s);
	}
	
	public void setApellido1(String s) {
		this.jtfApellido1.setText(s);
	}
	
	public void setApellido2(String s) {
		this.jtfApellido2.setText(s);
	}
	
	public void setColor(String hexColor) {
		if (hexColor != null && hexColor.length() >= 6) {
	        if (!hexColor.startsWith("#")) {
	            hexColor = "#" + hexColor;
	        }
	        this.jtfColor.setText(hexColor);
	        this.panel.setBackground(Color.decode(hexColor));
	    }
	}
	
	public void setDNI(String s) {
		this.jtfDNI.setText(s);
	}
	
	public void setDireccion(String s) {
		this.jtfDireccion.setText(s);
	}
	
	public void setEmail(String s) {
		this.jtfEmail.setText(s);
	}
	
	public void setTelefono(String s) {
		this.jtfTelefono.setText(s);
	}
	
	public void setId(int id) {
		this.jtfId.setText("" + id);
	}
	
	public int getId() {
		return Integer.parseInt(this.jtfId.getText());
	}



	public JTextField getJtfId() {
		return jtfId;
	}

	public void setJtfId(JTextField jtfId) {
		this.jtfId = jtfId;
	}

	public JTextField getJtfNombre() {
		return jtfNombre;
	}

	public void setJtfNombre(JTextField jtfNombre) {
		this.jtfNombre = jtfNombre;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}

	public JTextField getJtfApellido1() {
		return jtfApellido1;
	}
	
	public JTextField getJtfColor() {
		return jtfColor;
	}

	public void setJtfColor(JTextField jtfColor) {
		this.jtfColor = jtfColor;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setJtfApellido1(JTextField jtfApellido1) {
		this.jtfApellido1 = jtfApellido1;
	}

	public JTextField getJtfApellido2() {
		return jtfApellido2;
	}

	public void setJtfApellido2(JTextField jtfApellido2) {
		this.jtfApellido2 = jtfApellido2;
	}

	public JTextField getJtfDNI() {
		return jtfDNI;
	}

	public void setJtfDNI(JTextField jtfDNI) {
		this.jtfDNI = jtfDNI;
	}

	public JTextField getJtfDireccion() {
		return jtfDireccion;
	}

	public void setJtfDireccion(JTextField jtfDireccion) {
		this.jtfDireccion = jtfDireccion;
	}

	public JTextField getJtfEmail() {
		return jtfEmail;
	}

	public void setJtfEmail(JTextField jtfEmail) {
		this.jtfEmail = jtfEmail;
	}

	public JTextField getJtfTelefono() {
		return jtfTelefono;
	}

	public void setJtfTelefono(JTextField jtfTelefono) {
		this.jtfTelefono = jtfTelefono;
	}
	
	public JComboBox<TipologiaSexo> getJcbTipoSexo() {
		return jcbTipoSexo;
	}

	public void setJcbTipoSexo(JComboBox<TipologiaSexo> jcbTipoSexo) {
		this.jcbTipoSexo = jcbTipoSexo;
	}
	
	public void setImagen(byte[] img) {
		if (img != null && img.length > 0) {
			this.imagenEnArrayDeBytes = img;
			mostrarImagen();
		}
		else {
			this.imagenEnArrayDeBytes = null;
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}
	}
	
	public byte[] getImagen() {
		return imagenEnArrayDeBytes;
	}
	
	private void cargarTodasLasTipologias() {
		@SuppressWarnings("unchecked")
		List<TipologiaSexo> l = (List<TipologiaSexo>)ControladorTipologiaSexo.getInstance().findAll();
		
		for(TipologiaSexo t: l) {
			jcbTipoSexo.addItem(t);
		}
	}
	
	private void seleccionaImagen () {
		JFileChooser jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isDirectory() || (f.isFile() &&
						(f.getAbsolutePath().toLowerCase().endsWith(".jpg") || 
								f.getAbsolutePath().toLowerCase().endsWith(".jpeg")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".png")|| 
								f.getAbsolutePath().toLowerCase().endsWith(".gif")))) 
					return true;
				return false;
			}
		});
		
		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();
			
			
			
			if (fichero.isFile()) {
				
				try {
					if(anchoImagen(fichero)>100 || altoImagen(fichero)>100) {
						JOptionPane.showMessageDialog(null, "La imagen tiene que ser 100 x 100");
						setImagen(null);
					}
					else {
						this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
						setImagen(imagenEnArrayDeBytes);
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	private void mostrarImagen () {
		if (imagenEnArrayDeBytes != null && imagenEnArrayDeBytes.length > 0) {
			ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);
			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);
		}
		else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}
		
		mostrarDialogo();

	}
	
	private void seleccionaColor () {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.panel.setBackground(color);
		}
	}
	
	private int anchoImagen(File f){
		BufferedImage img = null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img.getWidth();
	}
	
	private int altoImagen(File f){
		BufferedImage img = null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img.getWidth();
	}
	
	private JPopupMenu getPopUpMenu () {
		JPopupMenu menu = new JPopupMenu();
		ImageIcon img = null;
		if(imagenEnArrayDeBytes != null) {
			img = new ImageIcon(imagenEnArrayDeBytes);
		}
		JMenuItem item1 =
				new JMenuItem("Dimensiones: " + ((img!=null)?img.getIconHeight():0)+ " x " + ((img!=null)?img.getIconWidth():0));
		JMenuItem item2 = new JMenuItem("Cambiar imagen");
		item2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionaImagen();
            }
        });
		menu.add(item1);
		menu.addSeparator();
		menu.add(item2);
		
		
		return menu;
	}
	
	public void mostrarDialogo() {
		JPopupMenu popup = getPopUpMenu();
		
		// Evento para mostrar el men� en las coordenadas que correspondan
		scrollPane.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
 
            /**
             * M�todo llamado cuando se detecta el evento de rat�n, mostrar� el men�
             * @param e
             */
            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popup.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
        });
	}
	}
	
	
	


