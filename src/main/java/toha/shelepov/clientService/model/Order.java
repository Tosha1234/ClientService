package toha.shelepov.clientService.model;

import java.util.Date;


public class Order {

    private int id;
    private int numberOrder;
    private int price;
    private Date dateOfOrdering;
    private String status;

    public Order(int id, int numberOrder, int price, Date dateOfOrdering, String status) {
        this.id = id;
        this.numberOrder = numberOrder;
        this.price = price;
        this.dateOfOrdering = dateOfOrdering;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDateOfOrdering() {
        return dateOfOrdering;
    }

    public void setDateOfOrdering(Date dateOfOrdering) {
        this.dateOfOrdering = dateOfOrdering;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
