import Listeners.Readylistenener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.hooks.EventListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import javax.security.auth.login.LoginException;

public class test  {
    public static void main(String args[]){
        JDABuilder jda = new JDABuilder(AccountType.BOT);
        try {
            jda.setToken(Secret.token).build();
            jda.addEventListener(new Readylistenener());

        } catch (LoginException e) {
            e.printStackTrace();
        }

        /**Twitter twitter = TwitterFactory.getSingleton();
        try {
            twitter.updateStatus("Salut les boyz");
            twitter.directMessages().sendDirectMessage("@Yoann_Beelzed", "Coucouu");
        } catch (TwitterException e) {
            e.printStackTrace();
        }**/
    }




}
