package listeners;

import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.List;

public class readyListener extends ListenerAdapter {
    private String idChannel = null;

    public void onReady(ReadyEvent event) {

        String out = "\nThis bot is running on following servers: \n";

        for (Guild g : event.getJDA().getGuilds() ) {
            out += g.getName() + " (" + g.getId() + ") \n";
        }

        System.out.println(out);

        for (Guild g : event.getJDA().getGuilds() ) {
            List<TextChannel> l = g.getTextChannels();
            for (TextChannel t : l){
                if (t.getName().equals("morde-channel")){
                    idChannel = t.getId();
                };
            }
            if (idChannel !=null){
               g.getTextChannelById(idChannel).sendMessage("I'm back from the dead, and u're gonna suffer, fool").queue();
            }
            else {
                g.getTextChannels().get(0).sendMessage("I'm back from the dead, and u're gonna suffer, fool").queue();
            }

        }

    }

}