package games.negative.embedbuilder.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import games.negative.embedbuilder.DiscordMessage;
import org.jetbrains.annotations.NotNull;

public class DiscordMessageBuilder {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static DiscordMessage fromJson(@NotNull String json) {
        return GSON.fromJson(json, DiscordMessage.class);
    }

}
