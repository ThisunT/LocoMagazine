package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Thisun Pathirage on 9/3/2017.
 */


public class GetRequest {

    public static String sendGetRequest(String targetUrl) throws IOException {

        URL myUrl = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) myUrl.openConnection();
        //con.setDoOutput(true);
        //con.setDoInput(true);

        con.setRequestProperty("Method", "GET");

        StringBuilder sb = new StringBuilder();
        int HttpResult = con.getResponseCode();
        if (HttpResult == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            br.close();
            return ("" + sb.toString());

        } else {
            //System.out.println(con.getResponseCode());
            return (con.getResponseMessage());
        }
    }
}

