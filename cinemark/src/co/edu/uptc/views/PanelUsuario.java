package co.edu.uptc.views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import co.edu.uptc.constants.Constants;


public class PanelUsuario extends JPanel {

	private JFMainWindow ventana;
	private JLabel label1, label2, label3, label4,label5,label6;
	private Constants constantes;
//	private Person person;
	String name = "";
	String lastname= "";
	String doc = "";
	String typo = "";
//	private Reserva reserva;

	private JTextField textNombre, textApellido, textDocumento,textFecha;
	private JComboBox textTipo,textSexo;

	public PanelUsuario(JFMainWindow ventana) {
		this.ventana = ventana;
//		person = new Person();
//		reserva = new Reserva();
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
		textFecha = new JTextField("dd/mm/aaaa");
		this.add(textFecha);
	}
	
	public String informacionUsuario(JTextField jText){
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

//	public Person hacerPersona(){
//	 name = text1.getText().toString();
//		 lastname= text2.getText();
//		 doc = text3.getText();
//		 typo = text4.getSelectedItem().toString();
//		person = new Person(name, lastname, doc, typo);
//		return person;
//	} 
	
	
	
}
