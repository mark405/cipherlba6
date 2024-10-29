import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private BigInteger n, d, e;

    private int bitLength = 1024; // Bit length for the prime numbers

    // Constructor to generate keys
    public RSA() {
        generateKeys();
    }

    // Method to generate the public and private key pair
    public void generateKeys() {
        SecureRandom random = new SecureRandom();

        // Generate two large prime numbers
        BigInteger p = BigInteger.probablePrime(bitLength / 2, random);
        BigInteger q = BigInteger.probablePrime(bitLength / 2, random);

        n = p.multiply(q); // Calculate n = p * q
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE)); // Euler's totient function φ(n) = (p-1)(q-1)

        // Choose an integer e such that 1 < e < phi and gcd(e, phi) = 1
        e = new BigInteger("65537"); // Commonly used prime exponent

        // Calculate d as the modular multiplicative inverse of e modulo φ(n)
        d = e.modInverse(phi);
    }

    // Method to encrypt the message using the public key
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    // Method to decrypt the message using the private key
    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(d, n);
    }

    // Getters for public key components
    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }
}
