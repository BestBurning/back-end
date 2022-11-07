package com.di1shuai;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shea
 * @since 2022/11/2
 */
public class TestJson {

    public static void main(String[] args) {

        String schemaStr = "{\n" +
                "  \"type\": \"object\",\n" +
                "  \"title\": \"主数据推入Object\",\n" +
                "  \"properties\": {\n" +
                "    \"test1\": {\n" +
                "      \"type\": \"string\"\n" +
                "    },\n" +
                "    \"test2\": {\n" +
                "      \"type\": \"string\",\n" +
                "      \"enum\": [\n" +
                "        \"0\",\n" +
                "        \"1\"\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  \"if\": {\n" +
                "    \"properties\": {\n" +
                "      \"test2\": {\n" +
                "        \"enum\": [\n" +
                "          \"1\"\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"then\": {\n" +
                "    \"required\": [\n" +
                "      \"test1\"\n" +
                "    ]\n" +
                "  },\n" +
                "  \"else\": {\n" +
                "    \"properties\": {\n" +
                "      \"test2\": {\n" +
                "        \"enum\": [\n" +
                "          \"0\"\n" +
                "        ]\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        Map<String, String> jsonMap = new HashMap<>();
        jsonMap.put("全量json", "{\n" +
                "  \"test2\": \"1\"\n" +
                "}");
        JSONObject rawSchema = new JSONObject(new JSONTokener(schemaStr));
        SchemaLoader loader = SchemaLoader.builder().schemaJson(rawSchema).draftV7Support().build();
        Schema schema =loader.load().build();

        jsonMap.entrySet().stream().forEach(entry -> {
            System.out.print("case:【" + entry.getKey() + "】");
            try {
                schema.validate(new JSONObject(entry.getValue()));
                System.out.println(" ok");
            } catch (ValidationException e) {
                System.out.println(" error");
                e.getAllMessages().stream()
                        .forEach(s -> System.out.println(s));
            }
        });


    }

}
