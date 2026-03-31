package GK_KyThuatVien;

import java.util.ArrayList;

public class quanly_KTV {
	ArrayList<KTV> list;
	public quanly_KTV () {
		list = new ArrayList<KTV>();
	}
	public quanly_KTV(ArrayList<KTV> list) {
		super();
		this.list = list;
	}
	
	public boolean themKyThuatVien(KTV ktv) {
		if(list.contains(ktv)) return false;
		list.add(ktv);
		return true;
	}
	
	public boolean xoaKyThuatVien(KTV ktv) {
		if(!list.contains(ktv)) return false;
		list.remove(ktv);
		return true;
	}
	
	public KTV timKyThuatVien( String ma) {
		KTV ktv = new KTV(ma);
		if(list.contains(ktv)) return list.get(list.indexOf(ktv));
		return null;
	}
	
	public ArrayList<KTV> getList(){
		return list;
	}
}
