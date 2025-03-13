package com.cab.servlet;

import com.cab.dao.BookingDAO;
import com.cab.model.Booking;
import com.cab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet("/book")
public class BookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            response.sendRedirect("login.jsp");  // Redirect to login if the customer is not logged in
            return;
        }

        String pickupLocation = request.getParameter("pickupLocation");
        Date bookingDate = new Date(); // current date as booking date
        String bookingTime = request.getParameter("bookingTime");
        int hourLimit = Integer.parseInt(request.getParameter("hourLimit"));
        double totalAmount = 100.0; // Dummy value, calculate based on vehicle type and time (add logic here)

        Booking booking = new Booking(customer.getCustomerId(), pickupLocation, bookingDate, bookingTime, hourLimit, totalAmount);
        BookingDAO bookingDAO = new BookingDAO();

        boolean isBooked = bookingDAO.addBooking(booking);
        if (isBooked) {
            response.sendRedirect("customer/bookingDetails.jsp");  // Redirect to booking details page
        } else {
            request.setAttribute("errorMessage", "Booking failed. Please try again.");
            request.getRequestDispatcher("customer/bookRide.jsp").forward(request, response);
        }
    }
}
