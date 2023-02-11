import java.sql.*;



/*TODO
 * bilans
 * okienko wyświetlane kiedy zmiany w koncie się powiodą
 * walidować długość i format danych
 */

class Aplikacja{

    static Connection conn = null;
    static int loggedUserId = -1;
    static int loggedWypozyczalniaid = -1;
    static String loggedNazwaWypozyczalni = "";

    public static void viewTable(Connection con) throws SQLException{
        String query = "select * from Asortyment";
        try(Statement stmt = con.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                int asortymentid = rs.getInt("ASORTYMENTID");
                String stanfizyczny = rs.getString("STANFIZYCZNY");
                System.out.println(asortymentid + stanfizyczny);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    static int getWypozyczalniaId(Connection con){
        String query = String.format("SELECT wypozyczalniaid,nazwa FROM wypozyczalnia WHERE pracownikid = %d",loggedUserId);
        try(Statement stmt = Aplikacja.conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            loggedWypozyczalniaid = rs.getInt("WYPOZYCZALNIAID");
            loggedNazwaWypozyczalni = rs.getString("Nazwa");
            return loggedWypozyczalniaid;
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
//Metoda obliczająca ID kolejnej instancji
    public static int calcID(String columnName, String tableName){
        String query = String.format("SELECT %S FROM %S WHERE ROWNUM =1 ORDER BY %S DESC",columnName,tableName,columnName);
        try(Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            int id = rs.getInt(columnName);
            id +=1;
            return id;
        }
        catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args){
        /*try {
            Class.forName("oracle.jbdc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }*/
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "SECUSER";
        String password = "PASSWORD";
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
        LoginFrame log = new LoginFrame();
        log.setVisible(true);
        

    }
}