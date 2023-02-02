package com.messages;

import java.util.LinkedList;

public class LobbyInfoMessage extends MessageHolder{
    LinkedList<String> playernames;
    String GameName;
    public LobbyInfoMessage(){
        playernames = new LinkedList<>();
    }

    public LinkedList<String> getPlayernames() {
        return playernames;
    }
    public String getGameName() {
        return GameName;
    }

    public void setGameName(String gameName) {
        GameName = gameName;
    }
}