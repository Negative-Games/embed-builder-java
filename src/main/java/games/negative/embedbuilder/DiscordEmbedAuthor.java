package games.negative.embedbuilder;

import com.google.gson.annotations.SerializedName;

public record DiscordEmbedAuthor(@SerializedName("icon_url") String iconUrl, @SerializedName("name") String name) {

}
