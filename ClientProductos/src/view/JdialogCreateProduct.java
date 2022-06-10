package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JdialogCreateProduct extends JDialog{

	private static final long serialVersionUID = 1L;
	public JTextField txtTitle;
	public JTextArea txtDescription;
	public JTextField txtPhone;
	  private File file;
	public JFileChooser chooser;

	public JdialogCreateProduct(ActionListener listener) {
		this.getContentPane().setBackground(Color.WHITE);
		setTitle("Crear publicacion");
		setIconImage(new ImageIcon(getClass().getResource("/img/icono.JPG")).getImage());
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.white);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		JLabel lblTitle = new JLabel("Titulo");
		lblTitle.setAlignmentX(RIGHT_ALIGNMENT);
		panel.add(lblTitle);
		txtTitle = new JTextField();
		panel.add(txtTitle);
		
		JLabel lblDescription = new JLabel("Descripcion");
		lblDescription.setAlignmentX(RIGHT_ALIGNMENT);
		panel.add(lblDescription);
		JPanel p1 = new JPanel();
		p1.setBackground(Color.WHITE);
		txtDescription = new JTextArea();
		txtDescription.setBorder(BorderFactory.createBevelBorder(1));
		txtDescription.setPreferredSize(new Dimension(200 , 50 ));
		p1.add(txtDescription);
		panel.add(p1);
		
		JLabel lblPhone = new JLabel("Telefono");
		lblPhone.setAlignmentX(RIGHT_ALIGNMENT);
		panel.add(lblPhone);
		txtPhone= new JTextField();
		panel.add(txtPhone);
		
		chooser = new JFileChooser();
		
		JTextArea txt = new JTextArea();
		txt.setEditable(false);
		panel.add(txt);
		
		JPanel panelBtn = new JPanel();
		  JButton btnFile = new JButton("Select photo");
		    btnFile.addActionListener(new ActionListener() {
		    	@Override
		    	public void actionPerformed(ActionEvent e) {
		            final JFileChooser fc = new JFileChooser(); 
		            int returnVal = fc.showOpenDialog(getContentPane());
		            if (returnVal == JFileChooser.APPROVE_OPTION) {
		                file = fc.getSelectedFile();
		            } else {
		                System.out.println("Open command cancelled by user.");
		            }
		        }
			
		    });
		    panelBtn.setAlignmentX(CENTER_ALIGNMENT);
		  panelBtn.add(btnFile);
		  panelBtn.setBackground(Color.WHITE);
		 panel.add(panelBtn);
		
		JPanel panel3 = new JPanel();
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setAlignmentX(CENTER_ALIGNMENT);
		btnAceptar.setActionCommand(control.Action.ACEPT.toString());
		btnAceptar.addActionListener(listener);
		panel3.setBackground(Color.WHITE);
		panel3.add(btnAceptar);
		
		panel.add(panel3);
		
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(200,500));
		panel1.add(panel);
		panel1.setBackground(Color.WHITE);
		add(panel1);
		
		setSize(250, 550);
	}
	
	public String [] datos() {
		String [] datos = new String[ 4];
		datos[0]= txtTitle.getText();
		datos[1]= txtDescription.getText();
		datos[2]= txtPhone.getText();
		datos[3] = file.getAbsolutePath();
		clearDatos();
		return datos;
	}
	
	public void clearDatos() {
		txtDescription.setText("");
		txtTitle.setText("");
		txtPhone.setText("");
		txtDescription.setText("");
	}
	
}
