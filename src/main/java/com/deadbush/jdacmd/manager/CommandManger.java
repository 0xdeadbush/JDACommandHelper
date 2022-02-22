package com.deadbush.jdacmd.manager;

import com.deadbush.jdacmd.command.Command;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandManger {
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
}
