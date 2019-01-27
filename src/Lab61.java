import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.*;

public class Lab61 {
    public static void main(String[] args) throws SQLException {

        String connectionUrl = "jdbc:sqlserver://morfeusz.wszib.edu.pl:1433;databaseName=AdventureWorks;user=***;password=***";


        Connection con = DriverManager.getConnection(connectionUrl);
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("select top 10 * from Person.Contact where LastName = 'Anderson'");

         while(rs.next()){
            System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
         }

        rs.close();

        System.out.println("---------------------------------------------------");

        ResultSet rs2 = stmt.executeQuery("select DISTINCT Title from HumanResources.Employee");

        while(rs2.next()){
            System.out.println(rs2.getString("Title"));
        }

        rs2.close();

        System.out.println("---------------------------------------------------");

        ResultSet rs3 = stmt.executeQuery("select CustomerID, count(SalesOrderID) as IloscZamowien from Sales.SalesOrderHeader group by CustomerID order by IloscZamowien DESC ");

        while(rs3.next()){
            System.out.println(rs3.getString("CustomerID") + " " + rs3.getString("IloscZamowien"));
        }

        rs3.close();
        stmt.close();
        con.close();
    }

}
