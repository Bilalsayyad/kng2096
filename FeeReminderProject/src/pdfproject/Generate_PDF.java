
package pdfproject;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Generate_PDF {
public static void main(String[] args) {
	Document document=new Document();
	try {
		PdfWriter writer=PdfWriter.getInstance(document,new FileOutputStream("E://test//bilal//PDFInstruction.pdf"));
		
	Font font=new Font(Font.FontFamily.TIMES_ROMAN,11,Font.NORMAL,BaseColor.GREEN);
	Font font1=new Font(Font.FontFamily.TIMES_ROMAN,26,Font.BOLD,BaseColor.ORANGE);
	Font font2=new Font(Font.FontFamily.TIMES_ROMAN,16,Font.ITALIC,BaseColor.MAGENTA);
	Font font3=new Font(Font.FontFamily.TIMES_ROMAN,16,Font.ITALIC,BaseColor.BLUE);
	Font font4=new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLD,BaseColor.GREEN);

	System.out.println("PDF Created.....");
	
		document.open();
		Paragraph para=new Paragraph("HAARIS INFOTECH ",font);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);
     	
		Paragraph para1=new Paragraph("Golden Touch ",font1);
		para1.setAlignment(Element.ALIGN_CENTER);
		document.add(para1);
		
		Paragraph para2=new Paragraph("The Full Stack Training Academy",font2);
		para2.setAlignment(Element.ALIGN_CENTER);
		document.add(para2);	
		Paragraph para3=new Paragraph("Dear Students, \n Kindly Pay Your Current Months Fees By EOD"
				+ " Today And Update The Same In Excel Sheet.Online Payment Number Have Gived Below In "
				+ "In The Table So Do Payment Asap.......",font3);
		document.add(para3);
		document.add(Chunk.NEWLINE);
		
	//create table
	
	PdfPTable table=new PdfPTable(9);

	float value=50000f;
			table.setTotalWidth(value);
			
	PdfPCell c1=new PdfPCell(new Paragraph("Sr.No"));c1.setBackgroundColor(BaseColor.RED);
	PdfPCell c2=new PdfPCell(new Paragraph(""));c1.setBackgroundColor(BaseColor.RED);
	table.addCell(c1);
    c1=new PdfPCell(new Paragraph("Course"));c1.setBackgroundColor(BaseColor.RED);
	table.addCell(c1);
	c1=new PdfPCell(new Paragraph("Batch"));c1.setBackgroundColor(BaseColor.RED);
	table.addCell(c1);
	c1=new PdfPCell(new Paragraph("Year"));c1.setBackgroundColor(BaseColor.RED);
	table.addCell(c1);
	c1=new PdfPCell(new Paragraph("Course Duration"));c1.setBackgroundColor(BaseColor.RED);
	table.addCell(c1);
	c1=new PdfPCell(new Paragraph("Registration Fee"));c1.setBackgroundColor(BaseColor.RED);
	table.addCell(c1);
	c1=new PdfPCell(new Paragraph("Monthly Fee"));c1.setBackgroundColor(BaseColor.RED);
	table.addCell(c1);
	c1=new PdfPCell(new Paragraph("Total Fee"));c1.setBackgroundColor(BaseColor.RED);
	table.addCell(c1);
	c1=new PdfPCell(new Paragraph("Online Payment Number"));c1.setBackgroundColor(BaseColor.RED);
	table.addCell(c1);
	c2=new PdfPCell(new Paragraph("1"));c2.setBackgroundColor(BaseColor.YELLOW);
	table.addCell(c2);
	c2=new PdfPCell(new Paragraph("Java FullStack Developer"));c2.setBackgroundColor(BaseColor.YELLOW);
	table.addCell(c2);
	c2=new PdfPCell(new Paragraph("Knightangle"));c2.setBackgroundColor(BaseColor.YELLOW);
	table.addCell(c2);
	c2=new PdfPCell(new Paragraph("2022"));c2.setBackgroundColor(BaseColor.YELLOW);
	table.addCell(c2);
	c2=new PdfPCell(new Paragraph("Six Month"));c2.setBackgroundColor(BaseColor.YELLOW);
	table.addCell(c2);
	c2=new PdfPCell(new Paragraph("750"));c2.setBackgroundColor(BaseColor.YELLOW);
	table.addCell(c2);
	c2=new PdfPCell(new Paragraph("250"));c2.setBackgroundColor(BaseColor.YELLOW);
	table.addCell(c2);
	c2=new PdfPCell(new Paragraph("1500"));c2.setBackgroundColor(BaseColor.YELLOW);
	table.addCell(c2);
	c2=new PdfPCell(new Paragraph("9840135749"));c2.setBackgroundColor(BaseColor.YELLOW);
	table.addCell(c2);
	document.add(table);
	document.add(Chunk.NEWLINE);
	document.add(Chunk.NEWLINE);
	Paragraph para4=new Paragraph("Thanxs & Regards",font3);
	document.add(para4);
	
	para3=new Paragraph("Shoiab",font4);
	document.add(para3);
	
	document.close();
	writer.close();
	
	} catch (Exception e) {
		System.out.println(e);
	}
}
}
