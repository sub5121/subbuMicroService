package com.javatpoint.excelExportImport;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.javatpoint.model.Books;

public class ExcelGenerator {

	public static boolean checkExcel(MultipartFile file) {
		String contentType = file.getContentType();

		if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}

	public List<Books> convertExcelToList(InputStream inpStr) {

		List<Books> books = new ArrayList<>();

		try {
			XSSFWorkbook wb = new XSSFWorkbook(inpStr);
			XSSFSheet sheet = wb.getSheet("books");
			int rowNum = 0;
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING: // field that represents string cell type
						System.out.print(cell.getStringCellValue() + "\t\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC: // field that represents number cell type
						System.out.print(cell.getNumericCellValue() + "\t\t\t");
						break;
					default:
					}
				}
				System.out.println("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return books;
	}

}
