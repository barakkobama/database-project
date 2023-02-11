import java.sql.*;
import java.util.ArrayList;


public class AsortymentFrame extends javax.swing.JFrame {

    ArrayList<Object[]> rows;


    public void drawTable(){
        Object[][] arrRow= rows.toArray(new Object[][] {});
        Object[] names = {"Asortyment Id","Nazwa Wypozyczalni","Nazwa sprzętu" ,"Cena wypożyczenia (1H)", "Stan fizyczny", "Cena usterki 1", "Cena usterki 2", "Cena usterki 3"};
        Table.setModel(new javax.swing.table.DefaultTableModel(arrRow,names) {
            Class[] types = new Class [] {
                java.lang.Integer.class,java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
    }

    public AsortymentFrame() {
        initComponents();
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Dodaj = new javax.swing.JButton();
        Usun = new javax.swing.JButton();
        Edytuj = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Wejdz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Modyfikacja asortymentu");

        Dodaj.setText("Zamów sprzęt");
        Dodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DodajActionPerformed(evt);
            }
        });

        Usun.setText("Usuń");
        Usun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    UsunActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        Edytuj.setText("Edytuj");
        Edytuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    EdytujActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });


        String query = "SELECT * FROM ASORTYMENT_view";
        rows = new ArrayList<>();
        try(Statement stmt = Aplikacja.conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Object[] row = new Object[8];
                row[0] = rs.getInt("ID");
                row[1] = rs.getString("Nazwa WYPOZYCZALNI");
                row[2] = rs.getString("SPRZET");
                row[3] = rs.getString("CENA WYPOZYCZENIA");
                row[4] = rs.getString("STAN FIZYCZNY");
                row[5] = rs.getString("CENA USTERKI 1");
                row[6] = rs.getString("CENA USTERKI 2");
                row[7] = rs.getDouble("CENA USTERKI 3");
                rows.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        drawTable();

        Table.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                TableComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        Wejdz.setText("Wyjdź");
        Wejdz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WejdzActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Dodaj)
                        .addGap(156, 156, 156)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Wejdz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Usun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Edytuj)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Edytuj)
                    .addComponent(Dodaj)
                    .addComponent(Usun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(Wejdz)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsunActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        int row = Table.getSelectedRow();
        int asortymentId = (int) Table.getValueAt(row, 0);
        String sql = "DELETE FROM ASORTYMENT WHERE asortymentid = ?";
        PreparedStatement pstmt = Aplikacja.conn.prepareStatement(sql);
        pstmt.setInt(1,asortymentId);
        System.out.println(pstmt.executeUpdate());
       // pstmt.close();
        rows.remove(row);
        drawTable();
    }

    private void EdytujActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        dispose();
        int id = (int) Table.getValueAt(Table.getSelectedRow(),0);
        EdycjaAsortymentuFrame edit = new EdycjaAsortymentuFrame(id);
        edit.setVisible(true);
    }

    private void DodajActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
        DodajAsortymentFrame aso = new DodajAsortymentFrame();
        aso.setVisible(true);
    }

    private void TableComponentAdded(java.awt.event.ContainerEvent evt) {
        
    }

    private void WejdzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WejdzActionPerformed
        // TODO add your handling code here:
        dispose();
        CentralFrame cen = new CentralFrame();
        cen.setVisible(true);
    }//GEN-LAST:event_WejdzActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dodaj;
    private javax.swing.JButton Edytuj;
    private javax.swing.JTable Table;
    private javax.swing.JButton Usun;
    private javax.swing.JButton Wejdz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;

}
