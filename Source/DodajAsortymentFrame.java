import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
public class DodajAsortymentFrame extends javax.swing.JFrame {
    

    String chosenProducent;
    String chosenSprzet;
    int ilosc;
    float koszt;
    int chosenSprzetId = 0;
    int chosenProducentId = 0;
    /**
     * Creates new form DodajAsortymentFrame
     */
    public DodajAsortymentFrame() {
        initComponents();
    }
    private float getCena(){
        String query =String.format("SELECT %s FROM cennik_producenta_view where %s =  ? and %s = ?",'"'+"Cena minimalna"+'"','"'+"Producent"+'"','"'+"Sprzęt"+'"');
        try(PreparedStatement stmt = Aplikacja.conn.prepareStatement(query)){
            stmt.setString(1,chosenProducent);
            stmt.setString(2,chosenSprzet);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getFloat("Cena minimalna");
        }
        catch (SQLException e){
            e.printStackTrace();
            return 0;
        }

    }
                       
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Dodaj = new javax.swing.JButton();
        cbProducent = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbSprzet = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbIlosc = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        tfWypozyczalniaId = new javax.swing.JLabel();
        tfCena = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Wypożyczalnia");

        jLabel2.setText("Sprzęt");

        jLabel4.setText("Cena");


        Dodaj.setText("Dodaj");
        Dodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    DodajActionPerformed(evt);
                } catch (SQLException e) {
                    ZleDaneFrame zdf = new ZleDaneFrame();
                    zdf.setVisible(true);
                    e.printStackTrace();
                }
            }
        });
        ArrayList<String> produceni = new ArrayList<>();
        String query = "select nazwa from producent";
        try(Statement stmt = Aplikacja.conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                produceni.add(rs.getString("nazwa"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        jLabel6.setText("Producent");

        cbProducent.setModel(new javax.swing.DefaultComboBoxModel(produceni.toArray()));

        chosenProducent = (String) cbProducent.getSelectedItem();

        ArrayList<String> sprzety = new ArrayList<>();
        query = String.format("SELECT %s FROM cennik_producenta_view where %s =  ?",'"' + "Sprzęt" + '"','"' + "Producent"+'"');
        try(PreparedStatement stmt = Aplikacja.conn.prepareStatement(query)){
            stmt.setString(1,chosenProducent);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                sprzety.add(rs.getString("SPRZĘT"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }


        cbSprzet.setModel(new javax.swing.DefaultComboBoxModel(sprzety.toArray()));

        chosenSprzet = (String) cbSprzet.getSelectedItem();

        jLabel8.setText("Ilość");

        cbIlosc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        ilosc = Integer.parseInt((String) cbIlosc.getSelectedItem());

        cbProducent.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                cbProducentActionPreformed(evt);
            }
        });

        cbSprzet.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                cbSprzetActionPreformed(evt);
            }
        });

        cbIlosc.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                cbIloscActionPreformed(evt);
            }
        });

        jButton1.setText("Anuluj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tfWypozyczalniaId.setText(Aplikacja.loggedNazwaWypozyczalni);

        tfCena.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(Dodaj)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(140, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfCena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbProducent, javax.swing.GroupLayout.Alignment.LEADING, 0, 112, Short.MAX_VALUE)
                            .addComponent(cbSprzet, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbIlosc, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfWypozyczalniaId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfWypozyczalniaId))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProducent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(cbSprzet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbIlosc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfCena))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dodaj)
                    .addComponent(jButton1))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>                        

    protected void cbIloscActionPreformed(ActionEvent evt) {
        ilosc = Integer.parseInt((String) cbIlosc.getSelectedItem());
        koszt = getCena()*ilosc;
        tfCena.setText(Float.toString(koszt));
    }


    protected void cbSprzetActionPreformed(ActionEvent evt) {
        chosenSprzet = (String) cbSprzet.getSelectedItem();
        koszt =getCena()*ilosc;
        tfCena.setText(Float.toString(koszt));
        String query = "SELECT sprzetid FROM sprzet where nazwa = ?";
        try(PreparedStatement stmt = Aplikacja.conn.prepareStatement(query)){
            stmt.setString(1,chosenSprzet);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            chosenSprzetId =Integer.parseInt(rs.getString("sprzetid"));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    protected void cbProducentActionPreformed(ActionEvent evt) {
        chosenProducent = (String) cbProducent.getSelectedItem();
        koszt = getCena()*ilosc;
        tfCena.setText(Float.toString(koszt));
        String query = "SELECT producentid FROM producent where nazwa = ?";
        try(PreparedStatement stmt = Aplikacja.conn.prepareStatement(query)){
            stmt.setString(1,chosenProducent);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            chosenProducentId =Integer.parseInt(rs.getString("producentid"));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    private void DodajActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {                                      
        // TODO add your handling code here:
        dispose();
        AsortymentFrame aso = new AsortymentFrame();
        aso.setVisible(true);

        String sql = "INSERT INTO ASORTYMENT (ASORTYMENTID,WYPOZYCZALNIAID,SPRZETID,STANWYPOZYCZENIA,STANFIZYCZNY) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt;
            for (int i = 0;i<ilosc;i++){
                pstmt = Aplikacja.conn.prepareStatement(sql);
                pstmt.setInt(1, Aplikacja.calcID("ASORTYMENTID","ASORTYMENT"));
                pstmt.setInt(2,Aplikacja.loggedWypozyczalniaid);
                pstmt.setInt(3,chosenSprzetId);
                pstmt.setString(4,"F");
                pstmt.setString(5,"SPRAWNY");

                pstmt.executeQuery();
                pstmt.close();
            }
            
            sql = "INSERT INTO ZAMOWIENIA (ZAMOWIENIAID,PRODUCENTID,SPRZETID,WYPOZYCZALNIAID,ILOSC,CENA,DATA) VALUES (?,?,?,?,?,?,?)";
            pstmt = Aplikacja.conn.prepareStatement(sql);
            
            pstmt.setInt(1, Aplikacja.calcID("ZAMOWIENIAID","ZAMOWIENIA"));
            pstmt.setInt(2,chosenProducentId);
            pstmt.setInt(3,chosenSprzetId);
            pstmt.setInt(4,Aplikacja.loggedWypozyczalniaid);
            pstmt.setInt(5,ilosc);
            pstmt.setFloat(6,koszt);
            pstmt.setDate(7,java.sql.Date.valueOf(java.time.LocalDate.now()));

            pstmt.executeQuery();
            pstmt.close();
    }                                     

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        dispose();
        AsortymentFrame aso = new AsortymentFrame();
        aso.setVisible(true);
    }                                        



    // Variables declaration - do not modify                     
    private javax.swing.JButton Dodaj;
    private javax.swing.JComboBox<String> cbIlosc;
    private javax.swing.JComboBox<String> cbProducent;
    private javax.swing.JComboBox<String> cbSprzet;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel tfCena;
    private javax.swing.JLabel tfWypozyczalniaId;
    // End of variables declaration                   
}
