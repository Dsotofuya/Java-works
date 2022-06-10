package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class DialogPostal extends JDialog {
	private static final long serialVersionUID = -3400612549206842079L;

	private static final String CLOSE = "Close";
	
	private JLabel postal;
	private JButton aceptBtn;
	
	public DialogPostal(BufferedImage image) {
		setSize(image.getWidth() + 50, image.getHeight() + 77);
		setLayout(new FlowLayout());
		postal = new JLabel(new ImageIcon(image));
		postal.setSize(new Dimension(image.getWidth(), image.getHeight()));
		add(postal);
		aceptBtn = new JButton(CLOSE);
		aceptBtn.setPreferredSize(new Dimension(100, 25));
		aceptBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(aceptBtn);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
