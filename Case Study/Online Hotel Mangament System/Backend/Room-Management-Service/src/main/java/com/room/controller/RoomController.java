package com.room.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.room.model.Report;
import com.room.model.Room;
import com.room.model.RoomsAvailable;
import com.room.model.RoomsBooked;
import com.room.model.Show;
import com.room.service.RoomService;


@RestController
public class RoomController {
	
	@Autowired
	RoomService roomService;

	@PostMapping("/addRoom")
	public Show addNewRoom(@RequestBody Room room) {
		return roomService.addNewRoom(room);
	}
	@GetMapping("/getAllRooms")
	public List<Room> getAllRooms()
	{
		
		return roomService.getAllRooms();
	}
	
	@PostMapping("/addMultiple/{type}/{count}")
	public Show addInBulk(@PathVariable int count, @PathVariable String type) {
		return roomService.addInBulk(count, type);
	}
	@GetMapping("/getRoom/{id}")
	public Room getRoomById(@PathVariable String id) {
		return roomService.getRoomById(id);
	}
	
	@GetMapping("/getAllRoomsByType/{type}")
	public List<Room> getRoomsByType(@PathVariable String type){
		return roomService.getRoomsByType(type);
	}
	
	@GetMapping("/getAllRoomsByStatus/{status}")
	public List<Room> getRoomsByStatus(@PathVariable String status){
		return roomService.getRoomsByStatus(status);
	}
	
	
	@GetMapping("/getAllAvailableRooms")
	public RoomsAvailable getAllAvailableRooms() {
		return roomService.getAllAvailableRooms();
	}
	
	@GetMapping("/getAllBookedRooms")
	public RoomsBooked getAllBookedRooms() {
		return roomService.getAllBookedRooms();
	}
	
	@PutMapping("/updateRoom")
	public Show updateRoomDetails(@RequestBody Room room) {
		return roomService.updateRoomDetails(room);
	}
	
	@DeleteMapping("/deleteRoom/{id}")
	public Show deleteRoomById(@PathVariable String id) {
		return roomService.deleteRoomById(id);
	}
	
	
	@GetMapping("/getReports")
	public Report getreports() {
		return roomService.generateEarningsReport();
	}
}
