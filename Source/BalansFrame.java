
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;


public class BalansFrame extends javax.swing.JFrame {

    /**
     * Creates new form BalansFrame
     */
    public BalansFrame() {
        initComponents();
    }

                     
    private void initComponents() {

        Wyjdz = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        kosMiesieczny = new javax.swing.JLabel();
        przMiesieczny = new javax.swing.JLabel();
        bilMieiseczny = new javax.swing.JLabel();
        kosKwartalny = new javax.swing.JLabel();
        przKwartalny = new javax.swing.JLabel();
        bilKwartalny = new javax.swing.JLabel();
        kosRoczny = new javax.swing.JLabel();
        przRoczny = new javax.swing.JLabel();
        bilRoczny = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Wyjdz.setText("Wyjdź");
        Wyjdz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WyjdzActionPerformed(evt);
            }
        });

        jLabel4.setText("Bilans miesięczny");

        jLabel5.setText("Bilans kwartalny");

        jLabel6.setText("Bilans roczny");

        jLabel7.setText("Koszty");

        jLabel8.setText("Przychody");

        jLabel9.setText("Bilans");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Wyjdz)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addComponent(kosMiesieczny, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(kosKwartalny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kosRoczny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(przMiesieczny, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(przKwartalny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(przRoczny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9)
                    .addComponent(bilRoczny, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(bilKwartalny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bilMieiseczny, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kosMiesieczny, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(przMiesieczny, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bilMieiseczny, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(kosKwartalny, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(przKwartalny, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bilKwartalny, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kosRoczny, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(przRoczny, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bilRoczny, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(Wyjdz)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>                        

    private void WyjdzActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        dispose();
        CentralFrame cen = new CentralFrame();
        cen.setVisible(true);
    }                                     

    private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     
        // TODO add your handling code here:
        Calendar calender = Calendar.getInstance();
        int miesiac = calender.get(Calendar.MONTH)+1;
        int rok = calender.get(Calendar.YEAR);
        int kwartal = (miesiac/ 3) + 1;
        double sum = 0;
        
        String query = "SELECT SUM(KOSZT) AS KOSZT FROM wypozyczenia WHERE EXTRACT(MONTH FROM DATA) = ? AND EXTRACT(YEAR FROM DATA) = ?";
        try(PreparedStatement stmt = Aplikacja.conn.prepareStatement(query)){
            stmt.setInt(1,miesiac);
            stmt.setInt(2,rok);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            sum += rs.getFloat("KOSZT");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            sum+=0;
        }
        
        przMiesieczny.setText(String.valueOf(sum));
        
        double sum1 = 0;
        query ="SELECT SUM(KOSZT) AS KOSZT FROM wypozyczenia WHERE to_char(sysdate, 'Q') = ? AND EXTRACT(YEAR FROM DATA) = ?";
        try(PreparedStatement stmt = Aplikacja.conn.prepareStatement(query)){
            stmt.setInt(1,kwartal);
            stmt.setInt(2,rok);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            sum1 += rs.getDouble("KOSZT");
            stmt.close();
        } catch (SQLException e) {
            sum1+=0;
        }
        
        przKwartalny.setText(String.valueOf(sum1));
        
        double sum2 = 0;
        query = "SELECT SUM(KOSZT) AS KOSZT FROM wypozyczenia WHERE EXTRACT(YEAR FROM DATA) = ?";
        try(PreparedStatement stmt = Aplikacja.conn.prepareStatement(query)){
            stmt.setInt(1,rok);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            sum2 += rs.getDouble("KOSZT");
            stmt.close();
        } catch (SQLException e) {
            sum2+=0;
        }
        
        przRoczny.setText(String.valueOf(sum2));
        
        
        
        double sumK = 0;
        
        query = "SELECT SUM(CENA) AS CENA FROM ZAMOWIENIA WHERE EXTRACT(MONTH FROM DATA) = ? AND EXTRACT(YEAR FROM DATA) = ?";
        try(PreparedStatement stmt = Aplikacja.conn.prepareStatement(query)){
            stmt.setInt(1,miesiac);
            stmt.setInt(2,rok);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            sumK = rs.getDouble("CENA");
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            sumK+=0;
        }
        
        kosMiesieczny.setText(String.valueOf(sumK));
        
        double sumK1 =0 ;
        query = "SELECT SUM(CENA) AS CENA FROM ZAMOWIENIA WHERE to_char(sysdate, 'Q') = ? AND EXTRACT(YEAR FROM DATA) = ?";
        try(PreparedStatement stmt = Aplikacja.conn.prepareStatement(query)){
            stmt.setInt(1,kwartal);
            stmt.setInt(2,rok);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            sumK1 += rs.getDouble("Cena");
            stmt.close();
        } catch (SQLException e) {
            sumK1+=0;
        }
        
        kosKwartalny.setText(String.valueOf(sumK1));
        
        double sumK2 =0 ;
        query = "SELECT SUM(CENA) AS CENA FROM ZAMOWIENIA WHERE EXTRACT(YEAR FROM DATA) = ?";
        try(PreparedStatement stmt = Aplikacja.conn.prepareStatement(query)){
            stmt.setInt(1,rok);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            sumK2 += rs.getDouble("Cena");
            stmt.close();
        } catch (SQLException e) {
            sumK2+=0;
        }
        
        kosRoczny.setText(String.valueOf(sumK2));
        
        double bil = sum - sumK;
        double bil1 = sum1 - sumK1;
        double bil2 = sum2 - sumK2;
        
        bilMieiseczny.setText(String.valueOf(bil));
        bilKwartalny.setText(String.valueOf(bil1));
        bilRoczny.setText(String.valueOf(bil2));
    }                                    


    // Variables declaration - do not modify                     
    private javax.swing.JButton Wyjdz;
    private javax.swing.JLabel bilKwartalny;
    private javax.swing.JLabel bilMieiseczny;
    private javax.swing.JLabel bilRoczny;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel kosKwartalny;
    private javax.swing.JLabel kosMiesieczny;
    private javax.swing.JLabel kosRoczny;
    private javax.swing.JLabel przKwartalny;
    private javax.swing.JLabel przMiesieczny;
    private javax.swing.JLabel przRoczny;
    // End of variables declaration                   
}
