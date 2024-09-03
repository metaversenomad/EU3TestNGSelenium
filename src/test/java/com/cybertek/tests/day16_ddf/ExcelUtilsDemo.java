package com.cybertek.tests.day16_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {
    @Test
    public void readExcelFile(){

        ExcelUtil qa3short = new  ExcelUtil ("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        System.out.println("qa3short.rowCount() = " + qa3short.rowCount());

        System.out.println("qa3short.columnCount() = " + qa3short.columnCount());

        System.out.println("qa3short.getColumnsNames() = " + qa3short.getColumnsNames());

        List<Map<String, String>> dataList = qa3short.getDataList();
        for (Map<String, String> onerow : dataList) {
            System.out.println(onerow);

        }
        System.out.println("dataList.get(2) = " + dataList.get(2).get("firstname"));

        System.out.println("dataList.get(8) = " + dataList.get(8).get("lastname"));

        String [] [] dataArray = qa3short.getDataArray();

        System.out.println(Arrays.deepToString(dataArray));
    }
}
