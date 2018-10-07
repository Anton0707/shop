package com.ahohlov.model;

public enum CommandEnum {
    LOGIN,
    USERS,
    ADDUSER,
    UPDATEUSER,
    DELETEUSER, ITEMS;

    public static CommandEnum getCommand(String command) {
        try {
            return CommandEnum.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Command does not found");
            e.printStackTrace();
        }
        return null;
    }
}
