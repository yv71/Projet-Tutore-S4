import Core.Answer;
import Core.SECRET;
import listeners.readyListener;
import listeners.voiceListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;
import javax.swing.*;


public class Main extends ListenerAdapter {


    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = SECRET.token;
        builder.setToken(token);
        JDA jda = builder.build();
        //builder.addEventListener(new Answer(jda));
        builder.addEventListener(new readyListener());
        //builder.addEventListener(new voiceListener());
        builder.build();



    }


}
