package id.smile.req;

public class InquiryPaymentMethodReq {

    private MerchantReq merchant;

    private String additionalInfo;

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
