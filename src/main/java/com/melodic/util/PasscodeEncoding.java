package com.melodic.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasscodeEncoding {
    private static String encode(String passcode, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(passcode.getBytes(StandardCharsets.UTF_8));
            byte[] array = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte x : array) {
                sb.append(Integer.toHexString((x & 0xFF) | 0x100), 1, 3);
            }
            return sb.toString().toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encodeByMD5(String passcode) {
        return encode(passcode, "MD5");
    }

    public static String encodeBySHA256(String passcode) {
        return encode(passcode, "SHA-256");
    }
}