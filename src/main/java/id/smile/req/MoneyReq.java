package id.smile.req;


import java.math.BigDecimal;

public class MoneyReq {

    /**
     * currency
     */
    private String currency;

    /**
     * how mush to transaction
     */
    private BigDecimal amount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
