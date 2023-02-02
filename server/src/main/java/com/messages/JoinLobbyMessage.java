package com.messages;

public class JoinLobbyMessage extends MessageHolder {
    String hostName;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}