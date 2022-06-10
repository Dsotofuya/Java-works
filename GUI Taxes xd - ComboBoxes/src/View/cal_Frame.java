package View;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Control.Control;
import Costants.Costants;
import View.Panels.discount_Panel;
import View.Panels.tax_Panel;
import View.Panels.vehicle_Panel;

public class cal_Frame extends JFrame {
	private static final long serialVersionUID = 7791153880035705817L;
	private vehicle_Panel vehicle_Panel;
	private discount_Panel discount_Panel;
	private tax_Panel tax_Panel;
	private Control controller;
		
	public cal_Frame(Control controller) {
	super("Calculadora Impuestos");
	this.controller = controller;
	setLayout(new BorderLayout());
	setJMenuBar(config());
	init();
	add(vehicle_Panel, BorderLayout.NORTH);
	add(discount_Panel, BorderLayout.CENTER);
	add(tax_Panel, BorderLayout.SOUTH);
	setSize(350, 400);
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	pack();
	setVisible(true);
	}
	
	private void init() {
		vehicle_Panel = new vehicle_Panel(controller);
		discount_Panel = new discount_Panel();
		tax_Panel = new tax_Panel(controller);
	}
	
	private JMenuBar config() {
		JMenuBar menu = new JMenuBar();
		JMenu config =  new JMenu("Configuracioxn");
		
		JMenuItem config_discounts = new JMenuItem("Descuentos");
		config_discounts.setActionCommand(Costants.DISCOUNTS_CHANGE);
		config_discounts.addActionListener(controller);
		JMenuItem config_Ranges = new JMenuItem("Rangos");
		JMenuItem config_Archive_Dates = new JMenuItem("Archivo de datos");
		config.add(config_discounts);
		config.add(config_Ranges);
		config.add(config_Archive_Dates);
		
		
		JMenu help =  new JMenu("Ayuda");
		JMenuItem about = new JMenuItem("Acerca De xdxdxd");
		help.add(about);
		menu.add(config);
		menu.add(help);
		return menu;
	}
	
	public void cleanFrame() {
		vehicle_Panel.clean();
		discount_Panel.clean();
		tax_Panel.clean();
	}
	
	public void setValueText(String value){
		vehicle_Panel.setValueText(value);;
	}
	
	public boolean getPaidDiscount() {
		return discount_Panel.getPaidDiscount();
	}
	public boolean getLocationDiscount() {
		return discount_Panel.getLocationDiscount();
	}
	public boolean getPublicDiscount() {
		return discount_Panel.getPublicDiscount();
	}
	
	public void setFinalValueText(String value){
		tax_Panel.setValueText(value);;
	}
	
	public Object[] writeJCBBrand(Object[] brandList) {
		vehicle_Panel.writeJCBBrand(brandList);
		return brandList;
	}	
	
	public Object[] writeJCBLine(Object[] lineList) {
		vehicle_Panel.writeJCBLine(lineList);
		return lineList;
	}
	
	public Object[] writeJCBModel(Object[] modelList) {
		vehicle_Panel.writeJCBModel(modelList);
		return modelList;
	}

	public String brandSelected() {
		return vehicle_Panel.brandSelected();
	}
	
	public int modelSelected() {
		return vehicle_Panel.modelSelected();
	}
	
	public String lineSelected() {
		return vehicle_Panel.lineSelected();
	}
	
	
	
}
