import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DeviceRepository repository = new DeviceRepository();

        List<Device> devices = repository.findAll();

//        Device deviceTest = new Device(0, "加工中心二号", DeviceType.CNC, DeviceStatus.RUNNING);
//        repository.save(deviceTest);


        for (Device device : devices) {
            device.displayInfo();
            System.out.println("------------------");
        }

        Device device = repository.findById(3);
        if (device != null) {
            System.out.println("找到设备：");
            device.displayInfo();
        }else {
            System.out.println("设备不存在！");
        }
        boolean updated = repository.updateStatus(999, DeviceStatus.STOPPED);
        System.out.println(updated);

        boolean deleted = repository.deleteById(5);
        System.out.println(deleted);
    }
}
