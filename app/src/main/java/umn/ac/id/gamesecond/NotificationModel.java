package umn.ac.id.gamesecond;

public class NotificationModel {
    String address, idproduct, name, phone;

   public NotificationModel() {

   }
    public NotificationModel(String address, String idproduct, String name, String phone) {
        this.address = address;
        this.idproduct = idproduct;
        this.name = name;
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
