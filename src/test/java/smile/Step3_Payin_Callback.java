package smile;

import id.smile.SmileConstant;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;


public class Step3_Payin_Callback extends BaseTest {


    ///payment/callBack/mock/payin?tradeNo=

    @Test
    public void payinCallback() throws Exception {
        System.out.println("=====> Step3_Payin_Callback");
        callback("12120014240205131332350");
    }

    public static void callback(String tradeNo) throws IOException {
        String url = SmileConstant.BASE_URL + "/payment/callBack/mock/payin?tradeNo=" + tradeNo;
        System.out.println("url = " + url);
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        try {
            HttpResponse response = httpclient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                String responseBody = EntityUtils.toString(entity);

                System.out.println("Status Code: " + statusCode);
                System.out.println("Response Body: " + responseBody);
            } else {
                System.out.println("Request failed with status code: " + statusCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}