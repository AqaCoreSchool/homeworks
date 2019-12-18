package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Location {
    private String locationName;
    private int locationCountryIndex;
    private String locationState;
    private String locationCity;
    private String locationAddress;
    private String locationPostalCode;

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public void setLocationPostalCode(String locationPostalCode) {
        this.locationPostalCode = locationPostalCode;
    }

    public String getLocationName() {
        return locationName;
    }

    public int getLocationCountryIndex() {
        return locationCountryIndex;
    }

    public void setLocationCountryIndex(int locationCountryIndex) {
        this.locationCountryIndex = locationCountryIndex;
    }

    public String getLocationState() {
        return locationState;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public String getLocationPostalCode() {
        return locationPostalCode;
    }
}
