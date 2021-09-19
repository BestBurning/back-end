package com.di1shuai.jasper.test;

import com.di1shuai.jasper.service.ReportService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: shea
 * @date: 2021/8/3
 * @description:
 */
@SpringBootTest
public class PDFTest {

    @Autowired
    private ReportService reportService;

    @Test
    public void generatePDFTest() throws Exception {
        String templateName = "DemoReport";
        reportService.generateReport(templateName);
    }


}
