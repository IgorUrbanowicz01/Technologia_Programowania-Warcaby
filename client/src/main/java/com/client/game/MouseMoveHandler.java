package com.client.game;

import com.client.ClientCore;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Class for detecting users mouse events
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {
    boolean isPawnChoosen = false;
    int pawnX;
    int pawnY;
    int playerNumber;
    CheckersBoardAdapter ccba;

    public MouseMoveHandler(CheckersBoardAdapter ccba) {
        this.ccba = ccba;
    }

    /**
     * Method for checking what the user do
     * 
     * @param mouseEvent users mouseEvent
     */
    @Override
    public void handle(MouseEvent mouseEvent) {

        Field field = (Field) mouseEvent.getSource();
        if (!ClientCore.getInstance().myTurn) {
            return;
        }
        try {
            if (isPawnChoosen) {
                move(pawnX, pawnY, field.getWidth(), field.getHeight());
                isPawnChoosen = false;
            } else {
                pawnX = field.getWidth();
                pawnY = field.getHeight();
                if (ccba.checkersBoard.getBoard()[pawnY][pawnX] != playerNumber) {
                    return;
                }
                isPawnChoosen = true;
            }
        } catch (Exception e) {
            isPawnChoosen = false;
        }
    }

    /**
     * @param pawnX pawn position X
     * @param pawnY pawn position Y
     * @param moveX pawn move position X
     * @param moveY pawn move position Y
     * @throws Exception throws if pawn can't move on new position
     */
    private void move(int pawnX, int pawnY, int moveX, int moveY) throws Exception {
        CheckersBoard logic = ccba.checkersBoard.setValidMoves(pawnY, pawnX);
        if (logic.getBoard()[moveY][moveX] == 1) {
            ClientCore.getInstance().sendMove(pawnX, pawnY, moveX, moveY);
            ClientCore.getInstance().myTurn = false;
        } else {
            throw new Exception("invalid move");
        }
    }

    /**
     * Method is invokes when pawn can move on new position
     * 
     * @param pawnX pawn position X
     * @param pawnY pawn position Y
     * @param moveX pawn move position X
     * @param moveY pawn move position Y
     */
    public void executeMove(int pawnX, int pawnY, int moveX, int moveY) {
        try {
            ccba.move(pawnX, pawnY, moveX, moveY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Setter for the player number
     * 
     * @param playerNumber which player move is now
     */
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
}
