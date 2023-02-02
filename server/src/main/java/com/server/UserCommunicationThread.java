package com.server;

import com.database.UserInformationPackage;
import com.messages.*;

import java.io.*;
import java.net.Socket;

/**
 * Class responsible for connection with one client
 */
public class UserCommunicationThread extends Thread {

    public ObjectInputStream in;
    public ObjectOutputStream out;
    Socket clientSocket;
    MessageHolder message;
    public UserInformationPackage userData;
    public Lobby myLobby = null;

    /**
     * creates new user thread
     * 
     * @param clientSocket users socket
     */
    public UserCommunicationThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    /**
     * sets player lobby
     * 
     * @param lobby lobby
     */
    public void setLobby(Lobby lobby) {
        myLobby = lobby;
    }

    /**
     * setups input and output
     * 
     * @throws IOException throws if unable to set up
     */
    public void setInOut() throws Exception {
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        in = new ObjectInputStream(clientSocket.getInputStream());
    }

    /**
     * Function reading input from client
     */
    @Override
    public void run() {
        try {
            setInOut();
        } catch (Exception exception) {
            ServerCore.getInstance().getController()
                    .append("failed to connect client" + clientSocket.getInetAddress().getHostAddress());
            ServerCore.getInstance().getUsers().remove(this);
            return;
        }
        do {
            try {
                message = (MessageHolder) in.readObject();
                inputObjectHandling(message);
            } catch (IOException | ClassNotFoundException exception) {
                ServerCore.getInstance().getUsers().remove(this);
                break;
            }
        } while (message != null);
    }

    /**
     * closes connection
     * 
     * @throws IOException
     */
    public void close() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    /**
     * Function Processing input from client
     * 
     * @param message input received from client
     */
    public void inputObjectHandling(MessageHolder message) throws IOException {
        ServerCore.getInstance().getController().appendInput(message.getMessageType());
        switch (message.getMessageType()) {
            case "get lobby info" -> getLobbyInfo();
            case "Create Lobby" -> createLobby();
            case "join lobby" -> joinLobby(message);
            case "exit lobby" -> exitLobby();
            case "StartGame" -> startGame();
            case "move" -> move(message);
            case "change name" -> changeLobbyName(message);
        }
    }

    private void register() throws IOException {
        // Registration with DB
    }

    private void login() throws IOException {
        // Registration with DB
    }

    private void getLobbyInfo() throws IOException {
        LobbyListMessage llm = new LobbyListMessage();
        llm.setMessageType("lobby list info");
        llm.setLobbys(ServerCore.getInstance().getLobbysInfo());
        out.writeObject(llm);
        ServerCore.getInstance().getController().appendOutput(llm.getMessageType());
    }

    private void createLobby() {
        Lobby lobby = new Lobby();
        lobby.addPlayer(this);
        ServerCore.getInstance().getLobbys().add(lobby);
    }

    private void joinLobby(MessageHolder message) {
        JoinLobbyMessage jlm = (JoinLobbyMessage) message;
        Lobby lobby = ServerCore.getInstance().getLobbybyHost(jlm.getHostName());
        if (lobby != null) {
            lobby.addPlayer(this);
        }
    }

    private void exitLobby() {
        if (myLobby != null) {
            myLobby.removePlayer(this);
        }
        myLobby = null;
    }

    public void changeLobbyName(MessageHolder message) {
        JoinLobbyMessage jm = (JoinLobbyMessage) message;
        if (myLobby != null) {
            myLobby.setName(jm.getHostName());
        }
    }

    private void startGame() {
        if (myLobby != null) {
            myLobby.start();
        }
    }

    private void move(MessageHolder message) {
        MoveMessage mm = (MoveMessage) message;
        if (myLobby != null) {
            myLobby.game.move(mm.getPawnX(), mm.getPawnY(), mm.getMoveX(), mm.getMoveY());
        }
    }
}
