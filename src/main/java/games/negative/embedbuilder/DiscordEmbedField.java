package games.negative.embedbuilder;

import org.jetbrains.annotations.NotNull;

public record DiscordEmbedField(@NotNull String name, @NotNull String value, boolean inline) {

}
