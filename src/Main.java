import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 泛型
        List<Device> devices = new ArrayList<>();

        devices.add(new Device(1,"加工中心一号"));
        devices.add(new Device(2,"加工中心二号"));
        devices.add(new Device(3,"工业机器人一号"));

        for (Device device : devices) {
            device.displayInfo();
        }
    }
}
