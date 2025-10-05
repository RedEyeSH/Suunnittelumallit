package facade;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApiFacade {
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IOException {
        String jsonResponse = getJsonFromApi(urlString);
        return extractValueFromJson(jsonResponse, attributeName);
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        HttpURLConnection con = null;
        BufferedReader in = null;
        try {
            URL url = new URL(apiUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException("Failed API response, HTTP code: " + responseCode);
            }

            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            if (in != null) in.close();
            if (con != null) con.disconnect();
        }
    }

    private String extractValueFromJson(String json, String attributeName) throws IOException {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            if (!jsonObject.containsKey(attributeName)) {
                throw new IOException("Attribute '" + attributeName + "' not found.");
            }

            Object value = jsonObject.get(attributeName);
            return value.toString();
        } catch (Exception e) {
            throw new IOException("Error parsing JSON: " + e.getMessage(), e);
        }
    }
}
