import Core.SECRET;
import listeners.readyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import javax.security.auth.login.LoginException;


public class Main extends ListenerAdapter {


    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = SECRET.token;
        builder.setToken(token);
        JDA jda = builder.build();
        builder.addEventListener(new readyListener());
        //builder.addEventListener(new voiceListener());
        builder.build();



    }


}
