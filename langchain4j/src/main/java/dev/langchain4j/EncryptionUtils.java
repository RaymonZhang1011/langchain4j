package dev.langchain4j;


/**
 * EncryptionUtils
 * <p></p>
 *
 * @author ZhangKaiRui
 * @since 2024/9/23 17:28
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class EncryptionUtils {

    // 1. 使用 AES 加密
    public static String encryptAES(String data, String key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // 2. 使用 AES 解密
    public static String decryptAES(String encryptedData, String key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData, StandardCharsets.UTF_8);
    }

    // 3. 使用 RSA 生成密钥对
    public static KeyPair generateRSAKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        return keyPairGen.generateKeyPair();
    }

    // 4. 使用 RSA 加密
    public static String encryptRSA(String data, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // 5. 使用 RSA 解密
    public static String decryptRSA(String encryptedData, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData, StandardCharsets.UTF_8);
    }

    // 6. 生成 MD5 散列
    public static String generateMD5Hash(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    // 7. 生成 SHA-256 散列
    public static String generateSHA256Hash(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }

    public static void main(String[] args) throws Exception {
        // AES 加密解密示例
        String aesKey = "1234567890123456"; // 16 字节的密钥
        String originalText = "Hello, AES!";
        String encryptedAES = encryptAES(originalText, aesKey);
        String decryptedAES = decryptAES(encryptedAES, aesKey);

        System.out.println("AES 加密: " + encryptedAES);
        System.out.println("AES 解密: " + decryptedAES);

        // RSA 加密解密示例
        KeyPair rsaKeyPair = generateRSAKeyPair();
        String encryptedRSA = encryptRSA(originalText, rsaKeyPair.getPublic());
        String decryptedRSA = decryptRSA(encryptedRSA, rsaKeyPair.getPrivate());

        System.out.println("RSA 加密: " + encryptedRSA);
        System.out.println("RSA 解密: " + decryptedRSA);

        // MD5 和 SHA-256 散列示例
        String md5Hash = generateMD5Hash(originalText);
        String sha256Hash = generateSHA256Hash(originalText);

        System.out.println("MD5 散列: " + md5Hash);
        System.out.println("SHA-256 散列: " + sha256Hash);
    }
}
