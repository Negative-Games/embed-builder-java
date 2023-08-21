package games.negative.embedbuilder;

import com.google.gson.annotations.SerializedName;

public record DiscordEmbedFooter(@SerializedName("icon_url") String iconUrl, @SerializedName("text") String text) {

}
