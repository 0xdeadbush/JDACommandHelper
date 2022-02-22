package com.deadbush.jdacmd.configuration;

import lombok.Getter;
import lombok.Setter;

public class CommandConfiguration {
    @Getter
    @Setter
    private static String disallowcmd = ":x: You don't allowed to use this command ! :x:";
    @Getter
    @Setter
    private static String syntaxe = ":x: Syntaxe: %command% %args% :x:";

    public static String getDisallowMessage() {
        return disallowcmd;
    }

    public static String getSyntaxeMessage() {
        return syntaxe;
    }

    public static void setSyntaxeMessage(String syntaxe) {
        CommandConfiguration.syntaxe = syntaxe;
    }

    public static void setDisallowMessage(String disallowcmd) {
        CommandConfiguration.disallowcmd = disallowcmd;
    }
}
