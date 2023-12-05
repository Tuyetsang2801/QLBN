package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import SQL.connectSQL;

public class testMySQL {
    public static void main(String[] args) {
        try (Connection connection = connectSQL.getConnection()) {
            connectSQL.printInfo(connection);

            // Bước 2: Tạo ra đối tượng statement
            Statement st = connection.createStatement();

            // Bước 3: Thực thi một câu lệnh SQL
            String sql = "INSERT INTO qltt(STT,HoTen,GioiTinh, DiaChi, TinhTrang,Khu,Phong) " +
                    "VALUES ('3', 'Thi', 'Nữ', 'QN', 'f1','Khu B',2)";

            int check = st.executeUpdate(sql);

            // Bước 4: xử lý kết quả
            System.out.println("Số dòng thay đổi: " + check);
            if (check > 0) {
                System.out.println("Thêm dữ liệu thành công!");
            } else {
                System.out.println("Thêm dữ liệu thất bại!");
            }

            // Bước 5: ngắt kết nối
            connectSQL.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately (log, show user-friendly message, etc.)
        }
    }
}
