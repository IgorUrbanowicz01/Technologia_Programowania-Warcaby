package com.client;

import com.client.controllers.GameViewController;
import com.client.helpers.Routes;
import com.messages.*;

import javafx.application.Platform;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Class for read information from a server and intepreated information
 */
public class ConnectionListener extends Thread {
    public ObjectInputStream in;
    public ObjectOutputStream out;
    public MessageHolder currentMessage;
    public boolean creatingGame = false;

    public ConnectionListener(Socket clientSocket) throws Exception {
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        in = new ObjectInputStream(clientSocket.getInputStream());
    }

    /**
     * Constructor for tests
     */
    public ConnectionListener() {
    }

    /**
     * Start connection listener
     */
    @Override
    public void run() {
        while (true) {
            try {
                currentMessage = (MessageHolder) in.readObject();
                System.out.println(currentMessage.getMessageType());
                messageHandler(currentMessage);
            } catch (Exception exception) {
                break;
            }
        }
    }

    /**
     * Close connection listener
     */
    public void close() {
        try {
            out.close();
            in.close();
        } catch (IOException ignored) {
        }
    }

    /**
     * Method calling appropriate methods depending on the message received from the
     * server
     * 
     * @param message message from server
     * @throws MalformedURLException
     * @throws FileNotFoundException
     */
    public void messageHandler(MessageHolder message) throws MalformedURLException {
        switch (message.getMessageType()) {
            case "Registered" -> {
                ClientCore.getInstance().getRegisteryController()
                        .accountCreatedSuccesfullyNotification();
                ClientCore.getInstance().getRegisteryController().setAllCorrect(true);
            }
            case "Register failed" -> {
                ClientCore.getInstance().getRegisteryController().errorNotification();
                ClientCore.getInstance().getRegisteryController().setAllCorrect(false);
            }
            case "Logged in" -> {
                RegisterMessage rm = (RegisterMessage) message;
                ClientCore.getInstance().setLogin(rm.getLogin());
                ClientCore.getInstance().getLoginIntoLauncherController().loadDashboardScene();
            }
            case "Login fail" -> ClientCore.getInstance().getLoginIntoLauncherController().errorNotification();
            case "LobbyInfo" -> {
                LobbyInfoMessage lm = (LobbyInfoMessage) message;
                ClientCore.getInstance().setLobbyInfo(lm);
                ClientCore.getInstance().getDashboardController().loadLobby();
                GameViewController x = ClientCore.getInstance().getGameController();
            }
            case "lobby list info" -> {
                LobbyListMessage llm = (LobbyListMessage) message;
                LinkedList<DummyLobby> lobbys = llm.getLobbys();
                ClientCore.getInstance().getDashboardController().changeLobbyList(lobbys);
                ClientCore.getInstance().getDashboardController().initDashboardGames();
            }
            case "gameBeginning" -> {
                creatingGame = true;
                GameBeginningMessage gbm = (GameBeginningMessage) message;
                try {
                    ClientCore.getInstance().getLobbyController().loadGameScene(gbm.getPlayerCount(),
                            gbm.getPlayerNumber());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            case "invalid move" -> {
                ClientCore.getInstance().myTurn = true;
            }
            case "turn" -> {
                JoinLobbyMessage jlm = (JoinLobbyMessage) message;
                if (Objects.equals(jlm.getHostName(), ClientCore.getInstance().getLogin())) {
                    ClientCore.getInstance().myTurn = true;

                }
                ClientCore.getInstance().currentPlayer = jlm.getHostName();

            }
            case "move" -> {
                MoveMessage mm = (MoveMessage) message;
                ClientCore.getInstance().getGameController().getMouseMoveHandler().executeMove(mm.getPawnX(),
                        mm.getPawnY(), mm.getMoveX(), mm.getMoveY());
            }

        }
    }

    /**
     * @return ObjectOutputStream
     */
    public ObjectOutputStream getOut() {
        return out;
    }
}