package Tu_hoc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DataFile {
	public static boolean saveFile(dsNhanVien ds, String path) {
		if (ds == null || path.isEmpty())
			return false;

		try (FileWriter fw = new FileWriter(path)) {
			fw.write("Ma NV, Ho NV, Ten NV, Tuoi, Phai, Phong ban, Thang, Luong\n");
			for (NhanVien nv : ds.getList()) {
				fw.write(
						nv.getMaNV() + "," +
								nv.getHoNV() + "," +
								nv.getTenNV() + "," +
								nv.getTuoi() + "," +
								(nv.isPhai() ? "Nu" : "Nam") + "," +
								nv.getPhongBan() + "," +
								nv.getThang() + "," +
								nv.getLuong() + "\n"

				);
			}

			return true;
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static dsNhanVien loadFile(String path) {
		dsNhanVien ds = new dsNhanVien();
		if (path.isEmpty())
			return ds;
		try (Scanner sc = new Scanner(new FileReader(path))) {
			if (!sc.hasNextLine())
				return ds;
			sc.nextLine();
			while (sc.hasNextLine()) {
				String line = sc.nextLine().trim();
				if (line.isEmpty())
					continue;

				String data[] = line.split(",");
				if (data.length >= 6 && data.length <= 8) {
					if (data.length == 6) {
						ds.themNhanVien(new NhanVien(
								data[0].trim(),
								data[1].trim(),
								data[2].trim(),
								20,
								false,
								data[3].trim(),
								Integer.parseInt(data[4].trim()),
								Double.parseDouble(data[5].trim())));
					} else if (data.length == 8) {
						ds.themNhanVien(new NhanVien(
								data[0].trim(),
								data[1].trim(),
								data[2].trim(),
								Integer.parseInt(data[3].trim()),
								data[4].trim().equals("Nu"),
								data[5].trim(),
								Integer.parseInt(data[6].trim()),
								Double.parseDouble(data[7].trim())));
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ds;
	}
}
