package com.board;

public interface GameType {

    public int getSize(); // size of the board

    public void moveOneField(int height, int width, Pawn[][] board, Pawn[][] logic); // one move to the left

    public int[] jumpOver(int height, int width, Pawn[][] board, Pawn[][] logic, int player); // jumping over opponents

    public void moveKing(int height, int width, Pawn[][] board, Pawn[][] logic, int player); // How dose the king move

    public Pawn[][] setPlayers(Pawn[][] board); // sets Players in their correct position

    public Pawn[][] setVaildmovesP(int height, int width, Pawn[][] board);

}
