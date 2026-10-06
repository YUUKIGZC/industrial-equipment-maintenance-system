package com.industrial.model;

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
    public void setId(int id) {
        this.id = id;
    }
    public String  getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public DeviceStatus getStatus() {
        return Status;
    }
    public void setStatus(DeviceStatus status) {
        this.Status = status;
    }
    public DeviceType getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
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
