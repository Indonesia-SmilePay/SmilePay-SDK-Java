package id.smile.req;


public class MerchantReq {

    /**
     * merchantID
     */
    private String merchantId;

    /**
     * merchantName
     */
    private String merchantName;

    /**
     * SmilePay accountNo
     */
    private String accountNo;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
