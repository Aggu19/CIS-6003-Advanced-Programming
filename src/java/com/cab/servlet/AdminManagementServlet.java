package com.cab.servlet;

import com.cab.dao.BookingDAO;
import com.cab.dao.DriverDAO;
import com.cab.dao.CustomerDAO;
import com.cab.model.Booking;
import com.cab.model.Driver;
import com.cab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/manage")
public class AdminManagementServlet extends HttpServlet {

    // Handles GET requests for the admin management pages
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("manageBookings".equals(action)) {
            manageBookings(request, response);
        } else if ("manageDrivers".equals(action)) {
            manageDrivers(request, response);
        } else if ("manageCustomers".equals(action)) {
            manageCustomers(request, response);
        } else {
            response.sendRedirect("admin/dashboard.jsp");
        }
    }

    // Handles POST requests for deleting bookings or other actions
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("deleteBooking".equals(action)) {
            deleteBooking(request, response);
        } else if ("deleteDriver".equals(action)) {
            deleteDriver(request, response);
        } else if ("deleteCustomer".equals(action)) {
            deleteCustomer(request, response);
        }
    }

    // Manage bookings
    private void manageBookings(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookingDAO bookingDAO = new BookingDAO();
        List<Booking> bookings = bookingDAO.getAllBookings();
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("admin/bookingManagement.jsp").forward(request, response);
    }

    // Manage drivers
    private void manageDrivers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DriverDAO driverDAO = new DriverDAO();
        List<Driver> drivers = driverDAO.getAllDrivers();
        request.setAttribute("drivers", drivers);
        request.getRequestDispatcher("admin/driverManagement.jsp").forward(request, response);
    }

    // Manage customers
    private void manageCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getAllCustomers();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("admin/customerManagement.jsp").forward(request, response);
    }

    // Delete a booking
    private void deleteBooking(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookingId = Integer.parseInt(request.getParameter("bookingId"));
        BookingDAO bookingDAO = new BookingDAO();
        boolean isDeleted = bookingDAO.deleteBooking(bookingId);

        if (isDeleted) {
            response.sendRedirect("admin/manage?action=manageBookings");  // Refresh the booking management page
        } else {
            request.setAttribute("errorMessage", "Failed to delete the booking.");
            request.getRequestDispatcher("admin/bookingManagement.jsp").forward(request, response);
        }
    }

    // Delete a driver
    private void deleteDriver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int driverId = Integer.parseInt(request.getParameter("driverId"));
        DriverDAO driverDAO = new DriverDAO();
        boolean isDeleted = driverDAO.deleteDriver(driverId);

        if (isDeleted) {
            response.sendRedirect("admin/manage?action=manageDrivers");  // Refresh the driver management page
        } else {
            request.setAttribute("errorMessage", "Failed to delete the driver.");
            request.getRequestDispatcher("admin/driverManagement.jsp").forward(request, response);
        }
    }

    // Delete a customer
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        CustomerDAO customerDAO = new CustomerDAO();
        boolean isDeleted = customerDAO.deleteCustomer(customerId);

        if (isDeleted) {
            response.sendRedirect("admin/manage?action=manageCustomers");  // Refresh the customer management page
        } else {
            request.setAttribute("errorMessage", "Failed to delete the customer.");
            request.getRequestDispatcher("admin/customerManagement.jsp").forward(request, response);
        }
    }
}
