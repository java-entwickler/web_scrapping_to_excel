import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter {
    public void writeExcel(List<Ranking> rankingList) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();

        int rowCount = 0;

        for (int i = 0; i < rankingList.size(); i++) {
            Row row = sheet.createRow(++rowCount);
            if (i == 0) {
                writeHeaders(row);
            } else {
                writeRanking(rankingList.get(i), row);
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream("Quality of Life Ranking.xlsx")) {
            workbook.write(outputStream);
        }
    }

    private void writeHeaders(Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue("Rank");

        cell = row.createCell(2);
        cell.setCellValue("City");

        cell = row.createCell(3);
        cell.setCellValue("Quality of Life Index");

        cell = row.createCell(4);
        cell.setCellValue("Purchasing Power Index");

        cell = row.createCell(5);
        cell.setCellValue("Safety Index");

        cell = row.createCell(6);
        cell.setCellValue("Health Care Index");

        cell = row.createCell(7);
        cell.setCellValue("Cost of Living Index");

        cell = row.createCell(8);
        cell.setCellValue("Property Price to Income Ratio");

        cell = row.createCell(9);
        cell.setCellValue("Traffic Commute Time Index");

        cell = row.createCell(10);
        cell.setCellValue("Pollution Index");

        cell = row.createCell(11);
        cell.setCellValue("Climate Index");
    }


    private void writeRanking(Ranking ranking, Row row) {
        Cell cell = row.createCell(1);
        cell.setCellValue(row.getRowNum());

        cell = row.createCell(2);
        cell.setCellValue(ranking.getCity());

        cell = row.createCell(3);
        cell.setCellValue(ranking.getQualityOfLifeIndex());

        cell = row.createCell(4);
        cell.setCellValue(ranking.getPurchasingPowerIndex());

        cell = row.createCell(5);
        cell.setCellValue(ranking.getSafetyIndex());

        cell = row.createCell(6);
        cell.setCellValue(ranking.getHealthCareIndex());

        cell = row.createCell(7);
        cell.setCellValue(ranking.getCostOfLivingIndex());

        cell = row.createCell(8);
        cell.setCellValue(ranking.getPropertyPriceToIncomeRatio());

        cell = row.createCell(9);
        cell.setCellValue(ranking.getTrafficCommuteTimeIndex());

        cell = row.createCell(10);
        cell.setCellValue(ranking.getPollutionIndex());

        cell = row.createCell(11);
        cell.setCellValue(ranking.getClimateIndex());
    }

}
