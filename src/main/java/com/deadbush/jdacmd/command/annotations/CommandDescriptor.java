package com.deadbush.jdacmd.command.annotations;

import net.dv8tion.jda.api.Permission;

public @interface CommandDescriptor {
    String name();

    String description() default "This command didn't have any description yet !";

    String[] argsSyntaxe() default {};

    Permission permission() default Permission.UNKNOWN;

    String[] allowedRoles() default {};

    String[] allowedChannels() default {};

    String[] disallowChannels() default {};

    String[] allowUser() default {};
}
