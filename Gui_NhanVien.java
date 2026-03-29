package Tu_hoc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.awt.Component;

public class Gui_NhanVien extends JFrame implements ActionListener {
	JTextField txtMa, txtHo, txtTen, txtTuoi, txtTrang, txtLuong, txtTim, txtThucNhan;
	JRadioButton radNu;
	JComboBox<String> cboPhongBan, cboTablePhongBan;
	JButton btnThem, btnXoa, btnXoaTrang, btnLuu, btnTim;
	DefaultTableModel model;
	JTable table;
	dsNhanVien list = new dsNhanVien();
	String path ="src/data/dsNV.txt";
	public Gui_NhanVien() {
		super("Trần Duy Khang");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 100, 900, 500);
		createUI();
		setVisible(true);
	}

	private void createUI() {
		JPanel pnMain = new JPanel(new BorderLayout());
		add(pnMain);

		JPanel pnNorth = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setForeground(Color.BLUE);

		pnNorth.add(lblTitle);
		pnMain.add(pnNorth, BorderLayout.NORTH);

		JPanel pnCenter = new JPanel(new BorderLayout());
		pnMain.add(pnCenter, BorderLayout.CENTER);

		JPanel pnNhap = new JPanel(new GridLayout(6, 1, 10, 10));
		pnCenter.add(pnNhap, BorderLayout.NORTH);

		JPanel pnMa = new JPanel(new BorderLayout());
		JLabel lblMa = new JLabel("Mã nhân viên:");
		lblMa.setPreferredSize(new Dimension(150, 30));
		txtMa = new JTextField("NV001");
		pnMa.add(lblMa, BorderLayout.WEST);
		pnMa.add(txtMa, BorderLayout.CENTER);
		pnNhap.add(pnMa);

		JPanel pnHoTen = new JPanel(new GridLayout(1, 2, 10, 10));
		pnNhap.add(pnHoTen);

		JPanel pnHo = new JPanel(new BorderLayout());
		JLabel lblHo = new JLabel("Họ: ");
		lblHo.setPreferredSize(new Dimension(150, 30));
		txtHo = new JTextField("Trần");
		pnHo.add(lblHo, BorderLayout.WEST);
		pnHo.add(txtHo, BorderLayout.CENTER);
		pnHoTen.add(pnHo);

		JPanel pnTen = new JPanel(new BorderLayout());
		JLabel lblTen = new JLabel("Tên: ");
		lblTen.setPreferredSize(new Dimension(150, 30));
		txtTen = new JTextField("Duy Khang");
		pnTen.add(lblTen, BorderLayout.WEST);
		pnTen.add(txtTen, BorderLayout.CENTER);
		pnHoTen.add(pnTen);

		JPanel pnTuoi = new JPanel(new BorderLayout());
		JLabel lblTuoi = new JLabel("Tuổi:");
		lblTuoi.setPreferredSize(new Dimension(150, 30));
		txtTuoi = new JTextField("20");
		pnTuoi.add(lblTuoi, BorderLayout.WEST);
		pnTuoi.add(txtTuoi, BorderLayout.CENTER);
		pnNhap.add(pnTuoi);

		// tháng + phòng ban
		JPanel pnThangPhong = new JPanel(new BorderLayout());
		pnNhap.add(pnThangPhong);

		JPanel pnThang = new JPanel(new BorderLayout());
		JLabel lblThang = new JLabel("Tháng:");
		lblThang.setPreferredSize(new Dimension(150, 30));
		txtTrang = new JTextField("15");
		pnThang.add(lblThang, BorderLayout.WEST);
		pnThang.add(txtTrang, BorderLayout.CENTER);
		pnThangPhong.add(pnThang, BorderLayout.CENTER);

		JPanel pnPhongBan = new JPanel(new BorderLayout());
		pnPhongBan.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		JLabel lblPhong = new JLabel("Phòng Ban:");
		lblPhong.setPreferredSize(new Dimension(150, 30));
		cboPhongBan = new JComboBox<String>();
		cboPhongBan.setPreferredSize(new Dimension(170, 30)); // width 250
		cboPhongBan.addItem("Nhân sự");
		cboPhongBan.addItem("Kinh doanh");
		pnPhongBan.add(lblPhong, BorderLayout.WEST);
		pnPhongBan.add(cboPhongBan, BorderLayout.CENTER);
		pnThangPhong.add(pnPhongBan, BorderLayout.EAST);

		// lương
		JPanel pnLuong = new JPanel(new BorderLayout());
		pnNhap.add(pnLuong);

		JLabel lblLuong = new JLabel("Lương nhân viên:");
		lblLuong.setPreferredSize(new Dimension(150, 30));
		txtLuong = new JTextField("10000");

		JPanel pnPhai = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPhai = new JLabel("Phái: ");
		radNu = new JRadioButton("Nữ");
		pnPhai.add(lblPhai);
		pnPhai.add(radNu);

		JPanel pnLuongCenter = new JPanel(new BorderLayout());
		pnLuongCenter.add(txtLuong, BorderLayout.CENTER);
		pnLuongCenter.add(pnPhai, BorderLayout.EAST);
		
		pnLuong.add(lblLuong, BorderLayout.WEST);
		pnLuong.add(pnLuongCenter, BorderLayout.CENTER);
		pnNhap.add(pnLuong);
		// thực nhận
		JPanel pnThucNhan = new JPanel(new BorderLayout());
		pnNhap.add(pnThucNhan);

		JLabel lblThucNhan = new JLabel("Thực Nhận:");
		lblThucNhan.setPreferredSize(new Dimension(150, 30));
		txtThucNhan = new JTextField();
		txtThucNhan.setEditable(false);
		pnThucNhan.add(lblThucNhan, BorderLayout.WEST);
		pnThucNhan.add(txtThucNhan, BorderLayout.CENTER);
		pnNhap.add(pnThucNhan);

		// Sự kiện lắng nghe sự thay đổi văn bản để tính Thực Nhận ngay lập tức
		DocumentListener docListener = new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				tinhThucNhan();
			}

			public void removeUpdate(DocumentEvent e) {
				tinhThucNhan();
			}

			public void insertUpdate(DocumentEvent e) {
				tinhThucNhan();
			}
		};
		txtTrang.getDocument().addDocumentListener(docListener);
		txtLuong.getDocument().addDocumentListener(docListener);
		tinhThucNhan(); 

		pnNhap.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		// table

		JPanel pnTable = new JPanel(new BorderLayout());
		pnCenter.add(pnTable, BorderLayout.CENTER);

		model = new DefaultTableModel(new String[] {
				"Mã", "Họ", "Tên", "Tuổi", "Phái", "Tháng", "Phong Ban", "Lương", "Thực Nhận"
		}, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// Khóa cột 0 (Mã) và cột 8 (Thực Nhận) không cho sửa trực tiếp trên bảng
				return column != 0 && column != 8;
			}
		};

		table = new JTable(model);
		// định dạng số tiền
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
			DecimalFormat df = new DecimalFormat("#,##0 $");

			@Override
			protected void setValue(Object value) {
				try {
					super.setValue(df.format(Double.parseDouble(value.toString())));
				} catch (Exception e) {
					super.setValue(value);
				}
			}
		};
		renderer.setHorizontalAlignment(JLabel.RIGHT); // Chỉnh qua góc phải
		table.getColumnModel().getColumn(7).setCellRenderer(renderer);
		table.getColumnModel().getColumn(8).setCellRenderer(renderer);

		JScrollPane srcoll = new JScrollPane(table);
		pnTable.add(srcoll, BorderLayout.CENTER);
		// combobox

		JComboBox<String> cboPhai = new JComboBox<String>();
		cboPhai.addItem("Nữ");
		cboPhai.addItem("Nam");
		table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(cboPhai));

		cboTablePhongBan = new JComboBox<String>();
		cboTablePhongBan.addItem("Nhân sự");
		cboTablePhongBan.addItem("Kinh doanh");

		table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(cboTablePhongBan));

		// Nút
		JPanel pnSouth = new JPanel(new GridLayout(1, 2));
		pnMain.add(pnSouth, BorderLayout.SOUTH);

		JPanel pnTim = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnTim.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel lblTim = new JLabel("Nhập mã số cần tìm:");
		txtTim = new JTextField();
		txtTim.setPreferredSize(new Dimension(120, 30));
		btnTim = new JButton("Tìm");
		pnTim.add(lblTim);
		pnTim.add(txtTim);
		pnTim.add(btnTim);

		pnSouth.add(pnTim);

		JPanel pnButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");
		pnButton.add(btnThem);
		pnButton.add(btnXoaTrang);
		pnButton.add(btnXoa);
		pnButton.add(btnLuu);
		pnSouth.add(pnButton);

		loadDataFromFile();

		table.getSelectionModel().addListSelectionListener(e -> {
			if (e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				if (row >= 0)
					loadDataToForm(row);
			}
		});

		// Sự kiện lắng nghe sự thay đổi dữ liệu trực tiếp trong các Ô của Bảng
		model.addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					int row = e.getFirstRow();
					int col = e.getColumn();
					
					if (row >= 0 && col >= 0) {
						try {
							String ma = model.getValueAt(row, 0).toString();
							NhanVien nv = list.timNhanVien(ma);
							if (nv != null) {
								if (col == 1)
									nv.setHoNV(model.getValueAt(row, col).toString());
								else if (col == 2)
									nv.setTenNV(model.getValueAt(row, col).toString());
								else if (col == 3)
									nv.setTuoi(Integer.parseInt(model.getValueAt(row, col).toString()));
								else if (col == 4)
									nv.setPhai(model.getValueAt(row, col).toString().equals("Nữ"));
								else if (col == 5) {
									nv.setThang(Integer.parseInt(model.getValueAt(row, col).toString()));
									model.setValueAt(nv.getThang() * nv.getLuong(), row, 8);
								} else if (col == 6)
									nv.setPhongBan(model.getValueAt(row, col).toString());
								else if (col == 7) {
									nv.setLuong(Double.parseDouble(model.getValueAt(row, col).toString()));
									model.setValueAt(nv.getThang() * nv.getLuong(), row, 8);
								}
							}
						} catch (Exception ex) {
							String loi = ex.getMessage();
							if (ex instanceof NumberFormatException) {
								loi = "Dữ liệu nhập vào phải là số hợp lệ!";
							}
							JOptionPane.showMessageDialog(Gui_NhanVien.this, loi, "Lỗi", JOptionPane.ERROR_MESSAGE);
							
							// Trả lại giá trị cũ lên Table
							String ma = model.getValueAt(row, 0).toString();
							NhanVien nv = list.timNhanVien(ma);
							if (nv != null) {
								if (col == 1) model.setValueAt(nv.getHoNV(), row, col);
								else if (col == 2) model.setValueAt(nv.getTenNV(), row, col);
								else if (col == 3) model.setValueAt(nv.getTuoi(), row, col);
								else if (col == 4) model.setValueAt(nv.isPhai() ? "Nữ" : "Nam", row, col);
								else if (col == 5) model.setValueAt(nv.getThang(), row, col);
								else if (col == 6) model.setValueAt(nv.getPhongBan(), row, col);
								else if (col == 7) model.setValueAt(nv.getLuong(), row, col);
							}
						}
					}
					int selectedRow = table.getSelectedRow();
					if (selectedRow >= 0 && selectedRow == e.getFirstRow()) {
						loadDataToForm(selectedRow);
					}
				}
			}
		});

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTim.addActionListener(this);

	}

	private void loadDataFromFile() {
		// TODO Auto-generated method stub
		dsNhanVien dsNV = DataFile.loadFile(path);
		if (dsNV != null) {
			list = dsNV;
			loadDataToTable();
		}

	}

	private void loadDataToTable() {
		model.setRowCount(0);
		for (Tu_hoc.NhanVien nv : list.getList()) {
			model.addRow(new Object[] {
					nv.getMaNV(),
					nv.getHoNV(),
					nv.getTenNV(),
					nv.getTuoi(),
					nv.isPhai() ? "Nữ" : "Nam",
					nv.getThang(),
					nv.getPhongBan(),
					nv.getLuong(),
					nv.getThang() * nv.getLuong()
			});
		}
	}

	private void loadDataToForm(int row) {
		txtMa.setText(model.getValueAt(row, 0).toString());
		txtHo.setText(model.getValueAt(row, 1).toString());
		txtTen.setText(model.getValueAt(row, 2).toString());
		txtTuoi.setText(model.getValueAt(row, 3).toString());
		radNu.setSelected(model.getValueAt(row, 4).toString().equals("Nữ"));
		txtTrang.setText(model.getValueAt(row, 5).toString());
		cboPhongBan.setSelectedItem(model.getValueAt(row, 6).toString());
		txtLuong.setText(model.getValueAt(row, 7).toString());

	}

	// Hàm tự động tính thực nhận dựa theo số liệu mới nhất
	private void tinhThucNhan() {
		try {
			int thang = Integer.parseInt(txtTrang.getText().trim());
			double luong = Double.parseDouble(txtLuong.getText().trim());
			txtThucNhan.setText(new DecimalFormat("#,##0 $").format(thang * luong));
		} catch (Exception e) {
			txtThucNhan.setText(""); // Nếu lỗi thì tạm xóa ô Thực Nhận
		}
	}

	public static void main(String[] args) {
		new Gui_NhanVien();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnThem) {
			String ma = txtMa.getText().trim();
			String ho = txtHo.getText().trim();
			String ten = txtTen.getText().trim();
			String tuoiStr = txtTuoi.getText().trim();
			boolean phai = radNu.isSelected();
			String thang = txtTrang.getText().trim();
			String phongBan = cboPhongBan.getSelectedItem().toString();
			String luong = txtLuong.getText().trim();

			try {
				int tuoiInt = Integer.parseInt(tuoiStr);
				int thangInt = Integer.parseInt(thang);
				double luongDouble = Double.parseDouble(luong);
				
				NhanVien nv = new NhanVien(ma, ho, ten, tuoiInt, phai, phongBan, thangInt, luongDouble);
				
				if (list.themNhanVien(nv)) {
					loadDataToTable();
					JOptionPane.showMessageDialog(this,
							"Thêm thành công",
							"Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(this,
							"Mã nhân viên không được trùng",
							"Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Dữ liệu Tuổi, Tháng và Lương phải là số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			} catch (IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == btnXoaTrang) {
			txtMa.setText("");
			txtHo.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			radNu.setSelected(false);
			txtTrang.setText("");
			txtLuong.setText("");
		}
		if (e.getSource() == btnLuu) {
			boolean ok = DataFile.saveFile(list, path);
			if (ok) {
				JOptionPane.showMessageDialog(
						this,
						"Lưu thành công",
						"Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				return;
			} else {
				JOptionPane.showMessageDialog(
						this,
						"Lưu thất bại",
						"Thông báo",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (e.getSource() == btnXoa) {
			int[] rows = table.getSelectedRows();
			if (rows.length == 0) {
				JOptionPane.showMessageDialog(
						this,
						"Vui lòng chọn dòng để xoá",
						"Thông báo",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			int choice = JOptionPane.showConfirmDialog(
					this,
					"Bạn xác nhận xoá?",
					"Xác Nhận",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			boolean kq = false;
			if (choice == JOptionPane.YES_OPTION) {
				for (int i = rows.length - 1; i >= 0; i--) {
					String ma = table.getValueAt(rows[i], 0).toString();
					NhanVien nv = list.timNhanVien(ma);
					if (list.xoaNhanVien(nv))
						kq = true;
				}
				if (kq) {
					JOptionPane.showMessageDialog(
							this,
							"Xoá thành công",
							"Thông Báo",
							JOptionPane.INFORMATION_MESSAGE);
					loadDataToTable();
					return;
				}
			}
		}
		if (e.getSource() == btnTim) {
			String tim = txtTim.getText().toString();
			if (tim.isEmpty()) {
				JOptionPane.showMessageDialog(
						this,
						"Nhập mã muốn tìm",
						"Thông Báo",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			NhanVien nv = list.timNhanVien(tim);
			if (nv != null) {
				// model.setRowCount(0);
				// model.addRow(new Object[] {
				// nv.getMaNV(),
				// nv.getHoNV(),
				// nv.getTenNV(),
				// nv.getThang(),
				// nv.getPhongBan(),
				// nv.getLuong(),
				// nv.getThang() * nv.getLuong()

				// });
				table.clearSelection();
				int index = list.getList().indexOf(nv);
				if (index >= 0) {
					table.setRowSelectionInterval(index, index);
					table.scrollRectToVisible(table.getCellRect(index, 0, true));
					loadDataToForm(index);
				}
			} else {
				JOptionPane.showMessageDialog(
						this,
						"Không tìm thấy nhân viên",
						"Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}
}
