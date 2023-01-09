package com.board;

public class PolishCheckers implements GameType {

    int size = 10;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void moveOneField(int height, int width, Pawn[][] board, Pawn[][] logic) {
        if (board[height][width].getPlayer() == 1) {
            try {
                if (board[height++][width--].getPlayer() == 0)
                    logic[height++][width--].setPlayer(1);
            } catch (Exception e) {
            }
            try {
                if (board[height++][width++].getPlayer() == 0)
                    logic[height++][width--].setPlayer(1);
            } catch (Exception e) {
            }
        }
        if (board[height][width].getPlayer() == 2) {
            try {
                if (board[height--][width--].getPlayer() == 0)
                    logic[height--][width--].setPlayer(1);
            } catch (Exception e) {
            }
            try {
                if (board[height--][width++].getPlayer() == 0)
                    logic[height--][width--].setPlayer(1);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public int[] jumpOver(int height, int width, Pawn[][] board, Pawn[][] logic, int player) {
        int[] moves = new int[] { 0, 0 };
        int[] temp = new int[] { 0, 0 };
        if (player == 1) {
            try {
                if (board[height++][width--].getPlayer() == 2 && board[height + 2][width - 2].getPlayer() == 0)
                    logic[height + 2][width - 2].setPlayer(1);
                logic[height + 2][width - 2].addKill(height++, width--);
                temp = jumpOver(height + 2, width - 2, board, logic, 1);
                moves[0] = 1;
            } catch (Exception e) {
                moves[0] = -1;
            }
            try {
                if (board[height++][width++].getPlayer() == 2 && board[height + 2][width + 2].getPlayer() == 0)
                    logic[height + 2][width + 2].setPlayer(1);
                logic[height + 2][width + 2].addKill(height++, width++);
                temp = jumpOver(height + 2, width + 2, board, logic, 1);
                moves[1] = 1;
            } catch (Exception e) {
                moves[0] = -1;
            }
        } else {
            try {
                if (board[height--][width--].getPlayer() == 1 && board[height - 2][width - 2].getPlayer() == 0)
                    logic[height - 2][width - 2].setPlayer(2);
                logic[height - 2][width - 2].addKill(height++, width--);
                temp = jumpOver(height - 2, width - 2, board, logic, 2);
                moves[0] = 1;
            } catch (Exception e) {
                moves[0] = -1;
            }
            try {
                if (board[height--][width++].getPlayer() == 1 && board[height - 2][width + 2].getPlayer() == 0)
                    logic[height - 2][width + 2].setPlayer(2);
                logic[height - 2][width + 2].addKill(height++, width++);
                temp = jumpOver(height - 2, width + 2, board, logic, 2);
                moves[1] = 1;
            } catch (Exception e) {
                moves[0] = -1;
            }
        }
        return moves;
    }

    @Override
    public void moveKing(int height, int width, Pawn[][] board, Pawn[][] logic, int player) {
        for (int i = 1; i < size - Math.max(height, width); i++) {
            try {
                if (board[height + i][width + i].getPlayer() == 0) {
                    logic[height + i][width + i].setPlayer(player);
                    logic[height + i][width + i].coppyKills(logic[height + i - 1][width + i - 1].getKills());
                } else if (board[height + i][width + i].getPlayer() == player) {
                    break;
                } else {
                    if (board[height + i + 1][width + i + 1].getPlayer() == 0) {
                        logic[height + i + 1][width + i + 1].setPlayer(player);
                        logic[height + i + 1][width + i + 1].addKill(height + i, width + i);
                        i = +1;
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }

        for (int i = 1; i < size - Math.max(size - height, width); i++) {
            try {
                if (board[height - i][width + i].getPlayer() == 0) {
                    logic[height - i][width + i].setPlayer(player);
                    logic[height - i][width + i].coppyKills(logic[height - i + 1][width + i - 1].getKills());
                } else if (board[height - i][width + i].getPlayer() == player) {
                    break;
                } else {
                    if (board[height - i + 1][width + i + 1].getPlayer() == 0) {
                        logic[height - i + 1][width + i + 1].setPlayer(player);
                        logic[height - i + 1][width + i + 1].addKill(height - i, width + i);
                        i = +1;
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }

        for (int i = 1; i < size - Math.max(height, size - width); i++) {
            try {
                if (board[height + i][width - i].getPlayer() == 0) {
                    logic[height + i][width - i].setPlayer(player);
                    logic[height + i][width - i].coppyKills(logic[height + i - 1][width - i + 1].getKills());
                } else if (board[height + i][width - i].getPlayer() == player) {
                    break;
                } else {
                    if (board[height + i + 1][width - i - 1].getPlayer() == 0) {
                        logic[height + i + 1][width - i - 1].setPlayer(player);
                        logic[height + i + 1][width - i - 1].addKill(height + i, width - i);
                        i = +1;
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }

        for (int i = 1; i < Math.min(height, width) + 1; i++) {
            try {
                if (board[height - i][width - i].getPlayer() == 0) {
                    logic[height - i][width - i].setPlayer(player);
                    logic[height - i][width - i].coppyKills(logic[height - i + 1][width - i + 1].getKills());
                } else if (board[height - i][width - i].getPlayer() == player) {
                    break;
                } else {
                    if (board[height - i - 1][width - i - 1].getPlayer() == 0) {
                        logic[height - i - 1][width - i - 1].setPlayer(player);
                        logic[height - i - 1][width - i - 1].addKill(height + i, width + i);
                        i = +1;
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
    }

    @Override
    public Pawn[][] setPlayers(Pawn[][] board) {
        for (int height = 0; height < 3; height++) {

            for (int width = 0; width < width; width = +2) {
                Pawn pawn = new Pawn(1);
                board[width][height] = pawn;
            }

            for (int i = this.getSize(); i < i - 3; i--) {
                for (int width = 0; width < width; width = +2) {
                    Pawn pawn = new Pawn(2);
                    board[width][height] = pawn;
                }
            }
        }
        return board;

    }

    @Override
    public Pawn[][] setVaildmovesP(int height, int width, Pawn[][] board) {
        Pawn[][] LogicBoard = new CheckersBoardBuilder().buildEmpty(size);
        int[] nextmove;
        int player = board[height][width].getPlayer();
        LogicBoard = new CheckersBoardBuilder().buildEmpty(size);
        if (board[height][width].king == true) {
            moveKing(height, width, board, LogicBoard, player);
        }
        nextmove = jumpOver(height, width, board, LogicBoard, player);
        if (nextmove[0] != 1 && nextmove[1] != 1) {
            moveOneField(height, width, board, LogicBoard);
        } else {
            int maxKill = -1;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (LogicBoard[i][j].getPlayer() != 0) {
                        if (LogicBoard[i][j].getKillsSize() >= maxKill) {
                            maxKill = LogicBoard[i][j].getKillsSize();
                        } else {
                            LogicBoard[i][j].setPlayer(0);
                        }
                    }
                }
            }
        }
        return LogicBoard;
    }

}
