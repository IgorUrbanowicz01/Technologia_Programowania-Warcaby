package com.client.game;

public interface GameType {

    int getSize(); // size of the board

    void moveOneField(int height, int width, Pawn[][] board, Pawn[][] logic); // one move to the left

    int[] jumpOver(int height, int width, Pawn[][] board, Pawn[][] logic, int player); // jumping over opponents

    void moveKing(int height, int width, Pawn[][] board, Pawn[][] logic, int player); // How dose the king move

    Pawn[][] setPlayers(Pawn[][] board); // sets Players in their correct position

    Pawn[][] setVaildmovesP(int height, int width, Pawn[][] board);

}