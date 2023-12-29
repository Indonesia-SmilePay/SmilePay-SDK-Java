package id.smile;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class SmileConstant {

    /**
     * param
     */
    public static final String CURRENCY = "IDR";

    /**
     * zoned
     */
    public static final ZoneId ZONE_ID = ZoneId.of("Asia/Jakarta");

    /**
     * DateTime
     */
    public static final String F_0 = "yyyy-MM-dd'T'HH:mm:ssXXX";
    public static final DateTimeFormatter DF_0 = DateTimeFormatter.ofPattern(F_0);

    /**
     * merchantID.
     * From merchant platform
     */
    public static final String MERCHANT_ID = "20001";

    /**
     * MerchantSecret.
     * From merchant platform
     */
    public static final String MERCHANT_SECRET = "0686d0aad339977d1f0fc42885d8e165134112779eef777e7f3b246b8b37afd0";

    /**
     * SANDBOX URL.
     * From docs API
     */
    public static final String BASE_SANDBOX_URL = "https://sandbox-gateway-test.thesmilepay.com";

    /**
     * PRODUCTION URL. From docs API. <br>
     * If you pass the sandbox docking, you can switch the URL to production.
     */
    public static final String BASE_URL = "https://gateway-test.thesmilepay.com";

    /**
     * AccessToken_API.
     * From docs API
     */
    public static final String ACCESS_TOKEN_API = "/v1.0/access-token/b2b";

    /**
     * Payin_API.
     * From docs API
     */
    public static final String PAY_IN_API = "/v1.0/transaction/pay-in";

    /**
     * Payout_API.
     * From docs API
     */
    public static final String PAY_OUT_API = "/v1.0/disbursement/cash-out";

}


