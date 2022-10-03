package model;

public class Product {
    private int id;
    private String name;
    private Double price;
    private int amount;
    private String color;
    private String description;
    private int category;
    private String nameCategory;

    public Product() {
    }

    public Product(int id, String name, Double price, int amount, String color, String description, int category, String nameCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.category = category;
        this.nameCategory = nameCategory;
    }

    public Product(String name, Double price, int amount, String color, String description, int category, String nameCategory) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.category = category;
        this.nameCategory = nameCategory;
    }

    public Product(String name, Double price, int amount, String color, String description, int category) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
