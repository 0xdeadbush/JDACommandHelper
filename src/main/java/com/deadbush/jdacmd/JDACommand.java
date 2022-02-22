package com.deadbush.jdacmd;

import com.deadbush.jdacmd.events.CommandEvents;
import com.deadbush.jdacmd.manager.CommandManager;
import net.dv8tion.jda.api.JDA;

public class JDACommand {

    public JDACommand(JDA jda){
        jda.addEventListener(new CommandEvents());
        CommandManager.getCommands().forEach(c -> jda.upsertCommand(c.getName(), c.getDescription()));
    }
}
