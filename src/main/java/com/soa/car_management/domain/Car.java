package com.soa.car_management.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Setter
@Getter
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // Số lượng kho
    // Số lượng bán
    //tg nhận
    //tg bán
    // Thêm entity khách hàng Mua(carID){số lượng kho -1}

    private String name; // Tên

    private String price; // Giá

    private String version; // Phiên bản

    private String image; // Hình ảnh

    @OneToMany(mappedBy="car",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Sale> sales;// Doanh số

    private String company; // Hãng xe
    // Động cơ/hộp số
    private String engineType; // Kiểu động cơ

    private String enginePower; // Công suất máy xăng/dầu (Nm)/vòng tua (vòng/phút)

    private String engineTorque; // Mô-men xoắn máy xăng/dầu (Nm)/vòng tua (vòng/phút)

    private String gearBox; // Hộp số

    private String driveSystem; // Hệ dẫn động

    private String fuelType; // Loại nhiên liệu

    private String fuelConsumption; // Mức tiêu thụ nhiên liệu đường hỗn hợp (lít/100 km)

    private String operatingRange; // Tầm hoạt động (km)

    private String fastChargingTime; // Thời gian sạc nhanh DC từ 10-80% (phút)

    private String batteryType; // Loại pin

    private String batteryCapacity; // Dung lượng pin (kWh)

    private String horsepower; // Công suất (mã lực)/vòng tua (vòng/phút)

    private String capacity; // Dung tích (cc)

    private String torque; // Mô-men xoắn (Nm)/vòng tua (vòng/phút)

    //Kích thước/trọng lượng

    private String seatNumber; // Số chỗ

    private String dimensions; // Kích thước dài x rộng x cao (mm)

    private String wheelbase; // Chiều dài cơ sở (mm)

    private String groundClearance; // Khoảng sáng gầm (mm)

    private String turningRadius; // Bán kính vòng quay (mm)

    private String fuelTankCapacity; // Dung tích bình nhiên liệu (lít)

    private String tireAndWheel; // Lốp, la-zăng

    private String luggageCompartmentVolume; // Thể tích khoang hành lý (lít)

    private String selfWeight; // Trọng lượng bản thân (kg)

    private String fullLoadWeight; // Trọng lượng toàn tải (kg)

    //Ngoại thất

    private String highBeam; // Đèn chiếu xa

    private String proximityLights; // Đèn chiếu gần

    private String daytimeLights; // Đèn ban ngày

    private String taillights; // Đèn hậu

    private Boolean automaticHeadlights; // Đèn pha tự động bật/tắt

    private Boolean automaticAngleHeadlights; // Đèn pha tự động điều chỉnh góc chiếu

    private Boolean overheadBrakeLights; // Đèn phanh trên cao

    private Boolean rearviewMirrorDrying; // Sấy gương chiếu hậu

    private Boolean fishFinAntenna; // Ăng ten vây cá

    private Boolean powerTrunk; // Cốp đóng/mở điện

    private Boolean openTrunkHandsFree; // Mở cốp rảnh tay

    private Boolean inhalationDoors; // Cửa hít

    private Boolean automaticWipers; // Gạt mưa tự động

    private String rearviewMirror; // Gương chiếu hậu

    private Boolean autoHeadlights; // Đèn pha tự động xa/gần

    //Nội thất

    private String steeringWheelCoverMaterial; // Chất liệu bọc vô-lăng

    private String steeringWheelAdjustment; // Điều chỉnh vô-lăng

    private Boolean steeringWheelHeating; // Sưởi vô-lăng

    private Boolean steeringWheelPositionMemory; // Nhớ vị trí vô-lăng

    private String seatCoverMaterial; // Chất liệu bọc ghế

    private String driversSeatAdjustment; // Điều chỉnh ghế lái

    private Boolean driversSeatPositionMemory; // Nhớ vị trí ghế lái

    private String passengerSeatAdjustment; // Điều chỉnh ghế phụ

    private String airConditioning; // Điều hoà

    private String entertainmentScreen; // Màn hình giải trí

    private String speakerSystem; // Hệ thống loa

    private Boolean driversSeatCooling; // Thông gió (làm mát) ghế lái

    private Boolean passengersSeatCooling; // Thông gió (làm mát) ghế phụ

    private Boolean driversSeatHeating; // Sưởi ấm ghế lái

    private Boolean passengersSeatHeating; // Sưởi ấm ghế phụ

    private Boolean smartKey; // Chìa khoá thông minh

    private Boolean rearSeatAirVents; // Cửa gió hàng ghế sau

    private Boolean appleCarPlayConnection; // Kết nối Apple CarPlay

    private Boolean androidAutoConnection; // Kết nối Android Auto

    private Boolean voiceCommand; // Ra lệnh giọng nói

    private Boolean handsFreeTalk; // Đàm thoại rảnh tay

    private Boolean airFilter; // Lọc không khí

    private Boolean airQualityControl; // Kiểm soát chất lượng không khí

    private Boolean virtualAssistant; // Trợ lý ảo

    private Boolean wiFiStreaming; // Phát WiFi

    private Boolean wirelessCharging; // Sạc không dây

    private Boolean aCOutlet; // Ổ điện xoay chiều 230V

    private Boolean panoramicSunroof; // Cửa sổ trời toàn cảnh

    private String driversDashboard; // Bảng đồng hồ tài xế

    private String oneTouchWindows; // Cửa kính một chạm

    private Boolean sunroof; // Cửa sổ trời

    private String powerDriversSeat; // Ghế lái chỉnh điện

    private String electricPassengerSeat; // Ghế phụ chỉnh điện

    private Boolean autoDimmingInteriorRearviewMirror; // Gương chiếu hậu trong xe chống chói tự động

    private String secondRowSeats; // Hàng ghế thứ hai

    private Boolean bluetoothConnection; // Kết nối Bluetooth

    private Boolean uSBConnection; // Kết nối USB

    private Boolean wiFiConnection; // Kết nối WiFi

    private Boolean pushButtonStart; // Khởi động nút bấm

    private String centralScreen; // Màn hình trung tâm

    private Boolean driverSeatMassage; // Massage ghế lái

    private Boolean passengerSeatMassage; // Massage ghế phụ

    private Boolean steeringWheelIntegratedButtons; // Nút bấm tích hợp trên vô-lăng

    private Boolean aMFMRadio; // Radio AM/FM

    private Boolean rearSeatArmrest; // Tựa tay hàng ghế sau

    private Boolean frontSeatArmrest; // Tựa tay hàng ghế trước

    private Boolean aUXConnection; // Kết nối AUX

    private String thirdRow; // Hàng ghế thứ ba

    //Hỗ trợ vận hành

    private String powerSteering; // Trợ lực vô-lăng

    private Boolean multipleDrivingModes; // Nhiều chế độ lái

    private Boolean electronicHandbrake; // Phanh tay điện tử

    private Boolean automaticBrakeHold; // Giữ phanh tự động

    private Boolean activeParkingAssist; // Hỗ trợ đỗ xe chủ động

    private Boolean supportReadingTrafficSignsAndSignals; // Hỗ trợ đọc biển báo, tín hiệu giao thông

    private Boolean vehicleManagementViaPhoneApp; // Quản lý xe qua app điện thoại

    private Boolean displayInformationOnTheWindshield; // Hiển thị thông tin trên kính lái (HUD)

    private Boolean steeringAssistWhenCornering; // Hỗ trợ đánh lái khi vào cua

    private Boolean accelerationControl; // Kiểm soát gia tốc

    private Boolean cruiseControl; // Kiểm soát hành trình (Cruise Control)

    private Boolean adaptiveCruiseControl; // Kiểm soát hành trình thích ứng (Adaptive Cruise Control)

    private Boolean steeringWheelPaddleShifters; // Lẫy chuyển số trên vô-lăng

    private Boolean idlingStop; // Ngắt động cơ tạm thời (Idling Stop)

    private Boolean electronicBrake; // Phanh điện tử

    private Boolean idlingStopStartStop; // Ngắt động cơ tạm thời (Idling Stop/Start-Stop)

    //Công nghệ an toàn

    private int airbags; // Số túi khí

    private Boolean adaptiveCruiseControl2; // Kiểm soát hành trình thích ứng (Adaptive Cruise Control)

    private Boolean antiLockBrakingSystem; // Chống bó cứng phanh (ABS)

    private Boolean emergencyBrakeAssist; // Hỗ trợ lực phanh khẩn cấp (BA)

    private Boolean electronicBrakeForceDistribution; // Phân phối lực phanh điện tử (EBD)

    private Boolean electronicStabilityControl; // Cân bằng điện tử (VSC, ESP)

    private Boolean blindSpotWarning; // Cảnh báo điểm mù

    private Boolean reverseSensor; // Cảm biến lùi

    private Boolean reverseCamera; // Camera lùi

    private Boolean laneDepartureWarning; // Cảnh báo chệch làn đường

    private Boolean laneKeepingAssist; // Hỗ trợ giữ làn

    private Boolean automaticLaneChange; // Tự động chuyển làn

    private Boolean automaticCollisionMitigationBrakeAssist; // Hỗ trợ phanh tự động giảm thiểu va chạm

    private Boolean crossTrafficWarningWhenReversing; // Cảnh báo phương tiện cắt ngang khi lùi

    private Boolean drowsyDriverWarning; // Cảnh báo tài xế buồn ngủ

    private Boolean isoFixChildSafetySeatHooks; // Móc ghế an toàn cho trẻ em Isofix

    private Boolean tirePressureSensor; // Cảm biến áp suất lốp

    private Boolean frontDistanceSensor; // Cảm biến khoảng cách phía trước

    private Boolean preCollisionWarning; // Cảnh báo tiền va chạm

    private Boolean laneChangeAssist; // Hỗ trợ chuyển làn

    private Boolean trafficWarningWhenOpeningTheDoor; // Cảnh báo giao thông khi mở cửa

    private Boolean trafficSignRecognition; // Nhận diện biển báo giao thông

    private Boolean three60degreeCamera; // Camera 360 độ

    private Boolean tractionControl; // Kiểm soát lực kéo (chống trượt, kiểm soát độ bám đường TCS)

    private Boolean hillStartAssist; // Hỗ trợ khởi hành ngang dốc

    private Boolean hillDescentAssist; // Hỗ trợ đổ đèo

    private Boolean blindSpotCamera; // Camera quan sát điểm mù

    //Hệ thống treo/phanh

    private String rearBrakes; // Phanh sau

    private String frontBrakes; // Phanh trước

    private String rearSuspension; // Treo sau

    private String frontSuspension; // Treo trước

}
