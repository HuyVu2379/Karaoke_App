package view;

import com.opencsv.exceptions.CsvValidationException;
import dao.Impl.NhanVienDaoImpl;
import dao.NhanVienDAO;
import entity.NhanVien;
import enums.TrangThaiNhanVien;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;

public class GD_QuanLyNhanVien extends JPanel implements ActionListener {

    private List<NhanVien> list = null;
    private NhanVienDAO daoNV;
    private JPanel PaneThongTinText;
    private Box BoxVerticalThongTin, BoxMaAndSDT, BoxTenAndEmail, horizontalBox_6, horizontalBox_7;
    private JTextField txtMaNhanVien, txtSDT, txtTenNhanVien, txtEmail, txtDiaChi, txtTuKhoaTimKiem;
    private JComboBox cbTrangThai;
    private JButton btnCapNhat, btnXoaTrang, btnTimKiem;
    private JPanel PaneTVandDanhSach, PaneTacVu_1;
    private Box verticalBox_1, horizontalBox_1;
    private JComboBox cbTuKhoa;
    private JTable table;
    private DefaultTableModel modelTable;
    private JScrollPane scrollPane;
    private Component horizontalStrut;
    private JButton btnThemNhieu;
    private JButton btnThem;

    public GD_QuanLyNhanVien() throws RemoteException {
        setSize(1000, 700);
        daoNV = new NhanVienDaoImpl();
        setLayout(new BorderLayout());

        JPanel TitlePanel = new JPanel();
        TitlePanel.setBackground(new Color(97, 250, 204));
        add(TitlePanel, BorderLayout.NORTH);
        TitlePanel.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lbTitle = new JLabel("Quản lý nhân viên");
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
        TitlePanel.add(lbTitle);

        JPanel PaneThongTin = new JPanel();
        PaneThongTin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Nh\u1EADp th\u00F4ng tin",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        add(PaneThongTin, BorderLayout.CENTER);
        PaneThongTin.setLayout(new BorderLayout(0, 0));

        PaneThongTinText = new JPanel();
        PaneThongTin.add(PaneThongTinText, BorderLayout.CENTER);
        PaneThongTinText.setLayout(new BoxLayout(PaneThongTinText, BoxLayout.X_AXIS));

        PaneThongTinText.add(Box.createHorizontalStrut(20));

        BoxVerticalThongTin = Box.createVerticalBox();
        PaneThongTinText.add(BoxVerticalThongTin);

        BoxVerticalThongTin.add(Box.createVerticalStrut(20));

        BoxMaAndSDT = Box.createHorizontalBox();
        BoxVerticalThongTin.add(BoxMaAndSDT);

        JLabel lbMaNhanVien = new JLabel("Mã nhân viên:");
        lbMaNhanVien.setPreferredSize(new Dimension(110, 30));
        lbMaNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
        BoxMaAndSDT.add(lbMaNhanVien);

        txtMaNhanVien = new JTextField();
        lbMaNhanVien.setLabelFor(txtMaNhanVien);
        BoxMaAndSDT.add(txtMaNhanVien);
        txtMaNhanVien.setColumns(10);

        BoxMaAndSDT.add(Box.createHorizontalStrut(20));

        JLabel lbSDT = new JLabel("Số điện thoại:");
        lbSDT.setPreferredSize(new Dimension(100, 30));
        lbSDT.setFont(new Font("Tahoma", Font.BOLD, 14));
        BoxMaAndSDT.add(lbSDT);

        txtSDT = new JTextField();
        lbSDT.setLabelFor(txtSDT);
        BoxMaAndSDT.add(txtSDT);
        txtSDT.setColumns(10);

        BoxVerticalThongTin.add(Box.createVerticalStrut(20));

        BoxTenAndEmail = Box.createHorizontalBox();
        BoxVerticalThongTin.add(BoxTenAndEmail);

        JLabel lbTenNhanVien = new JLabel("Tên nhân viên:");
        lbTenNhanVien.setPreferredSize(new Dimension(110, 30));
        lbTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 14));
        BoxTenAndEmail.add(lbTenNhanVien);

        txtTenNhanVien = new JTextField();
        lbTenNhanVien.setLabelFor(txtTenNhanVien);
        BoxTenAndEmail.add(txtTenNhanVien);
        txtTenNhanVien.setColumns(10);

        BoxTenAndEmail.add(Box.createHorizontalStrut(20));

        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setPreferredSize(new Dimension(100, 30));
        lbEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
        BoxTenAndEmail.add(lbEmail);

        txtEmail = new JTextField();
        lbEmail.setLabelFor(txtEmail);
        BoxTenAndEmail.add(txtEmail);
        txtEmail.setColumns(10);

        BoxVerticalThongTin.add(Box.createVerticalStrut(20));

        horizontalBox_6 = Box.createHorizontalBox();
        BoxVerticalThongTin.add(horizontalBox_6);

        JLabel lbDiaChi = new JLabel("Địa chỉ:");
        lbDiaChi.setPreferredSize(new Dimension(110, 30));
        lbDiaChi.setFont(new Font("Tahoma", Font.BOLD, 14));
        horizontalBox_6.add(lbDiaChi);

        txtDiaChi = new JTextField();
        lbDiaChi.setLabelFor(txtDiaChi);
        horizontalBox_6.add(txtDiaChi);
        txtDiaChi.setColumns(10);

        horizontalBox_6.add(Box.createHorizontalStrut(20));

        JLabel lblTrangThai = new JLabel("Trạng thái:");
        lblTrangThai.setPreferredSize(new Dimension(90, 30));
        lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 14));
        horizontalBox_6.add(lblTrangThai);

        cbTrangThai = new JComboBox<TrangThaiNhanVien>();
        cbTrangThai.setModel(new DefaultComboBoxModel());
        lblTrangThai.setLabelFor(cbTrangThai);
        horizontalBox_6.add(cbTrangThai);

        BoxVerticalThongTin.add(Box.createVerticalStrut(20));

        horizontalBox_7 = Box.createHorizontalBox();
        horizontalBox_7.setSize(new Dimension(0, 21));
        BoxVerticalThongTin.add(horizontalBox_7);

        btnThemNhieu = new JButton("Thêm file excel");
        btnThemNhieu.setBackground(new Color(107, 208, 107));
        btnThemNhieu.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnThemNhieu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        horizontalBox_7.add(btnThemNhieu);

        horizontalStrut = Box.createHorizontalStrut(20);
        horizontalBox_7.add(horizontalStrut);
        
        btnThem = new JButton("Thêm");
        btnThem.setPreferredSize(new Dimension(80, 0));
        btnThem.setMaximumSize(new Dimension(80, 21));
        btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnThem.setBackground(new Color(107, 208, 107));
        horizontalBox_7.add(btnThem);
        
                Component horizontalStrut_2 = Box.createHorizontalStrut(20);
                horizontalBox_7.add(horizontalStrut_2);

        btnXoaTrang = new JButton("Xóa trắng");
        btnXoaTrang.setPreferredSize(new Dimension(120, 0));
        btnXoaTrang.setMaximumSize(new Dimension(150, 21));
        btnXoaTrang.setIcon(new ImageIcon("src\\main\\resources\\image\\icon\\clear_icon.png"));
        btnXoaTrang.setBackground(new Color(107, 208, 107));
        btnXoaTrang.setFont(new Font("Tahoma", Font.BOLD, 14));
        horizontalBox_7.add(btnXoaTrang);
                
                        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
                        horizontalBox_7.add(horizontalStrut_1);
        
                btnCapNhat = new JButton("Cập nhật");
                btnCapNhat.setPreferredSize(new Dimension(120, 0));
                btnCapNhat.setMaximumSize(new Dimension(100, 21));
                btnCapNhat.setIcon(new ImageIcon("src\\main\\resources\\image\\icon\\update_icon.png"));
                btnCapNhat.setBackground(new Color(107, 208, 107));
                btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 14));
                horizontalBox_7.add(btnCapNhat);
                btnCapNhat.addActionListener(this);

        BoxVerticalThongTin.add(Box.createVerticalStrut(20));

        PaneThongTinText.add(Box.createHorizontalStrut(20));

        PaneTVandDanhSach = new JPanel();
        add(PaneTVandDanhSach, BorderLayout.SOUTH);
        PaneTVandDanhSach.setLayout(new BorderLayout(0, 10));

        PaneTacVu_1 = new JPanel();
        PaneTacVu_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ch\u1ECDn t\u00E1c v\u1EE5",
                TitledBorder.LEADING, TitledBorder.TOP, null, null));
        PaneTVandDanhSach.add(PaneTacVu_1, BorderLayout.NORTH);
        PaneTacVu_1.setLayout(new BoxLayout(PaneTacVu_1, BoxLayout.X_AXIS));

        verticalBox_1 = Box.createVerticalBox();
        PaneTacVu_1.add(verticalBox_1);

        verticalBox_1.add(Box.createVerticalStrut(20));

        horizontalBox_1 = Box.createHorizontalBox();
        verticalBox_1.add(horizontalBox_1);

        horizontalBox_1.add(Box.createHorizontalStrut(20));

        JLabel lbChonTuKhoa = new JLabel("Chọn từ khóa:");
        lbChonTuKhoa.setPreferredSize(new Dimension(115, 30));
        lbChonTuKhoa.setFont(new Font("Tahoma", Font.BOLD, 14));
        horizontalBox_1.add(lbChonTuKhoa);

        cbTuKhoa = new JComboBox();
        cbTuKhoa.setModel(new DefaultComboBoxModel(new String[]{"Tất cả", "Mã nhân viên", "Tên nhân viên", "Chức vụ",
                "Số điện thoại", "Email", "Địa chỉ"}));
        horizontalBox_1.add(cbTuKhoa);

        horizontalBox_1.add(Box.createHorizontalStrut(20));

        JLabel lbTuKhoaTimKiem = new JLabel("Từ khóa cần tìm:  ");
        lbTuKhoaTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
        horizontalBox_1.add(lbTuKhoaTimKiem);

        txtTuKhoaTimKiem = new JTextField();
        txtTuKhoaTimKiem.setColumns(10);
        horizontalBox_1.add(txtTuKhoaTimKiem);

        horizontalBox_1.add(Box.createHorizontalStrut(20));

        btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setSize(new Dimension(80, 21));
        btnTimKiem.setPreferredSize(new Dimension(110, 21));
        btnTimKiem.setMaximumSize(new Dimension(100, 21));
        btnTimKiem.setIcon(new ImageIcon("src\\main\\resources\\image\\icon\\search_icon.png"));
        btnTimKiem.setBackground(new Color(107, 208, 107));
        btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
        horizontalBox_1.add(btnTimKiem);

        horizontalBox_1.add(Box.createHorizontalStrut(20));

        verticalBox_1.add(Box.createVerticalStrut(20));

        String row[] = {"Mã nhân viên", "Tên nhân viên", "Chức vụ", "Số điện thoại", "Email", "Địa chỉ",
                "Trạng thái"};
        modelTable = new DefaultTableModel(row, 0);
        table = new JTable(modelTable);
        scrollPane = new JScrollPane(table);
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        PaneTVandDanhSach.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setPreferredSize(new Dimension(200, 300));

        loadData();
        loadcomboBoxTrangThai();
        btnXoaTrang.addActionListener(this);
        btnTimKiem.addActionListener(this);
        btnThemNhieu.addActionListener(this);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                txtMaNhanVien.setText(table.getValueAt(row, 0).toString());
                txtTenNhanVien.setText(table.getValueAt(row, 1).toString());
                txtSDT.setText(table.getValueAt(row, 3).toString());
                txtEmail.setText(table.getValueAt(row, 4).toString());
                txtDiaChi.setText(table.getValueAt(row, 5).toString());
                String ttnv = table.getValueAt(row, 6).toString();
                if (ttnv.trim().equals(TrangThaiNhanVien.VO_HIEU.toString())) {
                    cbTrangThai.setSelectedItem(TrangThaiNhanVien.VO_HIEU);
                } else {
                    cbTrangThai.setSelectedItem(TrangThaiNhanVien.HIEU_LUC);
                }
            }
        });

        cbTuKhoa.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (cbTuKhoa.getSelectedIndex() == 0) {
                        txtTuKhoaTimKiem.setText("");
                        txtTuKhoaTimKiem.setEnabled(false);
                        try {
                            loadData();
                        } catch (RemoteException ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (cbTuKhoa.getSelectedIndex() == 1) {
                        txtTuKhoaTimKiem.setEnabled(true);
                        txtTuKhoaTimKiem.setText("");
                        txtTuKhoaTimKiem.requestFocus();
                    } else if (cbTuKhoa.getSelectedIndex() == 2) {
                        txtTuKhoaTimKiem.setEnabled(true);
                        txtTuKhoaTimKiem.setText("");
                        txtTuKhoaTimKiem.requestFocus();
                    } else if (cbTuKhoa.getSelectedIndex() == 3) {
                        txtTuKhoaTimKiem.setEnabled(true);
                        txtTuKhoaTimKiem.setText("");
                        txtTuKhoaTimKiem.requestFocus();
                    } else if (cbTuKhoa.getSelectedIndex() == 4) {
                        txtTuKhoaTimKiem.setEnabled(true);
                        txtTuKhoaTimKiem.setText("");
                        txtTuKhoaTimKiem.requestFocus();
                    } else if (cbTuKhoa.getSelectedIndex() == 5) {
                        txtTuKhoaTimKiem.setEnabled(true);
                        txtTuKhoaTimKiem.setText("");
                        txtTuKhoaTimKiem.requestFocus();
                    } else if (cbTuKhoa.getSelectedIndex() == 6) {
                        txtTuKhoaTimKiem.setEnabled(true);
                        txtTuKhoaTimKiem.setText("");
                        txtTuKhoaTimKiem.requestFocus();
                    } else if (cbTuKhoa.getSelectedIndex() == 7) {
                        txtTuKhoaTimKiem.setEnabled(true);
                        txtTuKhoaTimKiem.setText("");
                        txtTuKhoaTimKiem.requestFocus();
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnXoaTrang)) {
            xoaTrang();
        } else if (o.equals(btnThem)) {
            try {
                chucNangThem();
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        } else if (o.equals(btnCapNhat)) {
            try {
                chucNangCapNhat();
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        } else if (o.equals(btnTimKiem)) {
            chucNangTimKiem();
        } else if (o.equals(btnThemNhieu)) {
            try {
                String path = NutChonAnh();
                List<NhanVien> list = daoNV.pushFileExcel(path);
                addToDBFromCsv(list);
            } catch (IOException | CsvValidationException ex) {
                throw new RuntimeException(ex);
            }
            try {
                loadData();
            } catch (RemoteException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void loadData() throws RemoteException {
        list = daoNV.getAllNhanVien();
        modelTable.setRowCount(0);
        for (NhanVien nhanVien : list) {
            String[] s = {nhanVien.getMaNhanVien(), nhanVien.getTen(), nhanVien.getChucVu(), nhanVien.getSdt(),
                    nhanVien.getEmail(), nhanVien.getDiaChi(), nhanVien.getTrangThai().toString()};
            modelTable.addRow(s);
        }
    }

    public void loadDataFind() throws RemoteException {
        String tuKhoa = txtTuKhoaTimKiem.getText();
        String s = cbTuKhoa.getSelectedItem().toString();
        if (s.equals("Tất cả")) {
            list = daoNV.TimKiemTatCa(tuKhoa);
        } else if (s.equals("Mã nhân viên")) {
            list = daoNV.getNhanVienTheoMa(tuKhoa);
        } else if (s.equals("Tên nhân viên")) {
            list = daoNV.getNhanVienTheoTen(tuKhoa);
        } else if (s.equals("Chức vụ")) {
            list = daoNV.getNhanVienTheoChucVu(tuKhoa);
        } else if (s.equals("Số điện thoại")) {
            list = daoNV.getNhanVienTheoSDT(tuKhoa);
        } else if (s.equals("Email")) {
            list = daoNV.getNhanVienTheoEmail(tuKhoa);
        } else if (s.equals("Địa chỉ")) {
            list = daoNV.getNhanVienTheoDiaChi(tuKhoa);
        }
        modelTable.setRowCount(0);
        for (NhanVien nhanVien : list) {
            String[] s1 = {nhanVien.getMaNhanVien(), nhanVien.getTen(), nhanVien.getChucVu(), nhanVien.getSdt(),
                    nhanVien.getEmail(), nhanVien.getDiaChi(), nhanVien.getTrangThai().toString()};
            modelTable.addRow(s1);
        }
    }

    public void xoaTrang() {
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        txtTenNhanVien.setText("");
        txtTuKhoaTimKiem.setText("");
    }

    public void chucNangThem() throws RemoteException {
        NhanVien nhanVien = createNhanVien();
        if (nhanVien != null) {
            String[] s = {nhanVien.getMaNhanVien(), nhanVien.getTen(), nhanVien.getChucVu(), nhanVien.getSdt(),
                    nhanVien.getEmail(), nhanVien.getDiaChi(), nhanVien.getTrangThai().toString()};
            modelTable.addRow(s);
            daoNV.createNhanVien(nhanVien);
        }
    }

    public void chucNangCapNhat() throws RemoteException {
        NhanVien nv = createNhanVien();
        if (nv != null) {
            daoNV.updateNhanVien(nv, nv.getMaNhanVien());
            loadData();
        }
    }

    public void chucNangTimKiem() {
        try {
            loadDataFind();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public NhanVien createNhanVien() {
        if (txtMaNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập vào mã nhân viên", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        } else if (txtTenNhanVien.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập vào tên nhân viên", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        } else if (txtSDT.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập số điện thoại nhân viên", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        } else if (txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập vào email nhân viên", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        } else if (txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hãy nhập vào địa chỉ nhân viên", "Thông báo",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }
        return new NhanVien(txtMaNhanVien.getText(), txtTenNhanVien.getText(), "Nhân viên", txtSDT.getText(),
                txtEmail.getText(), txtDiaChi.getText(), (TrangThaiNhanVien) cbTrangThai.getSelectedItem());
    }

    public void loadcomboBoxTrangThai() {
        cbTrangThai.addItem(TrangThaiNhanVien.HIEU_LUC);
        cbTrangThai.addItem(TrangThaiNhanVien.VO_HIEU);
    }

    public String NutChonAnh() {
        JFileChooser f = new JFileChooser();
        f.setDialogTitle("Mở file");
        f.showOpenDialog(null);
        File fileAnh = f.getSelectedFile();
        String strAnh = fileAnh.getAbsolutePath();
        return strAnh;
    }
    public void addToDBFromCsv(List<NhanVien> list){
        for (NhanVien nhanVien : list) {
            try {
                daoNV.createNhanVien(nhanVien);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}