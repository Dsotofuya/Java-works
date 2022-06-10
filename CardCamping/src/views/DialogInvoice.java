package views;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controllers.Events;

import models.Reserve;

public class DialogInvoice extends JDialog {//acts as a JDialog class

	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;//sets the constant parts of the invoice table
	private JTable tableInvoice;//gets content in other classes for the invoice table

	public DialogInvoice(JFrame frame, ActionListener controller) {//links with frame and controller info
		super(frame, true);
		setSize(500, 500);
		setLocationRelativeTo(frame);//sets in relation to the frame
		setLayout(new BorderLayout());

		model = new DefaultTableModel();//creates default set of constrains for the table
		model.setColumnIdentifiers(new String [] {"Id camping", "Hours", "Value"});//creates a row for the columns' names

		tableInvoice = new JTable(model);//creates a table with the "model" column
		
		add(new JScrollPane(tableInvoice), BorderLayout.CENTER);//puts table into the center of a scrollPanel

		JButton btnPrint = new JButton("Print");//creates new button with given text
		btnPrint.addActionListener(controller);//links with ActionListener class and adds controller events as parameter
		btnPrint.setActionCommand(Events.PRINT.toString());//links with the specified event
		add(btnPrint, BorderLayout.PAGE_END);//adds created button at the page end
	}

	public void showInvoice(Reserve invoice) {//gets info from a Reserve object and adds it to the table
		model.setRowCount(0);//first item is added in the row's column 0
		model.addRow(new Object[]{invoice.getCamingZone(), invoice.getHourNumber(), invoice.getValue()});//adds Reserve object info
		setVisible(true);//shows the builded table
	}

	public void print() throws PrinterException {//prints pdf
		tableInvoice.print();
	}
}