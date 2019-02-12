package Core;

import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;

public class ChercheChannel {

    public static TextChannel chercheChannel(Guild guild){
        TextChannel retour = guild.getDefaultChannel();
        for (TextChannel t : guild.getTextChannels()){
            if (t.getName().equals("morde-channel")){
                retour = t;
            }
        }
        return retour;
    }
}
