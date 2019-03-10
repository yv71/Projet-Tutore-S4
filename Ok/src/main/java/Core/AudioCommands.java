package Core;

import AudioPlayer.AudioPlayer;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.VoiceChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.managers.AudioManager;

import java.util.ArrayList;
import java.util.List;

public class AudioCommands {

    private AudioManager audioManager;
    private AudioPlayer audioPlayer;
    private List<String> listMusic;
    private Directory music;

    public AudioCommands(JDA jda){
        audioManager = null;
        audioPlayer = new AudioPlayer(jda);
        music = new Directory("D:\\Musiques\\Musiques\\");
        listMusic = music.listRepertoire();
    }

    public void audio(MessageReceivedEvent event){
        if ((event.getMessage().getContentRaw().equals("Come on Morde")) && (event.getChannel().getName().equals("morde-channel"))) {
            VoiceChannel myChannel = event.getMember().getVoiceState().getChannel();
            if (audioManager == null) {
                audioManager = event.getGuild().getAudioManager();
            }
            audioManager.openAudioConnection(myChannel);
            audioPlayer.loadAndPlay(event.getTextChannel(),"D:\\GIthub_\\BotJava\\src\\main\\resources\\morde_arrival.mp3");
        }
        if (audioManager != null) {
            if ((event.getMessage().getContentRaw().equals("Gtfo Morde")) && (event.getChannel().getName().equals("morde-channel")) && (audioManager.isConnected())) {
                audioManager.closeAudioConnection();
            }
        }
        if(event.getMessage().getContentRaw().startsWith("Morde ? Play")){
            String[] list = event.getMessage().getContentRaw().split(" ");
            if (list.length==3){
                event.getChannel().sendMessage("There's nothing to play, stupid human").queue();
            }
            else {
                if (list[3].startsWith("https://")){
                    audioPlayer.loadAndPlay(event.getTextChannel(),list[3]);
                }
                else if (event.getMessage().getContentRaw().startsWith("Morde ? Play N° ") && (estUnEntier(list[4]))){
                    audioPlayer.loadAndPlay(event.getTextChannel(), (music.getAdress()+ listMusic.get(Integer.parseInt(list[4]))));
                }
                else{
                    String nom = list[3];
                    nom.toLowerCase();
                    switch(nom){
                        case ("botrk"):
                            audioPlayer.loadAndPlay(event.getTextChannel(),"https://www.youtube.com/watch?v=gUEKZpjPYNU");
                            break;

                        default:
                            event.getChannel().sendMessage("There's nothing to play, stupid human").queue();
                            break;
                    }
                }
            }
            event.getMessage().delete().queue();
        }
        if (event.getMessage().getContentRaw().equals("Morde ? Next.")){
            audioPlayer.skipTrack(event.getTextChannel());
            event.getMessage().delete().queue();
        }
        if (event.getMessage().getContentRaw().equals("Morde ? Stop.")){
            audioPlayer.stop(event.getTextChannel());
            event.getMessage().delete().queue();
        }
        if (event.getMessage().getContentRaw().startsWith("Morde ? Volume to")){
            String[] list = event.getMessage().getContentRaw().split(" ");
            if (list.length==4 ||list.length > 5){
                event.getChannel().sendMessage("I just need a number, idiot").queue();
            }
            else {
                audioPlayer.setVolume(event.getTextChannel(),Integer.parseInt(list[4]));
                event.getChannel().sendMessage("Volume set to " + list[4]);
            }
            event.getMessage().delete().queue();
        }
        if(event.getMessage().getContentRaw().equals("Morde ? List music")){
            this.audioList(event);
        }
        if(event.getMessage().getContentRaw().equals("Help")){
            this.commandHelp(event);
        }
    }

    public void audioList(MessageReceivedEvent event){
        String rez = "";
        for (int i =0; i < listMusic.size() - 1; i++){
            if (rez.length()>1800   ){
                event.getChannel().sendMessage(rez).queue();
                rez = "";

            }
            rez += "N°"+ i + " : " + listMusic.get(i)+"\n";
        }

    }

    public boolean estUnEntier(String chaine) {
        try {
            Integer.parseInt(chaine);
        } catch (NumberFormatException e){
            return false;
        }

        return true;
    }


    public void commandHelp(MessageReceivedEvent event){
        String message = "Some help summoners ? Here's my powers list : \n"
                + " Come on Morde : I'll join ur voice channel\n" +
                " Gtfo Morde : I'll leave ur voice channel, son of a ***\n" +
                "Morde ? List music : I'll show u the music directory of one of my disciple\n" +
                "Morde ? Play N°[Number] : I'll play the song corresponding to the number u typed (see the list, fool)\n" +
                "Morde ? Play [URL] : I'll play the video corresponding to the URL u type, u can use youtube URL\n" +
                "Morde ? Volume to [Number] : Set the volume to the number u typed\n" +
                "Morde ? Next. : Skip to next track\n" +
                "Morde ? Stop. : Stop the music\n" +
                "play GuessMyNumber : Start playing a little game\n";
        event.getChannel().sendMessage(message).queue();
    }
}
