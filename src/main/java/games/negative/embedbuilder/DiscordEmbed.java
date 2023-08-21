package games.negative.embedbuilder;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public record DiscordEmbed(@SerializedName("description") String description,
                           @SerializedName("color") int color,
                           @SerializedName("author") DiscordEmbedAuthor author,
                           @SerializedName("fields") List<DiscordEmbedField> fields,
                           @SerializedName("thumbnail") DiscordEmbedThumbnail thumbnail,
                           @SerializedName("image") DiscordEmbedImage image,
                           @SerializedName("footer") DiscordEmbedFooter footer) {

    @NotNull
    public Color asColor() {
        return new Color(color);
    }

}
