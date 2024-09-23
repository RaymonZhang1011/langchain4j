package dev.langchain4j;


/**
 * JsonUtils
 * <p></p>
 *
 * @author ZhangKaiRui
 * @since 2024/9/23 17:24
 */
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class JsonUtils {

    // Jackson 的 ObjectMapper 是线程安全的
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // 1. 将对象转换为 JSON 字符串
    public static String toJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    // 2. 将对象转换为格式化的 JSON 字符串 (美化输出)
    public static String toPrettyJson(Object obj) throws JsonProcessingException {
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    // 3. 将 JSON 字符串转换为 Java 对象
    public static <T> T fromJson(String jsonString, Class<T> clazz) throws IOException {
        return objectMapper.readValue(jsonString, clazz);
    }

    // 4. 将 JSON 字符串转换为 JsonNode (方便读取树形结构)
    public static JsonNode parseJson(String jsonString) throws JsonProcessingException {
        return objectMapper.readTree(jsonString);
    }

    // 5. 从 JsonNode 中读取字段值
    public static String getFieldFromJson(JsonNode jsonNode, String fieldName) {
        JsonNode fieldNode = jsonNode.get(fieldName);
        return fieldNode != null ? fieldNode.asText() : null;
    }

    // 6. 判断字符串是否是有效的 JSON
    public static boolean isValidJson(String jsonString) {
        try {
            objectMapper.readTree(jsonString);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // 7. 将 JSON 字符串转换为带缩进的格式
    public static String formatJson(String jsonString) throws JsonProcessingException {
        Object jsonObject = objectMapper.readValue(jsonString, Object.class);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
    }

    public static void main(String[] args) {
        try {
            // 示例对象
            User user = new User("John", 30);

            // 对象转换为 JSON 字符串
            String jsonString = toJson(user);
            System.out.println("普通 JSON: " + jsonString);

            // 对象转换为格式化的 JSON 字符串
            String prettyJsonString = toPrettyJson(user);
            System.out.println("格式化 JSON: " + prettyJsonString);

            // JSON 字符串转换为对象
            User parsedUser = fromJson(jsonString, User.class);
            System.out.println("解析后的 User 对象: " + parsedUser.getName() + ", 年龄: " + parsedUser.getAge());

            // 解析 JSON 字符串为 JsonNode
            JsonNode jsonNode = parseJson(jsonString);
            String name = getFieldFromJson(jsonNode, "name");
            System.out.println("从 JsonNode 中读取 name 字段: " + name);

            // 判断是否为有效的 JSON 字符串
            boolean valid = isValidJson(jsonString);
            System.out.println("JSON 是否有效: " + valid);

            // 将 JSON 字符串格式化输出
            String formattedJson = formatJson(jsonString);
            System.out.println("格式化的 JSON 字符串: " + formattedJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 示例用户类
class User {
    private String name;
    private int age;

    // 构造函数
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter 和 Setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
