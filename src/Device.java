public class Device {

    private int id;
    private String deviceName;
    private DeviceStatus Status;
    private DeviceType deviceType;

    public Device(int id, String deviceName, DeviceStatus Status, DeviceType deviceType) {
        this.id = id;
        this.deviceName = deviceName;
        this.Status = Status;
        this.deviceType = deviceType;
    }
    public int getId() {
        return id;
    }
    public String  getDeviceName() {
        return deviceName;
    }
    public DeviceStatus getStatus() {
        return Status;
    }
    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void displayInfo() {
        System.out.println("Device ID: " + id);
        System.out.println("Device Name: " + deviceName);
        System.out.println("Status: " + Status);
        System.out.println("Device Type: " + deviceType);
    }
    public void changeStatus(DeviceStatus Status) {
        this.Status = Status;
    }
}
