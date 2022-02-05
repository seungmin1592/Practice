package com.example.receipt.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.tomcat.util.codec.binary.Base64;

public class Aes256Util {
    private static volatile Aes256Util INSTANCE;
    static final String secretKey = "shplab123456789abcdefghijklmnopq";
    static String IV = "";

    public static Aes256Util getInstance() {
        if (INSTANCE == null) {
            Class var0 = Aes256Util.class;
            synchronized(Aes256Util.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Aes256Util();
                }
            }
        }

        return INSTANCE;
    }

    private Aes256Util() {
        IV = "shplab123456789abcdefghijklmnopq".substring(0, 16);
    }

    public static String AES_Encode(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyData = "shplab123456789abcdefghijklmnopq".getBytes();
        SecretKey secureKey = new SecretKeySpec(keyData, "AES");
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(1, secureKey, new IvParameterSpec(IV.getBytes()));
        byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
        String enStr = new String(Base64.encodeBase64(encrypted));
        return enStr;
    }

    public static String AES_Decode(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] keyData = "shplab123456789abcdefghijklmnopq".getBytes();
        SecretKey secureKey = new SecretKeySpec(keyData, "AES");
        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(2, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));
        byte[] byteStr = Base64.decodeBase64(str.getBytes());
        return new String(c.doFinal(byteStr), "UTF-8");
    }
}
