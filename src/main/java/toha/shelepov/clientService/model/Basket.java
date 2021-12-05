package toha.shelepov.clientService.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "basket")
@EntityListeners(AuditingEntityListener.class)
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "orderid")
    long orderid;

    @Column(name = "productid")
    long productid;

    @Column(name = "count")
    int count = 0;

    public long getOrderId() {
        return orderid;
    }

    public void setOrderId(long orderId) {
        this.orderid = orderId;
    }

    public long getProductId() {
        return productid;
    }

    public void setProductId(long productId) {
        this.productid = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
