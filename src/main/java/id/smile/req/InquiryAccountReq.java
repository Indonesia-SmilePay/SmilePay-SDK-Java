package id.smile.req;

public class InquiryAccountReq {

    private MerchantReq merchant;

    private String paymentMethod;

    private String accountNo;

    private String holderName;

    private String additionalInfo;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public MerchantReq getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantReq merchant) {
        this.merchant = merchant;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
