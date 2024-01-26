package id.smile.req;


public class QrisScReq {

    private MerchantReq merchant;

    private String shopName;

    private String whatsAppNotification;

    private String additionalInfo;

    public MerchantReq getMerchant() {
        return merchant;
    }

    public void setMerchant(MerchantReq merchant) {
        this.merchant = merchant;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getWhatsAppNotification() {
        return whatsAppNotification;
    }

    public void setWhatsAppNotification(String whatsAppNotification) {
        this.whatsAppNotification = whatsAppNotification;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
