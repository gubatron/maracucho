package com.gubatron.maracucho;

public class Constants {
    public static final String VERSION = "0.1.1"; // MAJOR, MINOR, MONOTONIC_INCREMENTAL_BUILD
    public static final String AGENT_NAME = "Maracucho Client";
    public static final String AGENT = AGENT_NAME + " " + VERSION.substring(0, VERSION.lastIndexOf("."));
    public static final int STANDARD_MARABU_PORT = 18018;
    public static final String BOOSTRAP_HOSTNAME = "keftes.di.uoa.gr";
}
