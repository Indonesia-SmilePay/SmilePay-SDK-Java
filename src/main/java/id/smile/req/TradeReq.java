package id.smile.req;


import java.util.List;

public class TradeReq {

    /**
     * Merchant platform order number
     */
    private String orderNo;

    /**
     * purpose
     */
    private String purpose;

    /**
     * Product details
     */
    private String productDetail;

    /**
     * Add extension information: in addition to the purpose, other descriptions
     */
    private String additionalParam;

    /**
     * Transaction details
     */
    private List<ItemDetailReq> itemDetailList;

    /**
     * Billing address
     */
    private AddressReq billingAddress;

    /**
     * Shipping address
     */
    private AddressReq shippingAddress;

    /**
     * money information
     */
    private MoneyReq money;

    /**
     * Merchant information
     */
    private MerchantReq merchant;

    /**
     * Callback address
     */
    private String callbackUrl;

    /**
     * Redirect address
     */
    private String redirectUrl;

    /**
     * area
     */
    private Integer area;



    //----------------------------------

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getAdditionalParam() {
        return additionalParam;
    }

    public void setAdditionalParam(String additionalParam) {
        this.additionalParam = additionalParam;
    }

    public List<ItemDetailReq> getItemDetailList() {
        return itemDetailList;
    }

    public void setItemDetailList(List<ItemDetailReq> itemDetailList) {
        this.itemDetailList = itemDetailList;
    }

    public AddressReq getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressReq billingAddress) {
        this.billingAddress = billingAddress;
    }

    public AddressReq getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(AddressReq shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public MoneyReq getMoney() {
        return money;
    }

    public void setMoney(MoneyReq money) {
        this.money = money;
    }

    public MerchantReq getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantReq merchant) {
        this.merchant = merchant;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
