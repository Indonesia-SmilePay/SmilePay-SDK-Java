package id.smile;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RemoteUtil {

    /**
     * post request
     */
    public static String postJson(String url, String timestamp, String clientKey, String signature, String jsonBody) {
        // create httpClient
        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.addHeader("X-TIMESTAMP", timestamp);
        httpPost.addHeader("X-CLIENT-KEY", clientKey);
        httpPost.addHeader("X-SIGNATURE", signature);

        // set entity
        httpPost.setEntity(new StringEntity(jsonBody, StandardCharsets.UTF_8));

        String responseContent = null;
        try {
            // send
            HttpResponse response = httpClient.execute(httpPost);

            // response
            HttpEntity httpEntity = response.getEntity();
            responseContent = EntityUtils.toString(httpEntity, "UTF-8");
            //System.out.println("responseContent = " + responseContent);

            // release
            EntityUtils.consume(httpEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseContent;
    }
}
