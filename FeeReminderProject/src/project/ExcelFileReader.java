package project;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
public void readSend() throws Exception {
	String ExcelFile="E:\\test\\bilal\\StudentInfo.xlsx";
	FileInputStream fis=new FileInputStream(ExcelFile);
	
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheetAt(0);
	
	int rows=sheet.getLastRowNum();
	int col=sheet.getRow(1).getLastCellNum();
	
	ArrayList<String>Name=new ArrayList<String>();
	ArrayList<String>Email=new ArrayList<String>();
	ArrayList<String>Num=new ArrayList<String>();
	ArrayList<String>FeeStatus=new ArrayList<String>();
	
	for (int i=1;i<=rows;i++) {
		XSSFRow row=sheet.getRow(i);
		for (int j=0;j<=rows;j++) {
			Cell val=row.getCell(j);
			switch(j) {
			case 0:
			Name.add(val.getStringCellValue());
			break;
			
			case 1:
				Email.add(val.getStringCellValue());
				break;
				
			case 2:
				Num.add(val.getStringCellValue().toString());
				break;
				
			case 3:
				FeeStatus.add(val.getStringCellValue());
				break;
				
			default:
				break;
			}
		}
	}
	
	for (String string : Name) {
		System.out.print(string+"\t\t");
	}System.out.println();
	for (String string : Email) {
		System.out.print(string );
	}System.out.println();
	for (String string : Num) {
		System.out.print(string +"\t\t");
	}System.out.println();
	for (String string : FeeStatus) {
		System.out.print(string+"\t\t\t");
	}
	System.out.println();
	System.out.println("Sending e-mails ");
	 EmailService ES=new EmailService();
	 ES.Sendmail(Name, Email, FeeStatus);
	SMS sms=new SMS();
	sms.sendSms("+919769069454");
	 
	 System.out.println("E-mails sent successfully...");
}
}
