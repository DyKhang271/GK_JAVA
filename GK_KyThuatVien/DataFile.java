package GK_KyThuatVien;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class DataFile {
	public static boolean saveFile(quanly_KTV ds, String path) {
		if(ds == null || path.isEmpty()) return false;
		try (FileWriter fw = new FileWriter(path)) {
			fw.write("MaKTV,TenKTV,ThamNien,ChuyenMon,sdt\n");
			for (KTV ktv :ds.getList()) {
				fw.write(ktv.getMaKTV()+ ","+
						ktv.getTenKTV() + ","+
						ktv.getThamNien() + ","+ 
						ktv.getChuyenMon() + ","+ 
						ktv.getSdt() + "\n"
						);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static quanly_KTV loadFile(String path) {
		quanly_KTV ds= new quanly_KTV();
		if(path.isEmpty()) return ds;
		try(Scanner sc = new Scanner(new FileReader(path))) {
			if(!sc.hasNextLine()) return ds;
			sc.nextLine();
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();
				if(line.isEmpty()) continue;
				String data[]= line.split(",");
				if(data.length == 5) {
					ds.themKyThuatVien(new KTV(data[0], data[1], Integer.parseInt(data[2]), data[3], data[4]));
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
