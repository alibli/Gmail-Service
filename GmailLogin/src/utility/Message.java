package utility;

import java.io.Serializable;

public class Message implements Serializable {

   // public static final long serialVersionUID = 14L;

    private MessageType messageType;

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageType getMessageType() {
        return messageType;
    }
}
