package controlller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JOptionPane;

import view.QLTTView;

public class QLBenhNhan implements Action {
	public QLTTView view;

	public QLBenhNhan(QLTTView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    String cm = e.getActionCommand();
	    //JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: " + cm);
	    if (cm.equals("Thêm")) {
	        this.view.xoaForm();
	        this.view.model.setLuaChon("Thêm");
	    } else if (cm.equals("Ok")) {
	        try {
	            this.view.thucHienThemBenhNhan();
	        } catch (Exception e2) {
	            e2.printStackTrace();
	            System.out.print("nhap sai dữ liệu");
	        }
	    } else if (cm.equals("Sửa")) {
	        this.view.hienThiThongTinBenhNhanDaChon();
	        
	        if(cm.equals("Ok")) {
	        	this.view.thucHienCapNhatBenhNhan();
	        ;
	        	
	        }
	    } else if (cm.equals("Xóa")) {
	        this.view.thucHienXoa();
	        if(cm.equals("YES")) {
	        this.view.thucHienXoaBenhNhan();
	        }
	    } else if (cm.equals("Bỏ")) { // Change to "Bỏ" (with accent)
	        this.view.xoaForm();
	    } else if (cm.equals("Tìm")) {
	        this.view.thucHienTim();
	    } else if (cm.equals("bỏ")) { // Change to "bỏ" (with accent)
	        this.view.thucHienTaiLaiDuLieu();
	    } else if (cm.equals("Exit")) {
	        this.view.thoatKhoiChuongTrinh();
	    }
	}


	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub

	}

}
