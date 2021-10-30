package com.gubatron.maracucho.messages;

import java.util.ArrayList;
import java.util.List;

public class PeersMessage extends Message {
    public final List<String> peers;
    public PeersMessage() {
        super("peers");
        peers = new ArrayList<>();
    }
    public void addPeer(String peerString) {
        peers.add(peerString);
    }

    public void addPeer(String host, int port) {
        addPeer(new String(host + ":" + port));
    }
}
