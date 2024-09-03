package Practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFronExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis =new FileInputStream("C:\\Users\\LENOVO\\Desktop\\testScriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		 int rowcount = sh.getLastRowNum();
		  
		for(int i=1;i<=rowcount;i++){
			Row row = sh.getRow(i);
		String cell = row.getCell(0).toString();
		String data = row.getCell(1).toString(); 
		System.out.println(cell+"\t"+data);
		}
		wb.close();

	}

}
