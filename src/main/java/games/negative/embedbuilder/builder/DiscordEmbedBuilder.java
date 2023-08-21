package games.negative.embedbuilder.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import games.negative.embedbuilder.DiscordEmbed;
import org.jetbrains.annotations.NotNull;

public class DiscordEmbedBuilder {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static DiscordEmbed fromJson(@NotNull String json) {
        return GSON.fromJson(json, DiscordEmbed.class);
    }

}
