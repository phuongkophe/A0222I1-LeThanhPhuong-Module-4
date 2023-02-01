package son.codegym.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
public class Service {
    @Id
    @Column(columnDefinition = "varchar(50)")
    @Pattern(regexp = "^DV-\\d{4}$", message = "Mã dịch vụ không đúng định dạng")
    private String serviceId;
    @NotBlank(message = "{type}")
    private String serviceName;
    @Min(value = 0, message = "Diện tích phải lớn hơn 0")
    private double serviceArea;
    @Min(value = 0, message = "Giá phải lớn hơn 0")
    private double serviceCost;
    @Min(value = 0, message = "Số lượng người phải lớn hơn 0")
    private int serviceMaxPeople;

    @ManyToOne()
    @JoinColumn(name = "rentTypeId")
    private RentType rentTypeId;

    @ManyToOne
    @JoinColumn(name = "serviceTypeId")
    private ServiceType serviceTypeId;

    @JsonBackReference
    @OneToMany(mappedBy = "serviceId", cascade = CascadeType.REMOVE)
    private Set<Contract> contracts;

    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(value = 0, message = "Lớn hơn 0")
    private double poolArea;
    @Min(value = 0, message = "Số tầng phải là số nguyên dương")
    private int numberOfFloors;

    public Service(){};

    public Service(String serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, RentType rentTypeId, ServiceType serviceTypeId, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Service(String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, RentType rentTypeId, ServiceType serviceTypeId, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentTypeId = rentTypeId;
        this.serviceTypeId = serviceTypeId;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(double serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(RentType rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public ServiceType getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(ServiceType serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
