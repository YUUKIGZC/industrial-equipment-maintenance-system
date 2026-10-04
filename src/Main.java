import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DeviceRepository repository = new DeviceRepository();

        repository.save(new Device(1, "加工中心一号", DeviceStatus.RUNNING, DeviceType.CNC));
        repository.save(new Device(2, "PLC控制柜一号", DeviceStatus.STOPPED, DeviceType.PLC));
        repository.save(new Device(3, "工业机器人一号", DeviceStatus.MAINTENANCE, DeviceType.ROBOT));
        repository.save(new Device(4, "视觉检测设备一号", DeviceStatus.ERROR, DeviceType.VISON_SYSTEM));

        for (Device device : repository.findAll()) {
            device.displayInfo();
            System.out.println("------------------");
        }

        Device device = repository.findById(999);
        if (device != null) {
            device.displayInfo();
        }else {
            System.out.println("设备不存在！");
        }
        boolean result = repository.updateStatus(4, DeviceStatus.RUNNING);
        if (result) {
            System.out.println("状态修改成功");
        }else {

        }
        boolean deleted = repository.deleteById(999);
        if (deleted) {
            System.out.println("成功删除设备！");
        }else {
            System.out.println("找不到设备!");
        }
        for (Device device1 : repository.findAll()) {
            device1.displayInfo();
        }
    }
}
