package id.smile.data;


public enum AreaEnum {

    INDONESIA(10, CurrencyEnum.IDR, 62),
    THAILAND(11, CurrencyEnum.THB, 66),
    INDIA(12, CurrencyEnum.INR, 91),
    BRAZIL(13, CurrencyEnum.BRL, 55);

    private final Integer code;
    private final CurrencyEnum currency;
    private final Integer countryId;


    AreaEnum(int code, CurrencyEnum currency, int countryId) {
        this.code = code;
        this.currency = currency;
        this.countryId = countryId;
    }

    public Integer getCode() {
        return code;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public Integer getCountryId() {
        return countryId;
    }
}
