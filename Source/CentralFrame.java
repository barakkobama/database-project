import java.sql.SQLException;

public class CentralFrame extends javax.swing.JFrame {

    /**
     * Creates new form CentralFrame
     */
    public CentralFrame() {
        initComponents();
    }

    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nowWypozyczenie = new javax.swing.JButton();
        wysBilans = new javax.swing.JButton();
        edyKonta = new javax.swing.JButton();
        modAsortyment = new javax.swing.JButton();
        hisWypozyczen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 36)); // NOI18N
        jLabel1.setText("Menu");

        nowWypozyczenie.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        nowWypozyczenie.setText("Nowe wypożyczenie");
        nowWypozyczenie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    nowWypozyczenieActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        wysBilans.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        wysBilans.setText("Wyświetl bilans");
        wysBilans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wysBilansActionPerformed(evt);
            }
        });

        edyKonta.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        edyKonta.setText("Edycja konta");
        edyKonta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    edyKontaActionPerformed(evt);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        modAsortyment.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        modAsortyment.setText("Modyfikuj asortyment");
        modAsortyment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modAsortymentActionPerformed(evt);
            }
        });

        hisWypozyczen.setFont(new java.awt.Font(".AppleSystemUIFont", 0, 18)); // NOI18N
        hisWypozyczen.setText("Historia wypożyczeń");
        hisWypozyczen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hisWypozyczenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hisWypozyczen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nowWypozyczenie, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edyKonta, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wysBilans, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(modAsortyment))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nowWypozyczenie)
                    .addComponent(wysBilans))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edyKonta)
                    .addComponent(hisWypozyczen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(modAsortyment)
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wysBilansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wysBilansActionPerformed
        // TODO add your handling code here:
        dispose();
        BalansFrame bal = new BalansFrame();
        bal.setVisible(true);
    }//GEN-LAST:event_wysBilansActionPerformed

    private void nowWypozyczenieActionPerformed(java.awt.event.ActionEvent evt) throws SQLException{
        // TODO add your handling code here:
        dispose();
        NoweWypozyczenieFrame now = new NoweWypozyczenieFrame();
        now.setVisible(true);
    }//GEN-LAST:event_nowWypozyczenieActionPerformed

    private void edyKontaActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        // TODO add your handling code here:
        dispose();
        EdycjaKontaFrame edy = new EdycjaKontaFrame();
        edy.setVisible(true);
    }//GEN-LAST:event_edyKontaActionPerformed

    private void modAsortymentActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
        AsortymentFrame aso = new AsortymentFrame();
        aso.setVisible(true);
    }//GEN-LAST:event_modAsortymentActionPerformed

    private void hisWypozyczenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hisWypozyczenActionPerformed
        // TODO add your handling code here:
        dispose();
        HistoriaWypozyczenFrame his = new HistoriaWypozyczenFrame();
        his.setVisible(true);
    }//GEN-LAST:event_hisWypozyczenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton edyKonta;
    private javax.swing.JButton hisWypozyczen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton modAsortyment;
    private javax.swing.JButton nowWypozyczenie;
    private javax.swing.JButton wysBilans;
    // End of variables declaration//GEN-END:variables
}
