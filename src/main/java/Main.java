import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Instantiate RSA class to generate keys
        RSA rsa = new RSA();

        // Display the generated public and private keys
        System.out.println("Public Key (n, e): (" + rsa.getN() + ", " + rsa.getE() + ")");

        // Message to be encrypted
        String originalMessage = "Hello, RSA!";
        BigInteger message = new BigInteger(originalMessage.getBytes(StandardCharsets.UTF_8));

        // Encrypt the message
        BigInteger encryptedMessage = rsa.encrypt(message);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Decrypt the message
        BigInteger decryptedMessage = rsa.decrypt(encryptedMessage);
        String decryptedText = new String(decryptedMessage.toByteArray(), StandardCharsets.UTF_8);
        System.out.println("Decrypted Message: " + decryptedText);

        // Verify that the decrypted message matches the original
        System.out.println("Decryption successful: " + originalMessage.equals(decryptedText));
    }
}
