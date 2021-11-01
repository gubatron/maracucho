package com.gubatron.maracucho;

import com.gubatron.maracucho.messages.GetPeersMessage;
import com.gubatron.maracucho.messages.HelloMessage;
import com.gubatron.maracucho.messages.Message;
import com.gubatron.maracucho.messages.PeersMessage;
import com.gubatron.maracucho.messages.codecs.JsonCodec;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MessageTests {
    @Test public void testHelloMessageAttributes() {
        HelloMessage hello = new HelloMessage();
        assertTrue("Hello message type should be 'hello'", hello.type.equals("hello"));
        assertTrue("Hello message version should be " + Constants.VERSION, hello.version.equals(Constants.VERSION));
        assertTrue("Agent should be '" + Constants.AGENT + "'", hello.agent.equals(Constants.AGENT));
    }

    @Test public void testJSONCodecHelloMessage() {
        HelloMessage hello = new HelloMessage();
        JsonCodec codec = new JsonCodec();
        byte[] bytes = codec.encodeMessage(hello);
        Message decoded = codec.decodeMessage(bytes);
        assertTrue("Message is not a HelloMessage", decoded instanceof HelloMessage);
        HelloMessage decodedMessage = (HelloMessage) decoded;
        assertTrue("Agent in HelloMessage does not match our agent", decodedMessage.agent.equals(Constants.AGENT));
        assertTrue("Decoded HelloMessage does not match type 'hello'", decodedMessage.type.equals("hello"));
    }

    @Test public void testJSONCodecGetPeersMessage() {
        GetPeersMessage message = new GetPeersMessage();
        JsonCodec codec = new JsonCodec();
        byte[] bytes = codec.encodeMessage(message);
        Message decoded = codec.decodeMessage(bytes);
        assertTrue("Message is not a GetPeersMessage", decoded instanceof GetPeersMessage);
        GetPeersMessage decodedMessage = (GetPeersMessage) decoded;
        assertTrue("Decoded GetPeersMessage does not match type 'getpeers'", decodedMessage.type.equals("getpeers"));
    }

    @Test public void testJSONCodecPeersMessage() {
        PeersMessage message = new PeersMessage();
        JsonCodec codec = new JsonCodec();
        byte[] bytes = codec.encodeMessage(message);
        Message decoded = codec.decodeMessage(bytes);
        assertTrue("Message is not a GetPeersMessage", decoded instanceof PeersMessage);
        PeersMessage decodedMessage = (PeersMessage) decoded;
        assertTrue("Decoded PeersMessage does not match type 'peers'", decodedMessage.type.equals("peers"));
    }
}
