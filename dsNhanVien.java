package Tu_hoc;

import java.util.ArrayList;

public class dsNhanVien {

	private ArrayList<NhanVien> list;

	public dsNhanVien() {
		list = new ArrayList<NhanVien>();
	}

	public dsNhanVien(ArrayList<NhanVien> list) {
		super();
		this.list = list;
	}

	public boolean themNhanVien(NhanVien nv) {
		if (list.contains(nv))
			return false;
		list.add(nv);
		return true;
	}

	public boolean xoaNhanVien(NhanVien nv) {
		if (!list.contains(nv))
			return false;
		list.remove(nv);
		return true;
	}

	public NhanVien timNhanVien(String ma) {
		NhanVien nv = new NhanVien(ma);
		if (list.contains(nv))
			return list.get(list.indexOf(nv));
		return null;
	}

	public ArrayList<NhanVien> getList() {
		return list;
	}

}
