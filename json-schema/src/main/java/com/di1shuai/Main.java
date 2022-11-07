package com.di1shuai;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String schemaStr = "{\n" +
                "    \"type\":\"object\",\n" +
                "    \"title\":\"主数据推入Object\",\n" +
                "    \"properties\":{\n" +
                "        \"internalUnitVals\":{\n" +
                "            \"type\":\"string\",\n" +
                "            \"enum\":[\n" +
                "                \"0\",\n" +
                "                \"1\"\n" +
                "            ],\n" +
                "            \"enumDesc\":\"是否内部单位,枚举(示意) : 0(不是),1(是)\"\n" +
                "        },\n" +
                "        \"status\":{\n" +
                "            \"type\":\"string\",\n" +
                "            \"enum\":[\n" +
                "                \"0\",\n" +
                "                \"1\"\n" +
                "            ],\n" +
                "            \"enumDesc\":\"数据状态,枚举(示意) : 0(新增或修改),1(删除)\"\n" +
                "        },\n" +
                "        \"propertyCode\":{\n" +
                "            \"type\":\"string\",\n" +
                "            \"enum\":[\n" +
                "                \"1\",\n" +
                "                \"2\",\n" +
                "                \"3\",\n" +
                "                \"4\"\n" +
                "            ],\n" +
                "            \"enumDesc\":\"单位性质编码,枚举(示意) : 1(境内组织),2(境内个人),3(境外组织),4(境外个人)\"\n" +
                "        },\n" +
                "        \"fullName\":{\n" +
                "            \"type\":\"string\"\n" +
                "        },\n" +
                "        \"customerId\":{\n" +
                "            \"type\":\"string\"\n" +
                "        },\n" +
                "        \"bankInfo\":{\n" +
                "            \"type\":\"array\",\n" +
                "            \"items\":{\n" +
                "                \"type\":\"object\",\n" +
                "                \"properties\":{\n" +
                "                    \"bankOfDeposit\":{\n" +
                "                        \"type\":\"string\"\n" +
                "                    },\n" +
                "                    \"bankAccount\":{\n" +
                "                        \"type\":\"string\"\n" +
                "                    },\n" +
                "                    \"accountName\":{\n" +
                "                        \"type\":\"string\"\n" +
                "                    },\n" +
                "                    \"number\":{\n" +
                "                        \"type\":\"string\"\n" +
                "                    },\n" +
                "                    \"accountType\":{\n" +
                "                        \"type\":\"string\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"required\":[\n" +
                "        \"fullName\",\n" +
                "        \"customerId\",\n" +
                "        \"status\",\n" +
                "        \"propertyCode\"\n" +
                "    ]\n" +
                "}";
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("全量json", "{\"industryName\":\"77777\",\"website\":\"77777\",\"buildTime\":\"20210808 00:00:00\",\"idCard\":\"77777\",\"fullName\":\"77777\",\"updateTime\":\"20220808 00:00:00\",\"industryCode\":\"77777\",\"propertyCode\":\"2\",\"money\":\"77777\",\"phone\":\"77777\",\"clientCode\":\"88888\",\"customerId\":\"77777\",\"internalUnitVals\":\"1\",\"fax\":\"77777\",\"email\":\"77777\",\"status\":\"0\"}");
        jsonMap.put("fullName没有", "{\"industryName\":\"77777\",\"website\":\"77777\",\"buildTime\":\"20210808 00:00:00\",\"idCard\":\"77777\",\"updateTime\":\"20220808 00:00:00\",\"industryCode\":\"77777\",\"propertyCode\":\"2\",\"money\":\"77777\",\"phone\":\"77777\",\"clientCode\":\"88888\",\"customerId\":\"77777\",\"internalUnitVals\":\"1\",\"fax\":\"77777\",\"email\":\"77777\",\"status\":\"0\"}");
        jsonMap.put("必填项没有", "{\"industryName\":\"77777\",\"website\":\"77777\",\"buildTime\":\"20210808 00:00:00\",\"idCard\":\"77777\",\"updateTime\":\"20220808 00:00:00\",\"industryCode\":\"77777\",\"money\":\"77777\",\"phone\":\"77777\",\"clientCode\":\"88888\",\"internalUnitVals\":\"1\",\"fax\":\"77777\",\"email\":\"77777\"}");
        jsonMap.put("bankInfo不为数组", "{\"industryName\":\"77777\",\"website\":\"77777\",\"buildTime\":\"20210808 00:00:00\",\"idCard\":\"77777\",\"fullName\":\"77777\",\"updateTime\":\"20220808 00:00:00\",\"industryCode\":\"77777\",\"propertyCode\":\"2\",\"money\":\"77777\",\"phone\":\"77777\",\"clientCode\":\"88888\",\"customerId\":\"77777\",\"internalUnitVals\":\"1\",\"fax\":\"77777\",\"email\":\"77777\",\"status\":\"0\"}");


        JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStr));
        Schema schema = SchemaLoader.load(rawSchema);

        jsonMap.entrySet().stream().forEach(entry -> {
            System.out.print("case:【" + entry.getKey() + "】");
            try {
                schema.validate(new JSONObject(entry.getValue()));
                System.out.println(" ok");
            } catch (ValidationException e) {
                System.out.println(" error");
                e.getCausingExceptions().stream()
                        .map(ValidationException::getMessage)
                        .forEach(s -> System.out.println(s));
            }
        });


    }
}
