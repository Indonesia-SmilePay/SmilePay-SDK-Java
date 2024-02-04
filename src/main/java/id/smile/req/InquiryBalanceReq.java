package id.smile.req;

import java.util.List;

public class InquiryBalanceReq {

    private String accountNo;

    private List<String> balanceTypes;

    private String additionalInfo;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public List<String> getBalanceTypes() {
        return balanceTypes;
    }

    public void setBalanceTypes(List<String> balanceTypes) {
        this.balanceTypes = balanceTypes;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
