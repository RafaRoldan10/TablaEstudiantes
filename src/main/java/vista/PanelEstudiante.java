package vista;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import controllers.ControladorEstudiante;
import controllers.DatosDeTabla;
import model.Estudiante;
import model.TipologiaSexo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.security.Principal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PanelEstudiante extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelDatosPersonales panelDatos = new PanelDatosPersonales();
	private Estudiante est = null;
	private int fila;
	private Object datos[][] = null;
	private DefaultTableModel dtm = null;
	

	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		setLayout(new BorderLayout(0, 0));
		this.add(panelDatos, BorderLayout.CENTER);
		panelDatos.setTitulo("Gestión de estudiante");
		
		this.panelDatos.getJtfId().setEditable(false);

		
			
		this.panelDatos.setRunnableGuardar(
				new Runnable() {
					
					public void run() {
						guardado();
					}
				}
				
				);
		
	}
	
	
	
	public void mostrarEntidad(Estudiante e, int num, Object[][] a, DefaultTableModel d) {
		fila = num;
		datos =a;
		dtm = d;
		est = e;
		if(e != null) {
			this.panelDatos.setId(e.getId());
			this.panelDatos.setNombre(e.getNombre());
			this.panelDatos.setApellido1(e.getApellido1());
			this.panelDatos.setApellido2(e.getApellido2());
			for (int i = 0; i < this.panelDatos.getJcbTipoSexo().getItemCount(); i++) {
				if (this.panelDatos.getJcbTipoSexo().getItemAt(i).getId() == e.getIdTipologiaSexo().getId()) {
					this.panelDatos.getJcbTipoSexo().setSelectedIndex(i);
				}
			}
			this.panelDatos.setDireccion(e.getDireccion());
			this.panelDatos.setDNI(e.getDni());
			this.panelDatos.setTelefono(e.getTelefono());
			this.panelDatos.setEmail(e.getEmail());
			this.panelDatos.setImagen(e.getImagen());
		    String colorAlmacenado = e.getColorPreferido();
		    
		    // Actualizar el color del panel
		    if (colorAlmacenado != null && !colorAlmacenado.isEmpty()) {
		        this.panelDatos.setColor((colorAlmacenado));
		    } else {
		        // Si no hay color almacenado, puedes establecer un color por defecto
		        this.panelDatos.setColor("#ffffff");
		    }
		   
			
		}
		 
		
	}
	
	
	
	
	
	public void guardar() throws SQLException {
		Estudiante e = new Estudiante();
		e.setId(this.panelDatos.getId());
		e.setNombre(this.panelDatos.getJtfNombre().getText());
		e.setApellido1(this.panelDatos.getJtfApellido1().getText());
		e.setApellido2(this.panelDatos.getJtfApellido2().getText());
		e.setDni(this.panelDatos.getJtfDNI().getText());
		e.setDireccion(this.panelDatos.getJtfDireccion().getText());
		e.setEmail(this.panelDatos.getJtfEmail().getText());
		e.setTelefono(this.panelDatos.getJtfTelefono().getText());
		e.setIdTipologiaSexo((TipologiaSexo) this.panelDatos.getJcbTipoSexo().getSelectedItem());
		e.setImagen(this.panelDatos.getImagen());
		e.setColorPreferido(this.panelDatos.getJtfColor().getText());
		ControladorEstudiante.getInstance().update(e);
		
		
		
	}
	
	public void guardado() {
		try {
			guardar();
			
			
			int filaSeleccionada = fila;
			
			Estudiante e = ControladorEstudiante.getInstance().findEstudiante((Integer) datos[fila][0]);
			
			
			datos[filaSeleccionada][0] = e.getId();
	        datos[filaSeleccionada][1] = e.getNombre();
	        datos[filaSeleccionada][2] = e.getApellido1();
	        datos[filaSeleccionada][3] = e.getApellido2();
	        datos[filaSeleccionada][4] = e.getDni();
	        datos[filaSeleccionada][5] = e.getDireccion();
	        datos[filaSeleccionada][6] = e.getEmail();
	        datos[filaSeleccionada][7] = e.getTelefono();
	        datos[filaSeleccionada][8] = e.getIdTipologiaSexo();
	        datos[filaSeleccionada][9] = e.getColorPreferido();
			
			dtm.fireTableDataChanged();
			
			JOptionPane.showMessageDialog(null, "Estudiante guardado correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	

	}
}
	
