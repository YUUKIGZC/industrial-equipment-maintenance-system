import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DeviceRepository repository = new DeviceRepository();

        List<Device> devices = repository.findAll();

        Device deviceTest = new Device(0, "加工中心二号", DeviceType.CNC, DeviceStatus.RUNNING);
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
//        boolean result = repository.updateStatus(4, DeviceStatus.RUNNING);
//        if (result) {
//            System.out.println("状态修改成功");
//        }else {
//
//        }
//        boolean deleted = repository.deleteById(999);
//        if (deleted) {
//            System.out.println("成功删除设备！");
//        }else {
//            System.out.println("找不到设备!");
//        }
//        for (Device device1 : repository.findAll()) {
//            device1.displayInfo();
//        }
    }
}
