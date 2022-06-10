package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Control.Events;

public class LeftPanel extends JPanel {

	private static final long serialVersionUID = -1210966928811455084L;

	private static final String BACKGROUND = "#d6754f";
	private static final String ADD_IMAGE = "Add image";

	private JList<String> list;
	private DefaultListModel<String> defaultListModel;
	private JButton addImage;

	public LeftPanel(ActionListener control) {
		setPreferredSize(new Dimension(350, 400));
		setBackground(Color.decode(BACKGROUND));
		defaultListModel = new DefaultListModel<String>();
		list = new JList<String>(defaultListModel);
		list.setPreferredSize(new Dimension(300, 500));
		JScrollPane pane = new JScrollPane(list);
		pane.setPreferredSize(new Dimension(300, 430));
		pane.setBorder(BorderFactory.createEmptyBorder());
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(pane);
		addImage = new JButton(ADD_IMAGE);
		addImage.addActionListener(control);
		addImage.setPreferredSize(new Dimension(300, 40));
		addImage.setBackground(Color.white);
		addImage.setActionCommand(Events.ADD.toString());
		add(addImage);
	}

	public void addElement(String element) {
		defaultListModel.addElement(element);
	}
	
	public void deleteElement(int index) {
		defaultListModel.remove(index);
	}
}
