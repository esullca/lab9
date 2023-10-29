package com.example.clase10crud.daos;

import com.example.clase10crud.beans.Title;

import java.sql.*;
import java.util.ArrayList;

public class TitleDao {
    private static final String username = "root";
    private static final String password = "root";

    public ArrayList<Title> list(){

        ArrayList<Title> lista = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/employees";

        // TODO: update query
        String sql = "select * from titles limit 100";


        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Title title = new Title();
                title.setEmpNo(rs.getInt(1));
                title.setTitle(rs.getString(2));
                title.setFromDate(rs.getString(3));
                title.setToDate(rs.getString(4));

                lista.add(title);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    public void crear(int titleEmp_no, String titleTitle, String titleFromDate, String titleToDate){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/hr";
        String username = "root";
        String password = "root";

        String sql = "insert into titles (emp_no, title, from_date,to_date) values (?,?,?,?)";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setInt(1,titleEmp_no);
            pstmt.setString(2,titleTitle);
            pstmt.setString(3,titleFromDate);
            pstmt.setString(4,titleToDate);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
