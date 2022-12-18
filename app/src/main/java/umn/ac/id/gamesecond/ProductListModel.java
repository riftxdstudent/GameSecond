package umn.ac.id.gamesecond;

public class ProductListModel {
    String Detail, Name, Price, Img;

    public ProductListModel() {
    }

    public ProductListModel (String Detail, String Name, String Price, String Img) {
        this.Detail = Detail;
        this.Name = Name;
        this.Price = Price;
        this.Img = Img;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
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

    public String getImg() {
        return Img;
    }

    public void setPurl(String img) {
        Img = img;
    }
}
