package model;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class QLTTModel {
	   private ArrayList<BenhNhan> DsThongTin;
	   public String LuaChon;

	   public QLTTModel() {
			this.DsThongTin=new ArrayList<BenhNhan>();
			this.LuaChon="";
		}
	  public QLTTModel(ArrayList<BenhNhan> DsThongTin) {
		this.DsThongTin=DsThongTin;
	}

	
	  public void setDsThongTin(ArrayList<BenhNhan> dsThongTin) {
			this.DsThongTin = dsThongTin;
		}
	  public ArrayList<BenhNhan> getDsThongTin() {
			return DsThongTin;
		}

	public String getLuaChon() {
		return LuaChon;
	}

	public void setLuaChon(String luaChon) {
		this.LuaChon = luaChon;
	}


	public void insert(BenhNhan benhNhan) {
		this.DsThongTin.add(benhNhan);
			
	}
	public void delete(BenhNhan benhNhan) {
		this.DsThongTin.remove(benhNhan);
	}
	public void update(BenhNhan benhNhan) {
		this.DsThongTin.remove(benhNhan);
		this.DsThongTin.add(benhNhan);
	}
	public void kiemTraSucKhoe(BenhNhan benhNhan) {
        if (benhNhan.getTinhTrang().equals("F1") || benhNhan.getTinhTrang().equals("F2")||benhNhan.getTinhTrang().equals("f2")||benhNhan.getTinhTrang().equals("f1")) {
            benhNhan.setKhu(false); // Assign to Khu B
        } else {
            benhNhan.setKhu(true); // Assign to Khu A
        }

        // Check and update the patient's health status
        if (benhNhan.getTinhTrang().equals("F0")||benhNhan.getTinhTrang().equals("f0")) {
            // Additional logic for F0 status
            benhNhan.setTinhTrang("Đang theo dõi"); // Update the health status
            // You can add more specific actions for F0 status if needed
        } else if (benhNhan.getTinhTrang().equals("F1")) {
            // Additional logic for F1 status
            benhNhan.setTinhTrang("Đang điều trị"); // Update the health status
            // You can add more specific actions for F1 status if needed
        } else if (benhNhan.getTinhTrang().equals("F2")) {
            // Additional logic for F2 status
            benhNhan.setTinhTrang("Đang cách ly"); // Update the health status
            // You can add more specific actions for F2 status if needed
        }

        // Add the patient to the management list
        this.DsThongTin.add(benhNhan);

        // Display a message or perform other actions based on the health status
        JOptionPane.showMessageDialog(null, "Bệnh nhân " + benhNhan.getHoTen() + " được đưa vào khu "
                + (benhNhan.isKhu() ? "A" : "B") + " với tình trạng: " + benhNhan.getTinhTrang());
    }

	public boolean kiemTraTonTai(BenhNhan Bn) {
		for(BenhNhan benhnhan: DsThongTin) {
			if(benhnhan.getSTT() == Bn.getSTT())
				return true;
		}
		return false;
	}
	public boolean kiemTraTonTaiKhuPhong(boolean Khu, int Phong) {
	    for (BenhNhan benhnhan : DsThongTin) {
	        if (benhnhan.isKhu() == Khu && benhnhan.getPhong() == Phong) {
	            // Display a message that the room is occupied
	            JOptionPane.showMessageDialog(null, "Phòng đã có bệnh nhân. Vui lòng kiểm tra phòng.");
	            return true;
	        }
	    }
	    return false;
	}

	
}
