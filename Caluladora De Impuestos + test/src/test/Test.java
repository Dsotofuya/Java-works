
package test;

import java.util.ArrayList;

import model.Brand;
import model.Line;
import model.Model;
import model.VehicleTax;

public class Test {

	public static void main(String[] args) {
		
		Model m = new Model(2005, 20000000);
		Model m2 = new Model(2006, 50000000);
		Model m3 = new Model(2007, 80000000);
		ArrayList<Model> modelList1 = new ArrayList<>();
		modelList1.add(m);
		modelList1.add(m2);
		modelList1.add(m3);
		Line l = new Line("patico", modelList1);
		

		Model m21 = new Model(2010, 21000000);
		Model m22 = new Model(2011, 52000000);
		Model m23 = new Model(2012, 83000000);
		ArrayList<Model> modelList2 = new ArrayList<>();
		modelList2.add(m21);
		modelList2.add(m22);
		modelList2.add(m23);
		Line l2 = new Line("perrito", modelList2);
		
		
		Model m31 = new Model(2013, 24000000);
		Model m32 = new Model(2014, 55000000);
		Model m33 = new Model(2015, 86000000);
		ArrayList<Model> modelList3 = new ArrayList<>();
		modelList3.add(m31);
		modelList3.add(m32);
		modelList3.add(m33);
		Line l3 = new Line("gatico", modelList3);
		
		ArrayList<Line> lineList = new ArrayList<>();
		lineList.add(l);
		lineList.add(l2);
		lineList.add(l3);

		
		Brand b = new Brand("animalitos", lineList);
		
		// Segunda Marca
		
		Model m41 = new Model(1999, 10000000);
		Model m42 = new Model(1998, 40000000);
		Model m43 = new Model(1997, 70000000);
		ArrayList<Model> modelList21 = new ArrayList<>();
		modelList21.add(m41);
		modelList21.add(m42);
		modelList21.add(m43);
		Line l21 = new Line("avion", modelList21);
		

		Model m51 = new Model(2010, 20000000);
		Model m52 = new Model(2011, 50000000);
		Model m53 = new Model(2012, 89000000);
		ArrayList<Model> modelList22 = new ArrayList<>();
		modelList22.add(m51);
		modelList22.add(m52);
		modelList22.add(m53);
		Line l22 = new Line("carro", modelList22);
		
		
		Model m61 = new Model(2013, 24000000);
		Model m62 = new Model(2014, 55000000);
		Model m63 = new Model(2015, 86000000);
		ArrayList<Model> modelList23 = new ArrayList<>();
		modelList23.add(m61);
		modelList23.add(m62);
		modelList23.add(m63);
		Line l23 = new Line("barco", modelList23);
		
		ArrayList<Line> lineList2 = new ArrayList<>();
		lineList2.add(l21);
		lineList2.add(l22);
		lineList2.add(l23);
		Brand b2 = new Brand("transportes", lineList2);
		
		ArrayList<Brand> brandList = new ArrayList<>();
		brandList.add(b);
		brandList.add(b2);
		
		VehicleTax c = new VehicleTax(brandList);
		
		System.out.print(c.calculateTax("animalitos", "perrito", 2011, 
				true, false, true));
		
	}
}
