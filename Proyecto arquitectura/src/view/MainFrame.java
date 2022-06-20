package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controllers.Events;
import controllers.presenter;

public class MainFrame extends JFrame {
	private static final String CONVERT = "Convert";
	/**
	 * @author DSotoFuya 
	 * Clase encargada de mantener la vista de la aplicación
	 */
	private static final String TITTLE = "Conversor de numeros NBase a MBase - Proyecto Arquitectura";
	private static final long serialVersionUID = -7824404318669296697L;
	private JLabel resultLbl;
	private JComboBox<String> baseNCB, baseMCB;
	private JTextField numberTF, truncTF;

	public MainFrame(presenter presenter) {
		try {
			setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			setTitle(TITTLE);
			setSize(new Dimension(250, 300));
			setResizable(false);
			setLayout(new BorderLayout());
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			add(initPanel(presenter), BorderLayout.CENTER);
			InitConvertButton(presenter);
			setVisible(true);
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	private void InitConvertButton(presenter presenter) {
		JButton convertBtn = new JButton(CONVERT);
		convertBtn.addActionListener(presenter);
		convertBtn.setActionCommand(Events.CONVERT.toString());
		add(convertBtn, BorderLayout.SOUTH);
	}

	public JPanel initPanel(ActionListener presenter) {
		JPanel dataPanel = new JPanel();
		dataPanel.add(new JLabel("N\u00FAmero: "));
		numberTF = new JTextField();
		numberTF.setPreferredSize(new Dimension(120, 30));
		dataPanel.add(numberTF);
		dataPanel.add(new JLabel("Base inicial: "));
		baseMCB = new JComboBox<String>();
		baseMCB.setPreferredSize(new Dimension(120, 30));
		baseNCB = new JComboBox<String>();
		baseNCB.setPreferredSize(new Dimension(120, 30));
		for (int i = 0; i < 36; i++) {
			baseMCB.addItem(String.valueOf(i));
			baseNCB.addItem(String.valueOf(i));
		}
		dataPanel.add(baseMCB);
		dataPanel.add(new JLabel("Base  final: "));
		dataPanel.add(baseNCB);
		dataPanel.add(new JLabel("Presici\u00F3n: "));
		truncTF = new JTextField("0");
		truncTF.setPreferredSize(new Dimension(120, 30));
		dataPanel.add(truncTF);
		dataPanel.add(new JLabel("Resultado: "));
		resultLbl = new JLabel();
		resultLbl.setFont(new Font("Arial", 0, 20));
		resultLbl.setForeground(Color.GREEN);
		resultLbl.setPreferredSize(new Dimension(120, 30));
		resultLbl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		dataPanel.add(resultLbl);
		return dataPanel;
	}

	public void refersh(String result) {
		resultLbl.setText(result);
	}

	public String getNumber() {
		return numberTF.getText();
	}

	public int getInitialBase() {
		return Integer.parseInt(baseMCB.getSelectedItem().toString());
	}

	public int getFinalBase() {
		return Integer.parseInt(baseNCB.getSelectedItem().toString());
	}

	public int getTruncNumber() {
		return Integer.parseInt(truncTF.getText());
	}

}
