package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import control.Controller;
import structures.Place;

public class View extends JFrame{
	public Controller control;
	public String selection1;
	public String selection2;
	private static final long serialVersionUID = 1L;
	private JLabel title,origin,destiny,flyTime;
	private JTextField resultTime;
	private JPanel panelUser;
	private JButton calculate;
	public JComboBox<String> city1;
	public JComboBox<String> city2;
	
	public View(ActionListener listener, Controller controller) {
		this.control=controller;
		panelUser = new JPanel();
		setBackground(Color.WHITE);
		setSize(500, 600);
		setLocationRelativeTo(null);
		initComponents(listener);
		setVisible(true);
		setResizable(false);
		add(panelUser);
	}

	private void initComponents(ActionListener listener) {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		panelUser.setLayout(gbl);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		title = new JLabel("Simulador de tiempos de Vuelo");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		gbc.insets = new Insets(0, 0, 100, 0);
		panelUser.add(title,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		origin = new JLabel("Ciudad Origen");
		origin.setFont(new Font("Arial", Font.BOLD, 20));
		gbc.insets = new Insets(0, 0, 0, -150);
		panelUser.add(origin,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		destiny = new JLabel("Ciudad Destino");
		destiny.setFont(new Font("Arial", Font.BOLD, 20));
		gbc.insets = new Insets(0, -150, 0, 0);
		panelUser.add(destiny,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		city1 = fillCity(city1);
		gbc.insets = new Insets(20, 0, 0, -150);
		panelUser.add(city1,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		calculate = new JButton("Calcular");
		calculate.addActionListener(listener);
		calculate.setActionCommand(Events.SHOW_TIME_FLY.name());
		gbc.insets = new Insets(20, 0, 0, 0);
		panelUser.add(calculate,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		city2 = fillCity(city2);
		gbc.insets = new Insets(20, -150, 0, 0);
		panelUser.add(city2,gbc);
	
	}

	public void reload(){
		selection1 = city1.getSelectedItem().toString();
		selection2 = city2.getSelectedItem().toString();
	}

	public void showResult(String message){
		JOptionPane.showMessageDialog(null, message);
	}
	
	private JComboBox<String> fillCity(JComboBox<String> cities) {
		cities = new JComboBox<String>();
		Place<String>[] nodelist = control.getNodeList();
		for (int i = 1; i < nodelist.length; i++) {
			String actual = (nodelist[i].getData());         
			cities.addItem(actual);
        }
		return cities;
	}
	
	public JTextField getResultTime() {
		return resultTime;
	}

	public void setResultTime(JTextField resultTime) {
		this.resultTime = resultTime;
	}

	public JLabel getFlyTime() {
		return flyTime;
	}

	public void setFlyTime(JLabel flyTime) {
		this.flyTime = flyTime;
	}

	public JLabel getTitle2() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JLabel getDestiny() {
		return destiny;
	}

	public void setDestiny(JLabel destiny) {
		this.destiny = destiny;
	}

	public JLabel getOrigin() {
		return origin;
	}

	public void setOrigin(JLabel origin) {
		this.origin = origin;
	}
	
	public JButton getCalculate() {
		return calculate;
	}

	public void setCalculate(JButton calculate) {
		this.calculate = calculate;
	}
}