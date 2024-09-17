package org.example;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelReader {
    private String path;
    ExcelReader(String path)
    {
        this.path = path;
    }

    public List<String> extractLines() throws Exception
    {
        List<String> resLines = new ArrayList<>();
        try {
            File file = new File(path);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator<Row> itr = sheet.iterator();
            String res = "";

            while(itr.hasNext()){
                Row row = itr.next();


                Iterator<Cell> celliterator = row.cellIterator();
                while(celliterator.hasNext()){
                    Cell cell = celliterator.next();
                    if (!cell.toString().equals("")){
                        res = res.concat(cell.toString()+",");
                    }
                    System.out.print(cell+" ");



                }
                System.out.println();
                resLines.add(res);
                res ="";
            }

        }catch (Exception e ){
            e.printStackTrace();
        }
        resLines.removeAll(Collections.singleton(""));
        System.out.println(resLines);
        System.out.println(resLines.size());
        return resLines;
    }
}