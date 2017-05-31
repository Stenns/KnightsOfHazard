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
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Stenns
 */
public class ScoreTable extends javax.swing.JFrame {

    public ScoreTable() {
        initComponents();

    }
    private static final Logger log = LoggerFactory.getLogger(ScoreTable.class);

    /**
     * Creates a Database to hold high scores.
     */
    public void scoreTable() {

        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g", "ENG_C4EB95", "stumm");
            Statement st = conn.createStatement();
            log.info("Connection to database: successful");
            try {
                st.executeUpdate("CREATE TABLE winners( "
                        + "Name varchar2(255) NOT NULL, "
                        + "Wins NUMBER(10))");

            } catch (SQLException ex) {
                if (ex.getErrorCode() == 955) {
                    log.debug("Table already exists!" + ex);
                }
            }

            ResultSet set = st.executeQuery("SELECT * FROM winners ORDER BY wins DESC");
            int i = 0;
            while (set.next()) {
                String tempName = set.getString(1);
                sTable.getModel().setValueAt(tempName, i, 0);
                System.out.println(tempName);
                int tempScore = set.getInt(2);
                sTable.getModel().setValueAt(tempScore, i, 1);
                System.out.println(tempScore);
                if (i < 4) {
                    i++;
                }
            }
            set.close();
            System.out.println("recieved");

        } catch (SQLException ex) {
            log.debug("Connection could not been established!" + ex);
        }
    }

    /**
     *  Method checks if the game winner  {@link Rules#winnerName name} is already in the table. 
     * If does, stores its victories in {@code tempWins} and updates the table for a given 
     * {@link Rules#winnerName winner} using {@code tempWins + 1} as number of victories. 
     * If not, sets {@code tempWins = 1} and creates a new row with {@link Rules#winnerName name} and 
     * {@code tempWins} as number of victories.
     */
    public void storeTable() {

        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g", "ENG_C4EB95", "stumm");
            Statement st = conn.createStatement();
            try {
                st.executeUpdate("CREATE TABLE winners "
                        + "(Name varchar2(255) NOT NULL, "
                        + "Wins NUMBER(10))");

            } catch (SQLException ex) {
                if (ex.getErrorCode() == 955) {
                    log.debug("Table already exists!" + ex);
                }
            }

            int tempWins = 0;
            st.executeQuery("INSERT INTO winners "
                    + "SELECT '" + Rules.winnerName.toUpperCase() + "', 0 "
                    + "FROM dual "
                    + "WHERE NOT EXISTS "
                    + "(SELECT * "
                    + "FROM winners "
                    + "WHERE name = '" + Rules.winnerName.toUpperCase() + "')");

            ResultSet set = st.executeQuery("SELECT wins FROM winners WHERE name = '" + Rules.winnerName.toUpperCase() + "'");
            while (set.next()) {
                tempWins = set.getInt(1) + 1;
            }
            st.executeQuery("UPDATE winners SET wins = " + tempWins + " WHERE name='" + Rules.winnerName.toUpperCase() + "'");

            log.info("stored");

        } catch (SQLException ex) {
            log.debug("Driver can't be registered!" + ex);
        }

    }

    public void resetTable() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@db.inf.unideb.hu:1521:ora11g", "ENG_C4EB95", "stumm");
            Statement st = conn.createStatement();
            log.info("Connection to Database successful!");
            try {
                st.executeUpdate("DROP TABLE winners");
            } catch (SQLException ex) {
                log.debug("There is no table to drop!" + ex);
            }
        } catch (SQLException ex) {
            log.debug("Table already exists!" + ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sTable = new javax.swing.JTable();
        drop = new javax.swing.JButton();

        sTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Player", "Wins"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(sTable);
        if (sTable.getColumnModel().getColumnCount() > 0) {
            sTable.getColumnModel().getColumn(0).setResizable(false);
            sTable.getColumnModel().getColumn(1).setResizable(false);
        }

        drop.setText("Drop scoreboard");
        drop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(drop)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(drop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropActionPerformed
        resetTable();
    }//GEN-LAST:event_dropActionPerformed

    /**
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
            java.util.logging.Logger.getLogger(ScoreTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoreTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoreTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoreTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton drop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable sTable;
    // End of variables declaration//GEN-END:variables
}
