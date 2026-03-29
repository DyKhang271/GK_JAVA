package Tu_hoc;

import java.util.Objects;

public class NhanVien {
	private String maNV, hoNV, tenNV, phongBan;
	private int thang, tuoi;
	private double luong;
	private boolean phai; // true: Nữ, false: Nam

	public NhanVien() {
		super();
	}

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}

	public NhanVien(String maNV, String hoNV, String tenNV, int tuoi, boolean phai, String phongBan, int thang,
			double luong) {
		super();
		setMaNV(maNV);
		setHoNV(hoNV);
		setTenNV(tenNV);
		setTuoi(tuoi);
		setPhai(phai);
		setPhongBan(phongBan);
		setThang(thang);
		setLuong(luong);
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		if (tuoi < 18 || tuoi > 60)
			throw new IllegalArgumentException("Tuổi phải từ 18 đến 60");
		this.tuoi = tuoi;
	}

	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		if (maNV == null || maNV.trim().isEmpty())
			throw new IllegalArgumentException("Mã không được rỗng");
		else
			this.maNV = maNV;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		if (hoNV == null || hoNV.trim().isEmpty())
			throw new IllegalArgumentException("Họ không được rỗng");
		this.hoNV = hoNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		if (tenNV == null || tenNV.trim().isEmpty())
			throw new IllegalArgumentException("Tên không được rỗng");
		this.tenNV = tenNV;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}

	public int getThang() {
		return thang;
	}

	public void setThang(int thang) {
		if (thang <= 0)
			throw new IllegalArgumentException("Tháng không được âm hoặc bằng 0");
		this.thang = thang;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		if (luong <= 0)
			throw new IllegalArgumentException("Lương không được âm hoặc bằng 0");
		this.luong = luong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

}
