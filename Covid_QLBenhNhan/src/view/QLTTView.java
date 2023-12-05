package view;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlller.QLBenhNhan;
import model.BenhNhan;
import model.QLTTModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class QLTTView extends JFrame {
	private JPanel contentPane1;
	public QLTTModel model;
	private JMenuItem MenuClose;
	public JTextField textField_NameTimKiem;
	public JTextField TextField_STTTimKiem;
	private JTable table;
	public JTextField textField_STT;
	public JTextField textField_Name;
	public JTextField textField_DiaChi;
	public JTextField textField_TinhTrang;
	public JTextField textField_Phong;
	public JRadioButton rdbtnKhuB = new JRadioButton("Khu B");
	public JRadioButton rdbtnKhuA = new JRadioButton("Khu A");
	public JRadioButton rdbtnNu = new JRadioButton("Nữ");
	public JRadioButton rdbtnNam = new JRadioButton("Nam");
	public JTextField textField_SDT;
	public ButtonGroup btn_GioiTinh;
	public ButtonGroup btn_Khu;
	private Object view;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLTTView frame = new QLTTView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public QLTTView() {
		setBackground(Color.WHITE);
		this.model = new QLTTModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 544);
		Action action = new QLBenhNhan(this);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu MenuFlie = new JMenu("File");
		MenuFlie.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(MenuFlie);

		JMenuItem MenuOpen = new JMenuItem("Open");
		MenuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		MenuFlie.add(MenuOpen);

		MenuClose = new JMenuItem("Close");
		MenuClose.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		MenuFlie.add(MenuClose);

		JMenuItem MenuEdit = new JMenuItem("Exit");
		MenuEdit.setForeground(new Color(0, 0, 0));
		MenuEdit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		MenuFlie.add(MenuEdit);

		JMenu About = new JMenu("About");
		About.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(About);

		JMenuItem MenuAbout = new JMenuItem("About Me");
		MenuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		About.add(MenuAbout);
		contentPane1 = new JPanel();
		contentPane1.setForeground(new Color(255, 255, 255));
		contentPane1.setBackground(Color.WHITE);
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane1);
		contentPane1.setLayout(null);

		JLabel HoTen = new JLabel("Họ Tên");
		HoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		HoTen.setBounds(10, 20, 58, 24);
		contentPane1.add(HoTen);

		JLabel lblStt = new JLabel("STT");
		lblStt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStt.setBounds(221, 20, 58, 24);
		contentPane1.add(lblStt);

		textField_NameTimKiem = new JTextField();
		textField_NameTimKiem.setBounds(68, 23, 144, 24);
		contentPane1.add(textField_NameTimKiem);
		textField_NameTimKiem.setColumns(10);

		TextField_STTTimKiem = new JTextField();
		TextField_STTTimKiem.setColumns(10);
		TextField_STTTimKiem.setBounds(252, 23, 160, 24);
		contentPane1.add(TextField_STTTimKiem);

		JButton btnTim = new JButton("Tìm");
		btnTim.setBackground(Color.WHITE);
		btnTim.setForeground(Color.BLACK);
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnTim.setBounds(478, 19, 94, 28);
		contentPane1.add(btnTim);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 67, 612, 2);
		contentPane1.add(separator);

		JLabel lblDanhSachBnh = new JLabel("Danh Sách Bệnh Nhân");
		lblDanhSachBnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDanhSachBnh.setBounds(10, 67, 160, 24);
		contentPane1.add(lblDanhSachBnh);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Ho\u0323 T\u00EAn", "Gi\u01A1\u0301i Ti\u0301nh", "\u0110i\u0323a Chi\u0309",
						"S\u0110T", "Ti\u0300nh Tra\u0323ng", "Khu", "Pho\u0300ng" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(43);
		table.getColumnModel().getColumn(1).setPreferredWidth(104);
		table.getColumnModel().getColumn(2).setPreferredWidth(63);
		table.getColumnModel().getColumn(3).setPreferredWidth(89);
		table.getColumnModel().getColumn(7).setPreferredWidth(83);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 104, 622, 144);
		contentPane1.add(scrollPane);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 246, 622, 2);
		contentPane1.add(separator_1);

		JLabel lblThngTinBnh = new JLabel("Thông Tin Bệnh nhân");
		lblThngTinBnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThngTinBnh.setBounds(0, 248, 170, 24);
		contentPane1.add(lblThngTinBnh);

		JLabel lblSTT = new JLabel("STT :");
		lblSTT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSTT.setBounds(52, 281, 58, 24);
		contentPane1.add(lblSTT);

		JLabel lblName = new JLabel("Họ Tên :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(42, 311, 58, 27);
		contentPane1.add(lblName);

		JLabel lblDiaChi = new JLabel("Địa Chỉ :");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiaChi.setBounds(42, 379, 58, 27);
		contentPane1.add(lblDiaChi);

		textField_STT = new JTextField();
		textField_STT.setColumns(10);
		textField_STT.setBounds(98, 281, 144, 24);
		contentPane1.add(textField_STT);

		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		textField_Name.setBounds(98, 315, 144, 24);
		contentPane1.add(textField_Name);

		textField_DiaChi = new JTextField();
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(98, 383, 144, 24);
		contentPane1.add(textField_DiaChi);

		JLabel lblTinhTrang = new JLabel("Tình Trạng :");
		lblTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTinhTrang.setBounds(273, 312, 85, 24);
		contentPane1.add(lblTinhTrang);

		JLabel lblKhu = new JLabel("Khu :");
		lblKhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKhu.setBounds(313, 349, 58, 24);
		contentPane1.add(lblKhu);

		JLabel lblPhong = new JLabel("Phòng :");
		lblPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhong.setBounds(300, 383, 58, 24);
		contentPane1.add(lblPhong);

		textField_TinhTrang = new JTextField();
		textField_TinhTrang.setColumns(10);
		textField_TinhTrang.setBounds(368, 315, 144, 24);
		contentPane1.add(textField_TinhTrang);

		textField_Phong = new JTextField();
		textField_Phong.setColumns(10);
		textField_Phong.setBounds(368, 383, 144, 24);
		contentPane1.add(textField_Phong);

		rdbtnKhuA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnKhuA.setBounds(368, 349, 70, 24);
		contentPane1.add(rdbtnKhuA);

		rdbtnKhuB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnKhuB.setBounds(442, 349, 70, 24);
		contentPane1.add(rdbtnKhuB);
		btn_Khu = new ButtonGroup();
		btn_Khu.add(rdbtnKhuA);
		btn_Khu.add(rdbtnKhuB);
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setForeground(Color.BLACK);
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnThem.setBackground(Color.WHITE);
		btnThem.setBounds(42, 432, 94, 34);
		contentPane1.add(btnThem);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(action);
		btnSua.setForeground(Color.BLACK);
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSua.setBackground(Color.WHITE);
		btnSua.setBounds(290, 432, 94, 34);
		contentPane1.add(btnSua);
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(action);
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnOk.setBackground(Color.WHITE);
		btnOk.setBounds(401, 432, 94, 34);
		contentPane1.add(btnOk);

		JButton btnBo = new JButton("Bỏ");
		btnBo.addActionListener(action);
		btnBo.setForeground(Color.BLACK);
		btnBo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnBo.setBackground(Color.WHITE);
		btnBo.setBounds(516, 432, 94, 34);
		contentPane1.add(btnBo);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(action);
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBounds(166, 432, 94, 34);
		contentPane1.add(btnXoa);

		textField_SDT = new JTextField();
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(368, 281, 144, 24);
		contentPane1.add(textField_SDT);

		JLabel lbSDT = new JLabel("SDT :");
		lbSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSDT.setBounds(313, 281, 85, 24);
		contentPane1.add(lbSDT);

		JLabel lblGioiTinh = new JLabel("Giới Tính :");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGioiTinh.setBounds(30, 348, 70, 27);
		contentPane1.add(lblGioiTinh);
		
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNu.setBounds(98, 349, 70, 24);
		contentPane1.add(rdbtnNu);
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNam.setBounds(178, 349, 70, 24);
		contentPane1.add(rdbtnNam);
		
		btn_GioiTinh = new ButtonGroup();
		btn_GioiTinh.add(rdbtnNu);
		btn_GioiTinh.add(rdbtnNam);
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_STT.setText("");
		textField_Name.setText("");
		btn_GioiTinh.clearSelection();
		textField_DiaChi.setText("");
		textField_TinhTrang.setText("");
		textField_Phong.setText("");
		textField_SDT.setText("");
		btn_Khu.clearSelection();

	}

	public void themBenhNhanVaoTable(BenhNhan Bn) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] { Bn.getSTT() + "", Bn.getHoTen() + "", (Bn.isGioiTinh() ? "Nữ" : "Nam"),
				Bn.getDiaChi() + "", Bn.getSoDienThoai() + "", Bn.getTinhTrang() + "", (Bn.isKhu() ? "Khu A" : "Khu B"),
				Bn.getPhong() + "" });
	}

	

	public void themHoacCapNhatBenhNhan(BenhNhan Bn) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if (!this.model.kiemTraTonTai(Bn)) {
			this.model.insert(Bn);
			this.themBenhNhanVaoTable(Bn);
		} else {
			this.model.update(Bn);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(Bn.getSTT() + "")) {
					model_table.setValueAt(Bn.getSTT() + "", i, 0);
					model_table.setValueAt(Bn.getHoTen() + "", i, 1);
					model_table.setValueAt((Bn.isGioiTinh() ? " Nữ " : " Nam "), i, 2);
					model_table.setValueAt(Bn.getDiaChi() + "", i, 3);
					model_table.setValueAt(Bn.getSoDienThoai() + "", i, 4);
					model_table.setValueAt(Bn.getTinhTrang() + "", i, 5);
					model_table.setValueAt((Bn.isKhu() ? "Khu A" : "Khu B"), i, 6);
					model_table.setValueAt(Bn.getPhong() + "", i, 7);
				}
			}
		}
	}

	public BenhNhan getBenhNhanDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		// Check if a row is selected
		if (i_row == -1) {
			return null;
		}
		int STT = Integer.valueOf(model_table.getValueAt(i_row, 0) + "");
		String HoTen = model_table.getValueAt(i_row, 1) + "";
		String textGioiTinh = model_table.getValueAt(i_row, 2) + "";
		boolean GioiTinh = textGioiTinh.equals("Nữ");
		String Diachi = model_table.getValueAt(i_row, 3) + "";
		String SoDienThoai = model_table.getValueAt(i_row, 4) + "";
		String TinhTrang = model_table.getValueAt(i_row, 5) + "";
		String textKhu = model_table.getValueAt(i_row, 6) + "";
		boolean Khu = textKhu.equals("Khu A");
		int Phong = Integer.valueOf(model_table.getValueAt(i_row, 7) + "");

		BenhNhan Bn = new BenhNhan(STT, HoTen, GioiTinh, Diachi, SoDienThoai, TinhTrang, Khu, Phong);
		return Bn;
	}

	public void hienThiThongTinBenhNhanDaChon() {
		BenhNhan Bn = getBenhNhanDangChon();
		this.textField_STT.setText(Bn.getSTT() + "");
		this.textField_Name.setText(Bn.getHoTen() + "");
		if (Bn.isGioiTinh()) {
			rdbtnNu.setSelected(true);
		} else {
			rdbtnNam.setSelected(true);
		}
		this.textField_DiaChi.setText(Bn.getDiaChi() + "");
		this.textField_SDT.setText(Bn.getSoDienThoai() + "");
		this.textField_TinhTrang.setText(Bn.getTinhTrang() + "");
		if (Bn.isKhu()) {
			rdbtnKhuA.setSelected(true);
		} else {
			rdbtnKhuB.setSelected(true);
		}
		this.textField_Phong.setText(Bn.getPhong() + "");
	}

	public void thucHienXoa() {
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    int i_row = table.getSelectedRow();

	    if (i_row != -1) {
	        try {
	            BenhNhan Bn = getBenhNhanDangChon();

	            if (Bn != null) {
	                int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn muốn xóa dòng đã chọn?",
	                        "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

	                if (luaChon == JOptionPane.YES_OPTION) {
	                    System.out.println("Deleting patient: " + Bn); // Add this line for debugging

	                    this.model.delete(Bn);
	                    model_table.removeRow(i_row);
	                  
	                }
	            } else {
	                JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
	            }
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Lỗi khi thực hiện xóa: " + ex.getMessage());
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
	    }
	}

	public boolean kiemTraTonTaiKhuPhong(boolean khu, int phong) {
	    for (BenhNhan Bn : model.getDsThongTin()) {
	        if (Bn.isKhu() == khu && Bn.getPhong() == phong) {
	            JOptionPane.showMessageDialog(null, "Phòng đã được sử dụng. Vui lòng chọn phòng khác.");
	            return true;
	        }
	    }
	  
	    return false;
	}

	public void thucHienThemBenhNhan() {
		int STT = Integer.valueOf(this.textField_STT.getText());
		String HoTen = this.textField_Name.getText();
		if (HoTen.length() < 45) {

		} else {
			JOptionPane.showMessageDialog(null, "Họ tên quá dài. Vui lòng nhập lại.");
			return ;
		}

		boolean GioiTinh = true;
		if (this.rdbtnNam.isSelected()) {
			GioiTinh =false;
		} else if (this.rdbtnNu.isSelected()) {
			GioiTinh = true;
		}
		String DiaChi = this.textField_DiaChi.getText();
		String SoDienThoai = this.textField_SDT.getText();
		if (!SoDienThoai.matches("0\\d{9}")) {
			// Thông báo lỗi khi số điện thoại không đúng định dạng
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ. Vui lòng nhập lại.");
			// Dừng hàm nếu có lỗi
			return;
		}
		String TinhTrang = this.textField_TinhTrang.getText();
		if (!(TinhTrang.equals("f1") || TinhTrang.equals("f0") || TinhTrang.equals("f2") || TinhTrang.equals("F0")
				|| TinhTrang.equals("F1") || TinhTrang.equals("F2"))) {
			JOptionPane.showMessageDialog(null, "Tình trạng không hợp lệ. Vui lòng nhập F1, F0 hoặc F2.");
			return;

		}
		boolean Khu = true;
		if (this.rdbtnKhuA.isSelected()) {
			Khu = true;
		} else if (this.rdbtnKhuB.isSelected()) {
			Khu = false;
		}
		int Phong = Integer.valueOf(this.textField_Phong.getText());
		if(Phong<0||Phong>30) {
			JOptionPane.showMessageDialog(null, "Không có số phòng này!Vui lòng nhập lại");
			// Dừng hàm nếu có lỗi
			return;

		}
		if (!this.model.kiemTraTonTai(new BenhNhan(STT, HoTen, GioiTinh, DiaChi, SoDienThoai, TinhTrang, Khu, Phong))&&
		        kiemTraTonTaiKhuPhong(Khu, Phong)) {
		        return; 
		    }
		BenhNhan Bn = new BenhNhan(STT, HoTen, GioiTinh, DiaChi, SoDienThoai, TinhTrang, Khu, Phong);
		this.themHoacCapNhatBenhNhan(Bn);

	}

	
	public void thucHienTim() {
	    // Reset search
	    this.thucHienTaiLaiDuLieu();

	    // Perform search
	    String nameTimKiem = this.textField_NameTimKiem.getText().toLowerCase(); 
	    String sttTimKiem = this.TextField_STTTimKiem.getText().toLowerCase(); 
	    DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	    int soLuongDong = model_table.getRowCount();

	    Set<Integer> STTBenhNhanCanXoa = new TreeSet<>();

	    for (int i = 0; i < soLuongDong; i++) {
	        String tenBenhNhan = model_table.getValueAt(i, 1).toString().toLowerCase();
	        String stt = model_table.getValueAt(i, 0).toString().toLowerCase(); 

	        if (tenBenhNhan.contains(nameTimKiem) || stt.equals(nameTimKiem) || stt.equals(sttTimKiem)) {
	            STTBenhNhanCanXoa.add(Integer.valueOf(stt));
	        }
	    }

	    if (nameTimKiem.length() > 0) {
	        for (int i = 0; i < soLuongDong; i++) {
	            String id = model_table.getValueAt(i, 0).toString();
	            if (!id.equals(nameTimKiem)) {
	                STTBenhNhanCanXoa.add(Integer.valueOf(id));
	            }
	        }
	    }
	    for (Integer STTCanXoa : STTBenhNhanCanXoa) {
	    	System.out.println(STTCanXoa);
			soLuongDong = model_table.getRowCount();
	        for (int i = 0; i < soLuongDong; i++) {
	            String STTTrongTable = model_table.getValueAt(i, 0).toString();
	            System.out.println("idTrongTable: " + STTTrongTable);
				if (STTTrongTable.equals(STTCanXoa.toString())) {
					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
	            }
	        }
	    }
	

	public void thucHienTaiLaiDuLieu() {
		while (true) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int soLuongDong = model_table.getRowCount();
			if (soLuongDong == 0)
				break;
			else
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (BenhNhan Bn : this.model.getDsThongTin()) {
			this.themBenhNhanVaoTable(Bn);
		}
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoải khỏi chương trình?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
