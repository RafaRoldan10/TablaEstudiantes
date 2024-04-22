package controllers;


import model.TipologiaSexo;

public class ControladorTipologiaSexo extends SuperControlador{
	
	private static ControladorTipologiaSexo instance = null;
	 
		
	public static ControladorTipologiaSexo getInstance() {
		if(instance == null) {
			instance = new ControladorTipologiaSexo();
		}
		return instance;
	}
	
	public ControladorTipologiaSexo() {
		super("tipologiaSexo",TipologiaSexo.class);
	}
	
	

}
