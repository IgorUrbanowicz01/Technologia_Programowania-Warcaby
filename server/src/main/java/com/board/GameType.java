package com.board;

public interface GameType {

    public int getSize(); // size of the board

    public int[] moveOneFieldLeft(int height, int width, Pawn[][] board); // one move to the left

    public int[] moveOneFieldRight(int height, int width, Pawn[][] board); // one move to the right

    public int[] jumpOverLeft(int height, int width, Pawn[][] board); // jumping over opponents picies to the Left

    public int[] jumpOverRight(int height, int width, Pawn[][] board); // jumping over opponents picies to the Riht

    public int[] moveKing(int height, int width); // How dose the king move

    public Pawn[][] setPlayers(Pawn[][] board); // sets Players in their correct position

    public Pawn[][] setVaildmoves(int height, int width, Pawn[][] board);
}
