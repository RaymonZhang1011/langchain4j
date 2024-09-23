package dev.langchain4j;


/**
 * NumberUtils
 * <p></p>
 *
 * @author ZhangKaiRui
 * @since 2024/9/23 17:22
 */
public class NumberUtils {

    // 1. 判断一个数是否为偶数
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // 2. 判断一个数是否为奇数
    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    // 3. 获取两个数中的最大值
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    // 4. 获取两个数中的最小值
    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    // 5. 四舍五入一个浮点数
    public static double round(double value, int precision) {
        double scale = Math.pow(10, precision);
        return Math.round(value * scale) / scale;
    }

    // 6. 计算一个数的阶乘 (非负整数)
    public static long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // 7. 判断一个数是否为质数
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 8. 将字符串转换为整数，如果无法转换则返回默认值
    public static int parseInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    // 9. 将字符串转换为浮点数，如果无法转换则返回默认值
    public static double parseDouble(String str, double defaultValue) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    // 10. 生成一个指定范围内的随机整数
    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    // 11. 计算两个数字的最大公约数 (GCD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 12. 计算两个数字的最小公倍数 (LCM)
    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    // Main 方法示例
    public static void main(String[] args) {
        // 测试偶数、奇数判断
        System.out.println("10 是偶数: " + isEven(10));  // true
        System.out.println("15 是奇数: " + isOdd(15));  // true

        // 获取最大值和最小值
        System.out.println("最大值: " + max(10, 20));  // 20
        System.out.println("最小值: " + min(10, 20));  // 10

        // 测试四舍五入
        System.out.println("四舍五入 (2 位小数): " + round(3.14159, 2));  // 3.14

        // 计算阶乘
        System.out.println("5 的阶乘: " + factorial(5));  // 120

        // 判断质数
        System.out.println("7 是质数: " + isPrime(7));  // true
        System.out.println("10 是质数: " + isPrime(10));  // false

        // 字符串转数字
        System.out.println("字符串 '123' 转整数: " + parseInt("123", 0));  // 123
        System.out.println("字符串 'abc' 转整数 (默认值 0): " + parseInt("abc", 0));  // 0

        // 生成随机数
        System.out.println("随机数 (1 到 100): " + getRandomInt(1, 100));

        // 最大公约数与最小公倍数
        System.out.println("12 和 15 的最大公约数: " + gcd(12, 15));  // 3
        System.out.println("12 和 15 的最小公倍数: " + lcm(12, 15));  // 60
    }
}
