package model;

public class Khach_hang {
    protected int id;
    protected String name;
    protected String email;
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.tuoi = tuoi;
        this.hinh_thuc = hinh_thuc;
        this.id_hinh_thuc = id_hinh_thuc;
        this.ten_hinh_thuc = ten_hinh_thuc;
        this.ghi_chu = ghi_chu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getHinh_thuc() {
        return hinh_thuc;
    }

    public void setHinh_thuc(int hinh_thuc) {
        this.hinh_thuc = hinh_thuc;
    }

    public int getId_hinh_thuc() {
        return id_hinh_thuc;
    }

    public void setId_hinh_thuc(int id_hinh_thuc) {
        this.id_hinh_thuc = id_hinh_thuc;
    }

    public String getTen_hinh_thuc() {
        return ten_hinh_thuc;
    }

    public void setTen_hinh_thuc(String ten_hinh_thuc) {
        this.ten_hinh_thuc = ten_hinh_thuc;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }
}
