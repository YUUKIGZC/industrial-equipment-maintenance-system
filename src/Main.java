import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // 泛型
        List<Device> devices = new ArrayList<>();

        devices.add(new Device(1, "加工中心一号", DeviceStatus.RUNNING, DeviceType.CNC));
        devices.add(new Device(2, "PLC控制柜一号", DeviceStatus.STOPPED, DeviceType.PLC));
        devices.add(new Device(3, "工业机器人一号", DeviceStatus.MAINTENANCE, DeviceType.PLC));
        devices.add(new Device(4, "视觉检测设备一号", DeviceStatus.ERROR, DeviceType.PLC));

        for (Device device : devices) {
            device.displayInfo();
            System.out.println("------------------");
        }

        Device device = devices.get(0);
        device.changeStatus(DeviceStatus.ERROR);

        device.displayInfo();
    }
}
