package com.board;

import java.util.List;
import java.util.ArrayList;

public class Pawn {
    public int player, height, width;
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
