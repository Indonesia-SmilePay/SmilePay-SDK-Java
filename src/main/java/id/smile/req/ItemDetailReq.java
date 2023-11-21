package id.smile.req;

import java.math.BigDecimal;

/**
 * what is transaction
 * do not explanation
 */
public class ItemDetailReq {

    /**
     * name
     */
    private String name;

    /**
     * quantity
     */
    private Integer quantity;

    /**
     * price
     */
    private BigDecimal price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
