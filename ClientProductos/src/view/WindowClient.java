package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.entity.Publicacion;

public class WindowClient extends JFrame{

	private static final long serialVersionUID = 1L;
	public JTextField txtTitle;
	public JTextArea txtDescription;
	public JTextField txtPhone;
	public JFileChooser chooser;
	public JdialogCreateProduct dialog;
	public PanelProducts products ;
	
	public WindowClient(ArrayList<Publicacion> listPublicacion , ActionListener listener) {
		setTitle("Aplicacion de publicaciones");
		setIconImage(new ImageIcon(getClass().getResource("/img/icono.JPG")).getImage());
		dialog = new JdialogCreateProduct(listener);
		setExtendedState( MAXIMIZED_BOTH );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		products = new PanelProducts(listPublicacion, listener);
		add(products , BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		JButton btn = new JButton("Actualizar");
		btn.setFont(new Font("Roboto", Font.PLAIN, 20));
		btn.setActionCommand(control.Action.UPDATE.toString());
		btn.addActionListener(listener);
		btn.setBackground(Color.WHITE);
		panel.add(btn);
		
		JButton btnGetSelected = new JButton("Añadir");
		btnGetSelected.setFont(new Font("Roboto", Font.PLAIN, 20));
		btnGetSelected.setActionCommand(control.Action.ADD.toString());
		btnGetSelected.addActionListener(listener);
		btnGetSelected.setBackground(Color.WHITE);
		panel.add(btnGetSelected);
		panel.setBackground(Color.WHITE);
		add(panel , BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public void chooser() {
		JDialog dialog = new JDialog();
		dialog.setSize(500, 500);
		dialog.setLocationRelativeTo(null);
		dialog.add(chooser);
		dialog.setVisible(true);
	}
	
	public void clearDatos() {
		dialog.clearDatos();
	}
	
	public void dialogVisible(Boolean option) {
		dialog.setVisible(option);
	}
	public String[] dialogDatos() {
		return dialog.datos();
	}
	
	public void repaintPane() {
		products.repaint();
	}
	
	public void paintPublicacion(ArrayList< Publicacion > listPublicacion , ActionListener listener) {
		products.paintCards(listPublicacion, listener);
	}
}
