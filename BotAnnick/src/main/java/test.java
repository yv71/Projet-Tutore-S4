import Listeners.readyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import twitter4j.*;

import javax.security.auth.login.LoginException;

public class test extends ListenerAdapter {
    public static void main(String args[]) throws LoginException {

        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = Secret.token;
        builder.setToken(token);
        JDA jda = builder.build();
        System.out.println(jda.getGuilds().size());
        builder.addEventListener(new readyListener());

       /**
       Twitter twitter = TwitterFactory.getSingleton();
        try {
            twitter.directMessages().sendDirectMessage("@Yoann_Beelzed", "coucou");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
      **/
    }




}
