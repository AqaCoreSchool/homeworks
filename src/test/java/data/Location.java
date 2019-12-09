package data;

public class Location {

    private String locationName = "CoreValue";
    private String country = "Ukraine";
    private String province = "Lviv region";
    private String city = "Lviv";
    private String address = "Heroiv UPA, 73";
    private String postalCode = "79000";
    private String phone = "380 32 584 55 55";

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (!locationName.equals(location.locationName)) return false;
        if (!country.equals(location.country)) return false;
        if (!province.equals(location.province)) return false;
        if (!city.equals(location.city)) return false;
        if (!address.equals(location.address)) return false;
        if (!postalCode.equals(location.postalCode)) return false;
        return phone.equals(location.phone);
    }

    @Override
    public int hashCode() {
        int result = locationName.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + province.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + postalCode.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
