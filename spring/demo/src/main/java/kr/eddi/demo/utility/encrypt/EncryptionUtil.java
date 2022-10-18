package kr.eddi.demo.utility.encrypt;

import kr.eddi.demo.utility.encrypt.exception.UnableToGenerateHash;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class EncryptionUtil {
    private static final int COUNT_OF_ITERATION = 1000;
    private static final int LENGTH_OF_SALT = 16;
    private static final int RADIX = 16;
    private static final int LENGTH_OF_KEY = 64 * 8;
    private static final String PBKDF2_HMAC_SHA1 = "PBKDF2WithHmacSHA1";
    private static final String SECURE_RND = "SHA1PRNG";
    private static final String DELIMITER = ":";

    public static String generateHash(final String plain) {
        try {
            final char[] charSequence = plain.toCharArray();
            final byte[] salt = getSalt();

            final PBEKeySpec spec = new PBEKeySpec(charSequence, salt, COUNT_OF_ITERATION, LENGTH_OF_KEY);
            final SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_HMAC_SHA1);
            final byte[] hash = skf.generateSecret(spec).getEncoded();
            return COUNT_OF_ITERATION + ":" + toHex(salt) + ":" + toHex(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new UnableToGenerateHash("Unsupported Algorithm!", e);
        } catch (InvalidKeySpecException e) {
            throw new UnableToGenerateHash("Unsupported Key Spec on this system!", e);
        }
    }

    public static boolean checkValidation(String plainToCheck, String originHash) {
        final String[] splited = originHash.split(DELIMITER);
        final int iteration = Integer.parseInt(splited[0]);
        final byte[] salt = fromHex(splited[1]);
        final byte[] hash = fromHex(splited[2]);

        try {
            final PBEKeySpec spec = new PBEKeySpec(plainToCheck.toCharArray(), salt, iteration, hash.length * 8);
            final SecretKeyFactory skf = SecretKeyFactory.getInstance(PBKDF2_HMAC_SHA1);
            final byte[] test = skf.generateSecret(spec).getEncoded();
            return checkDiff(hash, test);
        } catch (NoSuchAlgorithmException e) {
            throw new UnableToGenerateHash("Unsupported Algorithm!", e);
        } catch (InvalidKeySpecException e) {
            throw new UnableToGenerateHash("Unsupported Key Spec on this system!", e);
        }
    }

    private static boolean checkDiff(byte[] hash, byte[] test) {
        final int hl = hash.length;
        final int tl = test.length;
        int diff = hl ^ tl;
        for (int i = 0; i < hl; i++) {
            diff = diff | (hash[i] ^ test[i]);
        }
        return diff == 0;
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        final SecureRandom sr = SecureRandom.getInstance(SECURE_RND);
        final byte[] salt = new byte[LENGTH_OF_SALT];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(final byte[] array) {
        final BigInteger bi = new BigInteger(1, array);
        final String hex = bi.toString(RADIX);
        final int paddingLength = (array.length * 2) - hex.length();
        return (paddingLength > 0) ? "0".repeat(paddingLength) + hex : hex;
    }

    private static byte[] fromHex(String hex) {
        final byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), RADIX);
        }
        return bytes;
    }
}
