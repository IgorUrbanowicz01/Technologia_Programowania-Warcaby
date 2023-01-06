package com.board;

public class Pawn {
    public int player, height, width, kills = 0;
    Boolean king = false;

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

}
