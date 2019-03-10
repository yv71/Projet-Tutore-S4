package Core;

import Commands.Command_Clear;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.MessageType;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.xml.soap.Text;

public class Answer extends ListenerAdapter {
    private String autorizedRole;
    private JDA jda;



    public Answer(JDA jda){
        autorizedRole = "R:Morde's disciple(498903078179831809)";
        this.jda = jda;

    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if (!event.getAuthor().isBot() ) {
            this.welcome(event);
            if (event.getMember().getVoiceState().inVoiceChannel() && this.possedeLeRole(event)){
               // this.audio(event);
            }
            else if(!possedeLeRole(event)){
                event.getChannel().sendMessage("You're not my disciple, idiot.");
            }
            else if(!event.getMember().getVoiceState().inVoiceChannel()){
                event.getChannel().sendMessage("I can join u if u're nowhere, stupid disciple.");
            }

        }

    }

    public void welcome(MessageReceivedEvent event){
        if (event.getMessage().getType().equals(MessageType.GUILD_MEMBER_JOIN)) {
            event.getChannel().sendMessage("Oh ? Bienvenue, nouvelle âme tourmentée ! ").queue();
        }
    }

    public boolean possedeLeRole(MessageReceivedEvent event){
        boolean retour = false;
        for (Role r : event.getMember().getRoles()){
            if (r.toString().equals(autorizedRole)){
                retour = true;
            }
        }
        return retour;
    }

    /**public void audio(MessageReceivedEvent event){
        audioCommands.audio(event);
    }*/
}
