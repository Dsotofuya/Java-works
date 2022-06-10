package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JPanelMidLeft extends JPanel {

	private JTextField name, lastName, age, docNumber;
	private JLabel areaName, areaLastName, areaAge, areaDocType, areaDocNumber, areaGender;
	private JComboBox comboBoxDocType, comboBoxGender;
	
	public JPanelMidLeft(){
		setLayout(new GridLayout(6, 6));
		setBounds(10, 10, 200, 200);
		setBackground(Color.decode("#0b5ba1"));
		setVisible(true);
		init();
	}
	
	public void init(){
	
	areaName = new JLabel("Nombres:", SwingConstants.CENTER);
	Font auxFont=areaName.getFont(); 
	areaName.setFont(new Font(auxFont.getFontName(), auxFont.getStyle(), 15));
	areaName.setForeground(Color.white);
	add(areaName);
	name = new JTextField();
	add(name);
	
	areaLastName = new JLabel("Apellidos:" , SwingConstants.CENTER);
	Font auxFont1=areaLastName.getFont(); 
	areaLastName.setFont(new Font(auxFont1.getFontName(), auxFont1.getStyle(), 15));
	areaLastName.setForeground(Color.white);
	add(areaLastName);
	lastName = new JTextField();
	add(lastName);
	
	areaAge = new JLabel("Fecha de nacimiento:", SwingConstants.CENTER);
	Font auxFont2=areaAge.getFont(); 
	areaAge.setFont(new Font(auxFont2.getFontName(), auxFont2.getStyle(), 10));
	areaAge.setForeground(Color.white);
	add(areaAge);
	age = new JTextField();
	add(age);
	
	areaDocType = new JLabel("Tipo de documento:", SwingConstants.CENTER);
	Font auxFont3=areaDocType.getFont(); 
	areaDocType.setFont(new Font(auxFont3.getFontName(), auxFont3.getStyle(), 10));
	areaDocType.setForeground(Color.white);
	add(areaDocType);
	comboBoxDocType = new JComboBox();
	comboBoxDocType.addItem("Cedula de ciudadania");
	comboBoxDocType.addItem("Targeta de identidad");
	comboBoxDocType.addItem("Pasaporte extrangero");
	add(comboBoxDocType);
	
	areaDocNumber = new JLabel("Numero de documento:", SwingConstants.CENTER);
	Font auxFont4=areaDocNumber.getFont(); 
	areaDocNumber.setFont(new Font(auxFont4.getFontName(), auxFont4.getStyle(), 10));
	areaDocNumber.setForeground(Color.white);
	add(areaDocNumber);
	docNumber = new JTextField();
	add(docNumber);
	
	areaGender = new JLabel("Genero:", SwingConstants.CENTER);
	Font auxFont5=areaGender.getFont(); 
	areaGender.setFont(new Font(auxFont5.getFontName(), auxFont5.getStyle(), 15));
	areaGender.setForeground(Color.white);
	add(areaGender);
	comboBoxGender = new JComboBox();
	comboBoxGender.addItem("Hombre");
	comboBoxGender.addItem("Mujer");
	comboBoxGender.addItem("Otro");
	add(comboBoxGender);
	}
}
