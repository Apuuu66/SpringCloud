package com.guier.springboot.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.guier.springboot.pojo.Account;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.*;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class GsonMain {
    public static void main(String[] args) throws IOException {
        Account account1 = new Account().setId(1).setUsername("张三").setTel("110xxx110");
        Account account2 = new Account().setId(1).setUsername("张三").setTel("110xxx110");
        Account account3 = new Account().setId(1).setUsername("张三").setTel("110xxx110");
        List<Account> list = Arrays.asList(account1, account2, account3);
        ArrayList<Account> accountList = new ArrayList<>(list);

        // 1. obj to json
        Gson gson = new Gson();
        String jsonStr = gson.toJson(account1);
        System.out.println(jsonStr);
        System.out.println(gson.toJson(accountList));
        System.out.println(gson.toJson(accountList, new TypeToken<List<Account>>() {
        }.getType()));
        // 泛型类型
        Type type = new TypeToken<List<Account>>() {
        }.getType();
        System.out.println(gson.toJson(accountList, type));

        // 支持对值为null的对象进行封装
        gson = new GsonBuilder().serializeNulls().create();
        String str = gson.toJson(account1);
        System.out.println(str);
        Account account = gson.fromJson(str, Account.class);
        System.out.println(account);
        jackson();
    }

    public static void jackson() throws IOException {
        Account account1 = new Account().setId(1).setUsername("Li").setTel("110xxx110");
        Account account2 = new Account().setId(1).setUsername("Zhou").setTel("110xxx110");
        Account account3 = new Account().setId(1).setUsername("Wu").setTel("110xxx110");
        List<Account> list = Arrays.asList(account1, account2, account3);
        ArrayList<Account> accountList = new ArrayList<>(list);
        ObjectMapper objectMapper = new ObjectMapper();
        // 1. write to file
        String path = GsonMain.class.getClassLoader().getResource("").getPath();
        String fileName = path + "output.json";
        objectMapper.writeValue(new FileOutputStream(fileName), account1);
        // 2. write to string
        String json = objectMapper.writeValueAsString(account1);
        System.out.println(json);


        // 1. read from json string
        String accountJson = "{\"id\":1,\"username\":\"Li\",\"password\":null,\"email\":null,\"tel\":\"110xxx110\",\"list\":null}";
        Account account = objectMapper.readValue(accountJson, Account.class);
        System.out.println(account);
        // 2. read object from json reader
        Reader reader = new StringReader(accountJson);
        account = objectMapper.readValue(reader, Account.class);
        System.out.println(account);
        // 3. read object from json file
        File file = new File(fileName);
        account = objectMapper.readValue(file, Account.class);
        System.out.println(account);
        // 4. read object from json via url
        URL url = new URL("file:data/car.json");
        // 5. Read Object From JSON InputStream
        InputStream input = new FileInputStream(fileName);
        account = objectMapper.readValue(input, Account.class);
        System.out.println(account);
        // 6. Read Object From JSON Byte Array
        byte[] bytes = accountJson.getBytes("UTF-8");
        account = objectMapper.readValue(bytes, Account.class);
        System.out.println(account);
        // 7. read map from json string
        Map<String, Object> jsonMap = objectMapper.readValue(accountJson,
                new TypeReference<Map<String, Object>>() {
                });
        System.out.println(jsonMap);

        JsonNode jsonNode = objectMapper.readTree(accountJson);
        int id = jsonNode.get("id").asInt();
        System.out.println(id);
    }

    public static ObjectMapper configure() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 去掉默认的时间戳格式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 设置为东八区
        objectMapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        // 设置输入:
        // 禁止把POJO中值为null的字段映射到json字符串中
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        // 空值不序列化
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 反序列化时，属性不存在的兼容处理
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // 序列化时，日期的统一格式
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        // 序列化日期时以timestamps输出，默认true
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 序列化枚举是以toString() 来输出，默认false，即默认以name() 来输出
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        // 序列化枚举是以ordinal() 来输出，默认false
        objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, false);
        // 类为空时，不要抛异常
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 反序列化时, 遇到未知属性时是否引起结果失败
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 单引号处理
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 解析器支持解析结束符
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        return objectMapper;
    }
}

@Configuration
class JacksonConfig {
    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString("");
            }
        });
        return objectMapper;
    }
}