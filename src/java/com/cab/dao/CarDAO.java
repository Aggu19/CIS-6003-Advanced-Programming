package com.cab.dao;

import com.cab.model.Car;

import java.sql.*;

public class CarDAO {

    public boolean addCar(Car car) {
        String query = "INSERT INTO cars (car_model, license_plate, vehicle_type) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, car.getCarModel());
            ps.setString(2, car.getLicensePlate());
            ps.setString(3, car.getVehicleType());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateCar(Car car) {
        String query = "UPDATE cars SET car_model = ?, license_plate = ?, vehicle_type = ? WHERE car_id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, car.getCarModel());
            ps.setString(2, car.getLicensePlate());
            ps.setString(3, car.getVehicleType());
            ps.setInt(4, car.getCarId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCar(int carId) {
        String query = "DELETE FROM cars WHERE car_id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, carId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Car getCarById(int carId) {
        Car car = null;
        String query = "SELECT * FROM cars WHERE car_id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, carId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    car = new Car(
                            rs.getInt("car_id"),
                            rs.getString("car_model"),
                            rs.getString("license_plate"),
                            rs.getString("vehicle_type")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }
}
