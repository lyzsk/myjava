package cn.sichu.myjava.october2021.encryptionalgorithm;

public interface ICaesar {
    String encrypt(String text, int shiftNum);

    String decrypt(String text, int shiftNum);
}
