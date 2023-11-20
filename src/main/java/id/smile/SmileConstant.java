package id.smile;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class SmileConstant {

    /**
     * zoned
     */
    public static final ZoneId ZONE_ID = ZoneId.of("Asia/Jakarta");

    public static final String F_0 = "yyyy-MM-dd'T'HH:mm:ssXXX";
    public static final DateTimeFormatter DF_0 = DateTimeFormatter.ofPattern(F_0);
}


