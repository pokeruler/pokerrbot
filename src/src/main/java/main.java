import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        JDABuilder  builder = new JDABuilder(AccountType.BOT);
        String token = "NDMwMTE2MjY5NjgxOTM0MzUz.DaMZMQ.LcqtowPJLAN1PnFGxL4YNulzrZg";
        builder.setToken(token);
        builder.addEventListener(new main());
        builder.buildAsync();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) {
            return;
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        System.out.println("We received a message from " +
                event.getAuthor().getName() + ": " +
                event.getMessage().getContentDisplay()
        );

        if(event.getMessage().getContentRaw().equals(",,ping")) {
            event.getChannel().sendMessage("Pong!").queue();
        }

    }

}
