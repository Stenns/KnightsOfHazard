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
/**
 *
 * @author Stenns
 */
public class KnightsOfHazard extends javax.swing.JFrame {

    private static final Logger log = LoggerFactory.getLogger(KnightsOfHazard.class);
    /**
     * Variable {@code boolean Player1Turn} is used for specifying which
     * player's turn is at a given moment. True, if it is player 1 turn, else
     * false.
     */
    public static boolean Player1Turn = false;

    /**
     * Variable {@code boolean PlayerMoved} is a technical variable
     * which signals that turn should be given to another player in 
     * {@link #LabelPictures() movement visualisation} method
     */
    public static boolean PlayerMoved = true;

    /**
     * Layout of the board including 2 extra lines in each direction. (north,
     * west, south, east)
     */
    public static int PossibleMovings[][] = {
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}};

    /**
     * Layout of the initial Chess board. 0s are visible, unvisited squares. 1
     * is the Player 1's initial position and 2 is the Player 2's initial
     * position. 3s are the extra squares that can not be seen and there are two
     * extra spots in each direction because of the knights ability to move two
     * spots to any direction (in addition to +one to another direction)
     */
    public static int ChessBoard[][] = {
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 0, 0, 0, 0, 0, 0, 0, 2, 3, 3},
        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3},
        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3},
        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3},
        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3},
        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3},
        {3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3},
        {3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}};

    /**
     * Creates new form KnightsOfHazard
     */
    public KnightsOfHazard() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        LabelPictures();
    }

    /**
     * Method that changes the Knight icons using {@link Icons#KnightIcons(int, int) KnightIcons} 
     * method in order to visualize the Knights
     * movements after the players turn, and ends his turn.
     */
    public void LabelPictures() {

        if (PlayerMoved) {
            Player1Turn = !Player1Turn;
            PlayerMoved = false;
            log.trace("Player moved");
        }
        Label11.setIcon(Icons.KnightIcons(2, 2));
        Label12.setIcon(Icons.KnightIcons(2, 3));
        Label13.setIcon(Icons.KnightIcons(2, 4));
        Label14.setIcon(Icons.KnightIcons(2, 5));
        Label15.setIcon(Icons.KnightIcons(2, 6));
        Label16.setIcon(Icons.KnightIcons(2, 7));
        Label17.setIcon(Icons.KnightIcons(2, 8));
        Label18.setIcon(Icons.KnightIcons(2, 9));
        Label21.setIcon(Icons.KnightIcons(3, 2));
        Label22.setIcon(Icons.KnightIcons(3, 3));
        Label23.setIcon(Icons.KnightIcons(3, 4));
        Label24.setIcon(Icons.KnightIcons(3, 5));
        Label25.setIcon(Icons.KnightIcons(3, 6));
        Label26.setIcon(Icons.KnightIcons(3, 7));
        Label27.setIcon(Icons.KnightIcons(3, 8));
        Label28.setIcon(Icons.KnightIcons(3, 9));
        Label31.setIcon(Icons.KnightIcons(4, 2));
        Label32.setIcon(Icons.KnightIcons(4, 3));
        Label33.setIcon(Icons.KnightIcons(4, 4));
        Label34.setIcon(Icons.KnightIcons(4, 5));
        Label35.setIcon(Icons.KnightIcons(4, 6));
        Label36.setIcon(Icons.KnightIcons(4, 7));
        Label37.setIcon(Icons.KnightIcons(4, 8));
        Label38.setIcon(Icons.KnightIcons(4, 9));
        Label41.setIcon(Icons.KnightIcons(5, 2));
        Label42.setIcon(Icons.KnightIcons(5, 3));
        Label43.setIcon(Icons.KnightIcons(5, 4));
        Label44.setIcon(Icons.KnightIcons(5, 5));
        Label45.setIcon(Icons.KnightIcons(5, 6));
        Label46.setIcon(Icons.KnightIcons(5, 7));
        Label47.setIcon(Icons.KnightIcons(5, 8));
        Label48.setIcon(Icons.KnightIcons(5, 9));
        Label51.setIcon(Icons.KnightIcons(6, 2));
        Label52.setIcon(Icons.KnightIcons(6, 3));
        Label53.setIcon(Icons.KnightIcons(6, 4));
        Label54.setIcon(Icons.KnightIcons(6, 5));
        Label55.setIcon(Icons.KnightIcons(6, 6));
        Label56.setIcon(Icons.KnightIcons(6, 7));
        Label57.setIcon(Icons.KnightIcons(6, 8));
        Label58.setIcon(Icons.KnightIcons(6, 9));
        Label61.setIcon(Icons.KnightIcons(7, 2));
        Label62.setIcon(Icons.KnightIcons(7, 3));
        Label63.setIcon(Icons.KnightIcons(7, 4));
        Label64.setIcon(Icons.KnightIcons(7, 5));
        Label65.setIcon(Icons.KnightIcons(7, 6));
        Label66.setIcon(Icons.KnightIcons(7, 7));
        Label67.setIcon(Icons.KnightIcons(7, 8));
        Label68.setIcon(Icons.KnightIcons(7, 9));
        Label71.setIcon(Icons.KnightIcons(8, 2));
        Label72.setIcon(Icons.KnightIcons(8, 3));
        Label73.setIcon(Icons.KnightIcons(8, 4));
        Label74.setIcon(Icons.KnightIcons(8, 5));
        Label75.setIcon(Icons.KnightIcons(8, 6));
        Label76.setIcon(Icons.KnightIcons(8, 7));
        Label77.setIcon(Icons.KnightIcons(8, 8));
        Label78.setIcon(Icons.KnightIcons(8, 9));
        Label81.setIcon(Icons.KnightIcons(9, 2));
        Label82.setIcon(Icons.KnightIcons(9, 3));
        Label83.setIcon(Icons.KnightIcons(9, 4));
        Label84.setIcon(Icons.KnightIcons(9, 5));
        Label85.setIcon(Icons.KnightIcons(9, 6));
        Label86.setIcon(Icons.KnightIcons(9, 7));
        Label87.setIcon(Icons.KnightIcons(9, 8));
        Label88.setIcon(Icons.KnightIcons(9, 9));
        log.trace("Icons printed");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Label11 = new javax.swing.JLabel();
        Label12 = new javax.swing.JLabel();
        Label13 = new javax.swing.JLabel();
        Label14 = new javax.swing.JLabel();
        Label15 = new javax.swing.JLabel();
        Label16 = new javax.swing.JLabel();
        Label17 = new javax.swing.JLabel();
        Label21 = new javax.swing.JLabel();
        Label22 = new javax.swing.JLabel();
        Label23 = new javax.swing.JLabel();
        Label24 = new javax.swing.JLabel();
        Label18 = new javax.swing.JLabel();
        Label25 = new javax.swing.JLabel();
        Label26 = new javax.swing.JLabel();
        Label27 = new javax.swing.JLabel();
        Label28 = new javax.swing.JLabel();
        Label31 = new javax.swing.JLabel();
        Label32 = new javax.swing.JLabel();
        Label33 = new javax.swing.JLabel();
        Label34 = new javax.swing.JLabel();
        Label35 = new javax.swing.JLabel();
        Label36 = new javax.swing.JLabel();
        Label37 = new javax.swing.JLabel();
        Label38 = new javax.swing.JLabel();
        Label41 = new javax.swing.JLabel();
        Label42 = new javax.swing.JLabel();
        Label43 = new javax.swing.JLabel();
        Label44 = new javax.swing.JLabel();
        Label45 = new javax.swing.JLabel();
        Label46 = new javax.swing.JLabel();
        Label47 = new javax.swing.JLabel();
        Label48 = new javax.swing.JLabel();
        Label51 = new javax.swing.JLabel();
        Label52 = new javax.swing.JLabel();
        Label53 = new javax.swing.JLabel();
        Label54 = new javax.swing.JLabel();
        Label55 = new javax.swing.JLabel();
        Label56 = new javax.swing.JLabel();
        Label57 = new javax.swing.JLabel();
        Label58 = new javax.swing.JLabel();
        Label61 = new javax.swing.JLabel();
        Label62 = new javax.swing.JLabel();
        Label63 = new javax.swing.JLabel();
        Label64 = new javax.swing.JLabel();
        Label65 = new javax.swing.JLabel();
        Label66 = new javax.swing.JLabel();
        Label67 = new javax.swing.JLabel();
        Label68 = new javax.swing.JLabel();
        Label71 = new javax.swing.JLabel();
        Label72 = new javax.swing.JLabel();
        Label73 = new javax.swing.JLabel();
        Label74 = new javax.swing.JLabel();
        Label75 = new javax.swing.JLabel();
        Label76 = new javax.swing.JLabel();
        Label77 = new javax.swing.JLabel();
        Label78 = new javax.swing.JLabel();
        Label81 = new javax.swing.JLabel();
        Label82 = new javax.swing.JLabel();
        Label83 = new javax.swing.JLabel();
        Label84 = new javax.swing.JLabel();
        Label85 = new javax.swing.JLabel();
        Label86 = new javax.swing.JLabel();
        Label87 = new javax.swing.JLabel();
        Label88 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jLayeredPane1.setBackground(new java.awt.Color(0, 120, 120));
        jLayeredPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLayeredPane1.setOpaque(true);
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(580, 581));

        Label11.setText("jLabel1");
        Label11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label11MouseClicked(evt);
            }
        });

        Label12.setText("jLabel1");
        Label12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label12MouseClicked(evt);
            }
        });

        Label13.setText("jLabel1");
        Label13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label13MouseClicked(evt);
            }
        });

        Label14.setText("jLabel1");
        Label14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label14MouseClicked(evt);
            }
        });

        Label15.setText("jLabel1");
        Label15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label15MouseClicked(evt);
            }
        });

        Label16.setText("jLabel1");
        Label16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label16MouseClicked(evt);
            }
        });

        Label17.setText("jLabel1");
        Label17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label17MouseClicked(evt);
            }
        });

        Label21.setText("jLabel1");
        Label21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label21MouseClicked(evt);
            }
        });

        Label22.setText("jLabel1");
        Label22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label22MouseClicked(evt);
            }
        });

        Label23.setText("jLabel1");
        Label23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label23MouseClicked(evt);
            }
        });

        Label24.setText("jLabel1");
        Label24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label24MouseClicked(evt);
            }
        });

        Label18.setText("jLabel1");
        Label18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label18MouseClicked(evt);
            }
        });

        Label25.setText("jLabel1");
        Label25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label25MouseClicked(evt);
            }
        });

        Label26.setText("jLabel1");
        Label26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label26MouseClicked(evt);
            }
        });

        Label27.setText("jLabel1");
        Label27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label27MouseClicked(evt);
            }
        });

        Label28.setText("jLabel1");
        Label28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label28MouseClicked(evt);
            }
        });

        Label31.setText("jLabel1");
        Label31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label31MouseClicked(evt);
            }
        });

        Label32.setText("jLabel1");
        Label32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label32MouseClicked(evt);
            }
        });

        Label33.setText("jLabel1");
        Label33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label33MouseClicked(evt);
            }
        });

        Label34.setText("jLabel1");
        Label34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label34MouseClicked(evt);
            }
        });

        Label35.setText("jLabel1");
        Label35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label35MouseClicked(evt);
            }
        });

        Label36.setText("jLabel1");
        Label36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label36MouseClicked(evt);
            }
        });

        Label37.setText("jLabel1");
        Label37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label37MouseClicked(evt);
            }
        });

        Label38.setText("jLabel1");
        Label38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label38MouseClicked(evt);
            }
        });

        Label41.setText("jLabel1");
        Label41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label41MouseClicked(evt);
            }
        });

        Label42.setText("jLabel1");
        Label42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label42MouseClicked(evt);
            }
        });

        Label43.setText("jLabel1");
        Label43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label43MouseClicked(evt);
            }
        });

        Label44.setText("jLabel1");
        Label44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label44MouseClicked(evt);
            }
        });

        Label45.setText("jLabel1");
        Label45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label45MouseClicked(evt);
            }
        });

        Label46.setText("jLabel1");
        Label46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label46MouseClicked(evt);
            }
        });

        Label47.setText("jLabel1");
        Label47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label47MouseClicked(evt);
            }
        });

        Label48.setText("jLabel1");
        Label48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label48MouseClicked(evt);
            }
        });

        Label51.setText("jLabel1");
        Label51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label51MouseClicked(evt);
            }
        });

        Label52.setText("jLabel1");
        Label52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label52MouseClicked(evt);
            }
        });

        Label53.setText("jLabel1");
        Label53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label53MouseClicked(evt);
            }
        });

        Label54.setText("jLabel1");
        Label54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label54MouseClicked(evt);
            }
        });

        Label55.setText("jLabel1");
        Label55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label55MouseClicked(evt);
            }
        });

        Label56.setText("jLabel1");
        Label56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label56MouseClicked(evt);
            }
        });

        Label57.setText("jLabel1");
        Label57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label57MouseClicked(evt);
            }
        });

        Label58.setText("jLabel1");
        Label58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label58MouseClicked(evt);
            }
        });

        Label61.setText("jLabel1");
        Label61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label61MouseClicked(evt);
            }
        });

        Label62.setText("jLabel1");
        Label62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label62MouseClicked(evt);
            }
        });

        Label63.setText("jLabel1");
        Label63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label63MouseClicked(evt);
            }
        });

        Label64.setText("jLabel1");
        Label64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label64MouseClicked(evt);
            }
        });

        Label65.setText("jLabel1");
        Label65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label65MouseClicked(evt);
            }
        });

        Label66.setText("jLabel1");
        Label66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label66MouseClicked(evt);
            }
        });

        Label67.setText("jLabel1");
        Label67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label67MouseClicked(evt);
            }
        });

        Label68.setText("jLabel1");
        Label68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label68MouseClicked(evt);
            }
        });

        Label71.setText("jLabel1");
        Label71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label71MouseClicked(evt);
            }
        });

        Label72.setText("jLabel1");
        Label72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label72MouseClicked(evt);
            }
        });

        Label73.setText("jLabel1");
        Label73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label73MouseClicked(evt);
            }
        });

        Label74.setText("jLabel1");
        Label74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label74MouseClicked(evt);
            }
        });

        Label75.setText("jLabel1");
        Label75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label75MouseClicked(evt);
            }
        });

        Label76.setText("jLabel1");
        Label76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label76MouseClicked(evt);
            }
        });

        Label77.setText("jLabel1");
        Label77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label77MouseClicked(evt);
            }
        });

        Label78.setText("jLabel1");
        Label78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label78MouseClicked(evt);
            }
        });

        Label81.setText("jLabel1");
        Label81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label81MouseClicked(evt);
            }
        });

        Label82.setText("jLabel1");
        Label82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label82MouseClicked(evt);
            }
        });

        Label83.setText("jLabel1");
        Label83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label83MouseClicked(evt);
            }
        });

        Label84.setText("jLabel1");
        Label84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label84MouseClicked(evt);
            }
        });

        Label85.setText("jLabel1");
        Label85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label85MouseClicked(evt);
            }
        });

        Label86.setText("jLabel1");
        Label86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label86MouseClicked(evt);
            }
        });

        Label87.setText("jLabel1");
        Label87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label87MouseClicked(evt);
            }
        });

        Label88.setText("jLabel1");
        Label88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label88MouseClicked(evt);
            }
        });

        jLayeredPane1.setLayer(Label11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label28, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label31, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label32, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label33, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label34, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label35, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label36, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label37, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label38, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label41, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label42, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label43, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label44, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label45, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label46, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label47, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label48, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label51, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label52, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label53, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label54, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label55, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label56, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label57, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label58, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label61, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label62, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label63, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label64, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label65, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label66, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label67, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label68, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label71, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label72, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label73, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label74, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label75, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label76, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label77, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label78, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label81, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label82, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label83, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label84, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label85, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label86, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label87, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(Label88, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Label11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label16, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label17, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Label21, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label22, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label23, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label24, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label25, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label26, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label27, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label28, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Label31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label32, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label33, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label34, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label35, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label37, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label38, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Label41, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label42, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label43, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label44, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label45, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label46, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label47, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label48, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Label51, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label52, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label53, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label54, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label55, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label56, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label57, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label58, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Label61, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label62, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label63, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label64, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label65, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label66, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label67, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label68, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Label71, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label72, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label73, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label74, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label75, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label76, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label77, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label78, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(Label81, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label82, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label83, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label84, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label85, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label86, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label87, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(Label88, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label13, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label14, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label15, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label16, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label17, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label18, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label21, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label22, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label23, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label24, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label25, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label26, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label27, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label28, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label32, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label33, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label34, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label35, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label37, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label38, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label41, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label42, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label43, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label44, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label45, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label46, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label47, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label48, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label51, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label52, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label53, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label54, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label55, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label56, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label57, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label58, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label61, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label62, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label63, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label64, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label65, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label66, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label67, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label68, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label71, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label72, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label73, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label74, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label75, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label76, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label77, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label78, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label81, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label82, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label83, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label84, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label85, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label86, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label87, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label88, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jLayeredPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Label11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label11MouseClicked
        Rules.KnightMove(2, 2);
        LabelPictures();
    }//GEN-LAST:event_Label11MouseClicked

    private void Label12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label12MouseClicked
        Rules.KnightMove(2, 3);
        LabelPictures();
    }//GEN-LAST:event_Label12MouseClicked

    private void Label13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label13MouseClicked
        Rules.KnightMove(2, 4);
        LabelPictures();
    }//GEN-LAST:event_Label13MouseClicked

    private void Label14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label14MouseClicked
        Rules.KnightMove(2, 5);
        LabelPictures();
    }//GEN-LAST:event_Label14MouseClicked

    private void Label15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label15MouseClicked
        Rules.KnightMove(2, 6);
        LabelPictures();
    }//GEN-LAST:event_Label15MouseClicked

    private void Label16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label16MouseClicked
        Rules.KnightMove(2, 7);
        LabelPictures();
    }//GEN-LAST:event_Label16MouseClicked

    private void Label17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label17MouseClicked
        Rules.KnightMove(2, 8);
        LabelPictures();
    }//GEN-LAST:event_Label17MouseClicked

    private void Label18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label18MouseClicked
        Rules.KnightMove(2, 9);
        LabelPictures();
    }//GEN-LAST:event_Label18MouseClicked

    private void Label21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label21MouseClicked
        Rules.KnightMove(3, 2);
        LabelPictures();
    }//GEN-LAST:event_Label21MouseClicked

    private void Label22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label22MouseClicked
        Rules.KnightMove(3, 3);
        LabelPictures();
    }//GEN-LAST:event_Label22MouseClicked

    private void Label23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label23MouseClicked
        Rules.KnightMove(3, 4);
        LabelPictures();
    }//GEN-LAST:event_Label23MouseClicked

    private void Label24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label24MouseClicked
        Rules.KnightMove(3, 5);
        LabelPictures();
    }//GEN-LAST:event_Label24MouseClicked

    private void Label25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label25MouseClicked
        Rules.KnightMove(3, 6);
        LabelPictures();
    }//GEN-LAST:event_Label25MouseClicked

    private void Label26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label26MouseClicked
        Rules.KnightMove(3, 7);
        LabelPictures();
    }//GEN-LAST:event_Label26MouseClicked

    private void Label27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label27MouseClicked
        Rules.KnightMove(3, 8);
        LabelPictures();
    }//GEN-LAST:event_Label27MouseClicked

    private void Label28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label28MouseClicked
        Rules.KnightMove(3, 9);
        LabelPictures();
    }//GEN-LAST:event_Label28MouseClicked

    private void Label31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label31MouseClicked
        Rules.KnightMove(4, 2);
        LabelPictures();
    }//GEN-LAST:event_Label31MouseClicked

    private void Label32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label32MouseClicked
        Rules.KnightMove(4, 3);
        LabelPictures();
    }//GEN-LAST:event_Label32MouseClicked

    private void Label33MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label33MouseClicked
        Rules.KnightMove(4, 4);
        LabelPictures();
    }//GEN-LAST:event_Label33MouseClicked

    private void Label34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label34MouseClicked
        Rules.KnightMove(4, 5);
        LabelPictures();
    }//GEN-LAST:event_Label34MouseClicked

    private void Label35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label35MouseClicked
        Rules.KnightMove(4, 6);
        LabelPictures();
    }//GEN-LAST:event_Label35MouseClicked

    private void Label36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label36MouseClicked
        Rules.KnightMove(4, 7);
        LabelPictures();
    }//GEN-LAST:event_Label36MouseClicked

    private void Label37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label37MouseClicked
        Rules.KnightMove(4, 8);
        LabelPictures();
    }//GEN-LAST:event_Label37MouseClicked

    private void Label38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label38MouseClicked
        Rules.KnightMove(4, 9);
        LabelPictures();
    }//GEN-LAST:event_Label38MouseClicked

    private void Label41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label41MouseClicked
        Rules.KnightMove(5, 2);
        LabelPictures();
    }//GEN-LAST:event_Label41MouseClicked

    private void Label42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label42MouseClicked
        Rules.KnightMove(5, 3);
        LabelPictures();
    }//GEN-LAST:event_Label42MouseClicked

    private void Label43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label43MouseClicked
        Rules.KnightMove(5, 4);
        LabelPictures();
    }//GEN-LAST:event_Label43MouseClicked

    private void Label44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label44MouseClicked
        Rules.KnightMove(5, 5);
        LabelPictures();
    }//GEN-LAST:event_Label44MouseClicked

    private void Label45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label45MouseClicked
        Rules.KnightMove(5, 6);
        LabelPictures();
    }//GEN-LAST:event_Label45MouseClicked

    private void Label46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label46MouseClicked
        Rules.KnightMove(5, 7);
        LabelPictures();
    }//GEN-LAST:event_Label46MouseClicked

    private void Label47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label47MouseClicked
        Rules.KnightMove(5, 8);
        LabelPictures();
    }//GEN-LAST:event_Label47MouseClicked

    private void Label48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label48MouseClicked
        Rules.KnightMove(5, 9);
        LabelPictures();
    }//GEN-LAST:event_Label48MouseClicked

    private void Label51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label51MouseClicked
        Rules.KnightMove(6, 2);
        LabelPictures();
    }//GEN-LAST:event_Label51MouseClicked

    private void Label52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label52MouseClicked
        Rules.KnightMove(6, 3);
        LabelPictures();
    }//GEN-LAST:event_Label52MouseClicked

    private void Label53MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label53MouseClicked
        Rules.KnightMove(6, 4);
        LabelPictures();
    }//GEN-LAST:event_Label53MouseClicked

    private void Label54MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label54MouseClicked
        Rules.KnightMove(6, 5);
        LabelPictures();
    }//GEN-LAST:event_Label54MouseClicked

    private void Label55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label55MouseClicked
        Rules.KnightMove(6, 6);
        LabelPictures();
    }//GEN-LAST:event_Label55MouseClicked

    private void Label56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label56MouseClicked
        Rules.KnightMove(6, 7);
        LabelPictures();
    }//GEN-LAST:event_Label56MouseClicked

    private void Label57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label57MouseClicked
        Rules.KnightMove(6, 8);
        LabelPictures();
    }//GEN-LAST:event_Label57MouseClicked

    private void Label58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label58MouseClicked
        Rules.KnightMove(6, 9);
        LabelPictures();
    }//GEN-LAST:event_Label58MouseClicked

    private void Label61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label61MouseClicked
        Rules.KnightMove(7, 2);
        LabelPictures();
    }//GEN-LAST:event_Label61MouseClicked

    private void Label62MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label62MouseClicked
        Rules.KnightMove(7, 3);
        LabelPictures();
    }//GEN-LAST:event_Label62MouseClicked

    private void Label63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label63MouseClicked
        Rules.KnightMove(7, 4);
        LabelPictures();
    }//GEN-LAST:event_Label63MouseClicked

    private void Label64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label64MouseClicked
        Rules.KnightMove(7, 5);
        LabelPictures();
    }//GEN-LAST:event_Label64MouseClicked

    private void Label65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label65MouseClicked
        Rules.KnightMove(7, 6);
        LabelPictures();
    }//GEN-LAST:event_Label65MouseClicked

    private void Label66MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label66MouseClicked
        Rules.KnightMove(7, 7);
        LabelPictures();
    }//GEN-LAST:event_Label66MouseClicked

    private void Label67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label67MouseClicked
        Rules.KnightMove(7, 8);
        LabelPictures();
    }//GEN-LAST:event_Label67MouseClicked

    private void Label68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label68MouseClicked
        Rules.KnightMove(7, 9);
        LabelPictures();
    }//GEN-LAST:event_Label68MouseClicked

    private void Label71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label71MouseClicked
        Rules.KnightMove(8, 2);
        LabelPictures();
    }//GEN-LAST:event_Label71MouseClicked

    private void Label72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label72MouseClicked
        Rules.KnightMove(8, 3);
        LabelPictures();
    }//GEN-LAST:event_Label72MouseClicked

    private void Label73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label73MouseClicked
        Rules.KnightMove(8, 4);
        LabelPictures();
    }//GEN-LAST:event_Label73MouseClicked

    private void Label74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label74MouseClicked
        Rules.KnightMove(8, 5);
        LabelPictures();
    }//GEN-LAST:event_Label74MouseClicked

    private void Label75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label75MouseClicked
        Rules.KnightMove(8, 6);
        LabelPictures();
    }//GEN-LAST:event_Label75MouseClicked

    private void Label76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label76MouseClicked
        Rules.KnightMove(8, 7);
        LabelPictures();
    }//GEN-LAST:event_Label76MouseClicked

    private void Label77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label77MouseClicked
        Rules.KnightMove(8, 8);
        LabelPictures();
    }//GEN-LAST:event_Label77MouseClicked

    private void Label78MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label78MouseClicked
        Rules.KnightMove(8, 9);
        LabelPictures();
    }//GEN-LAST:event_Label78MouseClicked

    private void Label81MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label81MouseClicked
        Rules.KnightMove(9, 2);
        LabelPictures();
    }//GEN-LAST:event_Label81MouseClicked

    private void Label82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label82MouseClicked
        Rules.KnightMove(9, 3);
        LabelPictures();
    }//GEN-LAST:event_Label82MouseClicked

    private void Label83MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label83MouseClicked
        Rules.KnightMove(9, 4);
        LabelPictures();
    }//GEN-LAST:event_Label83MouseClicked

    private void Label84MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label84MouseClicked
        Rules.KnightMove(9, 5);
        LabelPictures();
    }//GEN-LAST:event_Label84MouseClicked

    private void Label85MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label85MouseClicked
        Rules.KnightMove(9, 6);
        LabelPictures();
    }//GEN-LAST:event_Label85MouseClicked

    private void Label86MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label86MouseClicked
        Rules.KnightMove(9, 7);
        LabelPictures();
    }//GEN-LAST:event_Label86MouseClicked

    private void Label87MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label87MouseClicked
        Rules.KnightMove(9, 8);
        LabelPictures();
    }//GEN-LAST:event_Label87MouseClicked

    private void Label88MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label88MouseClicked
        Rules.KnightMove(9, 9);
        LabelPictures();
    }//GEN-LAST:event_Label88MouseClicked

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KnightsOfHazard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KnightsOfHazard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KnightsOfHazard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KnightsOfHazard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KnightsOfHazard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label11;
    private javax.swing.JLabel Label12;
    private javax.swing.JLabel Label13;
    private javax.swing.JLabel Label14;
    private javax.swing.JLabel Label15;
    private javax.swing.JLabel Label16;
    private javax.swing.JLabel Label17;
    private javax.swing.JLabel Label18;
    private javax.swing.JLabel Label21;
    private javax.swing.JLabel Label22;
    private javax.swing.JLabel Label23;
    private javax.swing.JLabel Label24;
    private javax.swing.JLabel Label25;
    private javax.swing.JLabel Label26;
    private javax.swing.JLabel Label27;
    private javax.swing.JLabel Label28;
    private javax.swing.JLabel Label31;
    private javax.swing.JLabel Label32;
    private javax.swing.JLabel Label33;
    private javax.swing.JLabel Label34;
    private javax.swing.JLabel Label35;
    private javax.swing.JLabel Label36;
    private javax.swing.JLabel Label37;
    private javax.swing.JLabel Label38;
    private javax.swing.JLabel Label41;
    private javax.swing.JLabel Label42;
    private javax.swing.JLabel Label43;
    private javax.swing.JLabel Label44;
    private javax.swing.JLabel Label45;
    private javax.swing.JLabel Label46;
    private javax.swing.JLabel Label47;
    private javax.swing.JLabel Label48;
    private javax.swing.JLabel Label51;
    private javax.swing.JLabel Label52;
    private javax.swing.JLabel Label53;
    private javax.swing.JLabel Label54;
    private javax.swing.JLabel Label55;
    private javax.swing.JLabel Label56;
    private javax.swing.JLabel Label57;
    private javax.swing.JLabel Label58;
    private javax.swing.JLabel Label61;
    private javax.swing.JLabel Label62;
    private javax.swing.JLabel Label63;
    private javax.swing.JLabel Label64;
    private javax.swing.JLabel Label65;
    private javax.swing.JLabel Label66;
    private javax.swing.JLabel Label67;
    private javax.swing.JLabel Label68;
    private javax.swing.JLabel Label71;
    private javax.swing.JLabel Label72;
    private javax.swing.JLabel Label73;
    private javax.swing.JLabel Label74;
    private javax.swing.JLabel Label75;
    private javax.swing.JLabel Label76;
    private javax.swing.JLabel Label77;
    private javax.swing.JLabel Label78;
    private javax.swing.JLabel Label81;
    private javax.swing.JLabel Label82;
    private javax.swing.JLabel Label83;
    private javax.swing.JLabel Label84;
    private javax.swing.JLabel Label85;
    private javax.swing.JLabel Label86;
    private javax.swing.JLabel Label87;
    private javax.swing.JLabel Label88;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables
}
