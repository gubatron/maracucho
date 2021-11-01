package com.gubatron.maracucho.messages;

import com.gubatron.maracucho.Constants;

public final class HelloMessage extends Message {
    public final String version;
    public final String agent;

    public HelloMessage() {
        super("hello");
        version = Constants.VERSION;
        agent  = Constants.AGENT;
    }
}
