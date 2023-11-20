package id.smile;


import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

/**
 * 功能：SHA256withRSA 工具类
 *
 * @author west
 */


public class SignatureUtil {

    private static final String KEY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

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


}