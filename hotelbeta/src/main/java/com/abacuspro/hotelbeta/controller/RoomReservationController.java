package com.abacuspro.hotelbeta.controller;

import com.abacuspro.hotelbeta.domain.Room;
import com.abacuspro.hotelbeta.service.RoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest conttroller for room reservations
 */

@RestController
@RequestMapping("/hotel")
public class RoomReservationController {

	private RoomReservationService roomReservationService;

	@Autowired
	public RoomReservationController(RoomReservationService roomReservationService) {
		this.roomReservationService = roomReservationService;
	}

	@GetMapping(value= "/allrooms")
	public Page<Room> getAllRooms() {
		Page<Room> allRooms = roomReservationService.getAllRooms();
		return allRooms;
	}
}
