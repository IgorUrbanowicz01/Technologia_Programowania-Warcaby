package com.lab1;

import com.messages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessagesTest {
    @Test
    public void registerMessageTest(){
        RegisterMessage rm = new RegisterMessage();
        String login = "testLogin";
        String password = "testPassword";
        rm.setMessageType("Test");
        rm.setLogin(login);
        rm.setPassword(password);
        Assertions.assertEquals(login, rm.getLogin());
        Assertions.assertEquals(password, rm.getPassword());
        Assertions.assertEquals("Test", rm.getMessageType());
    }
    @Test
    public void moveMessageTest(){
        MoveMessage mm = new MoveMessage();
        mm.setMessageType("Test");
        int pawnX = 1;
        int pawnY = 2;
        int moveX = 3;
        int moveY = 4;
        mm.setAll(pawnX, pawnY, moveX, moveY);
        Assertions.assertEquals(pawnX, mm.getPawnX());
        Assertions.assertEquals(pawnY, mm.getPawnY());
        Assertions.assertEquals(moveX, mm.getMoveX());
        Assertions.assertEquals(moveY, mm.getMoveY());
        mm.setMoveX(moveX);
        mm.setMoveY(moveY);
        mm.setPawnX(pawnX);
        mm.setPawnY(pawnY);
        Assertions.assertEquals(pawnX, mm.getPawnX());
        Assertions.assertEquals(pawnY, mm.getPawnY());
        Assertions.assertEquals(moveX, mm.getMoveX());
        Assertions.assertEquals(moveY, mm.getMoveY());
        Assertions.assertEquals("Test", mm.getMessageType());
    }
    @Test
    public void messageHolderTest(){
        MessageHolder m = new MessageHolder();
        m.setMessageType("Test");
        Assertions.assertEquals("Test", m.getMessageType());
    }
    @Test
    public void loginMessageTest(){
        String login = "testLogin";
        String type = "Test";
        String password = "testPassword";
        LoginMessage m = new LoginMessage();
        m.setLogin(login);
        m.setMessageType(type);
        m.setPassword(password);
        Assertions.assertEquals(login, m.getLogin());
        Assertions.assertEquals(type, m.getMessageType());
        Assertions.assertEquals(password, m.getPassword());
    }
    @Test
    public void lobbyListMessageTest(){
        LobbyListMessage m = new LobbyListMessage();
        String type = "Test";
        m.setMessageType(type);
        LinkedList<DummyLobby> list = new LinkedList<>();
        list.add(new DummyLobby("tName", 2, "tHost"));
        m.setLobbys(list);
        Assertions.assertEquals(m.getMessageType(), type);
        Assertions.assertEquals("tName", m.getLobbys().getFirst().getName());
        Assertions.assertEquals(Integer.valueOf(2), m.getLobbys().getFirst().getPlayersInLobby());
        Assertions.assertEquals("tHost", m.getLobbys().getFirst().hostName());
    }
    @Test
    public void lobbyInfoMessageTest(){
        LobbyInfoMessage m = new LobbyInfoMessage();
        String type = "Test";
        String name = "TestName";
        m.setMessageType(type);
        m.setGameName(name);
        String name0 = "Test0";
        String name1 = "Test1";

        m.getPlayernames().add(name0);
        m.getPlayernames().add(name1);

        Assertions.assertEquals(type, m.getMessageType());
        Assertions.assertEquals(name, m.getGameName());
        Assertions.assertEquals(name1, m.getPlayernames().get(1));

    }
    @Test
    public void joinLobbyMessageTest(){
        JoinLobbyMessage m = new JoinLobbyMessage();
        String type = "Test";
        String host = "testHost";
        m.setMessageType(type);
        m.setHostName(host);
        Assertions.assertEquals(type, m.getMessageType());
        Assertions.assertEquals(host, m.getHostName());
    }
    @Test
    public void gameBeginningMessageTest(){
        GameBeginningMessage m = new GameBeginningMessage();
        String type = "Test";
        int count = 8;
        int number = 3;
        m.setPlayerCount(count);
        m.setMessageType(type);
        m.setPlayerNumber(number);
        Assertions.assertEquals(type, m.getMessageType());
        Assertions.assertEquals(count, m.getPlayerCount());
        Assertions.assertEquals(number, m.getPlayerNumber());
    }
}
