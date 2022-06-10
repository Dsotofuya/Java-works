package persistence;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import models.Condensacion;
import models.Partition;
import models.PartitionInfo;
import models.Process;
import models.ProcessInfo;
import utilities.Utilities;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("unused")
public class CreatePDF {
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
    private static String FILE = System.getProperty("user.home") + "/Reporte Simulacion.pdf";

    private static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
        document.left(100f);
        document.top(150f);
    }
    
    private static void addTitlePage(Document document) throws DocumentException {
        Paragraph preface = new Paragraph();
        addEmptyLine(preface, 1);
        preface.add(new Paragraph("Reporte simulaci"+"\u00f3"+"n procesador", chapterFont));
        addEmptyLine(preface, 1);
        preface.add(new Paragraph(
                "Reporte generado por: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                paragraphFont));
        addEmptyLine(preface, 3);
        document.add(preface);
    }

    private static void addContent(Document document, ArrayList<Process> exitProcessList, ArrayList<Condensacion> condensacionesList,
			ArrayList<Partition> exitPartitionList, ArrayList<Partition> historial) throws DocumentException {
       createTable(document,exitProcessList);
       createTableCondensasiones(document, condensacionesList);
       createTablePartition(document, exitPartitionList);
       createTableHistorialProcess(document, historial);    
    }
    
    private static void createTableHistorialProcess(Document document, ArrayList<Partition> historial) throws DocumentException {
    	Paragraph preface = new Paragraph();
        addEmptyLine(preface,1);
        preface.add(new Paragraph("Historial de paso de procesos por particiones", chapterFont));
        addEmptyLine(preface, 1);
        PdfPTable table = new PdfPTable(4);
        
        PdfPCell c1 = new PdfPCell(new Phrase("No"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Nombre Partición"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Nombre proceso"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Tamaño"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        for (int i = 0; i< historial.size(); i++){
            Partition partition = historial.get(i);
            table.addCell(String.valueOf(i + 1));
            table.addCell(partition.getPartitionName());
            table.addCell(partition.getProcessName());
            table.addCell(partition.getSize() + "");
        }
        preface.add(table);
        document.add(preface);
        
    }
    
    private static void createTableCondensasiones(Document document, ArrayList<Condensacion> condensacionesList) throws DocumentException {
    	Paragraph preface = new Paragraph();
        addEmptyLine(preface,1);
        preface.add(new Paragraph("Lista general", chapterFont));
        addEmptyLine(preface, 1);
        PdfPTable table = new PdfPTable(6);
        
        PdfPCell c1 = new PdfPCell(new Phrase("No"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Nombre "));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Nombre partición"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Nombre partición"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Partición resultado"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Tamaño"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        for (int i = 0; i< condensacionesList.size(); i++){
            Condensacion condensacion = condensacionesList.get(i);
            table.addCell(String.valueOf(i + 1));
            table.addCell(condensacion.getName());
            table.addCell(condensacion.getPartition().getPartitionName());
            table.addCell(condensacion.getPartition2().getPartitionName());
            table.addCell(condensacion.getPartition3().getPartitionName());
            table.addCell(condensacion.getSize() + "");
        }
        preface.add(table);
        document.add(preface);

        table.setHeaderRows(1);
    }
    
    private static void createTablePartition(Document document, ArrayList<Partition> exitPartitionList) throws DocumentException{
        Paragraph preface = new Paragraph();
        addEmptyLine(preface,1);
        preface.add(new Paragraph("Cola de salida de particiones", chapterFont));
        addEmptyLine(preface, 1);
        PdfPTable table = new PdfPTable(3);

        PdfPCell c1 = new PdfPCell(new Phrase("No"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Nombre"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Tamaño"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        table.setHeaderRows(1);

        for (int i = 0; i< exitPartitionList.size(); i++){
            Partition partition = exitPartitionList.get(i);
            table.addCell(String.valueOf(i + 1));
            table.addCell(partition.getPartitionName());
            table.addCell(String.valueOf(partition.getSize()));
        }
        preface.add(table);
        document.add(preface);


    }

    private static void createTable(Document document, ArrayList<Process> list) throws DocumentException{
        Paragraph preface = new Paragraph();
        addEmptyLine(preface,1);
        preface.add(new Paragraph("Cola de procesos de salida", chapterFont));
        addEmptyLine(preface, 1);
        PdfPTable table = new PdfPTable(4);

        PdfPCell c1 = new PdfPCell(new Phrase("No"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        
        c1 = new PdfPCell(new Phrase("Nombre del proceso"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Tiempo"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Tamanio"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        table.setHeaderRows(1);

        for (int i = 0; i< list.size(); i++){
            Process process = list.get(i);
            table.addCell(String.valueOf(i + 1));
            table.addCell(process.getProcessName());
            table.addCell(String.valueOf(Utilities.quitNegativeNumbers(process.getProcessTime())));
            table.addCell(process.getProcessSize() + "");
        }
        preface.add(table);
        document.add(preface);
    }


    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

	public void createReport(ArrayList<Process> exitProcessList, ArrayList<Condensacion> condensacionesList,
			ArrayList<Partition> exitPartitionList, ArrayList<Partition> historial) throws DocumentException, IOException  {
		Document document = new Document(PageSize.A4.rotate());
        FileOutputStream pdf = new FileOutputStream(FILE);
        PdfWriter.getInstance(document,pdf);
        document.open();
        addMetaData(document);
        addTitlePage(document);
        addContent(document, exitProcessList, condensacionesList, exitPartitionList, historial);
        document.close();
        File f = new File(FILE);
        Desktop.getDesktop().open(f);
	}
}