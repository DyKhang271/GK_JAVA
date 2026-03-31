package GK_KyThuatVien;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class GUI_KTV extends JFrame implements ActionListener {
	JTextField txtMa, txtHoTen, txtThamNien, txtDT, txtTim;
	JComboBox<String> cboChuyenMon;
	DefaultTableModel model;
	JTable table;
	JButton btnTim, btnThem, btnLamMoi, btnXoa, btnLuu;
	quanly_KTV list = new quanly_KTV();
	String path = "src/data/KTV_data.txt";

	public GUI_KTV() {
		super("Kiểm Tra Giữ Kỳ 23 Trần Duy Khang 23728961");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 500);
		createGUI();
		setVisible(true);
	}

	private void createGUI() {
		JPanel pnMain = new JPanel(new BorderLayout());
		JPanel pnNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTitle = new JLabel("THÔNG TIN KỸ THUẬT VIÊN");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
		pnNorth.add(lblTitle);
		pnMain.add(pnNorth, BorderLayout.NORTH);
		add(pnMain);

		JPanel pnCenter = new JPanel(new BorderLayout());
		pnMain.add(pnCenter, BorderLayout.CENTER);
		JPanel pnNhap = new JPanel(new GridLayout(3, 1, 10, 10));
		pnCenter.add(pnNhap, BorderLayout.NORTH);
		pnNhap.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

		JPanel pnMa = new JPanel(new BorderLayout());
		JLabel lblMa = new JLabel("Mã KTV:");
		txtMa = new JTextField("12333");
		lblMa.setPreferredSize(new Dimension(100, 30));
		pnMa.add(lblMa, BorderLayout.WEST);
		pnMa.add(txtMa, BorderLayout.CENTER);
		pnNhap.add(pnMa);

		JPanel pnHoTen_ThamNien = new JPanel(new GridLayout(1, 2, 30, 30));
		pnNhap.add(pnHoTen_ThamNien);
		JPanel pnHoTen = new JPanel(new BorderLayout());
		JLabel lblHoTen = new JLabel("Họ Tên KTV");
		txtHoTen = new JTextField("Trần Duy Khang");
		lblHoTen.setPreferredSize(new Dimension(100, 30));
		pnHoTen.add(lblHoTen, BorderLayout.WEST);
		pnHoTen.add(txtHoTen, BorderLayout.CENTER);
		pnHoTen_ThamNien.add(pnHoTen);

		JPanel pnThamNien = new JPanel(new BorderLayout());
		JLabel lblThamNien = new JLabel("Thâm niên:");
		txtThamNien = new JTextField("2");
		lblThamNien.setPreferredSize(new Dimension(100, 30));
		pnThamNien.add(lblThamNien, BorderLayout.WEST);
		pnThamNien.add(txtThamNien, BorderLayout.CENTER);
		pnHoTen_ThamNien.add(pnThamNien);

		JPanel pnChuyen_dt = new JPanel(new BorderLayout());
		pnNhap.add(pnChuyen_dt);
		JPanel pnChuyenMon = new JPanel(new BorderLayout());
		JLabel lblChuyenMon = new JLabel("Chuyên Môn:");
		cboChuyenMon = new JComboBox<String>();
		cboChuyenMon.addItem("Máy Tính");
		cboChuyenMon.addItem("Điện lạnh");
		cboChuyenMon.addItem("Cơ Điện");
		lblChuyenMon.setPreferredSize(new Dimension(100, 30));
		pnChuyenMon.add(lblChuyenMon, BorderLayout.WEST);
		pnChuyenMon.add(cboChuyenMon, BorderLayout.CENTER);
		pnChuyen_dt.add(pnChuyenMon, BorderLayout.WEST);

		JPanel pndt = new JPanel(new BorderLayout());
		pndt.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 0));
		JLabel lblDT = new JLabel("Điện Thoại:");
		txtDT = new JTextField("0327102743");
		lblDT.setPreferredSize(new Dimension(100, 30));
		cboChuyenMon.setPreferredSize(new Dimension(120, 30));
		pndt.add(lblDT, BorderLayout.WEST);
		pndt.add(txtDT, BorderLayout.CENTER);
		pnChuyen_dt.add(pndt, BorderLayout.CENTER);

		JPanel pntable = new JPanel(new BorderLayout());
		pnCenter.add(pntable, BorderLayout.CENTER);

		model = new DefaultTableModel(new String[] {
				"Mã KTV", "Tên KTV", "Thâm niên", "Chuyên môn", "số điện thoại"
		}, 0);
		table = new JTable(model);

		// Canh trái cho tất cả các cột của bảng
		DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
		leftRenderer.setHorizontalAlignment(SwingConstants.LEFT);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(leftRenderer);
		}

		// Canh trái cho tiêu đề cột (Table Header)
		TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
		if (headerRenderer instanceof JLabel) {
			((JLabel) headerRenderer).setHorizontalAlignment(SwingConstants.LEFT);
		}

		table.getSelectionModel().addListSelectionListener(e -> loadDataToForm(table.getSelectedRow()));

		JScrollPane scroll = new JScrollPane(table);
		pntable.add(scroll);

		JPanel pnNut = new JPanel(new GridLayout(1, 2));
		pnMain.add(pnNut, BorderLayout.SOUTH);

		JPanel pnTim = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnNut.add(pnTim);

		JLabel lblTim = new JLabel("Nhập mã KTV cần tìm:");
		lblTim.setPreferredSize(new Dimension(130, 10));
		txtTim = new JTextField();
		txtTim.setPreferredSize(new Dimension(130, 25));
		btnTim = new JButton("Tìm");
		pnTim.add(lblTim);
		pnTim.add(txtTim);
		pnTim.add(btnTim);

		JPanel pnChucNang = new JPanel(new FlowLayout());
		btnThem = new JButton("Thêm");
		btnThem.setMnemonic(KeyEvent.VK_T);
		btnLamMoi = new JButton("Làm mới");
		btnXoa = new JButton("Xoá");
		btnLuu = new JButton("Lưu");

		pnChucNang.add(btnThem);
		pnChucNang.add(btnLamMoi);
		pnChucNang.add(btnXoa);
		pnChucNang.add(btnLuu);
		pnNut.add(pnChucNang);

		loadDataFormFile();
		
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnLamMoi.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLuu.addActionListener(this);

	}

	private void loadDataToForm(int row) {
		if (row < 0) return; 
		txtMa.setText(model.getValueAt(row, 0).toString());
		txtHoTen.setText(model.getValueAt(row, 1).toString());
		txtThamNien.setText(model.getValueAt(row, 2).toString());
		cboChuyenMon.setSelectedItem(model.getValueAt(row, 3).toString());
		txtDT.setText(model.getValueAt(row, 4).toString());

	}

	private void loadDataFormFile() {
		quanly_KTV dsKTV = DataFile.loadFile(path);
		if (dsKTV != null) {
			list = dsKTV;
			loadDataToTable();
		}

	}

	private void loadDataToTable() {
		model.setRowCount(0);
		for (KTV ktv : list.getList()) {
			model.addRow(new Object[] {
					ktv.getMaKTV(),
					ktv.getTenKTV(),
					ktv.getThamNien(),
					ktv.getChuyenMon(),
					ktv.getSdt()
			});
		}
	}

	public static void main(String[] args) {
		new GUI_KTV();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnThem) {
			String ma = txtMa.getText().trim();
			String ten = txtHoTen.getText().trim();
			String strThamNien = txtThamNien.getText().trim();
			String chuyenMon = cboChuyenMon.getSelectedItem().toString();
			String sdt = txtDT.getText().trim();
			
			try {
				int thamNien = Integer.parseInt(strThamNien);
				KTV ktv = new KTV(ma, ten, thamNien, chuyenMon, sdt);
				
				if (list.themKyThuatVien(ktv)) {
					loadDataToTable();
					JOptionPane.showMessageDialog(this, 
							"Thêm Thành Công",
							"Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(this, 
							"Mã NHân viên không được trùng",
							"Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, 
						"Dữ liệu thâm niên phải là số hợp lệ",
						"Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}catch ( IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(this, 
						ex.getMessage(),
						"Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==btnLamMoi) {
			txtMa.setText("");
			txtHoTen.setText("");
			txtThamNien.setText("");
			cboChuyenMon.setSelectedIndex(0);
			txtDT.setText("");
			txtMa.requestFocus();
		}
		if(e.getSource()==btnXoa) {
			int []rows = table.getSelectedRows();
			if(rows.length==0) {
				JOptionPane.showMessageDialog(this, 
						"Vui lòng chọn nhân viên để xoá",
						"Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			int choice =JOptionPane.showConfirmDialog(this,
					"BẠN XÁC NHẬN XOÁ",
					"Xác Nhận",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			boolean kq=false;
			if(choice == JOptionPane.YES_OPTION) {
				for (int i =rows.length -1;i>=0;i--) {
					 String ma = table.getValueAt(rows[i], 0).toString();
					 KTV ktv = new KTV(ma);
					 if(list.xoaKyThuatVien(ktv))  kq= true;
				}
				if(kq) {
					JOptionPane.showMessageDialog(this, 
							"Xoá Thành Công",
							"Thông Báo",
							JOptionPane.INFORMATION_MESSAGE);
					btnLamMoi.doClick();
					loadDataToTable();
				}else {
					JOptionPane.showMessageDialog(this, 
							"Xoá Không Thành Công",
							"Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if (e.getSource()== btnLuu) {
			if(table.isEditing())
				table.getCellEditor().stopCellEditing();
			boolean ok = DataFile.saveFile(list, path);
			if (ok) {
				JOptionPane.showMessageDialog(this, 
						"Lưu Thành Công",
						"Thông Báo",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else {
				JOptionPane.showMessageDialog(this, 
						"Lưu lỗi",
						"Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(e.getSource()== btnTim) {
			String ma = txtTim.getText().toString();
			if(ma.isEmpty()) {
				JOptionPane.showMessageDialog(this, 
						"Nhập mã cần tìm",
						"Thông Báo",
						JOptionPane.ERROR_MESSAGE);
				return;}
			KTV ktv = list.timKyThuatVien(ma);
			if (ktv != null) {
				table.clearSelection();
				int index= list.getList().indexOf(ktv);
				if (index>=0) {
					table.setRowSelectionInterval(index, index);
					table.scrollRectToVisible(table.getCellRect(index, 0, true));
					loadDataToForm(index);
				}
			}
			else {
				JOptionPane.showMessageDialog(this, 
						"Không Tìm Thấy KTV",
						"Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}
}
