package games.negative.embedbuilder;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.Nullable;

public record DiscordMessage(@SerializedName("content") String content,
                             @SerializedName("ephemeral") boolean ephemeral,
                             @Nullable @SerializedName("embed") DiscordEmbed embed) {

}
