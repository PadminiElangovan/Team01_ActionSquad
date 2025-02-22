package common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class ExcelReader {

	private static final ThreadLocal<Workbook> threadLocalWorkbook = new ThreadLocal<>();
	private int totalRow;

	public List<Map<String, String>> getData(String sheetName) throws InvalidFormatException, IOException {
		File file = new File(ConfigReader.getProperty("Excelpath"));
		if (!file.exists()) {
			throw new IOException("Excel file not found at path: " + ConfigReader.getProperty("Excelpath"));
		}

		Workbook workbook = threadLocalWorkbook.get();
		if (workbook == null) {
			workbook = WorkbookFactory.create(file);
			threadLocalWorkbook.set(workbook);

		}

		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the file.");
		}
		LoggerLoad.info("Excel is Initialised and Path :" + ConfigReader.getProperty("Excelpath"));
		return readSheet(sheet);

	}

	private List<Map<String, String>> readSheet(Sheet sheet) {
		totalRow = sheet.getLastRowNum();
		List<Map<String, String>> excelRows = new ArrayList<>();

		if (totalRow > 0) {
			Row headerRow = sheet.getRow(0);
			if (headerRow == null) {
				throw new IllegalStateException("Header row is missing in the sheet.");
			}

			List<String> headers = new ArrayList<>();
			for (Cell headerCell : headerRow) {
				headers.add(headerCell.getStringCellValue());
			}

			for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
				Row row = sheet.getRow(currentRow);
				if (row == null)
					continue; // Skip empty rows

				LinkedHashMap<String, String> columnMapData = new LinkedHashMap<>();
				for (int currentColumn = 0; currentColumn < headers.size(); currentColumn++) {
					Cell cell = row.getCell(currentColumn);
					String cellValue = getCellValueAsString(cell);
					columnMapData.put(headers.get(currentColumn), cellValue);
				}
				excelRows.add(columnMapData);
			}
		}

		return excelRows;
	}

	private String getCellValueAsString(Cell cell) {
		if (cell == null)
			return "";
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula();
		default:
			return "";
		}
	}

	public List<String> getColumnData(String sheetName, int columnIndex) throws InvalidFormatException, IOException {
		File file = new File(ConfigReader.getProperty("Excelpath"));
		if (!file.exists()) {
			throw new IOException("Excel file not found at path: " + ConfigReader.getProperty("Excelpath"));
		}

		Workbook workbook = threadLocalWorkbook.get();
		if (workbook == null) {
			workbook = WorkbookFactory.create(file);
			threadLocalWorkbook.set(workbook);
		}

		Sheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the file.");
		}

		List<String> columnData = new ArrayList<>();
		int totalRows = sheet.getLastRowNum();

		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			Row row = sheet.getRow(rowIndex);
			if (row == null)
				continue;

			Cell cell = row.getCell(columnIndex);
			String cellValue = getCellValueAsString(cell);
			columnData.add(cellValue);
		}

		return columnData;
	}

	public static void closeAllWorkbooks() {
		Workbook workbook = threadLocalWorkbook.get();
		if (workbook != null) {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				threadLocalWorkbook.remove();
			}
		}
	}

	public int countRow() {
		return totalRow;
	}
}
