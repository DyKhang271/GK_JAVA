package GK_KyThuatVien;

import java.util.Objects;

public class KTV {
	private String maKTV,tenKTV,chuyenMon,sdt;
	private int thamNien;
	public String getMaKTV() {
		return maKTV;
	}
	public void setMaKTV(String maKTV) {
		if(maKTV==null || maKTV.trim().isEmpty())
			throw new IllegalArgumentException("Mã không được bỏ trống");
		this.maKTV = maKTV;
	}
	public String getTenKTV() {
		return tenKTV;
	}
	public void setTenKTV(String tenKTV) {
		if(tenKTV==null || tenKTV.trim().isEmpty())
			throw new IllegalArgumentException("Tên không được bỏ trống");
		this.tenKTV = tenKTV;
	}
	public String getChuyenMon() {
		return chuyenMon;
	}
	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		if(sdt==null || sdt.trim().isEmpty())
			throw new IllegalArgumentException("Số điện thoại không được bỏ trống");
		this.sdt = sdt;
	}
	public int getThamNien() {
		return thamNien;
	}
	public void setThamNien(int thamNien) {
		if(thamNien<= 0 )
			throw new IllegalArgumentException("Năm thâm niên phải dương");
		this.thamNien = thamNien;
	}
	public KTV(String maKTV, String tenKTV, int thamNien, String chuyenMon, String sdt) {
		super();
		setMaKTV(maKTV);
		setTenKTV(tenKTV);
		setChuyenMon(chuyenMon);
		setSdt(sdt);
		setThamNien(thamNien);
	}
	public KTV(String maKTV) {
		super();
		setMaKTV(maKTV);
	}
	public KTV() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maKTV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KTV other = (KTV) obj;
		return Objects.equals(maKTV, other.maKTV);
	}
	
	
	
	
	
	
}
