package DuvarciProject.Main;

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


import javax.swing.ImageIcon;

/**
 *
 * @author Stenns
 */
public class Icons {
    
    /**
     * Returns image address to be printed out icon for each 
     * square using row and column numbers as parameters, received from 
     * {@link KnightsOfHazard#LabelPictures() LabelPictures} method from main class
     * 
     * @param row is the label row
     * @param column is the label row
     * @return image address to be printed 
     */
    public static ImageIcon KnightIcons(int row, int column){
        
        ImageIcon white1 = new ImageIcon("src/main/resources/whitek1.png");
        ImageIcon white2 = new ImageIcon("src/main/resources/whitek2.png");
        ImageIcon black1 = new ImageIcon("src/main/resources/blackk1.png");
        ImageIcon black2 = new ImageIcon("src/main/resources/blackk2.png");
        ImageIcon empty = new ImageIcon("src/main/resources/empty.png");
        ImageIcon disabled = new ImageIcon("src/main/resources/disabled.png");

        switch(KnightsOfHazard.ChessBoard[row][column]){
            case 0:
                return empty;
            case 1:
                if (KnightsOfHazard.Player1Turn == true)
                    
                return white2;
                else
                    return white1;
            case 2:
                if (KnightsOfHazard.Player1Turn == true)
                return black1;
                else
                    return black2;
            case 3: 
                return disabled;       
        }
        return null;       
    }    
}
