public class Device {

    private int id;
    private String deviceName;
    private DeviceStatus Status;
    private DeviceType deviceType;

    public Device(int id, String deviceName, DeviceType deviceType, DeviceStatus Status) {
        this.id = id;
        this.deviceName = deviceName;
        this.deviceType = deviceType;
        this.Status = Status;
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
        System.out.println("Device Type: " + deviceType);
        System.out.println("Status: " + Status);
    }
    public void changeStatus(DeviceStatus Status) {
        this.Status = Status;
    }
}
