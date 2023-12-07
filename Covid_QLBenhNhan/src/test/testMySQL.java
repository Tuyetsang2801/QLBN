package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SQL.connectSQL;
import view.QLTTView;


public class testMySQL {
    public static void main(String[] args) {
        try (Connection connection = connectSQL.getConnection()) {
            // Display database information
            connectSQL.printInfo(connection);

            // Step 2: Create a statement object
            Statement st = connection.createStatement();

            // Step 3: Execute an SQL statement to retrieve data from the MySQL table
            String sqlSelect = "SELECT STT, HoTen, GioiTinh, DiaChi,SoDienThoai, TinhTrang, Khu, Phong FROM benhnhan";
            ResultSet resultSet = st.executeQuery(sqlSelect);
            
            // Step 4: Display data on QLTTView

            while (resultSet.next()) {
                // Read data from the resultSet and process as needed
                int STT = resultSet.getInt("STT");
                String HoTen = resultSet.getString("HoTen");
                String GioiTinh = resultSet.getInt("GioiTinh") == 1 ? "Nữ" : "Nam";
                String DiaChi = resultSet.getString("DiaChi");
                String SoDienThoai = resultSet.getString("SoDienThoai");
                String TinhTrang = resultSet.getString("TinhTrang");
                String Khu = resultSet.getInt("Khu")== 1? "Khu A" : "Khu B";
                int Phong = resultSet.getInt("Phong");

                // Display data on QLTTView
                System.out.println("STT: " + STT);
                System.out.println("Họ tên: " + HoTen);
                System.out.println("Giới tính: " + GioiTinh);
                System.out.println("Địa chỉ: " + DiaChi);
                System.out.println("SDT :"+SoDienThoai);
                System.out.println("Tình trạng: " + TinhTrang);
                System.out.println("Khu: " + Khu);
                System.out.println("Phòng: " + Phong);
                
                System.out.println("----------------------");

                // Add data to QLTTView
                QLTTView.add(new Object[]{STT, HoTen, GioiTinh, DiaChi, SoDienThoai, TinhTrang, Khu, Phong});
            }
            // Step 5: Disconnect
            connectSQL.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (log, show user-friendly message, etc.)
        }
    }
}

