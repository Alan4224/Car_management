package com.soa.car_management.mapper;

import com.soa.car_management.dto.request.CarRequestDTO;
import com.soa.car_management.dto.respond.CarRespondDTO;
import com.soa.car_management.entity.Car;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-24T16:43:35+0700",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarRespondDTO toCarRespondDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        CarRespondDTO carRespondDTO = new CarRespondDTO();

        carRespondDTO.setId( car.getId() );
        carRespondDTO.setName( car.getName() );
        carRespondDTO.setPrice( car.getPrice() );
        carRespondDTO.setEngineType( car.getEngineType() );
        carRespondDTO.setEnginePower( car.getEnginePower() );
        carRespondDTO.setEngineTorque( car.getEngineTorque() );
        carRespondDTO.setGearBox( car.getGearBox() );
        carRespondDTO.setDriveSystem( car.getDriveSystem() );
        carRespondDTO.setFuelType( car.getFuelType() );
        carRespondDTO.setFuelConsumption( car.getFuelConsumption() );
        carRespondDTO.setRange( car.getRange() );
        carRespondDTO.setFastChargingTime( car.getFastChargingTime() );
        carRespondDTO.setBatteryType( car.getBatteryType() );
        carRespondDTO.setBatteryCapacity( car.getBatteryCapacity() );
        carRespondDTO.setHorsepower( car.getHorsepower() );
        carRespondDTO.setCapacity( car.getCapacity() );
        carRespondDTO.setTorque( car.getTorque() );
        carRespondDTO.setSeatNumber( car.getSeatNumber() );
        carRespondDTO.setDimensions( car.getDimensions() );
        carRespondDTO.setWheelbase( car.getWheelbase() );
        carRespondDTO.setGroundClearance( car.getGroundClearance() );
        carRespondDTO.setTurningRadius( car.getTurningRadius() );
        carRespondDTO.setFuelTankCapacity( car.getFuelTankCapacity() );
        carRespondDTO.setTireAndWheel( car.getTireAndWheel() );
        carRespondDTO.setLuggageCompartmentVolume( car.getLuggageCompartmentVolume() );
        carRespondDTO.setSelfWeight( car.getSelfWeight() );
        carRespondDTO.setFullLoadWeight( car.getFullLoadWeight() );
        carRespondDTO.setHighBeam( car.getHighBeam() );
        carRespondDTO.setProximityLights( car.getProximityLights() );
        carRespondDTO.setDaytimeLights( car.getDaytimeLights() );
        carRespondDTO.setTaillights( car.getTaillights() );
        carRespondDTO.setAutomaticHeadlights( car.getAutomaticHeadlights() );
        carRespondDTO.setAutomaticAngleHeadlights( car.getAutomaticAngleHeadlights() );
        carRespondDTO.setOverheadBrakeLights( car.getOverheadBrakeLights() );
        carRespondDTO.setRearviewMirrorDrying( car.getRearviewMirrorDrying() );
        carRespondDTO.setHeatedSideMirrors( car.getHeatedSideMirrors() );
        carRespondDTO.setFishFinAntenna( car.getFishFinAntenna() );
        carRespondDTO.setPowerTrunk( car.getPowerTrunk() );
        carRespondDTO.setOpenTrunkHandsFree( car.getOpenTrunkHandsFree() );
        carRespondDTO.setInhalationDoors( car.getInhalationDoors() );
        carRespondDTO.setAutomaticWipers( car.getAutomaticWipers() );
        carRespondDTO.setRearviewMirror( car.getRearviewMirror() );
        carRespondDTO.setAutoHeadlights( car.getAutoHeadlights() );
        carRespondDTO.setSteeringWheelCoverMaterial( car.getSteeringWheelCoverMaterial() );
        carRespondDTO.setSteeringWheelAdjustment( car.getSteeringWheelAdjustment() );
        carRespondDTO.setSteeringWheelHeating( car.getSteeringWheelHeating() );
        carRespondDTO.setSteeringWheelPositionMemory( car.getSteeringWheelPositionMemory() );
        carRespondDTO.setSeatCoverMaterial( car.getSeatCoverMaterial() );
        carRespondDTO.setDriversSeatAdjustment( car.getDriversSeatAdjustment() );
        carRespondDTO.setDriversSeatPositionMemory( car.getDriversSeatPositionMemory() );
        carRespondDTO.setPassengerSeatAdjustment( car.getPassengerSeatAdjustment() );
        carRespondDTO.setAirConditioning( car.getAirConditioning() );
        carRespondDTO.setEntertainmentScreen( car.getEntertainmentScreen() );
        carRespondDTO.setSpeakerSystem( car.getSpeakerSystem() );
        carRespondDTO.setDriversSeatCooling( car.getDriversSeatCooling() );
        carRespondDTO.setPassengersSeatCooling( car.getPassengersSeatCooling() );
        carRespondDTO.setDriversSeatHeating( car.getDriversSeatHeating() );
        carRespondDTO.setPassengersSeatHeating( car.getPassengersSeatHeating() );
        carRespondDTO.setSmartKey( car.getSmartKey() );
        carRespondDTO.setRearSeatAirVents( car.getRearSeatAirVents() );
        carRespondDTO.setAppleCarPlayConnection( car.getAppleCarPlayConnection() );
        carRespondDTO.setAndroidAutoConnection( car.getAndroidAutoConnection() );
        carRespondDTO.setVoiceCommand( car.getVoiceCommand() );
        carRespondDTO.setHandsFreeTalk( car.getHandsFreeTalk() );
        carRespondDTO.setAirFilter( car.getAirFilter() );
        carRespondDTO.setAirQualityControl( car.getAirQualityControl() );
        carRespondDTO.setVirtualAssistant( car.getVirtualAssistant() );
        carRespondDTO.setWiFiStreaming( car.getWiFiStreaming() );
        carRespondDTO.setWirelessCharging( car.getWirelessCharging() );
        carRespondDTO.setACOutlet( car.getACOutlet() );
        carRespondDTO.setPanoramicSunroof( car.getPanoramicSunroof() );
        carRespondDTO.setDriversDashboard( car.getDriversDashboard() );
        carRespondDTO.setOneTouchWindows( car.getOneTouchWindows() );
        carRespondDTO.setSunroof( car.getSunroof() );
        carRespondDTO.setPowerDriversSeat( car.getPowerDriversSeat() );
        carRespondDTO.setElectricPassengerSeat( car.getElectricPassengerSeat() );
        carRespondDTO.setAutoDimmingInteriorRearviewMirror( car.getAutoDimmingInteriorRearviewMirror() );
        carRespondDTO.setSecondRowSeats( car.getSecondRowSeats() );
        carRespondDTO.setBluetoothConnection( car.getBluetoothConnection() );
        carRespondDTO.setUSBConnection( car.getUSBConnection() );
        carRespondDTO.setWiFiConnection( car.getWiFiConnection() );
        carRespondDTO.setPushButtonStart( car.getPushButtonStart() );
        carRespondDTO.setCentralScreen( car.getCentralScreen() );
        carRespondDTO.setDriverSeatMassage( car.getDriverSeatMassage() );
        carRespondDTO.setPassengerSeatMassage( car.getPassengerSeatMassage() );
        carRespondDTO.setSteeringWheelIntegratedButtons( car.getSteeringWheelIntegratedButtons() );
        carRespondDTO.setAMFMRadio( car.getAMFMRadio() );
        carRespondDTO.setRearSeatArmrest( car.getRearSeatArmrest() );
        carRespondDTO.setFrontSeatArmrest( car.getFrontSeatArmrest() );
        carRespondDTO.setAUXConnection( car.getAUXConnection() );
        carRespondDTO.setThirdRow( car.getThirdRow() );
        carRespondDTO.setPowerSteering( car.getPowerSteering() );
        carRespondDTO.setMultipleDrivingModes( car.getMultipleDrivingModes() );
        carRespondDTO.setElectronicHandbrake( car.getElectronicHandbrake() );
        carRespondDTO.setAutomaticBrakeHold( car.getAutomaticBrakeHold() );
        carRespondDTO.setActiveParkingAssist( car.getActiveParkingAssist() );
        carRespondDTO.setSupportReadingTrafficSignsAndSignals( car.getSupportReadingTrafficSignsAndSignals() );
        carRespondDTO.setVehicleManagementViaPhoneApp( car.getVehicleManagementViaPhoneApp() );
        carRespondDTO.setDisplayInformationOnTheWindshield( car.getDisplayInformationOnTheWindshield() );
        carRespondDTO.setSteeringAssistWhenCornering( car.getSteeringAssistWhenCornering() );
        carRespondDTO.setAccelerationControl( car.getAccelerationControl() );
        carRespondDTO.setCruiseControl( car.getCruiseControl() );
        carRespondDTO.setAdaptiveCruiseControl( car.getAdaptiveCruiseControl() );
        carRespondDTO.setSteeringWheelPaddleShifters( car.getSteeringWheelPaddleShifters() );
        carRespondDTO.setIdlingStop( car.getIdlingStop() );
        carRespondDTO.setElectronicBrake( car.getElectronicBrake() );
        carRespondDTO.setIdlingStopStartStop( car.getIdlingStopStartStop() );
        carRespondDTO.setAirbags( car.getAirbags() );
        carRespondDTO.setAdaptiveCruiseControl2( car.getAdaptiveCruiseControl2() );
        carRespondDTO.setAntiLockBrakingSystem( car.getAntiLockBrakingSystem() );
        carRespondDTO.setEmergencyBrakeAssist( car.getEmergencyBrakeAssist() );
        carRespondDTO.setElectronicBrakeForceDistribution( car.getElectronicBrakeForceDistribution() );
        carRespondDTO.setElectronicStabilityControl( car.getElectronicStabilityControl() );
        carRespondDTO.setBlindSpotWarning( car.getBlindSpotWarning() );
        carRespondDTO.setReverseSensor( car.getReverseSensor() );
        carRespondDTO.setReverseCamera( car.getReverseCamera() );
        carRespondDTO.setLaneDepartureWarning( car.getLaneDepartureWarning() );
        carRespondDTO.setLaneKeepingAssist( car.getLaneKeepingAssist() );
        carRespondDTO.setAutomaticLaneChange( car.getAutomaticLaneChange() );
        carRespondDTO.setAutomaticCollisionMitigationBrakeAssist( car.getAutomaticCollisionMitigationBrakeAssist() );
        carRespondDTO.setCrossTrafficWarningWhenReversing( car.getCrossTrafficWarningWhenReversing() );
        carRespondDTO.setDrowsyDriverWarning( car.getDrowsyDriverWarning() );
        carRespondDTO.setIsoFixChildSafetySeatHooks( car.getIsoFixChildSafetySeatHooks() );
        carRespondDTO.setTirePressureSensor( car.getTirePressureSensor() );
        carRespondDTO.setFrontDistanceSensor( car.getFrontDistanceSensor() );
        carRespondDTO.setPreCollisionWarning( car.getPreCollisionWarning() );
        carRespondDTO.setLaneChangeAssist( car.getLaneChangeAssist() );
        carRespondDTO.setTrafficWarningWhenOpeningTheDoor( car.getTrafficWarningWhenOpeningTheDoor() );
        carRespondDTO.setTrafficSignRecognition( car.getTrafficSignRecognition() );
        carRespondDTO.setThree60degreeCamera( car.getThree60degreeCamera() );
        carRespondDTO.setTractionControl( car.getTractionControl() );
        carRespondDTO.setHillStartAssist( car.getHillStartAssist() );
        carRespondDTO.setHillDescentAssist( car.getHillDescentAssist() );
        carRespondDTO.setBlindSpotCamera( car.getBlindSpotCamera() );
        carRespondDTO.setRearBrakes( car.getRearBrakes() );
        carRespondDTO.setFrontBrakes( car.getFrontBrakes() );
        carRespondDTO.setRearSuspension( car.getRearSuspension() );
        carRespondDTO.setFrontSuspension( car.getFrontSuspension() );

        return carRespondDTO;
    }

    @Override
    public Car toCar(CarRequestDTO carRequestDTO) {
        if ( carRequestDTO == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        car.name( carRequestDTO.getName() );
        car.price( carRequestDTO.getPrice() );
        car.engineType( carRequestDTO.getEngineType() );
        car.enginePower( carRequestDTO.getEnginePower() );
        car.engineTorque( carRequestDTO.getEngineTorque() );
        car.fuelType( carRequestDTO.getFuelType() );
        car.range( carRequestDTO.getRange() );
        car.batteryType( carRequestDTO.getBatteryType() );
        car.batteryCapacity( carRequestDTO.getBatteryCapacity() );
        car.dimensions( carRequestDTO.getDimensions() );
        car.wheelbase( (double) carRequestDTO.getWheelbase() );
        car.groundClearance( carRequestDTO.getGroundClearance() );
        if ( carRequestDTO.getTaillights() != null ) {
            car.taillights( String.valueOf( carRequestDTO.getTaillights() ) );
        }
        if ( carRequestDTO.getAutomaticHeadlights() != null ) {
            car.automaticHeadlights( Boolean.parseBoolean( carRequestDTO.getAutomaticHeadlights() ) );
        }
        car.heatedSideMirrors( carRequestDTO.getHeatedSideMirrors() );
        car.passengerSeatAdjustment( carRequestDTO.getPassengerSeatAdjustment() );
        car.airConditioning( carRequestDTO.getAirConditioning() );
        car.entertainmentScreen( carRequestDTO.getEntertainmentScreen() );
        car.smartKey( carRequestDTO.getSmartKey() );
        car.airQualityControl( carRequestDTO.getAirQualityControl() );
        car.virtualAssistant( carRequestDTO.getVirtualAssistant() );
        car.wirelessCharging( carRequestDTO.getWirelessCharging() );
        car.oneTouchWindows( carRequestDTO.getOneTouchWindows() );
        car.sunroof( carRequestDTO.getSunroof() );
        car.powerSteering( carRequestDTO.getPowerSteering() );
        car.activeParkingAssist( carRequestDTO.getActiveParkingAssist() );
        if ( carRequestDTO.getCruiseControl() != null ) {
            car.cruiseControl( Boolean.parseBoolean( carRequestDTO.getCruiseControl() ) );
        }
        car.adaptiveCruiseControl( carRequestDTO.getAdaptiveCruiseControl() );
        car.airbags( carRequestDTO.getAirbags() );
        car.blindSpotWarning( carRequestDTO.getBlindSpotWarning() );
        car.laneDepartureWarning( carRequestDTO.getLaneDepartureWarning() );
        car.laneKeepingAssist( carRequestDTO.getLaneKeepingAssist() );
        car.preCollisionWarning( carRequestDTO.getPreCollisionWarning() );
        car.laneChangeAssist( carRequestDTO.getLaneChangeAssist() );
        car.trafficSignRecognition( carRequestDTO.getTrafficSignRecognition() );
        car.tractionControl( carRequestDTO.getTractionControl() );
        car.hillStartAssist( carRequestDTO.getHillStartAssist() );
        car.rearBrakes( carRequestDTO.getRearBrakes() );
        car.frontBrakes( carRequestDTO.getFrontBrakes() );
        car.rearSuspension( carRequestDTO.getRearSuspension() );
        car.frontSuspension( carRequestDTO.getFrontSuspension() );

        return car.build();
    }
}
