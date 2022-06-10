package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controllers.Events;

import models.ManagerCamping;
import models.Guest;

public class DialogAddPerson extends JDialog {//pop-up window for customizing Person objs


	private static final long serialVersionUID = 1L;

	private JTextField txName;//textField class instantiation
	private JLabel lbImg;//Label img
	
	public DialogAddPerson(JFrame frame, ActionListener controller) {//containing frame and controller link 
		super(frame, true);
		setSize(500, 500);//width and height
		setLocationRelativeTo(frame);//relates placement dialogWindow to mainFrame
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));//sets boxLayout parameters, arranges items vertically
		
		txName = new JTextField();//use the initially instantiated textFiel to create a new component
		txName.setBorder(BorderFactory.createTitledBorder("Name:"));//sets a border with the field name in the top margin
		add(txName);//adds component

		
		lbImg = new JLabel();//blank JLabel panel for the img
		lbImg.setBorder(BorderFactory.createTitledBorder("Image:"));//sets a border with the field name in the top margin
		add(lbImg);//adds component
		
		JButton btnSelectImage = new JButton("Select image...");//fileChooser detonation button
		btnSelectImage.addActionListener(new ActionListener() {//overrides actionPerformed method and links it to local classes
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf = new JFileChooser();
				int option = jf.showOpenDialog(null);
				if (option == JFileChooser.APPROVE_OPTION) {
					lbImg.setIcon(new ImageIcon(jf.getSelectedFile().getPath()));//shows image within label panel
					lbImg.setName(jf.getSelectedFile().getPath());//shows img path
				}
			}
		});
		add(btnSelectImage);
		
		JButton btnAddDialog = new JButton("Add person");
		btnAddDialog.addActionListener(controller);
		btnAddDialog.setActionCommand(Events.ADD_PERSON.toString());
		add(btnAddDialog);
	}
	
	public Guest getPerson(){
		return ManagerCamping.createPerson(txName.getText(), lbImg.getName());
	}
}