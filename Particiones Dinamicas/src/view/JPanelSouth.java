package view;

import javax.swing.*;
import java.awt.*;

public class JPanelSouth extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLInfo;

    public JPanelSouth(){
        setBackground(Color.decode("#333333"));
        jLInfo.setForeground(Color.white);
        setLayout(new BorderLayout());
        this.add(jLInfo,BorderLayout.CENTER);
        this.setVisible(true);

    }
}
