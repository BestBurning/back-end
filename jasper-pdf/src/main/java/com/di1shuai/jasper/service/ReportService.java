package com.di1shuai.jasper.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: shea
 * @date: 2021/8/3
 * @description:
 */
@Service
public class ReportService {

    File jasperFolder;

    @Value("${report.path}")
    String reportPath;

    public void generateReport(String templateName) throws Exception {


        File jasperFile = getTemplate(templateName);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);

        Map paraMap = new HashMap<String, Object>();
        paraMap.put("title", "THIS IS TITLE");
        paraMap.put("date", new SimpleDateFormat("yyyy-mm-dd").format(new Date()));
        paraMap.put("name", "小明");
        paraMap.put("age", "18");
        paraMap.put("dept", "开发部");
        paraMap.put("gender", "男");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paraMap, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + File.separator + "Rpt.pdf");
    }

    private File getTemplate(String templateName) throws IOException {
        File templateFile;
        templateName = templateName + ".jasper";
        if (null == this.jasperFolder) {
            ClassPathResource classPathResource = new ClassPathResource(templateName);
            templateFile = classPathResource.getFile();
        } else {
            templateFile = new File(this.jasperFolder, templateName);
        }
        if (!templateFile.exists())
            throw new RuntimeException("未找到PDF模板文件");
        return templateFile;
    }
}
