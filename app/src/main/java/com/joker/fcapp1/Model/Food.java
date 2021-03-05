package com.joker.fcapp1.Model;

public class Food {
    private String MenuId,Name;
    private String Price;

    public Food() {
    }

    public Food(String menuId, String name, String price) {
        MenuId = menuId;
        Name = name;
        Price = price;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
