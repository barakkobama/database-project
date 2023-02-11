import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;

public class NoweWypozyczenieFrame extends javax.swing.JFrame {

    static int wypozyczalniaid = -1;
    static float cena;
    public NoweWypozyczenieFrame() throws SQLException {
        initComponents();
    }

 
    private void initComponents() throws SQLException {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Anuluj = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Anuluj.setText("Anuluj");
        Anuluj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnulujActionPerformed(evt);
            }
        });

        jButton2.setText("Dodaj wypożyczenie");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton2ActionPerformed(evt);
                } catch (SQLException e) {
                    ZleDaneFrame zdf = new ZleDaneFrame();
                    zdf.setVisible(true);
                    e.printStackTrace();
                }
            }
        });

        jLabel1.setText("Czas (h)");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    sprzetActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });
        jLabel2.setText("Imie");

        jLabel3.setText("Nazwisko");

        jLabel4.setText("Email");

        jLabel5.setText("Numer telefonu");

        jLabel6.setText("Płeć");

        jLabel7.setText("Sprzęt");;


        jLabel8.setText("Cena");



        ArrayList<String> sprzety = new ArrayList<>();
        String query = String.format("SELECT NAZWA FROM SPRZET s NATURAL JOIN ASORTYMENT a WHERE a.WYPOZYCZALNIAID = %d",Aplikacja.loggedWypozyczalniaid);
        try(Statement stmt = Aplikacja.conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                sprzety.add(rs.getString("nazwa"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(sprzety.toArray()));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    sprzetActionPerformed(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        });


        jLabel9.setText("zł");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "+48", "+43", "+32", "+49", "+45", "+34", "+33", "+44", "+30", "+36", "+39", "+31", "+46", "+47" }));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Mężczyzna");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Kobieta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(30, 30, 30)
                                .addComponent(jRadioButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(115, 115, 115)
                        .addComponent(Anuluj)))
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(Anuluj))
                .addGap(42, 42, 42))
        );

        pack();
    }


    protected void sprzetActionPerformed(ActionEvent evt) throws SQLException {
        String sprzet = (String) jComboBox2.getSelectedItem();
        int sprzetid = 0;

        String query = String.format("select WYPOZYCZALNIAID from WYPOZYCZALNIA where PRACOWNIKID = %s",Aplikacja.loggedUserId);
        try(Statement stmt = Aplikacja.conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            wypozyczalniaid = rs.getInt("WYPOZYCZALNIAID");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        query = String.format("select SPRZETID from SPRZET where NAZWA = %s","'" + sprzet + "'");
        try(Statement stmt = Aplikacja.conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            sprzetid = rs.getInt("sprzetid");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        Integer czas = Integer.parseInt((String) jComboBox1.getSelectedItem()); //CZAS
        cena = obliczKoszt(wypozyczalniaid, sprzetid,czas);
        jLabel9.setText(Float.toString(cena) + " zł");
    }



    protected static float obliczKoszt(int wypozyczalniaid,int sprzetid,int czas) throws SQLException{
        Float cena = Float.parseFloat("0.0");
        String cenaUnprc;
        String query = String.format("select cenaWypozyczenia from CENNIKWYPOZYCZALNI where WYPOZYCZALNIAID = %s and SPRZETID = %s",wypozyczalniaid,sprzetid);
        try(Statement stmt = Aplikacja.conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            cenaUnprc = rs.getString("CENAWYPOZYCZENIA");
            //czas = rs.getInt("CZAS");
            cenaUnprc = cenaUnprc.replace(',','.');
            cena  = Float.parseFloat(cenaUnprc);

        }
        catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
        return cena*czas;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                         
        // TODO add your handling code here:
        String numer = jTextField1.getText(); //NUMER
        String email = jTextField2.getText(); //EMAIL
        String surname = jTextField4.getText(); //NAZWISKO
        String name = jTextField5.getText();
        String plec = null;
        if (jRadioButton1.isSelected()) plec = "M";
        if (jRadioButton2.isSelected()) plec = "K";
        String czas = (String) jComboBox1.getSelectedItem(); //CZAS
        String malpa = "@";
        String kropka = ".";
        
        boolean onlyLettersName = name.matches("[a-zA-Ząęćęłńóśźż]+");
        boolean onlyLettersSurname = surname.matches("[a-zA-Ząęćęłńóśźż]+");
        boolean malpaEmail = email.contains(malpa);
        boolean kropkaEmail = email.contains(kropka);
        boolean onlyNumbersNumer = numer.matches("[0-9]+");
        
            
        if(onlyLettersName  && onlyLettersSurname  && malpaEmail && kropkaEmail 
                && onlyNumbersNumer && numer.length() == 9 && plec != null){
            
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
            surname = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
            
            int daneid = Aplikacja.calcID("DANEID","DANEOSOBOWE");

            String sql = "INSERT INTO DANEOSOBOWE (DANEID,IMIE,NAZWISKO,DATAURODZENIA,PLEC,NUMERTELEFONU,EMAIL) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = Aplikacja.conn.prepareStatement(sql);
            pstmt.setInt(1, daneid);
            pstmt.setString(2, name);
            pstmt.setString(3, surname);
            pstmt.setString(4,null);
            pstmt.setString(5, plec);
            pstmt.setInt(6, Integer.parseInt(numer));
            pstmt.setString(7, email);
            pstmt.executeQuery();

            sql = "INSERT INTO WYPOZYCZENIA (WYPOZYCZENIEID,WYPOZYCZALNIAID,DANEID,CZAS,KOSZT,DATA) VALUES (?,?,?,?,?,?)";
            pstmt = Aplikacja.conn.prepareStatement(sql);

            pstmt.setInt(1, Aplikacja.calcID("WYPOZYCZENIEID","WYPOZYCZENIA"));
            pstmt.setInt(2,wypozyczalniaid);
            pstmt.setInt(3,daneid);
            pstmt.setInt(4,Integer.parseInt(czas));
            pstmt.setFloat(5,cena);
            pstmt.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));


            pstmt.executeQuery();
            pstmt.close();

            dispose();
            CentralFrame cen = new CentralFrame();
            cen.setVisible(true);
            
        }else{
            ZleDaneFrame zle = new ZleDaneFrame();
                zle.setVisible(true);        }
        
        
    }


    private void AnulujActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        dispose();
        CentralFrame cen = new CentralFrame();
        cen.setVisible(true);
    }

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Anuluj;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
}
