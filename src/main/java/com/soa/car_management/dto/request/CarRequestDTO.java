package com.soa.car_management.dto.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarRequestDTO {

    private String name;

    private String price;

    // Động cơ/hộp số
    private String engineType;
    private int enginePower;
    private int engineTorque;
    private String transmission;
    private String drivetrain;

    // Pin và năng lượng
    private double batteryCapacity;
    private String fuelType;
    @Column(name = "`range`")
    private int range;
    private String batteryType;
    private Boolean standardCharger;
    private int fastChargeTime;
    private Boolean regenerativeBrakingSystem;

    // Kích thước và trọng lượng
    private int seats;
    private String dimensions;
    private int wheelbase;
    private int groundClearance;
    private int cargoVolume;
    private int curbWeight;
    private String tiresAndWheels;

    // Hệ thống treo và phanh
    private String frontSuspension;
    private String rearSuspension;
    private String frontBrakes;
    private String rearBrakes;

    // Ngoại thất
    private String headlights;
    private String daytimeRunningLights;
    private String fogLights;
    private Boolean taillights;
    private String automaticHeadlights;
    private Boolean headlightLeveling;
    private Boolean highMountStopLamp;
    private Boolean heatedSideMirrors;
    private Boolean automaticSideMirrors;
    private Boolean sharkFinAntenna;
    private Boolean powerTailgate;
    private Boolean rainSensingWipers;

    // Nội thất
    private String seatMaterial;
    private String driverSeatAdjustment;
    private String passengerSeatAdjustment;
    private String airConditioning;
    private String entertainmentScreen;
    private String audioSystem;
    private String driverSeatVentilation;
    private String passengerSeatVentilation;
    private Boolean driverSeatHeating;
    private Boolean passengerSeatHeating;
    private Boolean rearAirVents;
    private Boolean sunroof;
    private Boolean appleCarPlay;
    private Boolean androidAuto;
    private Boolean voiceControl;
    private Boolean handsFreeCall;
    private Boolean airPurifier;
    private Boolean airQualityControl;
    private Boolean virtualAssistant;
    private Boolean driverSeatMemory;
    private Boolean driverDisplay;
    private Boolean steeringWheelMaterial;
    private Boolean steeringWheelControls;
    private String rearSeatFolding;
    private Boolean smartKey;
    private String oneTouchWindows;
    private Boolean usbConnectivity;
    private Boolean bluetooth;
    private Boolean amFmRadio;
    private Boolean wirelessCharging;
    private Boolean smartphoneIntegration;
    private String vfConnect;
    private Boolean autoDimmingRearviewMirror;
    private Boolean rearSeatHeatingCooling;
    private Boolean wifiConnectivity;

    // Hỗ trợ vận hành
    private String powerSteering;
    private Boolean drivingModes;
    private Boolean electronicParkingBrake;
    private Boolean autoHold;
    private Boolean activeParkingAssist;
    private Boolean trafficSignRecognition;
    private Boolean vehicleManagementApp;
    private Boolean headsUpDisplay;

    // Công nghệ an toàn
    private int airbags;
    private String cruiseControl;
    private Boolean adaptiveCruiseControl;
    private Boolean abs;
    private Boolean brakeAssist;
    private Boolean ebd;
    private Boolean esc;
    private Boolean blindSpotWarning;
    private Boolean rearParkingSensors;
    private Boolean rearCamera;
    private Boolean laneDepartureWarning;
    private Boolean laneKeepingAssist;
    private Boolean autoLaneChange;
    private Boolean collisionMitigationBrake;
    private Boolean rearCrossTrafficAlert;
    private Boolean driverDrowsinessAlert;
    private Boolean isofix;
    private Boolean tirePressureMonitoring;
    private Boolean frontParkingSensors;
    private Boolean preCollisionWarning;
    private Boolean laneChangeAssist;
    private Boolean doorOpeningWarning;
    private Boolean tractionControl;
    private Boolean hillStartAssist;
    private Boolean surroundViewCamera;
    private Boolean autoHighBeams;
}
