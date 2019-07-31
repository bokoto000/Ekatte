package ekatte;

import javax.swing.JFileChooser;
import ekatte.xlxsData;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OpenFile {

	JFileChooser fileChooser = new JFileChooser();
	xlxsData data = new xlxsData();

	public xlxsData PickFile() throws Exception {

		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

			java.io.File file = fileChooser.getSelectedFile();
			data.setPath(file.getAbsolutePath());

			File excelFile = new File(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(excelFile);

			// we create an XSSF Workbook object for our XLSX Excel File
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			// we get first sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				for (int cn = 0; cn < 12; cn++) {
					// If the cell is missing from the file, generate a blank one
					// (Works by specifying a MissingCellPolicy)
					Cell cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					data.addData(cell.toString());
					System.out.print(cell.toString() + ";");
					// Print the cell for debugging
					System.out.println("CELL: " + cn + " --> " + cell.toString());
				}
			}
			/* we iterate on rows
			Iterator<Row> rowIt = sheet.iterator();
			while (rowIt.hasNext()) {
				Row row = rowIt.next();

				// iterate on cells for the current row
				Iterator<Cell> cellIterator = row.cellIterator();
				for (int i = 0; i < 12; i++) {
					Cell cell = cellIterator.next();
					data.addData(cell.toString());
					System.out.print(cell.toString() + ";");
				}

				System.out.println();
			}*/

			workbook.close();
			fis.close();

			return data;
		}
		return null;
	}
}
