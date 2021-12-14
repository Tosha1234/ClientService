package toha.shelepov.clientService.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "orders_product")
@EntityListeners(AuditingEntityListener.class)
public class OrderPoduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "count_product")
    private int countProduct = 0;

    @Column(name = "order_id")
    private long order = 0;

    @Column(name = "product_id")
    private long product = 0;

    public int getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(int countProduct) {
        this.countProduct = countProduct;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public long getProduct() {
        return product;
    }

    public void setProduct(long product) {
        this.product = product;
    }
}
