package com.example.firebase5;

public class User {

    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }
}
