package com.abacuspro.hotelbeta.service;

import com.abacuspro.hotelbeta.domain.Room;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class RoomReservationServiceImpl implements RoomReservationService {
	@Override
	public Page<Room> getAllRooms() {
		return null;
	}
}
