package view;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.Controller;
import model.Estado;

public class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JComboBox<String> comboestadoInicial;
	private JComboBox<String> comboestadoFinal;
	private int withBorderPanels = 650;
	private JButton agregarAlfabeto;
	private JButton compararLenguaje;
	private JButton agregarEstado;
	private JButton agregarFuncion;
	private JTextField textAlfabeto;
	private JTextField textEstado;
	private CheckboxGroup cbg;
	private Checkbox inicial;
	private Checkbox estadofinal;
	private Checkbox nada;
	private JTextField textFuncion;
	private JTextField textCompararLenguaje;
	private CheckboxGroup cbgTipo;
	private Checkbox noDerterministra;
	private Checkbox determinista;

	public MyFrame(Controller control) {
		super("Automata: ");
		gbc = new GridBagConstraints();
		setSize(new Dimension(1000, 1000));
		setLayout(new GridBagLayout());

		panelTipoAutomata();
		
		panelAlfabeto(control);

		panelEstado(control);

		panelFuncion(control);

		panelComprar(control);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void panelTipoAutomata() {
		JPanel seleccionarTipo = new JPanel();
		seleccionarTipo.setBorder(new LineBorder(Color.BLACK));
		cbgTipo = new CheckboxGroup();
		noDerterministra = new Checkbox("No Determinista", cbgTipo, false);
		determinista = new Checkbox("Determinista", cbgTipo, true);
		seleccionarTipo.add(noDerterministra, gbc);
		seleccionarTipo.add(determinista, gbc);
		
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(10, 10, 10, 10);
		add(seleccionarTipo, gbc);
	}

	private void panelComprar(Controller control) {
		JPanel panelcomparar = new JPanel();
		panelcomparar.setPreferredSize(new Dimension(withBorderPanels, 150));
		panelcomparar.setBorder(new LineBorder(Color.BLACK));

		panelcomparar.setLayout(new GridBagLayout());
		gbc.gridwidth = GridBagConstraints.RELATIVE;

		JLabel lblCompararLenguaje = new JLabel("Comparar Lenguaje: ");
		lblCompararLenguaje.setFont(new Font("Arial", Font.PLAIN, 20));
		panelcomparar.add(lblCompararLenguaje, gbc);

		textCompararLenguaje = new JTextField();
		textCompararLenguaje.setPreferredSize(new Dimension(300, 30));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelcomparar.add(textCompararLenguaje, gbc);

		compararLenguaje = new JButton("Comparar");
		compararLenguaje.setPreferredSize(new Dimension(150, 30));
		compararLenguaje.addActionListener(control);
		compararLenguaje.setActionCommand("COMPARAR");
		panelcomparar.add(compararLenguaje, gbc);

		gbc.insets = new Insets(10, 10, 10, 10);
		add(panelcomparar, gbc);
	}

	private void panelFuncion(Controller control) {
		JPanel panelfuncion = new JPanel();
		panelfuncion.setPreferredSize(new Dimension(withBorderPanels, 300));
		panelfuncion.setBorder(new LineBorder(Color.BLACK));

		panelfuncion.setLayout(new GridBagLayout());
		gbc.gridwidth = GridBagConstraints.RELATIVE;

		JLabel lblfuncion = new JLabel("Funcion: ");
		lblfuncion.setFont(new Font("Arial", Font.PLAIN, 20));
		panelfuncion.add(lblfuncion, gbc);

		textFuncion = new JTextField();
		textFuncion.setPreferredSize(new Dimension(300, 30));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelfuncion.add(textFuncion, gbc);

		JLabel lblincial = new JLabel("Estado Inical: ");
		lblfuncion.setFont(new Font("Arial", Font.PLAIN, 20));
		panelfuncion.add(lblincial, gbc);

		comboestadoInicial = new JComboBox<String>();
		comboestadoInicial.setBounds(10, 10, 80, 20);
		panelfuncion.add(comboestadoInicial, gbc);

		JLabel lblfinal = new JLabel("Estado Final: ");
		lblfuncion.setFont(new Font("Arial", Font.PLAIN, 20));
		panelfuncion.add(lblfinal, gbc);

		comboestadoFinal = new JComboBox<String>();
		comboestadoFinal.setBounds(10, 10, 80, 20);
		panelfuncion.add(comboestadoFinal, gbc);

		agregarFuncion = new JButton("Agregar Funcion");
		agregarFuncion.setPreferredSize(new Dimension(150, 30));
		agregarFuncion.addActionListener(control);
		agregarFuncion.setActionCommand("ADD_FUNCION");
		panelfuncion.add(agregarFuncion, gbc);

		gbc.insets = new Insets(10, 10, 10, 10);
		add(panelfuncion, gbc);
	}

	private void panelEstado(Controller control) {
		JPanel panelEstado = new JPanel();
		panelEstado.setPreferredSize(new Dimension(withBorderPanels, 250));
		panelEstado.setBorder(new LineBorder(Color.BLACK));

		panelEstado.setLayout(new GridBagLayout());
		gbc.gridwidth = GridBagConstraints.RELATIVE;

		JLabel lblestado = new JLabel("Estado: ");
		lblestado.setFont(new Font("Arial", Font.PLAIN, 20));
		panelEstado.add(lblestado, gbc);

		textEstado = new JTextField();
		textEstado.setPreferredSize(new Dimension(300, 30));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelEstado.add(textEstado, gbc);

		cbg = new CheckboxGroup();
		inicial = new Checkbox("Estado Inicial", cbg, false);
		estadofinal = new Checkbox("Estado Final", cbg, false);
		nada = new Checkbox("No es inicial ni final", cbg, true);
		panelEstado.add(inicial, gbc);
		panelEstado.add(estadofinal, gbc);
		panelEstado.add(nada, gbc);

		agregarEstado = new JButton("Agregar Estado");
		agregarEstado.setPreferredSize(new Dimension(150, 30));
		agregarEstado.addActionListener(control);
		agregarEstado.setActionCommand("ADD_ESTADO");
		panelEstado.add(agregarEstado, gbc);

		gbc.insets = new Insets(10, 10, 10, 10);
		add(panelEstado, gbc);
	}

	private void panelAlfabeto(Controller control) {
		JPanel panelalfabeto = new JPanel();

		panelalfabeto.setPreferredSize(new Dimension(withBorderPanels, 60));
		panelalfabeto.setBorder(new LineBorder(Color.BLACK));

		JLabel lblAlfabeto = new JLabel("Alfabeto: ");
		lblAlfabeto.setFont(new Font("Arial", Font.PLAIN, 20));
		panelalfabeto.add(lblAlfabeto, gbc);

		textAlfabeto = new JTextField();
		textAlfabeto.setPreferredSize(new Dimension(300, 30));
		panelalfabeto.add(textAlfabeto, gbc);

		agregarAlfabeto = new JButton("Agregar alfabeto");
		agregarAlfabeto.setPreferredSize(new Dimension(150, 30));
		agregarAlfabeto.addActionListener(control);
		agregarAlfabeto.setActionCommand("ADD_ALFABETO");
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		panelalfabeto.add(agregarAlfabeto, gbc);

		gbc.insets = new Insets(10, 10, 10, 10);
		add(panelalfabeto, gbc);
	}

	public void disableAlfabetoAgregado(boolean disable) {
		agregarAlfabeto.setEnabled(disable);
	}

	public void disablePanelComparar(boolean disable) {
		compararLenguaje.setEnabled(disable);
	}

	public void disablePaneEstado(boolean disable) {
		agregarEstado.setEnabled(disable);
	}

	public void disablePanelfuncion(boolean disable) {
		agregarFuncion.setEnabled(disable);
	}

	public String getAlfabeto() {
		return textAlfabeto.getText();
	}

	public void fillEstadosInicialesCheck(List<String> estadosiniciales) {
		comboestadoInicial.removeAllItems();
		comboestadoFinal.removeAllItems();

		for (String estadiIni : estadosiniciales) {
			comboestadoInicial.addItem(estadiIni);
			comboestadoFinal.addItem(estadiIni);
		}
	}

	public Estado getEstado() {
		if (textEstado.getText().isEmpty()) {
			this.showDialog("Texto del estado vacio, no se puede agregar");
			return null;
		}

		if (cbg.getSelectedCheckbox().equals(inicial)) {
			return new Estado(textEstado.getText(), true, false);
		} else if (cbg.getSelectedCheckbox().equals(estadofinal)) {
			return new Estado(textEstado.getText(), false, true);
		} else {
			return new Estado(textEstado.getText(), false, false);
		}
	}
	
	public String getTextFuncion() {
		if(textFuncion.getText().isEmpty()) {
			this.showDialog("No se puede agregar una funcion vacia");
			return "";
		}
		return textFuncion.getText();
	}
	
	public int getTipoDeterminista() {
		if (cbgTipo.getSelectedCheckbox().equals(noDerterministra)) {
			return 0;
		}else{
			return 1;
		}
	}
	
	public String getEstadoInitFuncion() {
		if(comboestadoInicial.getSelectedItem() == null) {
			this.showDialog("No se encuentran estados seleccionados, revise su selección");
			return null;
		}
		return comboestadoInicial.getSelectedItem().toString();
	}
	
	public String getEstadoFinishFuncion() {
		if(comboestadoFinal.getSelectedItem() == null) {
			this.showDialog("No se encuentran estados seleccionados, revise su selección");
			return null;
		}
		return comboestadoFinal.getSelectedItem().toString();
	}
	
	public String getComprar() {
		return textCompararLenguaje.getText();
	}
	
	public void showDialog(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
