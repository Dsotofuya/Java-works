package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import Costants.Costants;
import View.cal_Frame;
import View.Dialogs.discounts_Dialog;
import model.dao.Calculator;

public class Control implements ActionListener {
	private Calculator calculator;
	private cal_Frame cal_Frame;
	private discounts_Dialog discounts_Dialog;
	
	public Control() throws FileNotFoundException, IOException {
		calculator = new Calculator();
		discounts_Dialog = new discounts_Dialog();
		cal_Frame = new cal_Frame(this);
		generateMarkList();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (Costants.CLEAN == arg0.getActionCommand()) {
			cal_Frame.cleanFrame();
		}
		if (Costants.FIND == arg0.getActionCommand()) {
			int price = calculator.findPrice(cal_Frame.brandSelected(),
					cal_Frame.lineSelected(), cal_Frame.modelSelected());
			cal_Frame.setValueText(String.valueOf(price));
		}
		if (Costants.CALCULATE == arg0.getActionCommand()) {
			double finalPrice = calculator.calculateTax(cal_Frame.brandSelected(),
					cal_Frame.lineSelected(), cal_Frame.modelSelected(), cal_Frame.getPaidDiscount(),
					cal_Frame.getPublicDiscount(), cal_Frame.getLocationDiscount());
			cal_Frame.setFinalValueText(String.valueOf(finalPrice));
		}
		if (Costants.BRAND_SELECTED == arg0.getActionCommand()) {
			generateLineList();
		}
		if (Costants.LINE_SELECTED == arg0.getActionCommand()) {
			generateModelList();
		}
		if (Costants.DISCOUNTS_CHANGE == arg0.getActionCommand()) {
			discounts_Dialog.setVisible(true);
		}
	}

	public void generateMarkList() {
		cal_Frame.writeJCBBrand(calculator.generateMarkList());
	}

	public void generateLineList() {
		System.out.println(cal_Frame.brandSelected());
		cal_Frame.writeJCBLine(calculator.generateLineList(cal_Frame.brandSelected()));
	}

	public void generateModelList() {
		System.out.println(cal_Frame.lineSelected());
		cal_Frame.writeJCBModel(calculator.generateModelList(cal_Frame.brandSelected(), cal_Frame.lineSelected()));
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		new Control();
	}
}
