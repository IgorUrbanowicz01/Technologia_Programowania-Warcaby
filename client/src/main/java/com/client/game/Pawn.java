package com.client.game;

import java.util.List;

public class Pawn {
    public int player;
    public int height;
    public int width;
    Boolean king = false;
    List<Integer> kills;

    public Pawn(int player) {
        this.player = player;
    }

    public void setKing() {
        this.king = true;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void addKill(int height, int width) {
        kills.add(height, width);
    }

    public List<Integer> getKills() {
        return kills;
    }

    public void coppyKills(List<Integer> kills) {
        this.kills = kills;
    }

    public int getKillsSize() {
        return kills.size();
    }
}