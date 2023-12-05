package model;
import java.util.Objects;
public class Khu {
	 private String khu;
	 private long maPhong;
	 
	 public Khu(String khu, long maPhong) {
			this.khu = khu;
			this.maPhong = maPhong;
		}
	//tao doi tuong 
	@Override
		public String toString() {
			return "Khu [khu=" + khu + ", maPhong=" + maPhong + "]";
		}

	public String getKhu() {
		return khu;
	}

	public void setKhu(String khu) {
		this.khu = khu;
	}

	public long getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(long maPhong) {
		this.maPhong = maPhong;
	}


	@Override
	public int hashCode() {
		return Objects.hash(khu, maPhong);
	}

	//in 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Khu other = (Khu) obj;
		return Objects.equals(khu, other.khu) && maPhong == other.maPhong;
	}

}
