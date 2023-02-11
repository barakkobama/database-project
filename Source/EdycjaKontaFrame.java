import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;

public class EdycjaKontaFrame extends javax.swing.JFrame {


    public EdycjaKontaFrame() throws SQLException {
        initComponents();
    }

                     
    private void initComponents() throws SQLException {

        btZmienHaslo = new javax.swing.JButton();
        btZmienWypozyczalnie = new javax.swing.JButton();
        Wyjdz = new javax.swing.JButton();
        cbWypozyczalnie = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfAktualneHaslo = new javax.swing.JTextField();
        tfNoweHaslo = new javax.swing.JTextField();
        tfNoweHaslo1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btZmienHaslo.setText("Zmień hasło");

        ArrayList<String> wypozyczalnie = new ArrayList<>();
        String sql = "SELECT nazwa FROM wypozyczalnia";
        PreparedStatement pstmt = Aplikacja.conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery(sql);
        while(rs.next()){
            wypozyczalnie.add(rs.getString("nazwa"));
        }


        btZmienWypozyczalnie.setText("Zmień wypożyczalnie");
        btZmienWypozyczalnie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btZmienWypozyczalnieActionPerformed(evt);
                } catch (SQLException e) {
                    ZleDaneFrame zdf = new ZleDaneFrame();
                    zdf.setVisible(true);
                    e.printStackTrace();
                }
            }
        });

        Wyjdz.setText("Wyjdz");
        Wyjdz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WyjdzActionPerformed(evt);
            }
        });

        cbWypozyczalnie.setModel(new javax.swing.DefaultComboBoxModel(wypozyczalnie.toArray()));

        jLabel1.setText("Zmiana wypożyczalni");

        jLabel2.setText("Zmiana hasła");

        jLabel3.setText("Podaj aktualne hasło");

        jLabel4.setText("Podaj nowe hasło");

        jLabel5.setText("Podaj jeszcze raz nowe hasło");

        btZmienHaslo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btZmienHasloActionPerformed(evt);
                } catch (SQLException e) {
                    ZleDaneFrame zdf = new ZleDaneFrame();
                    zdf.setVisible(true);
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btZmienHaslo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Wyjdz)
                        .addGap(186, 186, 186))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btZmienWypozyczalnie)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                                .addComponent(cbWypozyczalnie, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfAktualneHaslo)
                                    .addComponent(tfNoweHaslo)
                                    .addComponent(tfNoweHaslo1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))))
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfAktualneHaslo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfNoweHaslo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfNoweHaslo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btZmienHaslo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbWypozyczalnie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addComponent(btZmienWypozyczalnie)
                .addGap(48, 48, 48)
                .addComponent(Wyjdz)
                .addGap(20, 20, 20))
        );

        pack();
    }                   

    protected void btZmienHasloActionPerformed(ActionEvent evt) throws SQLException {
        String pass;
        String sql = "SELECT haslo FROM pracownik where pracownikid = ?";
        PreparedStatement pstmt = Aplikacja.conn.prepareStatement(sql);
        pstmt.setInt(1,Aplikacja.loggedUserId);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        pass = rs.getString("haslo");
        if(!pass.equals(tfAktualneHaslo.getText()) || !tfNoweHaslo.getText().equals(tfNoweHaslo1.getText())){
            ZleHasloFrame zhf = new ZleHasloFrame();
            zhf.setVisible(true);
        }
        else{
            sql = "UPDATE PRACOWNIK SET HASLO = ? WHERE PRACOWNIKID = ?";
            pstmt = Aplikacja.conn.prepareStatement(sql);
            pstmt.setString(1,tfNoweHaslo.getText());
            pstmt.setInt(2,Aplikacja.loggedUserId);
            pstmt.executeUpdate();
            dispose();
            CentralFrame cf = new CentralFrame();
            cf.setVisible(true);
        }
    }


    private void WyjdzActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        dispose();
        CentralFrame cen = new CentralFrame();
        cen.setVisible(true);
    }                                     

    private void btZmienWypozyczalnieActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        //Czyta wybraną wypożyczalnie z combobox
        String newWypozyczalnia = (String) cbWypozyczalnie.getSelectedItem();
        //Przygotowuje zapytanie zwracające wypozyczalniaid
        String sql = "SELECT WYPOZYCZALNIAID FROM WYPOZYCZALNIA WHERE NAZWA = ?";
        PreparedStatement pstmt = Aplikacja.conn.prepareStatement(sql);
        //W miejsce ? wstawiany jest parametr z nazwą nowej wypożcyzalni
        pstmt.setString(1,newWypozyczalnia);
        //Wykonuje zapytanie
        ResultSet rs = pstmt.executeQuery();
        //Ustawia na pierwszy otrzymany rząd
        rs.next();
        //Zapisuje id wypożyczalni
        int newWypozyczalniaId = rs.getInt("wypozyczalniaid");
        pstmt.close();

        //Przygotowuje zapytanie aktualizujące tabele pracownik
        sql = String.format("UPDATE PRACOWNIK SET Wypozyczalniaid = ? WHERE PRACOWNIKID = ?");
        pstmt = Aplikacja.conn.prepareStatement(sql);
        pstmt.setInt(1,newWypozyczalniaId);
        pstmt.setInt(2,Aplikacja.loggedUserId);
        pstmt.executeUpdate();
        //Zamknięcie tej ramki
        dispose();
        //Otwarcie głównej ramki
        CentralFrame cen = new CentralFrame();
        cen.setVisible(true);                                        
        
    }                                                    



    // Variables declaration - do not modify                     
    private javax.swing.JButton Wyjdz;
    private javax.swing.JButton btZmienHaslo;
    private javax.swing.JButton btZmienWypozyczalnie;
    private javax.swing.JComboBox<String> cbWypozyczalnie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfAktualneHaslo;
    private javax.swing.JTextField tfNoweHaslo;
    private javax.swing.JTextField tfNoweHaslo1;
    // End of variables declaration                   
}
