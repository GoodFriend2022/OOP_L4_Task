import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ImportExport {
    
    private Workbook workbook;
    private Sheet sheet;
    private FileOutputStream fos;
    private ArrayList<String> importFile;
    
    
    public void exportExcel(Save save) throws IOException {
        this.workbook = new HSSFWorkbook();
        this.sheet = workbook.createSheet("Исполнители");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("id");
        cell = row.createCell(1);
        cell.setCellValue("Время постановки задачи");
        cell = row.createCell(2);
        cell.setCellValue("Дэдлайн");
        cell = row.createCell(3);
        cell.setCellValue("Задача");
        cell = row.createCell(4);
        cell.setCellValue("Исполнитель");
        for (int i = 1; i <= save.getpTask().size(); i++) {
            row = sheet.createRow(i);
            for (int j = 0; j < save.getpTask().get(0).size(); j++) {
                cell = row.createCell(j);
                cell.setCellValue(save.getpTask().get(i - 1).get(j));
            }
        }
        this.fos = new FileOutputStream("planner.xls");
        this.workbook.write(fos);
        this.fos.close();
    }

    public void importExcel(Save save) throws IOException {
        FileInputStream fls = new FileInputStream("planner2.xls");
        Workbook wb = new HSSFWorkbook(fls);
        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            this.importFile = new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        this.importFile.add(String.format("%.0f", cell.getNumericCellValue()));
                        break;
                    case Cell.CELL_TYPE_STRING:
                        this.importFile.add(cell.getStringCellValue());
                        break;
                    }
                }
            }
            if (!this.importFile.containsAll(save.getpTask())) {
                save.getpTask().add(this.importFile);
        }
        fls.close();
    }
    
}
