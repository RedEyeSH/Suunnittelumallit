package facade;

import java.io.IOException;

public class JokeClient {
    private final ApiFacade facade = new ApiFacade();

    public String getRandomJoke() throws IOException {
        return facade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
    }
}
