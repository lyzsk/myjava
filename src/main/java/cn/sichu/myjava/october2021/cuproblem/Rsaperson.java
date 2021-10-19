package cn.sichu.myjava.october2021.cuproblem;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class Rsaperson {
    public String name;
    PrivateKey privatek;
    PublicKey publick;

    public Rsaperson(String name) throws GeneralSecurityException {
        super();
        this.name = name;

        // 生成 公钥-私钥 Pair
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair kp = kpGen.generateKeyPair();
        this.privatek = kp.getPrivate();
        this.publick = kp.getPublic();
    }

    /**
     * 私钥导出为字节数组
     * 
     * @return
     */
    public byte[] getPrivateKey() {
        return this.privatek.getEncoded();
    }

    /**
     * 公钥导出为字节数组
     * 
     * @return
     */
    public byte[] getPublicKey() {
        return this.publick.getEncoded();
    }

    /**
     * 对公钥加密
     * 
     * @param message
     * @return
     * @throws GeneralSecurityException
     */
    public byte[] encrypt(byte[] message) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.publick);
        return cipher.doFinal(message);
    }

    /**
     * 对私钥解密
     * 
     * @param input
     * @return
     * @throws GeneralSecurityException
     */
    public byte[] decrypt(byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.privatek);
        return cipher.doFinal(input);
    }
}
