package view.center;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RightPanel extends JPanel {
	private static final long serialVersionUID = -5301128380571533893L;
	
	private JTextArea description;
	private JTextArea minimumReqs ;
	
	public RightPanel() {
		setLayout(new GridLayout(5, 3));
		description = new JTextArea();
		description.setEditable(false);
		description.setLineWrap(true);
		description.setOpaque(false);
		minimumReqs = new JTextArea();
		minimumReqs.setEditable(false);
		minimumReqs.setLineWrap(true);
		minimumReqs.setOpaque(false);
		add(new JLabel());
		add(new JScrollPane(description));
		add(new JLabel());
		add(new JScrollPane(minimumReqs));
		add(new JLabel());
	}
	
	public void loadDescription(String desciption)  {
		description.setText("Description : \n" + desciption);
		revalidate();
		repaint();
	}
	
	public void loadminimumReqs(String reqs)  {
		minimumReqs.setText("Requeriments : \n" + reqs);
		revalidate();
		repaint();
	}
	
}
