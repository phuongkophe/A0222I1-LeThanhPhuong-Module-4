package health_declaration.model;

public class HealthDeclaration {
    private String name;
    private String birthYear;
    private String gender;
    private String nationality;
    private String idCardNumber;
    private String transportation;
    private String transportNumber;
    private String seatNumber;
    private String departureDate;
    private String endDate;
    private String travelHistory;
    private String addressCity;
    private String addressDistrict;
    private String addressWard;
    private String addressDetail;
    private String phoneNumber;
    private String email;
    private String[] symptoms;
    private String exposureHistory;

    public HealthDeclaration() {
    }

    public HealthDeclaration(String name, String birthYear, String gender, String nationality, String idCardNumber, String transportation, String transportNumber, String seatNumber, String departureDate, String endDate, String travelHistory, String addressCity, String addressDistrict, String addressWard, String addressDetail, String phoneNumber, String email, String[] symptoms, String exposureHistory) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.nationality = nationality;
        this.idCardNumber = idCardNumber;
        this.transportation = transportation;
        this.transportNumber = transportNumber;
        this.seatNumber = seatNumber;
        this.departureDate = departureDate;
        this.endDate = endDate;
        this.travelHistory = travelHistory;
        this.addressCity = addressCity;
        this.addressDistrict = addressDistrict;
        this.addressWard = addressWard;
        this.addressDetail = addressDetail;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.symptoms = symptoms;
        this.exposureHistory = exposureHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getTransportNumber() {
        return transportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(String travelHistory) {
        this.travelHistory = travelHistory;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressDistrict() {
        return addressDistrict;
    }

    public void setAddressDistrict(String addressDistrict) {
        this.addressDistrict = addressDistrict;
    }

    public String getAddressWard() {
        return addressWard;
    }

    public void setAddressWard(String addressWard) {
        this.addressWard = addressWard;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String[] symptoms) {
        this.symptoms = symptoms;
    }

    public String getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(String exposureHistory) {
        this.exposureHistory = exposureHistory;
    }
}
