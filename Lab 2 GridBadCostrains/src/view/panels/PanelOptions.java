package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOptions extends JPanel {
	private static final long serialVersionUID = 7691527432593550274L;

	private JButton addBranchBtn;
	private JButton deleteBranchBtn;
	private JButton launchLineProductBtn;
	private JButton discontinueLineProducBtn;
	private JButton oldLineProductBtn;
	private JButton deleteRangeBtn;
	private JButton generateReportBtn;
	private GridBagConstraints gbc;
	
	public PanelOptions() {
	gbc = new GridBagConstraints();
	setLayout(new GridBagLayout());
	addBranchBtn = new JButton("Agregar Sucursal");
	gbc.insets = new Insets(0, 0, 10, 0);
	gbc.anchor = GridBagConstraints.LINE_START;
	gbc.gridwidth = GridBagConstraints.REMAINDER;
	gbc.fill = GridBagConstraints.BOTH;
	add(addBranchBtn, gbc);
	deleteBranchBtn = new JButton("Eliminar Surcursal");
	add(deleteBranchBtn, gbc);
	launchLineProductBtn = new  JButton("Lanzar Línea De Producto");
	add(launchLineProductBtn, gbc);
	discontinueLineProducBtn = new JButton("Descontinuar Línea De Producto");
	add(discontinueLineProducBtn, gbc);
	oldLineProductBtn = new JButton("Línea De Producto más Antigua");
	add(oldLineProductBtn, gbc);
	deleteRangeBtn = new JButton("Eliminar Dado Un Rango");
	add(deleteRangeBtn, gbc);
	generateReportBtn = new JButton("Generar Reporte");
	add(generateReportBtn, gbc);
	}
		
}
