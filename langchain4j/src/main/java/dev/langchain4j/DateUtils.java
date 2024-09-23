package dev.langchain4j;


/**
 * DateUtils
 * <p></p>
 *
 * @author ZhangKaiRui
 * @since 2024/9/23 17:22
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {

    // 1. 获取当前日期 (LocalDate)
    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    // 2. 获取当前时间 (LocalTime)
    public static LocalTime getCurrentTime() {
        return LocalTime.now();
    }

    // 3. 获取当前日期和时间 (LocalDateTime)
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    // 4. 格式化日期为指定格式 (LocalDate)
    public static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    // 5. 解析指定格式的日期字符串 (LocalDate)
    public static LocalDate parseDate(String dateStr, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateStr, formatter);
    }

    // 6. 获取两个日期之间的天数差
    public static long getDaysBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    // 7. 获取两个时间之间的小时差
    public static long getHoursBetween(LocalTime startTime, LocalTime endTime) {
        return ChronoUnit.HOURS.between(startTime, endTime);
    }

    // 8. 日期加天数
    public static LocalDate addDays(LocalDate date, int days) {
        return date.plusDays(days);
    }

    // 9. 日期减天数
    public static LocalDate subtractDays(LocalDate date, int days) {
        return date.minusDays(days);
    }

    // 10. 将 Date 转换为 LocalDate
    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // 11. 将 LocalDate 转换为 Date
    public static Date convertToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    // 12. 获取当前时间的时间戳 (秒)
    public static long getCurrentTimestamp() {
        return Instant.now().getEpochSecond();
    }

    // 13. 格式化 Date (旧版 Date)
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    // 14. 解析 Date 字符串 (旧版 Date)
    public static Date parseDateOld(String dateStr, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);
    }

    // Main 方法示例
    public static void main(String[] args) throws ParseException {
        // 获取当前日期和时间
        System.out.println("当前日期: " + getCurrentDate());
        System.out.println("当前时间: " + getCurrentTime());
        System.out.println("当前日期和时间: " + getCurrentDateTime());

        // 日期格式化和解析
        LocalDate date = LocalDate.of(2024, 9, 25);
        System.out.println("格式化日期: " + formatDate(date, "yyyy-MM-dd"));

        String dateStr = "2024-09-25";
        LocalDate parsedDate = parseDate(dateStr, "yyyy-MM-dd");
        System.out.println("解析日期: " + parsedDate);

        // 日期计算
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 12, 31);
        System.out.println("日期差: " + getDaysBetween(startDate, endDate) + " 天");

        // 日期加减
        System.out.println("加 10 天: " + addDays(date, 10));
        System.out.println("减 10 天: " + subtractDays(date, 10));

        // Date 和 LocalDate 互相转换
        Date oldDate = new Date();
        LocalDate localDate = convertToLocalDate(oldDate);
        System.out.println("Date 转 LocalDate: " + localDate);

        Date newDate = convertToDate(localDate);
        System.out.println("LocalDate 转 Date: " + newDate);

        // 获取当前时间戳
        System.out.println("当前时间戳: " + getCurrentTimestamp());

        // 旧版 Date 格式化和解析
        Date parsedOldDate = parseDateOld("2024-09-25", "yyyy-MM-dd");
        System.out.println("旧版 Date 解析: " + formatDate(parsedOldDate, "yyyy-MM-dd"));
    }
}
