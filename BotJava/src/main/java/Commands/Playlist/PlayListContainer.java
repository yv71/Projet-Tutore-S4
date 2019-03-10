package Commands.Playlist;

import AudioPlayer.AudioPlayer;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;

import java.io.*;
import java.util.ArrayList;

public class PlayListContainer {
    private ArrayList<Playlist> playlists;
    private AudioPlayer audioPlayer;

    public PlayListContainer(AudioPlayer audioPlayer){
        this.playlists = new ArrayList<>();
        this.audioPlayer = audioPlayer;
    }

    public ArrayList<Playlist> getPlaylists(){
            return this.playlists;
        }

        public void play(String nom, TextChannel channel, User owner){
            boolean decision = false;
            Playlist theChosenOne = new Playlist("AH", owner);
            for (Playlist p : playlists)
            {
                if (p.getNom().equals("nom")){
                    decision =true;
                    theChosenOne = p;
                }
            }


            if (decision){
                for (String s : theChosenOne.getListMusic()){
                    audioPlayer.loadAndPlay(channel, s);
                }
            }
    }

    public void saveMe() throws FileNotFoundException, IOException {
        FileOutputStream file = new FileOutputStream("D:\\Playlists.dat");
        ObjectOutputStream os = new ObjectOutputStream(file);
        os.writeObject(this);
        os.flush();
        os.close();
    }

    public void loadMe(){
        try {
            FileInputStream file = new FileInputStream("Playlists.dat");
            ObjectInputStream os = new ObjectInputStream(file);
            PlayListContainer load = (PlayListContainer) os.readObject();
            this.playlists = load.getPlaylists();
        }

         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
