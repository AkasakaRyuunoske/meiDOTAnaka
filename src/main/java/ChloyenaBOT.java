import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.channel.concrete.PrivateChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class ChloyenaBOT extends ListenerAdapter {
    static PrivateChannel privateChannel;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event){
        if (!event.getAuthor().isBot()) { // to prevent feedback loop
            System.out.println("Was called!");
            privateChannel = event.getChannel().asPrivateChannel();

            System.out.println(event.getMessage());
            event.getChannel().asPrivateChannel().sendMessage("Nee Nee").queue();
        }
    }

    static public void sendMessage(String message){
        privateChannel.sendMessage(message).queue();
    }
}
