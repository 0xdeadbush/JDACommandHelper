package com.deadbush.jdacmd.manager;

import com.deadbush.jdacmd.command.Command;
import com.deadbush.jdacmd.configuration.CommandConfiguration;
import lombok.Getter;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CommandManager {
    @Getter
    private static List<Command> commands = new ArrayList<>();

    @NotNull
    public static List<Command> getCommands() {
        return commands;
    }


    public static void addCommand(Command command){
        commands.add(command);
    }

    @NotNull
    public static Optional<Command> getCommand(String name){
        return commands.stream().filter(command -> command.getName().equalsIgnoreCase(name)).findFirst();
    }

    public static void run(Command command, SlashCommandInteractionEvent event) {
        //TODO: CHECK PERMISSION RESTRICTION
        if (command.getPermission() != Permission.UNKNOWN) {
            if (!event.getMember().hasPermission(command.getPermission())) {
                event.reply(CommandConfiguration.getDisallowMessage()).complete();
                return;
            }
        }
        if (command.getAllowedChannels().length != 0) {
            if (!Arrays.stream(command.getAllowedChannels()).filter(c -> c.equalsIgnoreCase(event.getChannel().getId())).findFirst().isPresent()) {
                event.reply(CommandConfiguration.getDisallowMessage()).complete();
                return;
            }
        }
        if (command.getAllowedRoles().length != 0) {
            if (!Arrays.stream(command.getAllowedRoles()).filter(r -> event.getMember().getRoles().contains(event.getGuild().getRoleById(r))).findFirst().isPresent()) {
                event.reply(CommandConfiguration.getDisallowMessage()).complete();
                return;
            }
        }
        if (command.getAllowedUsers().length != 0) {
            if (!Arrays.stream(command.getAllowedUsers()).filter(u -> event.getUser().getId() == u).findFirst().isPresent()) {
                event.reply(CommandConfiguration.getDisallowMessage()).complete();
                return;
            }
        }
        if (command.getDisallowedChannels().length != 0) {
            if (Arrays.stream(command.getDisallowedChannels()).filter(c -> c.equalsIgnoreCase(event.getChannel().getId())).findFirst().isPresent()) {
                event.reply(CommandConfiguration.getDisallowMessage()).complete();
                return;
            }
        }
    }
}
