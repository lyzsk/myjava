package cn.sichu.myjava.october2021.cuproblem;

import java.util.HashSet;

public class Primitiveroot {
    // public static int gcd(int a, int b) {
    // if (a == 0) {
    // return b;
    // }
    // if (b == 0) {
    // return a;
    // }
    //
    // if (a == b) {
    // return a;
    // }
    //
    // if (a > b) {
    // return gcd(a - b, b);
    // }
    // return gcd(a, b - a);
    // }
    //
    // public static int countPrimitiveRoots(int p) {
    // int res = 1;
    // for (int i = 2; i < p; i++) {
    // if (gcd(i, p) == 1) {
    // ++res;
    // }
    // }
    // return res;
    // }
    //
    // public static void main(String[] args) {
    // int p = 7;
    // System.out.println(countPrimitiveRoots(p - 1));
    // }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n < 4) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {

        }

        return true;
    }

    public static int power(int x, int y, int p) {
        int res = 1;

        x = x % p;

        while (y > 0) {
            if (y % 2 == 1) {
                res = (res * x) % p;
            }
            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    public static void findPrimefactors(HashSet<Integer> s, int n) {
        while (n % 2 == 0) {
            s.add(2);
            n = n >> 1;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                s.add(i);
                n = n / i;
            }
        }

        if (n > 2) {
            s.add(n);
        }
    }

    public static int findPrimitive(int n) {
        HashSet<Integer> s = new HashSet<Integer>();

        if (isPrime(n) == false) {
            return -1;
        }

        int phi = n - 1;

        findPrimefactors(s, phi);

        for (int r = 2; r <= phi; r++) {
            boolean flag = false;
            for (Integer a : s) {
                if (power(r, phi / (a), n) == 1) {
                    flag = true;
                    break;
                }
            }

            if (flag == false) {
                return r;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(findPrimitive(n));
    }
}
