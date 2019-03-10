package Games;

public abstract class Game {
    private Games game_type;

    public Game(Games game_type)
    {
        this.game_type = game_type;
    }

    public boolean estUnEntier(String chaine) {
        try {
            Integer.parseInt(chaine);
        } catch (NumberFormatException e){
            return false;
        }

        return true;
    }

     public abstract String play(String s);
}
