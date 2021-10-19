package cn.sichu.myjava.october2021.cuproblem;

import java.math.BigInteger;

public class Rsacrypt {
    public static void main(String[] args) throws Exception {
        byte[] plaintext = "Hello, encrypt use RSA".getBytes("UTF-8");
        Rsaperson alice = new Rsaperson("Alice");

        // alice PublicKey 加密
        byte[] publick = alice.getPublicKey();
        System.out.println(String.format("public key: %x", new BigInteger(1, publick)));

        byte[] encrypted = alice.encrypt(plaintext);
        System.out.printf("encrypted: %x\n", new BigInteger(1, encrypted));

        byte[] privatek = alice.getPrivateKey();
        System.out.println(String.format("private key: %x", new BigInteger(1, privatek)));
        byte[] decrypted = alice.decrypt(encrypted);
        System.out.println(new String(decrypted, "UTF-8"));

    }
}
