package Utils;

import io.cucumber.java.en.Given;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class CommonMethods {

    @Given("search and locate value<value>in excel sheet")
    public void ReadDataFromExcel(String data) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"src/main/resources/Login.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);

        int sheetcount = xssfWorkbook.getNumberOfSheets();
        for(int i =0;i<sheetcount; i++){
            if(xssfWorkbook.getSheetName(i).equalsIgnoreCase("data"))
            {
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);

                //identify test case coloums by searching entire rows
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                //Find the first row
                Iterator<Cell> cellvalue = firstrow.cellIterator();
                //iterate through cells in first row
                int k = 0;
                int coloumIndex =0;
                while(cellvalue.hasNext())//check the value in each cell of current row
                {
                    Cell value = cellvalue.next();
                    if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
                    {

                        coloumIndex=k;
                        System.out.println("index of coloum "+coloumIndex + "value is " + value);
                        break;
                    }
                    k++;
                }

            }
        }
    }

}
