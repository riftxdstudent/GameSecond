package umn.ac.id.gamesecond;

import android.widget.ImageView;

public class DeleteDataModel {
    String Name, Detail, Price, Img;

    public DeleteDataModel() {
    }

    public DeleteDataModel(String name, String detail, String price, String img) {
        Name = name;
        Detail = detail;
        Price = price;
        Img = img;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }
}
