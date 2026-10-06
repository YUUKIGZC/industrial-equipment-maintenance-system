package com.industrial.repository;

import com.industrial.model.Device;
import com.industrial.model.DeviceStatus;
import com.industrial.model.DeviceType;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Repository: 声明Repository类，托管给Spring
@Repository
public class DeviceRepository {

    private final String url = "jdbc:mysql://localhost:3306/industrial_equipment";
    private final String username = "root";
    private final String password = "123456";
//  INSERT、UPDATE、DELETE
//   ↓
//  executeUpdate()
//   ↓
//  int
    public void save(Device device) {
        String sql = """
                INSERT INTO devices (device_name, device_type, status)
                VALUES (?, ?, ?)
                """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);

                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, device.getDeviceName());
            statement.setString(2,device.getDeviceType().name());
            statement.setString(3,device.getStatus().name());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                int generatedId = resultSet.getInt(1);
                device.setId(generatedId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//  SELECT
//   ↓
//  executeQuery()
//   ↓
//  ResultSet
    public List<Device> findAll() {
        List<Device> devices = new ArrayList<>();

        String sql = "SELECT * FROM devices";

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String deviceName = resultSet.getString("device_name");
                String deviceType = resultSet.getString("device_type");
                String status = resultSet.getString("status");

                Device device = new Device(id, deviceName, DeviceType.valueOf(deviceType), DeviceStatus.valueOf(status));

                devices.add(device);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return devices;
    }
    public Device findById(int id) {

        String sql = "SELECT * FROM devices WHERE id = ?";

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int deviceId = resultSet.getInt("id");
                String deviceName = resultSet.getString("device_name");
                String deviceType = resultSet.getString("device_type");
                String status = resultSet.getString("status");

                Device device = new Device(deviceId, deviceName, DeviceType.valueOf(deviceType), DeviceStatus.valueOf(status));
                return device;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateStatus(int id, DeviceStatus status) {
        String sql = """
                UPDATE devices
                SET status = ?
                WHERE id = ?
                """;
        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(2, id);
            statement.setString(1, status.name());

            int rows = statement.executeUpdate();
            System.out.println("影响行数：" + rows);
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean deleteById(int id) {
        String sql = """
                DELETE FROM devices
                WHERE id = ?
                """;

        try (
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1,id);
            int rows = statement.executeUpdate();

            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
