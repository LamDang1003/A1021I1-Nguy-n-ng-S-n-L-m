package model;

public class Category {
    private int idCategory;
    private String nameCategory;
    private String note;

    public Category() {
    }

    public Category(int idCategory, String nameCategory, String note) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.note = note;
    }

    public Category(String nameCategory, String note) {
        this.nameCategory = nameCategory;
        this.note = note;
    }


    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
