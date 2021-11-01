package com.gubatron.maracucho.messages.codecs;

import com.gubatron.maracucho.messages.Message;

public interface MessageCodec {
    byte[] encodeMessage(Message message);

    Message decodeMessage(byte[] data);
}
