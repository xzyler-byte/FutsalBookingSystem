package com.ncit.minor.futsalbookingapp.controller;

import com.ncit.minor.futsalbookingapp.model.Booking;
import com.ncit.minor.futsalbookingapp.service.BookingService;
import com.ncit.minor.futsalbookingapp.service.FutsalService;
import com.ncit.minor.futsalbookingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class BookingController {

    @Autowired
    FutsalService futsalService;
    @Autowired
    BookingService bookingService;
    @Autowired
    UserService userService;

    @GetMapping("/book")
    public String showFutsalList(Model model) {
        model.addAttribute("futsals", futsalService.findFutsal());
        model.addAttribute("booking", new Booking());
        return "listFutsal";
    }

    @PostMapping("/book/{futsalId}")
    public String bookFutsal(@PathVariable Long futsalId, @Valid Booking booking, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("booking", bookingService.findById(booking.getId()));
            return "bookFutsalForm";
        }
        Booking currentBooking = bookingService.findById(booking.getId());
        String time = booking.getActualBookDate().toLocaleString();
        currentBooking.setBookDate(time);
        bookingService.save(currentBooking);
        return "index";
    }

    @GetMapping("/book/{futsalId}")
    public String showBookFutsal(Model model, @PathVariable Long futsalId, Principal principal) {
        Booking booking = new Booking();
        booking.setBookingStat("pending");
        bookingService.save(booking);
        bookingService.createBooking(booking, userService.findByUsername(principal.getName()), futsalService.findById(futsalId));
        model.addAttribute("booking", booking);
        return "bookFutsalForm";
    }

    @GetMapping("/book/list")
    public String bookList(Model model, Principal principal) {
        model.addAttribute("bookings", bookingService.findByUser(userService.findByUsername(principal.getName())));
        return "bookingList";
    }
}
