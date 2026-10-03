public class Device {

    private int id;
    private String deviceName;
    private DeviceStatus Status;

    public Device(int id, String deviceName) {
        this.id = id;
        this.deviceName = deviceName;
    }
    public int getId() {
        return id;
    }
    public String  getDeviceName() {
        return deviceName;
    }

    public void displayInfo() {
        System.out.println("Device ID: " + id);
        System.out.println("Device Name: " + deviceName);
    }
}
