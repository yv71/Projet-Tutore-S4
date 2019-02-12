package Commands.Playlist;

import net.dv8tion.jda.core.entities.User;

import java.util.ArrayList;

public class Playlist {
    private ArrayList<String> listMusic;
    private String nom;
    private User owner;

    public Playlist(String nom, User owner) {
        this.listMusic = new ArrayList<>();
        this.nom = nom;
        this.owner = owner;
    }

    public void addSong(String song){
        this.listMusic.add(song);
    }

    public String getNom(){
        return this.nom;
    }

    public ArrayList<String> getListMusic(){
        return this.listMusic;
    }
}
