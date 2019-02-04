import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import javax.security.auth.login.LoginException;

public class test {
    public static void main(String args[]){
        Twitter twitter = TwitterFactory.getSingleton();
        JDABuilder jda = new JDABuilder(AccountType.BOT);
        try {
            jda.setToken(Secret.token).build();

        } catch (LoginException e) {
            e.printStackTrace();
        }
        try {
            twitter.updateStatus("Salut les boyz");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
