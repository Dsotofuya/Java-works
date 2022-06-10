package co.edu.uptc.views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.constants.Constants;
import co.edu.uptc.models.Person;

public class PanelUsuario extends JPanel {

	private JFMainWindow ventana;
	private JLabel label1, label2, label3, label4, label5, label6;
	private Constants constantes;
	private Person person;
	
	String name = "";
	String lastname = "";
	String doc = "";
	String typo = "";
	String sexo = "";
	String fecha = "";

	private JTextField textNombre, textApellido, textDocumento, textFecha;
	private JComboBox textTipo, textSexo;

	public PanelUsuario(JFMainWindow ventana) {
		this.ventana = ventana;
		person = new Person();
		this.setLayout(new GridLayout(6, 2));
		this.setVisible(true);
		constantes = new Constants();
		this.initComponents();
	}

	public void initComponents() {
		label1 = new JLabel("NOMBRE");
		label1.setForeground(Color.white);
		this.add(label1);
		textNombre = new JTextField("");
		this.add(textNombre);
		label2 = new JLabel("APELLIDO");
		label2.setForeground(Color.white);
		this.add(label2);
		textApellido = new JTextField("");
		this.add(textApellido);
		label3 = new JLabel("NUMERO DE DOCUMENTO");
		label3.setForeground(Color.white);
		this.add(label3);
		textDocumento = new JTextField("");
		this.add(textDocumento);
		label4 = new JLabel("TIPO DE DOCUMENTO");
		label4.setForeground(Color.white);
		this.add(label4);
		textTipo = new JComboBox(constantes.DOC);
		this.add(textTipo);
		label5 = new JLabel("SEXO");
		label5.setForeground(Color.white);
		this.add(label5);
		textSexo = new JComboBox(constantes.SEXO);
		this.add(textSexo);
		label6 = new JLabel("FECHA DE NACIMIENTO");
		label6.setForeground(Color.white);
		this.add(label6);
		textFecha = new JTextField("19/04/1999");
		this.add(textFecha);
	}

	public Person hacerPersona() {
		name = textNombre.getText().toString();
		lastname = textApellido.getText();
		doc = textDocumento.getText();
		typo = textTipo.getSelectedItem().toString();
		sexo = textSexo.getSelectedItem().toString();
		fecha = textFecha.getText();
		person = new Person(name, lastname, doc, typo,sexo,fecha);
		return person;
	}

	// public Person hacerPersona(String nombre, String apellido, String doc,
	// String Tipo, String sexo, String fecha) {
	//
	// return null;
	// }

	public String informacionUsuario(JTextField jText) {
		String text = "";
		text = jText.getText();
		return null;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JTextField getTextApellido() {
		return textApellido;
	}

	public void setTextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}

	public JTextField getTextDocumento() {
		return textDocumento;
	}

	public void setTextDocumento(JTextField textDocumento) {
		this.textDocumento = textDocumento;
	}

	public JTextField getTextFecha() {
		return textFecha;
	}

	public void setTextFecha(JTextField textFecha) {
		this.textFecha = textFecha;
	}

	public JComboBox getTextTipo() {
		return textTipo;
	}

	public void setTextTipo(JComboBox textTipo) {
		this.textTipo = textTipo;
	}

	public JComboBox getTextSexo() {
		return textSexo;
	}

	public void setTextSexo(JComboBox textSexo) {
		this.textSexo = textSexo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public String getTypo() {
		return typo;
	}

	public void setTypo(String typo) {
		this.typo = typo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	// public Person hacerPersona(){
	// name = text1.getText().toString();
	// lastname= text2.getText();
	// doc = text3.getText();
	// typo = text4.getSelectedItem().toString();
	// person = new Person(name, lastname, doc, typo);
	// return person;
	// }

}
