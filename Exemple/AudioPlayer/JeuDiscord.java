package AudioPlayer;

import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.RichPresence;

public class JeuDiscord extends Game {

    public JeuDiscord(String name) {
        super(name);
    }

    protected JeuDiscord(String name, String url) {
        super(name, url);
    }

    protected JeuDiscord(String name, String url, GameType type) {
        super(name, url, type);
    }

    protected JeuDiscord(String name, String url, GameType type, RichPresence.Timestamps timestamps) {
        super(name, url, type, timestamps);
    }
}
