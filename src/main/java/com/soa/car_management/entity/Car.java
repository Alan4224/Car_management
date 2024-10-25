package com.soa.car_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String price;

    private String image;
    // Động cơ/hộp số
    private String engineType;
    private String enginePower;
    private String engineTorque;
    private String gearBox;
    private String driveSystem;
    private String fuelType;
    private String fuelConsumption;
    private String operatingRange;
    private String fastChargingTime;
    private String batteryType;
    private String batteryCapacity;
    private String horsepower;
    private String capacity;
    private String torque;

    // Kích thước và trọng lượng
    private String seatNumber;
    private String dimensions;
    private String wheelbase;
    private String groundClearance;
    private String turningRadius;
    private String fuelTankCapacity;
    private String tireAndWheel;
    private String luggageCompartmentVolume;
    private String selfWeight;
    private String fullLoadWeight;

    // Ngoại thất
    private String highBeam;
    private String proximityLights;
    private String daytimeLights;
    private String taillights;
    private Boolean automaticHeadlights;
    private Boolean automaticAngleHeadlights;
    private Boolean overheadBrakeLights;
    private Boolean rearviewMirrorDrying;
    private Boolean heatedSideMirrors;
    private Boolean fishFinAntenna;
    private Boolean powerTrunk;
    private Boolean openTrunkHandsFree;
    private Boolean inhalationDoors;
    private Boolean automaticWipers;
    private String rearviewMirror;
    private Boolean autoHeadlights;

    // Nội thất
    private String steeringWheelCoverMaterial;
    private String steeringWheelAdjustment;
    private Boolean steeringWheelHeating;
    private Boolean steeringWheelPositionMemory;
    private String seatCoverMaterial;
    private String driversSeatAdjustment;
    private Boolean driversSeatPositionMemory;
    private String passengerSeatAdjustment;
    private String airConditioning;
    private String entertainmentScreen;
    private String speakerSystem;
    private Boolean driversSeatCooling;
    private Boolean passengersSeatCooling;
    private Boolean driversSeatHeating;
    private Boolean passengersSeatHeating;
    private Boolean smartKey;
    private Boolean rearSeatAirVents;
    private Boolean appleCarPlayConnection;
    private Boolean androidAutoConnection;
    private Boolean voiceCommand;
    private Boolean handsFreeTalk;
    private Boolean airFilter;
    private Boolean airQualityControl;
    private Boolean virtualAssistant;
    private Boolean wiFiStreaming;
    private Boolean wirelessCharging;
    private Boolean aCOutlet;
    private Boolean panoramicSunroof;
    private String driversDashboard;
    private String oneTouchWindows;
    private Boolean sunroof;
    private String powerDriversSeat;
    private String electricPassengerSeat;
    private Boolean autoDimmingInteriorRearviewMirror;
    private String secondRowSeats;
    private Boolean bluetoothConnection;
    private Boolean uSBConnection;
    private Boolean wiFiConnection;
    private Boolean pushButtonStart;
    private String centralScreen;
    private Boolean driverSeatMassage;
    private Boolean passengerSeatMassage;
    private Boolean steeringWheelIntegratedButtons;
    private Boolean aMFMRadio;
    private Boolean rearSeatArmrest;
    private Boolean frontSeatArmrest;
    private Boolean aUXConnection;
    private String thirdRow;

    // Hỗ trợ vận hành
    private String powerSteering;
    private Boolean multipleDrivingModes;
    private Boolean electronicHandbrake;
    private Boolean automaticBrakeHold;
    private Boolean activeParkingAssist;
    private Boolean supportReadingTrafficSignsAndSignals;
    private Boolean vehicleManagementViaPhoneApp;
    private Boolean displayInformationOnTheWindshield;
    private Boolean steeringAssistWhenCornering;
    private Boolean accelerationControl;
    private Boolean cruiseControl;
    private Boolean adaptiveCruiseControl;
    private Boolean steeringWheelPaddleShifters;
    private Boolean idlingStop;
    private Boolean electronicBrake;
    private Boolean idlingStopStartStop;

    // Công nghệ an toàn
    private int airbags;
    private Boolean adaptiveCruiseControl2;
    private Boolean antiLockBrakingSystem;
    private Boolean emergencyBrakeAssist;
    private Boolean electronicBrakeForceDistribution;
    private Boolean electronicStabilityControl;
    private Boolean blindSpotWarning;
    private Boolean reverseSensor;
    private Boolean reverseCamera;
    private Boolean laneDepartureWarning;
    private Boolean laneKeepingAssist;
    private Boolean automaticLaneChange;
    private Boolean automaticCollisionMitigationBrakeAssist;
    private Boolean crossTrafficWarningWhenReversing;
    private Boolean drowsyDriverWarning;;
    private Boolean isoFixChildSafetySeatHooks;
    private Boolean tirePressureSensor;
    private Boolean frontDistanceSensor;
    private Boolean preCollisionWarning;
    private Boolean laneChangeAssist;
    private Boolean trafficWarningWhenOpeningTheDoor;
    private Boolean trafficSignRecognition;
    private Boolean three60degreeCamera;
    private Boolean tractionControl;
    private Boolean hillStartAssist;
    private Boolean hillDescentAssist;
    private Boolean blindSpotCamera;

    //Hệ thống treo/phanh
    private String rearBrakes;
    private String frontBrakes;
    private String rearSuspension;
    private String frontSuspension;

}
