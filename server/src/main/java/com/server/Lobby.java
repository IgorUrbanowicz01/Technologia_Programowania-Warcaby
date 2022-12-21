package com.server;

import java.util.LinkedList;

/**
 * lobby
 */
public class Lobby {
    private String host, name;
    private int numberOfPlayers;
    private final LinkedList<UserCommunicationThread> players;
    public Game game;

    /**
     * creates a new lobby
     */
    public Lobby() {
        numberOfPlayers = 0;
        players = new LinkedList<>();
    }

    /**
     * adds a player to lobby
     * 
     * @param newPlayer player to add
     */
    public void addPlayer(UserCommunicationThread newPlayer) {
        // To Do
    }

    /**
     * removes a player from lobby
     * 
     * @param playerToRemove player to remove
     */
    public void removePlayer(UserCommunicationThread playerToRemove) {
        // To Do
    }

    /**
     * starts a game
     */
    public void start() {
        // To Do
    }

    /**
     * return hosts login
     * 
     * @return hosts login
     */
    public String getHost() {
        return host;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // To Do
    }

    /**
     * returns number of players int the lobby
     * 
     * @return number of players
     */
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    /**
     * returns players list
     * 
     * @return players list
     */
    public LinkedList<UserCommunicationThread> getPlayers() {
        return players;
    }
}
