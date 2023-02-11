import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;



public class EdycjaAsortymentuFrame extends javax.swing.JFrame {

    int asortymentId;

    public EdycjaAsortymentuFrame(int asortymentId) throws SQLException {
        this.asortymentId = asortymentId;
        initComponents();
    }

              
    private void initComponents() throws SQLException {

        Anuluj = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tfCena2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfCena = new javax.swing.JTextField();
        cbStanFizyczny = new javax.swing.JComboBox<>();
        tfCena1 = new javax.swing.JTextField();
        cbNazwaWyp = new javax.swing.JComboBox<>();
        tfCena3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Anuluj.setText("Anuluj");

        Anuluj.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                    anulujActionPerformed(evt);
            }
        });


        

        jButton3.setText("Edytuj asortyment");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton3ActionPerformed(evt);
                } catch (SQLException e) {
                    ZleDaneFrame zdf = new ZleDaneFrame();
                    zdf.setVisible(true);
                    e.printStackTrace();
                }
            }
        });

        jLabel3.setText("Nazwa wypożyczalni");

        jLabel5.setText("Cena wypożyczenia");

        jLabel1.setText("Stan fizyczny");

        jLabel11.setText("Cena usterki 1");

        jLabel12.setText("Cena usterki 2");

        jLabel13.setText("Cena usterki 3");

        ArrayList<String> wypozyczalnie = new ArrayList<>();
        String sql = "SELECT NAZWA FROM WYPOZYCZALNIA";
        PreparedStatement pstmt = Aplikacja.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            wypozyczalnie.add(rs.getString("NAZWA"));
        }
        pstmt.close();


        cbStanFizyczny.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sprawny", "Uszkodzony", "Zniszczony"}));

        cbNazwaWyp.setModel(new javax.swing.DefaultComboBoxModel(wypozyczalnie.toArray()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Anuluj))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel1))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfCena1)
                            .addComponent(cbNazwaWyp, 0, 118, Short.MAX_VALUE)
                            .addComponent(tfCena)
                            .addComponent(cbStanFizyczny, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfCena2)
                            .addComponent(tfCena3))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbNazwaWyp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbStanFizyczny, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfCena1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfCena2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfCena3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(Anuluj))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>         
    
    protected void anulujActionPerformed(ActionEvent evt) {
        dispose();
        AsortymentFrame cf = new AsortymentFrame();
        cf.setVisible(true);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {      
                                  
        String nazwaW = (String) cbNazwaWyp.getSelectedItem(); //NUMER
        String cena = (String) tfCena.getText(); //NAZWISKO
        String stanF = (String) cbStanFizyczny.getSelectedItem();
        String cena1 = tfCena1.getText();
        String cena2 = tfCena2.getText();
        String cena3 = tfCena3.getText();
        

        
        boolean onlyNumbersCena = isNumeric(cena);
        boolean onlyNumbersCena1 = isNumeric(cena1);
        boolean onlyNumbersCena2 = isNumeric(cena2);
        boolean onlyNumbersCena3 = isNumeric(cena3);
        
            
        if(onlyNumbersCena == true && onlyNumbersCena1 == true && onlyNumbersCena2 == true
                && onlyNumbersCena3 == true){
            

            String sql = "SELECT WYPOZYCZALNIAID FROM WYPOZYCZALNIA WHERE NAZWA = ?";
            PreparedStatement pstmt = Aplikacja.conn.prepareStatement(sql);
            pstmt.setString(1,nazwaW);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int newWypozyczalniaId = rs.getInt("wypozyczalniaid");
            pstmt.close();
            
            sql = "SELECT SPRZETID FROM ASORTYMENT WHERE ASORTYMENTID = ?";
            pstmt = Aplikacja.conn.prepareStatement(sql);
            pstmt.setInt(1, this.asortymentId);
            rs = pstmt.executeQuery();
            rs.next();
            int newSprzetId = rs.getInt("sprzetid");
            pstmt.close();
            
            //Przygotowuje zapytanie aktualizujące tabele asortyment
            sql = String.format("UPDATE ASORTYMENT SET Wypozyczalniaid = ?,STANFIZYCZNY = ? WHERE ASORTYMENTID = ?");
            pstmt = Aplikacja.conn.prepareStatement(sql);
            pstmt.setInt(1,newWypozyczalniaId);
            pstmt.setString(2,stanF);
            pstmt.setInt(3,this.asortymentId);
            pstmt.executeUpdate();
           
            
            //Przygotowuje zapytanie aktualizujące tabele cennikwypozyczalni
            sql = String.format("UPDATE CENNIKWYPOZYCZALNI SET CENAWYPOZYCZENIA = ?,CENAUSTERKI1 = ?,CENAUSTERKI2 = ?, CENAUSTERKI3 = ? WHERE SPRZETID = ? AND WYPOZYCZALNIAID = ?");
            pstmt = Aplikacja.conn.prepareStatement(sql);
            pstmt.setFloat(1,Float.parseFloat(cena));
             pstmt.setFloat(2,Float.parseFloat(cena1));
            pstmt.setFloat(3,Float.parseFloat(cena2));
            pstmt.setFloat(4,Float.parseFloat(cena3));
             pstmt.setInt(5,newSprzetId);
             pstmt.setInt(6,newWypozyczalniaId);
            pstmt.executeUpdate();

            dispose();
            //Otwarcie głównej ramki
            AsortymentFrame cen = new AsortymentFrame();
            cen.setVisible(true);
        }else{
            ZleDaneAsortymentuFrame zle = new ZleDaneAsortymentuFrame();
            zle.setVisible(true);
        }
    }                                        

    // Variables declaration - do not modify                     
    private javax.swing.JButton Anuluj;
    private javax.swing.JComboBox<String> cbNazwaWyp;
    private javax.swing.JComboBox<String> cbStanFizyczny;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfCena;
    private javax.swing.JTextField tfCena1;
    private javax.swing.JTextField tfCena2;
    private javax.swing.JTextField tfCena3;
    // End of variables declaration                   
}
