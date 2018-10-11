package com.abacuspro.hotelbeta.service;


import com.abacuspro.hotelbeta.domain.Room;
import org.springframework.data.domain.Page;

public interface RoomReservationService {
	Page<Room> getAllRooms();
}
