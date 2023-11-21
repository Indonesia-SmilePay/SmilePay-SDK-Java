package id.smile.req;

public class AddressReq {

    /**
     * address
     */
    private String address;

    /**
     * city
     */
    private String city;

    /**
     * postalCode
     */
    private String postalCode;

    /**
     * phone
     */
    private String phone;

    /**
     * countryCode
     */
    private String countryCode;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}