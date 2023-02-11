import java.sql.*;
import java.util.ArrayList;


public class HistoriaWypozyczenFrame extends javax.swing.JFrame {
    public HistoriaWypozyczenFrame() {
        initComponents();
    }

    public static int getRowCount(ResultSet set) {
        int rowCount;
        try {
            set.last();
            rowCount = set.getRow();
            set.beforeFirst();
        } catch (SQLException e) {
            return 0;
        }
        return rowCount;
    }
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Wyjdz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        String query = "SELECT * FROM wypozyczenia_view";
        ArrayList<Object[]> rows = new ArrayList<>();
        try(Statement stmt = Aplikacja.conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Object[] row = new Object[8];
                row[0] = rs.getInt("ID");
                row[1] = rs.getString("WYPOZYCZALNIA");
                row[2] = rs.getString("IMIE");
                row[3] = rs.getString("NAZWISKO");
                row[4] = rs.getString("NR TELEFONU");
                row[5] = rs.getString("CZAS");
                row[6] = rs.getDouble("KOSZT");
                row[7] = rs.getDate("DATA");
                rows.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[][] arrRow= rows.toArray(new Object[][] {});
        Object[] names = {"Wypożyczenie Id","Nazwa wypożyczalni","Imie","Nazwisko","Numer telefonu","Czas","Koszt","Data"};
        jTable1.setModel(new javax.swing.table.DefaultTableModel(arrRow,names) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        Wyjdz.setText("Wyjdź");
        Wyjdz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WyjdzActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Wyjdz)
                .addGap(341, 341, 341))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(Wyjdz)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WyjdzActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
        CentralFrame cen = new CentralFrame();
        cen.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Wyjdz;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
