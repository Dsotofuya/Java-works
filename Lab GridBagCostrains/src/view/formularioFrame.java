package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class formularioFrame extends JFrame {

	private static final long serialVersionUID = 6992001805788855015L;
	private JLabel tittle;
	private JLabel name;
	private JLabel adress;
	private JLabel paid;
	private JLabel city;
	private JLabel state;
	private JTextField txtName;
	private JTextField txtAdress;
	private JTextField txtCity;
	private JTextField txtState;
	private JComboBox<String> cbPaid;
	private JPanel buttonsPanel;
	private JButton btnPaid;
	private JButton btnCancel;
	
	public formularioFrame() {
		super("Formulario De Pago");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setBackground(Color.LIGHT_GRAY);
		tittle = new JLabel("Pague Ahora");
		tittle.setFont(new Font("Arial", 1, 18));
		name = new JLabel("Nombre: ");
		adress = new JLabel("Dirección");
		paid = new JLabel("Método de pago ");
		city = new JLabel("Ciudad");
		state = new JLabel("departamento");
		txtName = new JTextField();
		txtAdress = new JTextField();
		txtCity = new JTextField(10);
		txtState = new JTextField(7);
		cbPaid = new JComboBox<>();
		cbPaid.addItem("Visa");
		cbPaid.addItem("MasterCard");
		cbPaid.addItem("AmericanExpress");
		buttonsPanel = new JPanel();
		btnPaid = new JButton("Pagar");
		buttonsPanel.add(btnPaid);
		btnCancel = new JButton("Cancel");
		buttonsPanel.add(btnCancel);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);
		gbc.insets = new Insets(0, 0, 20, 0);
		gbc.anchor= GridBagConstraints.NORTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(tittle, gbc);
		gbc.insets = new Insets(0, 0, 0, 0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor= GridBagConstraints.WEST;
		gbc.gridwidth = 1;
		getContentPane().add(name, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(txtName, gbc);
		gbc.gridwidth = 1;
		getContentPane().add(adress, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(txtAdress, gbc);
		gbc.gridwidth = 1;
		getContentPane().add(city, gbc);
		getContentPane().add(txtCity, gbc);
		getContentPane().add(state, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		getContentPane().add(txtState, gbc);
		gbc.insets = new Insets(5, 0, 5, 0);
		gbc.gridwidth = 1;
		getContentPane().add(paid, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.NONE;
		getContentPane().add(cbPaid, gbc);
		gbc.insets = new Insets(15, 0, 0, 0);
		gbc.anchor = GridBagConstraints.SOUTH;
		getContentPane().add(buttonsPanel, gbc);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new formularioFrame();
	}
}
