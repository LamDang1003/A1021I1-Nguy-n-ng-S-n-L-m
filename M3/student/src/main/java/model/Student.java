package model;

public class Student {
    private int id;
    private String name;
    private int old;
    private int id_address;
    private String address;
    private String country;

    public Student() {
    }

    public Student(int id, String name, int old, int id_address, String address, String country) {
        this.id = id;
        this.name = name;
        this.old = old;
        this.id_address = id_address;
        this.address = address;
        this.country = country;
    }

    public Student(String name, int old, int id_address, String address, String country) {
        this.name = name;
        this.old = old;
        this.id_address = id_address;
        this.address = address;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public int getId_address() {
        return id_address;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
