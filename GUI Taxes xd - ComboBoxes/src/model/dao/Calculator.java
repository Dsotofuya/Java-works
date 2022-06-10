package model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import model.entity.*;
import persistence.FileOperation;

public class Calculator {
	private int DISCOUNT_EARLY;
	private int DISCOUNT_PUBLIC;
	private int DISCOUNT_TRANSLATE;
	private ArrayList<Mark> marks;
	private ArrayList<Range> ranges;
	private String dataFile;

	public Calculator() throws FileNotFoundException, IOException {
		ranges = new ArrayList<>();
		marks = new ArrayList<>();
		loadParameters();
		loadData(dataFile);
	}

	public void loadParameters() throws FileNotFoundException, IOException {
		Properties parameters = new Properties();
		parameters.load(new FileReader("src/zData/config.properties"));
		DISCOUNT_EARLY = Integer.parseInt(parameters.getProperty("DISCOUNT_EARLY").trim());
		DISCOUNT_PUBLIC = Integer.parseInt(parameters.getProperty("DISCOUNT_PUBLIC").trim());
		DISCOUNT_TRANSLATE = Integer.parseInt(parameters.getProperty("DISCOUNT_TRANSLATE").trim());
		dataFile = parameters.getProperty("data_file").trim();
		createRange(parameters.getProperty("range1").split(";"));
		createRange(parameters.getProperty("range2").split(";"));
		createRange(parameters.getProperty("range3").split(";"));
	}

	public void createRange(String values[]) {
		ranges.add(new Range(Integer.parseInt(values[0].trim()), Integer.parseInt(values[1].trim()),
				Double.parseDouble(values[2].trim())));
	}

	public boolean markExists(String founded) {
		boolean exists = false;
		for (Mark mark : marks) {
			if (mark.getName().equals(founded)) {
				return true;
			}
		}
		return exists;
	}

	public void loadData(String file) throws IOException {
		ArrayList<String> list = FileOperation.loadTextFile(file);

		for (String item : list) {
			String values[] = item.split(";");
			if (values[3].trim().equalsIgnoreCase("automovil")) {
				process(values);
			}
		}
	}

	public void process(String values[]) {
		Mark mark = processMark(values);
		Line line = processLine(mark, values);
		processModels(line, values);
	}

	public Mark processMark(String values[]) {
		Mark mark = null;
		if (!markExists(values[2].trim())) {
			mark = new Mark(values[2].trim());
			marks.add(mark);
		} else {
			mark = marks.get(findMark(values[2].trim()));
		}
		return mark;
	}

	public Line processLine(Mark mark, String values[]) {
		Line line = null;

		if (!mark.lineExists(values[4].trim() + values[5].trim())) {
			line = new Line(values[4].trim() + values[5].trim());
			mark.addLine(values[4].trim() + values[5].trim());
		} else {
			line = mark.getLine(mark.findLine(values[4].trim() + values[5].trim()));
		}
		return line;
	}

	public void processModels(Line line, String values[]) {
		int value = 0;
		for (int year = 2002, pos = 9; year < 2020; year++, pos++) {
			value = Integer.parseInt(values[pos].trim()) * 1000;
			if (value != 0) {
				line.addModel(year, value);
			}
		}
	}

	public int findMark(String markName) {
		int pos = -1;
		int i = 0;
		boolean founded = false;
		while (i < marks.size() && !founded) {
			if (marks.get(i).getName().equals(markName)) {
				pos = i;
				founded = true;
			}
			i++;
		}
		return pos;
	}

	public void addRange(int min, int max, double per) {
		ranges.add(new Range(min, max, per));
	}

	public void addMark(String m) {
		marks.add(new Mark(m));
	}

	public void addLine(String mark, String line) {
		for (Mark m : marks) {
			if (m.getName().equals(mark)) {
				m.addLine(line);
			}
		}
	}

	public void addModel(String mark, String line, int year, int value) {
		for (Mark m : marks) {
			if (m.getName().equals(mark)) {
				for (Line l : m.getLines()) {
					if (l.getName().equals(line)) {
						l.addModel(year, value);
						;
					}
				}
			}
		}
	}

	public int findPrice(String mark, String line, int model) {
		int price = 0;
		for (Mark m : marks) {
			if (m.getName().equals(mark)) {
				for (Line l : m.getLines()) {
					if (l.getName().equals(line)) {
						for (Model mo : l.getModels()) {
							if (mo.getYear() == model) {
								price = mo.getValue();
							}
						}
					}
				}
			}
		}
		return price;
	}

	public double findRange(int price) {
		double range = 0;
		for (Range r : ranges) {
			if ((price >= r.getMin()) && (price <= r.getMax())) {
				range = r.getPer();
			}
		}
		return range;
	}

	public double calculateTax(String mark, String line, int model, boolean early, boolean publicService,
			boolean translate) {
		double tax = 0;
		int price = findPrice(mark, line, model);
		double range = findRange(price);
		tax = price * range / 100;
		if (early)
			tax = tax - (tax * DISCOUNT_EARLY / 100);
		if (publicService)
			tax = tax - DISCOUNT_PUBLIC;
		if (translate)
			tax = tax - (tax * DISCOUNT_TRANSLATE / 100);
		return tax;
	}

	public Object[] generateMarkList() {
		ArrayList<String> list = new ArrayList<String>();
		for (Mark mark : marks) {
			list.add(mark.getName());
		}
		return list.toArray();
	}

	public Object[] generateLineList(String markName) {
		ArrayList<String> list = new ArrayList<String>();
		Mark mark = marks.get(findMark(markName));
		ArrayList<Line> lines = mark.getLines();
		for (Line line : lines) {
			list.add(line.getName());
		}
		return list.toArray();
	}

	public Object[] generateModelList(String markName, String lineName) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Mark mark = marks.get(findMark(markName));
		Line line = mark.getLine(mark.findLine(lineName));
		ArrayList<Model> models = line.getModels();
		for (Model model : models) {
			list.add(model.getYear());
		}
		return list.toArray();
	}

}
