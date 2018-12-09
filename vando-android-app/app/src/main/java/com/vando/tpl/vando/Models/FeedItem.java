package com.vando.tpl.vando.Models;

public class FeedItem {
    private String itemName;
    private String quantity;
    private String contactNumb;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    private String dateTime;

    public FeedItem(String itemName, String quantity, String contactNumb, String imgUrl, String dateTime, double distance) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.contactNumb = contactNumb;
        this.imgUrl = imgUrl;
        this.dateTime = dateTime;
        this.distance = distance;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private String imgUrl;
    private double distance;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getContactNumb() {
        return contactNumb;
    }

    public void setContactNumb(String contactNumb) {
        this.contactNumb = contactNumb;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}
