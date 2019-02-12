package Commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageHistory;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.util.List;

public final class Command_Clear {

    public static void clear(MessageReceivedEvent event){
        MessageHistory history = new MessageHistory(event.getTextChannel());
        List<Message> msgs;
        event.getMessage().delete().queue();
        msgs = history.retrievePast(50).complete();
        event.getTextChannel().deleteMessages(msgs).queue();
        event.getChannel().sendMessage("I'm not a servant, fool.").queue();
    }
}
