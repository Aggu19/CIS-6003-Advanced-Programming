package com.cab.dao;

import com.cab.model.Booking;

import java.sql.*;
import java.util.List;

public class BookingDAO {

    public boolean addBooking(Booking booking) {
        String query = "INSERT INTO bookings (customer_id, pickup_location, booking_date, booking_time, hour_limit, total_amount) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, booking.getCustomerId());
            ps.setString(2, booking.getPickupLocation());
            ps.setDate(3, new java.sql.Date(booking.getBookingDate().getTime()));
            ps.setString(4, booking.getBookingTime());
            ps.setInt(5, booking.getHourLimit());
            ps.setDouble(6, booking.getTotalAmount());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBooking(Booking booking) {
        String query = "UPDATE bookings SET pickup_location = ?, booking_date = ?, booking_time = ?, hour_limit = ?, total_amount = ? WHERE booking_id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, booking.getPickupLocation());
            ps.setDate(2, new java.sql.Date(booking.getBookingDate().getTime()));
            ps.setString(3, booking.getBookingTime());
            ps.setInt(4, booking.getHourLimit());
            ps.setDouble(5, booking.getTotalAmount());
            ps.setInt(6, booking.getBookingId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBooking(int bookingId) {
        String query = "DELETE FROM bookings WHERE booking_id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, bookingId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Booking getBookingById(int bookingId) {
        Booking booking = null;
        String query = "SELECT * FROM bookings WHERE booking_id = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, bookingId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    booking = new Booking(
                            rs.getInt("booking_id"),
                            rs.getInt("customer_id"),
                            rs.getString("pickup_location"),
                            rs.getDate("booking_date"),
                            rs.getString("booking_time"),
                            rs.getInt("hour_limit"),
                            rs.getDouble("total_amount")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }

    public List<Booking> getAllBookings() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
