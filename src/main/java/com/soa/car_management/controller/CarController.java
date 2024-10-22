package com.soa.car_management.controller;

import com.soa.car_management.entity.Car;
import com.soa.car_management.service.CarService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    List<Car> getCar(){
        return carService.getCar();
    }
    @PostMapping
    List<Car> createCar(){
        List<Car> cars = new ArrayList<>();
        return carService.createListCar(cars);
    }
    private Boolean hasCheckIcon(Element element) {
        return element.select("div.td2 svg.icon-svg").size() > 0;
    }

    private void setAttribute(String label, String value, Car car) {
        try{
            String methodName = "set" + label.substring(0, 1).toUpperCase() + label.substring(1);
            car.getClass().getMethod(methodName, String.class).invoke(car, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/testjsoup")
    Car testJsoup(){
        Car car = new Car();
        try {
            // Fetch the HTML from a URL
            Document doc = Jsoup.connect("https://vnexpress.net/oto-xe-may/v-car/phien-ban-xe/vinfast-vf-9-2023-eco-650").get();

            // Print the title of the page
            System.out.println("Title: " + doc.title());

            /*
            Elements elements = doc.select("li");

            for (Element element : elements) {
                String label = element.select("div.td1").text();
                String value = element.select("div.td2").text();
                String name = doc.select("h1").select("a[title]").first().attr("title");
                car.setName(name);
                String price = doc.select("span.text-version").first().text();
                car.setPrice(price);
               // HashMap <String, String> dict = new HashMap<>();

                switch (label) {
                    // Động cơ/hộp số
                    case "Kiểu động cơ":
                        car.setEngineType(value);
                        break;
                    case "Công suất máy xăng/dầu (Nm)/vòng tua (vòng/phút)":
                        car.setEnginePower(Integer.parseInt(value));
                        break;
                    case "Mô-men xoắn máy xăng/dầu (Nm)/vòng tua (vòng/phút)":
                        car.setEngineTorque(Integer.parseInt(value));
                        break;
                    case "Hộp số":
                        car.setGearBox(value);
                        break;
                    case "Hệ dẫn động":
                        car.setDriveSystem(value);
                        break;
                    case "Loại nhiên liệu":
                        car.setFuelType(value);
                        break;
                    case "Mức tiêu thụ nhiên liệu đường hỗn hợp (lít/100 km)":
                        car.setFuelConsumption(value.isEmpty() ? null:Double.parseDouble(value.replace(",",".")));
                        break;
                    case "Tầm hoạt động (km)":
                        car.setRange(Integer.parseInt(value));
                        break;
                    case "Thời gian sạc nhanh DC từ 10-80% (phút)":
                        car.setFastChargingTime(value);
                        break;
                    case "Loại pin":
                        car.setBatteryType(value);
                        break;
                    case "Dung lượng pin (kWh)":
                        car.setBatteryCapacity(Double.parseDouble(value.replace(",",".")));
                        break;
                    case "Công suất (mã lực)/vòng tua (vòng/phút)":
                        car.setHorsepower(value);
                        break;
                    case "Dung tích (cc)":
                        car.setCapacity(Double.parseDouble(value.replace(",",".")));
                        break;
                    case "Mô-men xoắn (Nm)/vòng tua (vòng/phút)":
                        car.setTorque(value);
                        break;

                    // Kích thước và trọng lượng
                    case "Số chỗ":
                        car.setSeatNumber(value);
                        break;
                    case "Kích thước dài x rộng x cao (mm)":
                        car.setDimensions(value);
                        break;
                    case "Chiều dài cơ sở (mm)":
                        car.setWheelbase(Double.parseDouble(value.replace(",",".")));
                        break;
                    case "Khoảng sáng gầm (mm)":
                        car.setGroundClearance(Integer.parseInt(value));
                        break;
                    case "Bán kính vòng quay (mm)":
                        car.setTurningRadius(Double.parseDouble(value.replace(",",".")));
                        break;
                    case "Dung tích bình nhiên liệu (lít)":
                        car.setFuelTankCapacity(Integer.parseInt(value));
                        break;
                    case "Lốp, la-zăng":
                        car.setTireAndWheel(value);
                        break;
                    case "Thể tích khoang hành lý (lít)":
                        car.setLuggageCompartmentVolume(Integer.parseInt(value));
                        break;
                    case "Trọng lượng bản thân (kg)":
                        car.setSelfWeight(Double.parseDouble(value.replace(",",".")));
                        break;
                    case "Trọng lượng toàn tải (kg)":
                        car.setFullLoadWeight(Double.parseDouble(value.replace(",",".")));
                        break;

                    // Ngoại thất
                    case "Đèn chiếu xa":
                        car.setHighBeam(value);
                        break;
                    case "Đèn chiếu gần":
                        car.setProximityLights(value);
                        break;
                    case "Đèn ban ngày":
                        car.setDaytimeLights(value);
                        break;
                    case "Đèn hậu":
                        car.setTaillights(value);
                        break;
                    case "Đèn pha tự động bật/tắt":
                        car.setAutomaticHeadlights(hasCheckIcon(element));
                        break;
                    case "Đèn pha tự động điều chỉnh góc chiếu":
                        car.setAutomaticAngleHeadlights(hasCheckIcon(element));
                        break;
                    case "Đèn phanh trên cao":
                        car.setOverheadBrakeLights(hasCheckIcon(element));
                        break;
                    case "Sấy gương chiếu hậu":
                        car.setRearviewMirrorDrying(hasCheckIcon(element));
                        break;
                    case "Ăng ten vây cá":
                        car.setFishFinAntenna(hasCheckIcon(element));
                        break;
                    case "Cốp đóng/mở điện":
                        car.setPowerTrunk(hasCheckIcon(element));
                        break;
                    case "Mở cốp rảnh tay":
                        car.setOpenTrunkHandsFree(hasCheckIcon(element));
                        break;
                    case "Cửa hít":
                        car.setInhalationDoors(hasCheckIcon(element));
                        break;
                    case "Gạt mưa tự động":
                        car.setAutomaticWipers(hasCheckIcon(element));
                        break;
                    case "Gương chiếu hậu":
                        car.setRearviewMirror(value);
                        break;
                    case "Đèn pha tự động xa/gần":
                        car.setAutoHeadlights(hasCheckIcon(element));
                        break;

                    //Nội thất
                    case "Chất liệu bọc vô-lăng":
                        car.setSteeringWheelCoverMaterial(value);
                        break;
                    case "Điều chỉnh vô-lăng":
                        car.setSteeringWheelAdjustment(value);
                        break;
                    case "Sưởi vô-lăng":
                        car.setSteeringWheelHeating(hasCheckIcon(element));
                        break;
                    case "Nhớ vị trí vô-lăng":
                        car.setSteeringWheelPositionMemory(hasCheckIcon(element));
                        break;
                    case "Chất liệu bọc ghế":
                        car.setSeatCoverMaterial(value);
                        break;
                    case "Điều chỉnh ghế lái":
                        car.setDriversSeatAdjustment(value);
                        break;
                    case "Nhớ vị trí ghế lái":
                        car.setDriversSeatPositionMemory(hasCheckIcon(element));
                        break;
                }
            }*/
            Elements elements = doc.select("li");
            int AttributeCount = 0;
            HashMap <String, String> dict = new HashMap<>();
            for (Element element : elements) {
                String label = element.select("div.td1").text();
                String value = element.select("div.td2").text();
                String name = doc.select("h1").select("a[title]").first().attr("title");
                car.setName(name);
                String price = doc.select("span.text-version").first().text();
                car.setPrice(price);
                dict.put(label, value);
                setAttribute(label, value, car);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }
}
