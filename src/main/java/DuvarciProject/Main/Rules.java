package DuvarciProject.Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*
 * #%L
 * Duvarci Project
 * %%
 * Copyright (C) 2017 Debreceni Egyetem
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import javax.swing.JOptionPane;

/**
 *
 * @author Stenns
 */
public class Rules {

    private static final Logger log = LoggerFactory.getLogger(Rules.class);
    /**
     * Variable which stores information about which player wins, first or
     * second
     */
    public static int winner = 1;

    /**
     * Variable which stores the name of the winned player
     */
    public static String winnerName;

    /**
     * Receives players positions as two parameters from 
     * chess board {@link KnightsOfHazard#ChessBoard layout} and gets which 
     * {@link KnightsOfHazard#Player1Turn player} is moving now. 
     * Then it {@link KnightsOfHazard#PossibleMovings checks} the player click 
     * position - if it is acceptable by rules the knight is moved on this square
     * and another player turn starts
     * @param row is a position row
     * @param column is a position column
     */
    public static void KnightMove(int row, int column) {
        int knightRow = 0;
        int knightColumn = 0;
        int counter = 0;
        
        /**
         * When it's Player 1's turn, the position of Player 1 is updated with
         * this new position.
         */
        if (KnightsOfHazard.Player1Turn) {
            for (int i = 2; i <= 9; i++) {
                for (int j = 2; j <= 9; j++) {
                    if (KnightsOfHazard.ChessBoard[i][j] == 1) {
                        knightRow = i;
                        knightColumn = j;

                    }
                }
            }
        }
        log.trace("Player 1's position");
        
        /**
         * When it's Player 2's turn, the position of Player 2 updated with its
         * new position.
         */
        if (!KnightsOfHazard.Player1Turn) {
            for (int i = 2; i <= 9; i++) {
                for (int j = 2; j <= 9; j++) {
                    if (KnightsOfHazard.ChessBoard[i][j] == 2) {
                        knightRow = i;
                        knightColumn = j;

                    }
                }
            }
        }
        log.trace("Player 2's position");
        /**
         * It checks the Knight's possible movements. If it's an available spot,
         * Knight can move there. Otherwise it increases the counter by 1. If
         * all 8 possibilities are unavailable -i.e. no more possible movements-
         * then the other player wins the game.
         */
        if (KnightsOfHazard.ChessBoard[knightRow - 2][knightColumn - 1] == 0) {
            KnightsOfHazard.PossibleMovings[knightRow - 2][knightColumn - 1] = 0;
        } else {
            counter++;
        }

        if (KnightsOfHazard.ChessBoard[knightRow - 1][knightColumn - 2] == 0) {
            KnightsOfHazard.PossibleMovings[knightRow - 1][knightColumn - 2] = 0;
        } else {
            counter++;
        }
        if (KnightsOfHazard.ChessBoard[knightRow + 1][knightColumn - 2] == 0) {
            KnightsOfHazard.PossibleMovings[knightRow + 1][knightColumn - 2] = 0;

        } else {
            counter++;
        }
        if (KnightsOfHazard.ChessBoard[knightRow + 2][knightColumn - 1] == 0) {
            KnightsOfHazard.PossibleMovings[knightRow + 2][knightColumn - 1] = 0;

        } else {
            counter++;
        }
        if (KnightsOfHazard.ChessBoard[knightRow + 2][knightColumn + 1] == 0) {
            KnightsOfHazard.PossibleMovings[knightRow + 2][knightColumn + 1] = 0;
        } else {
            counter++;
        }
        if (KnightsOfHazard.ChessBoard[knightRow + 1][knightColumn + 2] == 0) {
            KnightsOfHazard.PossibleMovings[knightRow + 1][knightColumn + 2] = 0;
        } else {
            counter++;
        }
        if (KnightsOfHazard.ChessBoard[knightRow - 1][knightColumn + 2] == 0) {
            KnightsOfHazard.PossibleMovings[knightRow - 1][knightColumn + 2] = 0;
        } else {
            counter++;
        }
        if (KnightsOfHazard.ChessBoard[knightRow - 2][knightColumn + 1] == 0) {
            KnightsOfHazard.PossibleMovings[knightRow - 2][knightColumn + 1] = 0;
        } else {
            counter++;
        }

        /**
         * It announces the winning Player (Player 2) and updates the
         * scoreboard, then exits the application.
         */
        if (counter == 8 && KnightsOfHazard.Player1Turn) {
            JOptionPane.showMessageDialog(null, PlayerNames.Player2Name + " wins!");
            winner = 2;
            winnerName = PlayerNames.Player2Name;
            new ScoreTable().storeTable();
            System.exit(0);
        }
        /**
         * It announces the winning Player (Player 1) and updates the
         * scoreboard, then exits the application.
         */
        if (counter == 8 && !KnightsOfHazard.Player1Turn) {
            JOptionPane.showMessageDialog(null, PlayerNames.Player1Name + " wins!");
            winner = 1;
            winnerName = PlayerNames.Player1Name;
            new ScoreTable().storeTable();
            System.exit(0);
        }

        if (KnightsOfHazard.PossibleMovings[row][column] == 0 && KnightsOfHazard.Player1Turn) {
            KnightsOfHazard.ChessBoard[knightRow][knightColumn] = 3;
            KnightsOfHazard.ChessBoard[row][column] = 1;
            KnightsOfHazard.PlayerMoved = true;
            PlayerNames.score = PlayerNames.score + 1;

        }

        if (KnightsOfHazard.PossibleMovings[row][column] == 0 && !KnightsOfHazard.Player1Turn) {
            KnightsOfHazard.ChessBoard[knightRow][knightColumn] = 3;
            KnightsOfHazard.ChessBoard[row][column] = 2;
            KnightsOfHazard.PlayerMoved = true;
            PlayerNames.score = PlayerNames.score + 1;

        }
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 11; j++) {
                KnightsOfHazard.PossibleMovings[i][j] = 3;
                log.trace("Position becomes unavailable");
            }
        }

    }

}
