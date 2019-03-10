package Core;

import Commands.Command_Clear;
import Games.Games;
import Games.*;
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
    private Games Type_jeu;
    private Game jeu;
    private Game_PlusGrand_PlusPetit jeuPlusGrand_PlusPetit;
    private AudioCommands audioCommands;
    private String autorizedRole;
    private JDA jda;



    public Answer(JDA jda){
        Type_jeu = Games.Nothing;
        audioCommands = new AudioCommands(jda);
        autorizedRole = "R:Morde's disciple(498903078179831809)";
        this.jda = jda;

    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if (!event.getAuthor().isBot() ) {
            System.out.println("We received a message from " + event.getAuthor().getName() + " : " + event.getMessage().getContentDisplay());
            if (Type_jeu.equals(Games.Nothing)) {
                if (event.getChannel().getName().equals("morde-channel") && (event.getMessage().getContentRaw().equals("!morde?"))) {
                    event.getChannel().sendMessage("You only need to press once, fool").queue();
                }
                if ((event.getMessage().getContentRaw().equals("play GuessMyNumber")) && (event.getChannel().getName().equals("morde-channel"))) {
                    event.getChannel().sendMessage("Wanna play some game ? Try to guess my number, fool ! ").queue();
                    this.Type_jeu = Games.GuessMyNumber;
                    this.jeuPlusGrand_PlusPetit = new Game_PlusGrand_PlusPetit(Games.GuessMyNumber);
                    this.jeu = jeuPlusGrand_PlusPetit;
                }
                if ((event.getMessage().getContentRaw().equals("!MordeClear")) && (event.getMember().getUser().getId().equals(event.getGuild().getOwner().getUser().getId()))) {
                    Command_Clear.clear(event);
                }
            }
            else if (Type_jeu.equals(Games.GuessMyNumber)) {
                this.jeu(event);
            }
            this.welcome(event);
            if (event.getMember().getVoiceState().inVoiceChannel() && this.possedeLeRole(event)){
                this.audio(event);
            }
            else if(!possedeLeRole(event)){
                event.getChannel().sendMessage("You're not my disciple, idiot.");
            }
            else if(!event.getMember().getVoiceState().inVoiceChannel()){
                event.getChannel().sendMessage("I can join u if u're nowhere, stupid disciple.");
            }

        }

    }


    public void lancementJeu(MessageReceivedEvent event){

    }

    public void jeu(MessageReceivedEvent event){
        String rez ;
        if (jeu.estUnEntier(event.getMessage().getContentRaw())) {
            rez = this.jeu.play(event.getMessage().getContentRaw());
            if (jeuPlusGrand_PlusPetit.getWin()) {
                this.Type_jeu = Games.Nothing;
                this.jeu = null;
                this.jeuPlusGrand_PlusPetit = null;
            }
        } else if (event.getMessage().getContentRaw().equals("Stop it !")) {
            this.Type_jeu = Games.Nothing;
            this.jeu = null;
            rez = "A surrender ? What a challenger.";
        } else {
            rez = "It's not a number, idiot ! Too hard for you ? Type 'Stop it !' to stop";
        }
        event.getChannel().sendMessage(rez).queue();
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

    public void audio(MessageReceivedEvent event){
        audioCommands.audio(event);
    }
}
