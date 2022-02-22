package com.deadbush.jdacmd.command;

import com.deadbush.jdacmd.command.annotations.CommandDescriptor;
import com.deadbush.jdacmd.manager.CommandManger;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;

public class Command {
    public Command(){
        CommandManger.addCommand(this);
    }

    @NotNull
    public String getName(){
        return getAnnotation().name();
    }

    @NotNull
    private CommandDescriptor getAnnotation(){
        if(!getClass().isAnnotationPresent(CommandDescriptor.class)) throw new IllegalStateException("No, descriptor find !");
        return getClass().getAnnotation(CommandDescriptor.class);
    }

}
