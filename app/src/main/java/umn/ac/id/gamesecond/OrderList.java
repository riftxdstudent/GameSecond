package umn.ac.id.gamesecond;

public class OrderList {
    private String Name, Phone, Address, IDProduct;

    public OrderList(){}

    public OrderList(String name, String phone, String address, String idproduct) {
        Name = name;
        Phone = phone;
        Address = address;
        IDProduct = idproduct;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
    public String getIDProduct() {
        return IDProduct;
    }

    public void setIDProduct(String idproduct) {
        IDProduct = idproduct;
    }
}
