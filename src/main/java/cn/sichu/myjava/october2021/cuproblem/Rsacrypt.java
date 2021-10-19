package cn.sichu.myjava.october2021.cuproblem;

import java.math.BigInteger;

/**
 * 公钥-私钥组成的密钥对是非常有用的加密方式，因为公钥是可以公开的，而私钥是完全保密的
 * <p>
 * 以RSA算法为例，它的密钥有256/512/1024/2048/4096等不同的长度。长度越长，密码强度越大，当然计算速度也越慢。
 * <p>
 * 如果修改待加密的byte[]数据的大小，可以发现，使用512bit的RSA加密时，明文长度不能超过53字节，
 * <p>
 * 使用1024bit的RSA加密时，明文长度不能超过117字节，这也是为什么使用RSA的时候，总是配合AES一起使用，
 * <p>
 * 即用AES加密任意长度的明文，用RSA加密AES口令。
 * 
 * @author sichu
 * @date 2021/10/19
 */
public class Rsacrypt {
    public static void main(String[] args) throws Exception {
        byte[] plaintext = "Hello, encrypt use RSA".getBytes("UTF-8");
        Rsaperson alice = new Rsaperson("Alice");

        // alice PublicKey 加密
        byte[] publick = alice.getPublicKey();
        System.out.printf("public key: %x\n", new BigInteger(1, publick));

        byte[] encrypted = alice.encrypt(plaintext);
        System.out.printf("encrypted: %x\n", new BigInteger(1, encrypted));

        byte[] privatek = alice.getPrivateKey();
        System.out.printf("private key: %x\n", new BigInteger(1, privatek));
        byte[] decrypted = alice.decrypt(encrypted);
        System.out.println(new String(decrypted, "UTF-8"));

    }
}
