package id.smile;


import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * Function: SHA256withRSA utility class
 * @author west
 */


public class SignatureUtil {

    private static final String KEY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    private static final String HMAC_SHA512 = "HmacSHA512";

    private SignatureUtil() {
        throw new RuntimeException("Utility classes should not have public constructors");
    }

    /**
     * signature
     */
    public static String createSignature(String stringToSign, String privateKeyStr) {
        try {
            byte[] privateKeys = java.util.Base64.getDecoder().decode(privateKeyStr.getBytes());
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeys);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(privateKey);
            signature.update(stringToSign.getBytes(StandardCharsets.UTF_8));
            byte[] signed = signature.sign();
            return java.util.Base64.getEncoder().encodeToString(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * SHA-256
     */
    public static byte[] SHA256(String requestBody) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(requestBody.getBytes());
    }


    /**
     * Sha256 encryption, convert bytes to hexadecimal
     */
    public static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }


    /**
     * HmacSHA512 algorithm verifies signature
     */
    public static String hmacSHA512(String signData, String secret) throws Exception {
        Mac hMacSha512 = Mac.getInstance(HMAC_SHA512);
        SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(), HMAC_SHA512);
        hMacSha512.init(keySpec);
        byte[] signatureBytes = hMacSha512.doFinal(signData.getBytes());
        return java.util.Base64.getEncoder().encodeToString(signatureBytes);
    }


    /**
     * minify
     */
    public static String minify(String jsonString) {
        boolean in_string = false;
        boolean in_multi_line_comment = false;
        boolean in_single_line_comment = false;
        char string_opener = 'x'; // unused value, just something that makes compiler happy

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < jsonString.length(); i++) {
            // get next (c) and next-next character (cc)

            char c = jsonString.charAt(i);
            String cc = jsonString.substring(i, Math.min(i + 2, jsonString.length()));

            // big switch is by what mode we're in (in_string etc.)
            if (in_string) {
                if (c == string_opener) {
                    in_string = false;
                    out.append(c);
                } else if (c == '\\') { // no special treatment needed for \\u, it just works like this too
                    out.append(cc);
                    ++i;
                } else
                    out.append(c);
            } else if (in_single_line_comment) {
                if (c == '\r' || c == '\n')
                    in_single_line_comment = false;
            } else if (in_multi_line_comment) {
                if (cc.equals("*/")) {
                    in_multi_line_comment = false;
                    ++i;
                }
            } else {
                // we're outside of the special modes, so look for mode openers (comment start, string start)
                if (cc.equals("/*")) {
                    in_multi_line_comment = true;
                    ++i;
                } else if (cc.equals("//")) {
                    in_single_line_comment = true;
                    ++i;
                } else if (c == '"' || c == '\'') {
                    in_string = true;
                    string_opener = c;
                    out.append(c);
                } else if (!Character.isWhitespace(c))
                    out.append(c);
            }
        }
        return out.toString();
    }

}