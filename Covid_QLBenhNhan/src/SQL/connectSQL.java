package SQL;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.BenhNhan;

public class connectSQL {
	 private static Connection connection;
    public void fetchDataFromDatabase() {
        Connection c = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String url = "jdbc:mysql://localhost:3306/sang";
            String userName = "root";
            String password = "0728012004";

            c = DriverManager.getConnection(url, userName, password);
            System.out.println("Ket noi thanh cong den CSDL");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to establish a connection.", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection c = null;

        try {
            String url = "jdbc:mysql://localhost:3306/sang";
            String userName = "root";
            String password = "0728012004";
            c = DriverManager.getConnection(url, userName, password);
            System.out.println("Ket noi thanh cong den CSDL");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
            // Log or print a more meaningful error message
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {
            // Log or print a more meaningful error message
            e.printStackTrace();
        }
    }

    public static void insertData(BenhNhan Bn) {
        Connection c = null;
        PreparedStatement preparedStatement = null;

        try {
            c = getConnection();

            // Use prepared statement to avoid SQL injection
            String sql = "INSERT INTO benhnhan (STT, HoTen, GioiTinh, DiaChi, SoDienThoai, TinhTrang, Khu, Phong) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = c.prepareStatement(sql);
            preparedStatement.setInt(1, Bn.getSTT());
            preparedStatement.setString(2, Bn.getHoTen());
            preparedStatement.setBoolean(3, Bn.isGioiTinh());
            preparedStatement.setString(4, Bn.getDiaChi());
            preparedStatement.setString(5, Bn.getSoDienThoai());
            preparedStatement.setString(6, Bn.getTinhTrang());
            preparedStatement.setBoolean(7, Bn.isKhu());
            preparedStatement.setInt(8, Bn.getPhong());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(c);
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	public void deleteData(BenhNhan bn) {
		Connection c = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        c = getConnection();

	        // Use prepared statement to avoid SQL injection
	        String sql = "DELETE FROM benhnhan WHERE STT = ?";
	        preparedStatement = c.prepareStatement(sql);
	        preparedStatement.setInt(1, bn.getSTT());

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Record deleted successfully.");
	        } else {
	            System.out.println("No record found for deletion.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConnection(c);
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
	}

	public void updateData(BenhNhan bn) {
	    Connection c = null;
	    PreparedStatement preparedStatement = null;

	    try {
	        c = getConnection();

	        // Use prepared statement to avoid SQL injection
	        String sql = "UPDATE benhnhan SET HoTen = ?, GioiTinh = ?, DiaChi = ?, SoDienThoai = ?, TinhTrang = ?, Khu = ?, Phong = ? WHERE STT = ?";
	        preparedStatement = c.prepareStatement(sql);

	        preparedStatement.setString(1, bn.getHoTen());
	        preparedStatement.setBoolean(2, bn.isGioiTinh());
	        preparedStatement.setString(3, bn.getDiaChi());
	        preparedStatement.setString(4, bn.getSoDienThoai());
	        preparedStatement.setString(5, bn.getTinhTrang());
	        preparedStatement.setBoolean(6, bn.isKhu());
	        preparedStatement.setInt(7, bn.getPhong());
	        preparedStatement.setInt(8, bn.getSTT());

	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Record updated successfully.");
	        } else {
	            System.out.println("No record found for update.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        closeConnection(c);
	        try {
	            if (preparedStatement != null) {
	                preparedStatement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static ResultSet retrieveData() {
		        ResultSet resultSet = null;
		        String query = "SELECT * FROM YourTableName"; // Replace with your actual table name

		        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		            resultSet = preparedStatement.executeQuery();
		        } catch (SQLException e) {
		            e.printStackTrace();
		            // Handle the exception according to your application's requirements
		        }

		        return resultSet;
		    }
	}
