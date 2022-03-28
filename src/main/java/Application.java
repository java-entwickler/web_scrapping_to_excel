import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        ExcelWriter excelWriter = new ExcelWriter();
        WebScrapper webScrapper= new WebScrapper();
        List<Ranking> rankings = webScrapper.getRankings();
        excelWriter.writeExcel(rankings);
        rankings.forEach(System.out::println);
    }

}
