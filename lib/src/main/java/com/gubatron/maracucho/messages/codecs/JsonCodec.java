package com.gubatron.maracucho.messages.codecs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gubatron.maracucho.messages.GetPeersMessage;
import com.gubatron.maracucho.messages.HelloMessage;
import com.gubatron.maracucho.messages.Message;
import com.gubatron.maracucho.messages.PeersMessage;

import java.nio.charset.StandardCharsets;

public class JsonCodec implements MessageCodec {
    private final Gson gson = new GsonBuilder().create();

    @Override
    public byte[] encodeMessage(Message message) {
        return gson.toJson(message).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public Message decodeMessage(byte[] data) {
        final String dataString = new String(data);
        final Message message = gson.fromJson(dataString, Message.class);
        return switch (message.type) {
            case "hello" -> gson.fromJson(dataString, HelloMessage.class);
            case "getpeers" -> gson.fromJson(dataString, GetPeersMessage.class);
            case "peers" -> gson.fromJson(dataString, PeersMessage.class);
            default -> message;
        };
    }
}
