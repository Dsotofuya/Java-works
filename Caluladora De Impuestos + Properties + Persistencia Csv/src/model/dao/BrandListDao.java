package model.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Brand;
import model.Line;
import model.Model;

public class BrandListDao {
	
	private Brand brand;
	private Line line;
	
	public ArrayList<Brand> readBrandsDates() throws IOException{
		File file = new File("src/zData/ModelList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String readLine = null;
			while (reader.ready()) {
				readLine = reader.readLine();
				String[] textDates = readLine.split("-");
				for (int i = 0; i < textDates.length; i++) {
					line.addModel(new Model(Integer.parseInt(textDates[0]), Integer.parseInt(textDates[1])));
					brand.addLine(new Line(textDates[2], line.getModelList()));
//					brandList.add(new Brand(textDates[3], brand.getLineList()));
					readLine = reader.readLine();	
					} reader.close();
				}
			return null;
			}
}


//elimina espacios en blanco al extremo .trim()