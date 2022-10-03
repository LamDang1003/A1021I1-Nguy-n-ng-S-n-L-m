package model;


public class Customer {
    private int id;
    private String name;
    private int old;
    private int nPhone;
    private String email;
    private String address;
    private int category;
    private String categoryName;

    public Customer() {
    }

    public int getnPhone() {
        return nPhone;
    }

    public void setnPhone(int nPhone) {
        this.nPhone = nPhone;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Customer(int id, String name, int old, int nPhone, String email, String address, int category, String categoryName) {
        this.id = id;
        this.name = name;
        this.old = old;
        this.nPhone = nPhone;
        this.email = email;
        this.address = address;
        this.category = category;
        this.categoryName = categoryName;
    }

    public Customer(String name, int old, int nPhone, String email, String address, int category) {
        this.name = name;
        this.old = old;
        this.nPhone = nPhone;
        this.email = email;
        this.address = address;
        this.category = category;
    }


    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}