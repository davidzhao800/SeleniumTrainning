package commonutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {
	private Workbook oExcelWb;
	private InputStream oFileReader;
	private OutputStream oFileWriter;
	private String sExcelFileName;
	
	private void setNullValues() throws Exception {
		oExcelWb= null;
		oFileReader = null;
		oFileWriter = null;
		sExcelFileName = "";
	}
	
	private ExcelDriver() throws Exception {
		setNullValues();
	}
	
	public void openExcelFile( String sFileName) throws Exception {
		File oFile = new File(sFileName);
		if (!oFile.exists()) {
			oExcelWb = new XSSFWorkbook();
			oFileWriter = new FileOutputStream(sFileName);
			oExcelWb.write(oFileWriter);
			oFileWriter.close();
			setNullValues();
		}
		
		oFileReader = new FileInputStream(sFileName);
		oExcelWb = WorkbookFactory.create(oFileReader);
		sExcelFileName = sFileName;
	}
	
	public void closeExcelFile() throws Exception {
		if (oFileReader != null ) oFileReader.close();
		if (oExcelWb != null ) oExcelWb.close();
		
		setNullValues();
	}
	
	public void save() throws Exception {
		oFileWriter = new FileOutputStream(sExcelFileName);
		oExcelWb.write(oFileWriter);
		oFileWriter.close();
		oFileWriter = null;
	}
	
	public void saveAs(String sNewExcelFileName) throws Exception {
		if (new File(sNewExcelFileName).exists()) {
			throw new Exception("Specified already exists. NewFileNme = " + sNewExcelFileName);
		}
		
		oFileWriter = new FileOutputStream(sNewExcelFileName);
		oExcelWb.write(oFileWriter);
		oFileWriter.close();
		oFileWriter = null;
	}
	
	public void createNewSheet(String sSheetName) throws Exception {
		Sheet oSheet;
		oSheet = oExcelWb.getSheet(sSheetName);
		
		if(oSheet !=null) {
			System.err.println("Error: Specified Sheet Already Exists. SheetName = "+sSheetName);
		}else {
			oExcelWb.createSheet(sSheetName);
		}
	}
	
	public int getRowCount(String sSheetName) throws Exception {
		Sheet oSheet ;
		oSheet = oExcelWb.getSheet(sSheetName);
		if (oSheet == null) {
			 return 0;
		} else {
			return oSheet.getLastRowNum() +1;
		}
	}
	
	public int getRowCount(String sSheetName, int iRow) throws Exception {
		Sheet oSheet ;
		oSheet = oExcelWb.getSheet(sSheetName);
		if (oSheet == null) {
			 return 0;
		}
		Row oRow =  oSheet.getRow(iRow-1);
		if (oRow != null ) {
			return oRow.getLastCellNum() +1;
		} else {
			return 0;
		}
	}
	
	public String getCellData(String sSheetName, int iRow, int iCell) throws Exception {
		return oExcelWb.getSheet(sSheetName).getRow(iRow-1).getCell(iCell-1).getStringCellValue();
	}
	
	public void setCellData(String sSheetName, int iRow, int iCell, String sValue) throws Exception {
		Sheet oSheet;
		Row oRow;
		Cell oCell;
		
		oSheet = oExcelWb.getSheet(sSheetName);
		if (oSheet ==null) {
			oExcelWb.createSheet(sSheetName);
			oSheet = oExcelWb.getSheet(sSheetName);
		}
		
		oRow = oSheet.getRow(iRow-1);
		if (oRow ==null) {
			oSheet.createRow(iRow-1);
			oRow = oSheet.getRow(iRow-1);
		}
		
		oCell = oRow.getCell(iCell-1);
		if (oCell ==null) {
			oRow.createCell(iCell-1);
			oCell = oRow.getCell(iCell-1);
		}
		oCell.setCellValue(sValue);
	}
	
	
	
}
