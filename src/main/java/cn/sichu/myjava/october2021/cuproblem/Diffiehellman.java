package cn.sichu.myjava.october2021.cuproblem;

/**
 * DH算法是一个密钥协商算法，双方最终协商出一个共同的密钥，而这个密钥不会通过网络传输。
 * <p>
 * DH算法的本质就是双方各自生成自己的私钥和公钥，私钥仅对自己可见，然后交换公钥，并根据自己的私钥和对方的公钥，生成最终的密钥secretKey，DH算法通过数学定律保证了双方各自计算出的secretKey是相同的。
 * <p>
 * 双方的SecretKey相同，后续通信将使用SecretKey作为密钥进行AES加解密
 * 
 * @author sichu
 * @date 2021/10/19
 */
public class Diffiehellman {
    public static void main(String[] args) {
        Person bob = new Person("Bob");
        Person alice = new Person("Alice");

        // generate each one's KeyPair
        bob.generateKeyPair();
        alice.generateKeyPair();

        // 交换各自的 PublicKey
        // 相互根据对方的 PublicKey 生成自己的本地密钥
        bob.generateSecretKey(alice.publicKey.getEncoded());
        alice.generateSecretKey(bob.publicKey.getEncoded());

        // 检查双方本地密钥是否相同
        bob.printKeys();
        alice.printKeys();

    }
}
