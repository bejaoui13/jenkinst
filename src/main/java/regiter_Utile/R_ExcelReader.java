package regiter_Utile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class R_ExcelReader {

	FileInputStream fis = null;

	public FileInputStream getfileinput() {
		String filepath = System.getProperty("user.dir") + "/src/test/java/data/UserData.xlsx";
		File filesrc = new File(filepath);
		try {
			fis = new FileInputStream(filesrc);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return fis;
	}

	public String[][] getdataexcel() throws IOException {
 
		 String[][] xldata=null;
		 String[] newArray;
		 
		 
			fis = getfileinput();
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			int numrow = sheet.getLastRowNum() + 1;
			int numcol = sheet.getRow(0).getLastCellNum();
			xldata = new String[numrow][numcol];

			for(int i=0;i<numrow;i++){
				  newArray=new String[numcol]; 
				 for (int j=0;j<numcol;j++ ){
				   if(sheet.getRow(i).getCell(j)!=null){
				     XSSFCell cellval=sheet.getRow(i).getCell(j);
				     cellval.setCellType(CellType.STRING);
				     newArray[j] = cellval.toString();
				     
				   }
				   xldata[i][j] = newArray[j];   
				 }
				  
				}
				return xldata;

	 

 
	}
}
