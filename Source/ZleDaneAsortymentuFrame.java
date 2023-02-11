
public class ZleDaneAsortymentuFrame extends javax.swing.JFrame {

    /**
     * Creates new form BladEdycjiAsortymentuFrame
     */
    public ZleDaneAsortymentuFrame() {
        initComponents();
    }
                
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ceny muszą przyjmować formę numeryczną w której separatorem jest '.'");

        OK.setText("OK");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(OK)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(OK)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>                        

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {                                   
        // TODO add your handling code here:
        dispose();
    }                                  


    // Variables declaration - do not modify                     
    private javax.swing.JButton OK;
    private javax.swing.JLabel jLabel1;
}
    // End of variables declaration  