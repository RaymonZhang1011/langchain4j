package dev.langchain4j;


/**
 * StringUtils
 * <p></p>
 *
 * @author ZhangKaiRui
 * @since 2024/9/23 17:21
 */
public class StringUtils {

    // 1. 反转字符串
    public static String reverse(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    // 2. 将字符串转换为大写
    public static String toUpperCase(String input) {
        if (input == null) {
            return null;
        }
        return input.toUpperCase();
    }

    // 3. 将字符串转换为小写
    public static String toLowerCase(String input) {
        if (input == null) {
            return null;
        }
        return input.toLowerCase();
    }

    // 4. 拼接两个字符串
    public static String concatenate(String str1, String str2) {
        return (str1 != null ? str1 : "") + (str2 != null ? str2 : "");
    }

    // 5. 查找子字符串是否存在
    public static boolean contains(String input, String substring) {
        if (input == null || substring == null) {
            return false;
        }
        return input.contains(substring);
    }

    // 6. 删除字符串两端的空白字符
    public static String trim(String input) {
        if (input == null) {
            return null;
        }
        return input.trim();
    }

    // 7. 判断字符串是否为空或仅包含空白字符
    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    // 8. 替换子字符串
    public static String replace(String input, String target, String replacement) {
        if (input == null || target == null || replacement == null) {
            return input;
        }
        return input.replace(target, replacement);
    }

    // 9. 将字符串按分隔符分割为字符串数组
    public static String[] split(String input, String delimiter) {
        if (input == null || delimiter == null) {
            return null;
        }
        return input.split(delimiter);
    }

    // 10. 将字符串数组合并成一个字符串，使用指定的分隔符
    public static String join(String[] elements, String delimiter) {
        if (elements == null || delimiter == null) {
            return null;
        }
        return String.join(delimiter, elements);
    }

    public static void main(String[] args) {
        // 测试方法
        System.out.println("反转: " + reverse("hello")); // 输出: olleh
        System.out.println("大写: " + toUpperCase("hello")); // 输出: HELLO
        System.out.println("小写: " + toLowerCase("HELLO")); // 输出: hello
        System.out.println("拼接: " + concatenate("hello", " world")); // 输出: hello world
        System.out.println("是否包含子字符串: " + contains("hello world", "world")); // 输出: true
        System.out.println("去空格: " + trim("  hello world  ")); // 输出: hello world
        System.out.println("是否为空: " + isBlank("  ")); // 输出: true
        System.out.println("替换: " + replace("hello world", "world", "java")); // 输出: hello java
        System.out.println("分割: " + String.join(", ", split("a,b,c", ","))); // 输出: a, b, c
        System.out.println("合并: " + join(new String[]{"a", "b", "c"}, ", ")); // 输出: a, b, c
    }
}
