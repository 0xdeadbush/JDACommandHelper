package com.deadbush.jdacmd.command;

import com.deadbush.jdacmd.command.annotations.CommandDescriptor;
import com.deadbush.jdacmd.manager.CommandManager;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.jetbrains.annotations.NotNull;

public abstract class Command {
    public Command() {
        CommandManager.addCommand(this);
    }

    @NotNull
    public String getName() {
        return getAnnotation().name();
    }

    @NotNull
    public String getDescription() {
        return getAnnotation().description();
    }

    @NotNull
    public String[] getSyntaxes() {
        return getAnnotation().argsSyntaxe();
    }

    @NotNull
    public String[] getAllowedChannels() {
        return getAnnotation().allowedChannels();
    }

    @NotNull
    public String[] getAllowedUsers() {
        return getAnnotation().allowUser();
    }

    @NotNull
    public String[] getAllowedRoles() {
        return getAnnotation().allowedRoles();
    }

    @NotNull
    public String[] getDisallowedChannels() {
        return getAnnotation().disallowChannels();
    }

    @NotNull
    public Permission getPermission() {
        return getAnnotation().permission();
    }

    @NotNull
    private CommandDescriptor getAnnotation() {
        if (!getClass().isAnnotationPresent(CommandDescriptor.class))
            throw new IllegalStateException("No, descriptor find !");
        return getClass().getAnnotation(CommandDescriptor.class);
    }

    public abstract void onRun(Member member, MessageChannel channel, Guild guild);

}