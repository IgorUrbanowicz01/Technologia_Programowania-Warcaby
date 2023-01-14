package com.messages;

import java.util.LinkedList;

public class LobbyListMessage extends MessageHolder{
    private LinkedList<DummyLobby> lobbys = new LinkedList<>();

    public LinkedList<DummyLobby> getLobbys() {
        return lobbys;
    }

    public void setLobbys(LinkedList<DummyLobby> lobbys) {
        this.lobbys = lobbys;
    }
}