package com.example.mealz.Models;

public class GroceryItem {
    String gid;
    String name;
    int amount;
    String unit;
    float priceByUnit;
    String sharedWith;

    public GroceryItem(){}

    public GroceryItem(String gid, String name, int amount, String unit, float priceByUnit, String sharedWith) {
        this.gid = gid;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.priceByUnit = priceByUnit;
        this.sharedWith = sharedWith;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPriceByUnit() {
        return priceByUnit;
    }

    public void setPriceByUnit(float priceByUnit) {
        this.priceByUnit = priceByUnit;
    }

    public String getSharedWith() { return sharedWith; }

    public void setSharedWith(String sharedWith) { this.sharedWith = sharedWith; }
}
