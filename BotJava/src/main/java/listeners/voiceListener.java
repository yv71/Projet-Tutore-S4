package listeners;

import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
public class voiceListener extends ListenerAdapter {

    public void onGuildVoiceJoin(GuildVoiceJoinEvent event) {
        String envoi = event.getVoiceState().getMember().getUser().getName() + " a rejoint le channel vocal " +  event.getChannelJoined().getName();
        event.getGuild().getDefaultChannel().sendMessage(envoi).queue();
    }

}