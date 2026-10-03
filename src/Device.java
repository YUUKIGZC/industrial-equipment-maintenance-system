public class Device {

    private int id;
    private String deviceName;
    private DeviceStatus Status;

    public Device(int id, String deviceName, DeviceStatus Status) {
        this.id = id;
        this.deviceName = deviceName;
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

    public void displayInfo() {
        System.out.println("Device ID: " + id);
        System.out.println("Device Name: " + deviceName);
        System.out.println("Status: " + Status);
    }
    public void changeStatus(DeviceStatus Status) {
        this.Status = Status;
    }
}
