package Games;

import java.util.Random;

public class Game_PlusGrand_PlusPetit extends Game{
    private int nb;
    private int counter;
    private boolean win;

    public Game_PlusGrand_PlusPetit(Games game_type) {
        super(game_type);
        Random r = new Random();
        this.nb = r.nextInt(999+1)+0;
        this.counter = 0;
        this.win = false;
    }

    public int getNb(){
        return nb;
    }
    public int getCounter(){
        return counter;
    }

    public boolean getWin(){
        return win;
    }

    public String play(String guess){
        counter ++;
        int g = Integer.parseInt(guess);
        String rez ;
        if (g > nb){
            rez = "Ahah, u're wrong, it's less ! ";
        }
        else if(g < nb){
            rez = "Ahah, u're wrong, it's more ! ";
        }
        else {
            rez = "Impressive summoner, u got me in just " + this.counter+ " tries !";
            this.win = true;
        }
        return rez;
    }




}
