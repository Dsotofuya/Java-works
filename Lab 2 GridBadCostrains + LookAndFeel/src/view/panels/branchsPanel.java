package view.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class branchsPanel extends JPanel{
	private static final long serialVersionUID = -2134132225254080407L;
	
	private JComboBox<String> branchscb;
	private JList<String> branchsList;
	private JScrollPane branchsScroll;
	private GridBagConstraints gbc;
	private String[] componentsList = {"XXDDDDDDDDDDDDDDDDDDDDDDDDDDD",
			"                                                                               ",
			"                                                                               ",
			"                                                                               ",
			"                                                                               ",
			"                                                                               ",
			"                                                                               "};
	public branchsPanel(){
		TitledBorder tittle = BorderFactory.createTitledBorder("Sucursales");
		setBorder(tittle);
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		gbc.insets = new Insets(25, 25, 25, 25);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		branchscb = new JComboBox<String>();
		branchscb.addItem("                                                                               ");
		add(branchscb, gbc);
		branchsList = new JList<>(componentsList);
//		branchsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		branchsList.setLayoutOrientation(JList.VERTICAL);
		branchsScroll = new JScrollPane();
//		branchsScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		branchsScroll.setViewportView(branchsList);
		gbc.insets = new Insets(10, 10, 10, 10);
		add(branchsList, gbc);
		
//		add(branchsScroll, gbc);
	}
}
