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
    public static final String MERCHANT_ID = "sandbox-10001";

    /**
     * MerchantSecret.
     * From merchant platform
     */
    public static final String MERCHANT_SECRET = "c14befbb5976d969a91db06439d7e0f964f1a92c0d5417f5cc0a64a9988bf479";

    /**
     * SANDBOX URL.
     * From docs API
     */
    public static final String BASE_SANDBOX_URL = "https://sandbox-gateway.smilepay.id";

    /**
     * PRODUCTION URL. From docs API. <br>
     * If you pass the sandbox docking, you can switch the URL to production.
     */
    public static final String BASE_URL = "https://sandbox-gateway.smilepay.id";

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


