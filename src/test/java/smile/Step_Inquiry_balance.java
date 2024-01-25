package smile;

import com.google.gson.Gson;
import id.smile.SignatureUtil;
import id.smile.SmileConstant;
import id.smile.req.InquiryAccountReq;
import id.smile.req.InquiryBalanceReq;
import id.smile.req.MerchantReq;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;

public class Step_Inquiry_balance extends BaseTest {

    //accessToken.  from step2
    private String ACCESS_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYmYiOjE3MDYxODMxNDEsImV4cCI6MTcwNjE4NDA0MSwiaWF0IjoxNzA2MTgzMTQxLCJNRVJDSEFOVF9JRCI6IjEwMDAxIn0.6hyHi8xBPI0t-onFBJIWmJCkfbhnkqaQTxLa-H3jJyI";

    @Test
    public void payout_paymentMethodList() throws Exception {

        System.out.println("=====> step : Step_Inquiry_balance");

        //url
        String endPointUlr = SmileConstant.INQUIRY_BALANCE_NEW_API;
        String url = SmileConstant.BASE_URL + endPointUlr;

        String timestamp = ZonedDateTime.of(LocalDateTime.now(), SmileConstant.ZONE_ID).format(SmileConstant.DF_0);
        System.out.println("timestamp = " + timestamp);
        String partnerId = SmileConstant.MERCHANT_ID;

        //generate parameter
        InquiryBalanceReq balanceReq = new InquiryBalanceReq();
        balanceReq.setAccountNo("2023102513101825619");
        balanceReq.setBalanceTypes(Collections.singletonList("BALANCE"));
        balanceReq.setAdditionalInfo("2023102513101825619");
        //balanceReq.setHolderName("Jeffrey");

        //jsonStr by gson
        Gson gson = new Gson();
        String jsonStr = gson.toJson(balanceReq);
        System.out.println("jsonStr = " + jsonStr);

        //minify
        String minify = SignatureUtil.minify(jsonStr);
        System.out.println("minify = " + minify);

        //sha256
        byte[] bytes = SignatureUtil.SHA256(minify);

        //byte2Hex
        String byte2Hex = SignatureUtil.byte2Hex(bytes);

        //toLowerCase
        String lowerCase = byte2Hex.toLowerCase();

        //build
        String stringToSign = "POST" + ":" + endPointUlr + ":" + ACCESS_TOKEN + ":" + lowerCase + ":" + timestamp;
        System.out.println("stringToSign = " + stringToSign);

        //signature
        String signature = SignatureUtil.hmacSHA512(stringToSign, SmileConstant.MERCHANT_SECRET);
        System.out.println("signature = " + signature);

        // create httpClient
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("Authorization", "Bearer " + ACCESS_TOKEN);
        httpPost.addHeader("X-TIMESTAMP", timestamp);
        httpPost.addHeader("X-SIGNATURE", signature);

        httpPost.addHeader("ORIGIN", "www.yourDomain.com");
        httpPost.addHeader("X-PARTNER-ID", partnerId);
        httpPost.addHeader("X-EXTERNAL-ID", "123729342472347234236");
        httpPost.addHeader("CHANNEL-ID", "95221");

        // set entity
        httpPost.setEntity(new StringEntity(jsonStr, StandardCharsets.UTF_8));

        // send
        HttpResponse response = httpClient.execute(httpPost);

        // response
        HttpEntity httpEntity = response.getEntity();
        String responseContent = EntityUtils.toString(httpEntity, "UTF-8");
        System.out.println("responseContent = " + responseContent);

        // release
        EntityUtils.consume(httpEntity);


    }

    //{"merchantId":"sandbox-10001","additionalInfo":null,"paymentMethodList":[{"paymentMethod":"DANAMON","paymentName":"DANAMON Bank","singleFee":3000,"singleRate":0,"amountLimitMin":10000,"amountLimitMax":1000000000,"settleType":"T1"},{"paymentMethod":null,"paymentName":null,"singleFee":null,"singleRate":null,"amountLimitMin":null,"amountLimitMax":null,"settleType":null},{"paymentMethod":"MANDIRI","paymentName":"Mandiri Bank","singleFee":3300,"singleRate":0,"amountLimitMin":10000,"amountLimitMax":1000000000,"settleType":"T1"}],"responseCode":"2009300","responseMessage":"Successful"}

}
