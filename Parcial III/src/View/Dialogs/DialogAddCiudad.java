package View.Dialogs;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

import Control.Events;
import Model.Ciudad;
import Model.ManagerCiudad;
import View.WindowFrame;

public class DialogAddCiudad extends JDialog {

	private JButton addNewCiudad; 
	private JTextField fieldName, fieldLatitud, fieldLongitud, fieldTemperatura, fieldPoblacion;
	
	public DialogAddCiudad(WindowFrame window, ActionListener controller) {
		super(window, true);
		setSize(500, 500);
		setLocationRelativeTo(window);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		fieldName = new JTextField();
		fieldName.setBorder(BorderFactory.createTitledBorder("Nombre de la ciudad"));
		add(fieldName);
		
		fieldLatitud = new JTextField();
		fieldLatitud.setBorder(BorderFactory.createTitledBorder("Latitud"));
		add(fieldLatitud);
		
		fieldLongitud = new JTextField();
		fieldLongitud.setBorder(BorderFactory.createTitledBorder("Longitud"));
		add(fieldLongitud);
		
		fieldTemperatura = new JTextField();
		fieldTemperatura.setBorder(BorderFactory.createTitledBorder("Temperatura"));
		add(fieldTemperatura);
		
		fieldPoblacion = new JTextField();
		fieldPoblacion.setBorder(BorderFactory.createTitledBorder("Poblacion"));
		add(fieldPoblacion);
		
		addNewCiudad = new JButton("Añadir");
		addNewCiudad.addActionListener(controller);
		addNewCiudad.setActionCommand(Events.ADD.toString());
		add(addNewCiudad);
	}

	public String getName() {
		String nombre = fieldName.getText();
		return nombre;
	}
	
	public double getLatitud() {
		double latitud = Double.parseDouble(fieldLatitud.getText());
		return latitud;
	}
	
	public double getLongitud() {
		double longitud = Double.parseDouble(fieldLongitud.getText());
		return longitud;
	}
	
	public long getTemperatura() {
		long longitud = Long.parseLong(fieldTemperatura.getText());
		return longitud;
	}
	
	public long getPoblacion() {
		long poblacion = Long.parseLong(fieldPoblacion.getText());
		return poblacion;
	}
	
	public void clearDialog() {
		fieldName.setText("");
		fieldLatitud.setText("");
		fieldLongitud.setText("");
		fieldTemperatura.setText("");
		fieldPoblacion.setText("");
	}
}
