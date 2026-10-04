import java.util.ArrayList;
import java.util.List;

public class DeviceRepository {
    private List<Device> devices = new ArrayList<>();

    public void save(Device device) {
        devices.add(device);
    }
    public List<Device> findAll() {
        return devices;
    }
    public Device findById(int id) {
        for (Device device : devices) {
            if (device.getId() == id) {
                return device;
            }
        }
        return null;
    }
    public boolean updateStatus(int id, DeviceStatus status) {
        for (Device device : devices) {
            if (device.getId() == id) {
                device.changeStatus(status);
                return true;
            }
        }
        return false;
    }
    public boolean deleteById(int id) {
        for (Device device: devices) {
            if (device.getId() == id) {
                devices.remove(device);
                return true;
            }
        }
        return false;
    }
}
