package model;
import java.util.Objects;
public class BenhNhan {
	private int STT;
	private String HoTen;
	private String DiaChi;
	private String SoDienThoai;
	private boolean GioiTinh;
	private String TinhTrang;
	private boolean Khu;
    private int Phong;
    public BenhNhan() {
    	
    }
    
    public BenhNhan(int STT, String HoTen, boolean GioiTinh, String DiaChi, String SoDienThoai, String TinhTrang, boolean Khu, int Phong) {
    
    		this.STT = STT;
    		this.HoTen = HoTen;
    		this.DiaChi = DiaChi;
    		this.SoDienThoai = SoDienThoai;
    		this.GioiTinh = GioiTinh;
    		this.TinhTrang = TinhTrang;
    		this.Khu = Khu;
    		this.Phong = Phong;
    	}

	public int getSTT() {
		return STT;
	}
	public void setSTT(int sTT) {
		this.STT = sTT;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		this.HoTen = hoTen;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		this.DiaChi = diaChi;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.SoDienThoai = soDienThoai;
	}
	public boolean isGioiTinh() {
	  return GioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.GioiTinh = gioiTinh;
	}
	public String getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.TinhTrang = tinhTrang;
	}
	public boolean isKhu() {
		return Khu;
	}
	public void setKhu(boolean khu) {
		this.Khu = khu;
	}
	public int getPhong() {
		return Phong;
	}
	public void setPhong(int phong) {
		this.Phong = phong;
	}
	@Override
	public String toString() {
		return "BenhNhan [STT=" + STT + ", HoTen=" + HoTen + ", DiaChi=" + DiaChi + ", SoDienThoai=" + SoDienThoai
				+ ", GioiTinh=" + GioiTinh + ", TinhTrang=" + TinhTrang + ", Khu=" + Khu + ", Phong=" + Phong + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(DiaChi, GioiTinh, HoTen, Khu, Phong, STT, SoDienThoai, TinhTrang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BenhNhan other = (BenhNhan) obj;
		return Objects.equals(DiaChi, other.DiaChi) && GioiTinh == other.GioiTinh && Objects.equals(HoTen, other.HoTen)
				&& Khu == other.Khu && Phong == other.Phong && STT == other.STT && SoDienThoai == other.SoDienThoai
				&& Objects.equals(TinhTrang, other.TinhTrang);
	}


}
