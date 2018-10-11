package com.abacuspro.hotelbeta.domain;

import java.util.Objects;


public class Room {

	private int roomId;
	private int roomNumber;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Room room = (Room) o;
		return roomNumber == room.roomNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomNumber);
	}

	@Override
	public String toString() {
		return "Room{" +
				"roomId=" + roomId +
				", roomNumber=" + roomNumber +
				'}';
	}
}
