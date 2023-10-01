
package javaapplication1;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.util.*;
/**
 *
 * @author Abenezer Ashenafi
 */
public class RSA {
    
    public static void main(String args[]) {
        int p, q, n, z, d = 0, e, i;
        int msg = 12; // The number to be encrypted and decrypted
        Scanner sc = new Scanner(System.in);
        double c;
        BigInteger msgback;
        // 1st prime number p
        p = 3;
        // 2nd prime number q
        q = 11;
        System.out.println("This program is done only for showing RSA alogristhm steps and prove");  
        
        boolean validInput = false;
        do {
           System.out.println("Enter a message that is integer number :");
            try {
                msg = Integer.parseInt(sc.nextLine());
                validInput = true;
            } catch (NumberFormatException f) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        } while (!validInput);
        System.out.println("The integer entered is: " + msg);
    
        n = p * q;
        z = (p - 1) * (q - 1);

        System.out.println("the value of z = " + z);

        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) {
                break;
            }
        }

        System.out.println("the value of e = " + e);
        System.out.println("the public key set are{e:" + e +", n:" + n + "}" );

        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }

        System.out.println("the value of d = " + d);
        System.out.println("the private key set are{d:" + d +", n:" + n + "}");
        c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message is : " + c);

        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();

        msgback = (C.pow(d)).mod(N);
        System.out.println("Derypted message is : " + msgback);
    }

    static int gcd(int e, int z) {
        if (e == 0) {
            return z;
        } else {
            return gcd(z % e, e);
        }
    }
}
    
    

