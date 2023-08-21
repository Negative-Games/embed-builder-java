package games.negative.embedbuilder.builder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import games.negative.embedbuilder.*;
import net.dv8tion.jda.api.EmbedBuilder;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public class DiscordEmbedBuilder {

    /**
     * The {@link Gson} instance used to parse JSON.
     */
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Get a new {@link DiscordEmbedBuilder} instance from json.
     * @param json The json to parse.
     * @return The {@link DiscordEmbedBuilder} instance.
     */
    public static DiscordEmbed fromJson(@NotNull String json) {
        return GSON.fromJson(json, DiscordEmbed.class);
    }

    /**
     * Get a {@link EmbedBuilder} from a {@link DiscordEmbed} instance.
     * @param embed The {@link DiscordEmbed} instance.
     * @return The {@link EmbedBuilder} instance.
     */
    public static EmbedBuilder fromEmbed(@NotNull DiscordEmbed embed) {
        EmbedBuilder builder = new EmbedBuilder();

        Color color = embed.asColor();
        builder.setColor(color);

        if (embed.description() != null) builder.setDescription(embed.description());

        DiscordEmbedAuthor author = embed.author();
        if (author != null) applyAuthor(builder, author);

        List<DiscordEmbedField> fields = embed.fields();
        if (fields != null) applyFields(builder, fields);

        DiscordEmbedThumbnail thumbnail = embed.thumbnail();
        if (thumbnail != null) applyThumbnail(builder, thumbnail);

        DiscordEmbedImage image = embed.image();
        if (image != null) applyImage(builder, image);

        DiscordEmbedFooter footer = embed.footer();
        if (footer != null) applyFooter(builder, footer);

        return builder;
    }

    private static void applyFooter(@NotNull EmbedBuilder builder, @NotNull DiscordEmbedFooter footer) {
        String text = footer.text();
        if (text != null) builder.setFooter(text);

        String iconUrl = footer.iconUrl();
        if (iconUrl != null) builder.setFooter(text, iconUrl);
    }

    private static void applyImage(@NotNull EmbedBuilder builder, @NotNull DiscordEmbedImage image) {
        builder.setImage(image.url());
    }

    private static void applyThumbnail(@NotNull EmbedBuilder builder, @NotNull DiscordEmbedThumbnail thumbnail) {
        builder.setThumbnail(thumbnail.url());
    }

    private static void applyFields(@NotNull EmbedBuilder builder, @NotNull List<DiscordEmbedField> fields) {
        for (DiscordEmbedField field : fields) {
            builder.addField(field.name(), field.value(), field.inline());
        }
    }

    private static void applyAuthor(@NotNull EmbedBuilder builder, @NotNull DiscordEmbedAuthor author) {
        String name = author.name();
        String iconUrl = author.iconUrl();

        if (iconUrl == null) builder.setAuthor(name);

        builder.setAuthor(name, iconUrl);
    }

}
