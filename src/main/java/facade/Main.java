package facade;

import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();
        JokeClient jokeClient = new JokeClient();

        try {
            String joke = jokeClient.getRandomJoke();
            System.out.println("Chuck Norris Joke: " + joke);

            String ratesJson = facade.getAttributeValueFromJson("https://api.fxratesapi.com/latest?base=USD&symbols=EUR", "rates");
            JSONParser parser = new JSONParser();
            JSONObject ratesObj = (JSONObject) parser.parse(ratesJson);
            System.out.println("USD to EUR exchange rate: " + ratesObj.get("EUR"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
