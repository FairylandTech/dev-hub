/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 14:58:09 UTC+08:00
 ****************************************************/
package host.fairy.utils;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * 用户密码单向加密工具类，基于 PBKDF2WithHmacSHA256 算法
 *
 * @author Lionel Johnson
 */
public class PasswordUtils {
    // 固定盐值（实际应用中应为每个用户生成唯一盐值并存储在数据库中）
    public static final String SALT = "VVcnT0FHQ1ySK5W5QmBvgQ==";
    // 算法参数
    private static final String ALGORITHM = "PBKDF2WithHmacSHA256";
    // 盐值长度 (bytes)
    private static final int SALT_LENGTH = 16;
    // 导出密钥长度 (bits)
    private static final int KEY_LENGTH = 256;
    // 迭代次数
    private static final int ITERATIONS = 65536;
    private static final SecureRandom RANDOM = new SecureRandom();
    
    /**
     * 生成随机盐值
     *
     * @return Base64 编码的盐值
     */
    public static String generateSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        RANDOM.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
    
    /**
     * 对密码进行哈希
     *
     * @param password 原始明文密码
     * @param salt     Base64 编码的盐值
     * @return Base64 编码的哈希结果
     */
    public static String hashPassword(char[] password, String salt) {
        try {
            byte[] saltBytes = Base64.getDecoder().decode(salt);
            PBEKeySpec spec = new PBEKeySpec(password, saltBytes, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] hash = skf.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("无法生成密码哈希", e);
        }
    }
    
    /**
     * 验证密码是否匹配
     *
     * @param attemptedPassword 用户输入的明文密码
     * @param storedHash        数据库中存储的 Base64 哈希
     * @param storedSalt        数据库中存储的 Base64 盐值
     * @return 匹配返回 true，否则 false
     */
    public static boolean verifyPassword(char[] attemptedPassword, String storedHash, String storedSalt) {
        String newHash = hashPassword(attemptedPassword, storedSalt);
        // 直接比较两次哈希结果
        return newHash.equals(storedHash);
    }
    
    public static void main(String[] args) {
        String password = "123456";
        // 注册时：生成盐值并计算哈希，然后将它们存入数据库
        String salt = generateSalt();
        System.out.println("salt = " + salt);
        String hash = hashPassword(password.toCharArray(), SALT);
        System.out.println("Salt(Base64): " + SALT);
        System.out.println("Hash(Base64): " + hash);
        
        // 登录时：从数据库取出 salt 和 hash，再对用户输入的密码做同样运算并校验
        boolean match = verifyPassword("123456".toCharArray(), hash, SALT);
        System.out.println("密码校验：" + (match ? "通过" : "失败"));
    }
}
