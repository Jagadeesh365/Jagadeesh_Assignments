package com.room.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.room.exception.RoomStatusException;
import com.room.exception.RoomTypeNotFound;
import com.room.exception.SequenceNotFound;
import com.room.model.RoomsAvailable;
import com.room.model.RoomsBooked;
import com.room.model.BookedRoomsDetails;
import com.room.model.Report;
import com.room.model.Show;
import com.room.model.Room;
import com.room.model.RoomType;
import com.room.repository.RoomRepository;
import com.room.repository.SequenceRepository;
import com.room.service.util.CheckRoomType;




@Service
public class RoomService {

	//******************* Defaults from application.properties ***************** //

	@Value("${sequence.key}")
	private String counterKey;

	@Value("${room.prefix}")
	private String roomPrefix; 

	@Value("${room.status.default}")
	private String defaultStatus;

	@Value("${room.status.available}")
	private String availableStatus;

	@Value("${room.status.booked}")
	private String bookedStatus;

	@Value("${room.status.available.nights}")
	private int defaultNights;

	//***************************************************************************** //
	private int totalEarnings = 0;

	@Autowired
	SequenceRepository sequenceRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	Room bRoom;

	@Autowired
	RoomTypeService roomTypeService;

	@Autowired
	CheckRoomType eRoomType;

	@Autowired
	Logger logger;

	private List<Optional<Room>> allOptionalObjects;

	// Methods starts from Here
	// Add new room
	public Show addNewRoom(Room room) {
		try {
			eRoomType.exists(room.getRoomType());
			long sId = sequenceRepository.getNextSequenceId(counterKey);
			String cId = roomPrefix + sId;
			room.setId(cId); 
			room.setBookingDetails(null);
			roomRepository.save(room);
			return new Show("Success! Room with Id - "+room.getId(),"Added");
		}
		catch(RoomTypeNotFound e) {
			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getLocalizedMessage());
		}
		catch(IllegalArgumentException e) {
			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getLocalizedMessage());
		}
		catch(Exception e) {

			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getMessage());
		}

	}
	//search all Rooms
	public List<Room> getAllRooms()
	{	
		return roomRepository.findAll();
	}
	// Add Multiple Rooms
	public Show addInBulk(int count, String type) {

		int countBackUp = count;

		try {
			eRoomType.exists(type);

			while(count>0) {
				long sId = sequenceRepository.getNextSequenceId(counterKey);
				String cId = roomPrefix + sId;
				bRoom.setId(cId);
				bRoom.setRoomType(type);
				bRoom.setStatus(defaultStatus);
				bRoom.setBookingDetails(null);
				roomRepository.save(bRoom);
				count--;
			}

			return new Show(""+countBackUp,"Added successfully "+ countBackUp+ " of type "+type);
		}
		catch(SequenceNotFound e) { 
			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getLocalizedMessage());
		}
		catch(RoomTypeNotFound e) {
			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getLocalizedMessage());
		}
		catch(IllegalArgumentException e) {
			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getLocalizedMessage());
		}
		catch(Exception e) {
			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getMessage());
		}

	}

	// Get Room By Id
	public Room getRoomById(String id) {
		try {
			return roomRepository.findById(id).get();
		}catch(Exception e) {
			logger.warn(e.getMessage());
			return null;
		}	
	}

	// Get Room By Type
	public List<Room> getRoomsByType(String type){
		try {
			allOptionalObjects = roomRepository.findByRoomType(type);
			List<Room> allRoomsByType = allOptionalObjects.stream().map(i->i.get()).collect(Collectors.toList());
			return allRoomsByType;
		}catch(Exception e) {
			logger.warn(e.getMessage());
			return null;
		}
	}

	// Get Room By Status
	public List<Room> getRoomsByStatus(String status){
		try {
			allOptionalObjects = roomRepository.findByStatus(status);
			List<Room> allRoomsByStatus = allOptionalObjects.stream().map(i->i.get()).collect(Collectors.toList());
			return allRoomsByStatus;
		}
		catch(Exception e) {
			logger.warn(e.getMessage());
			return null;
		}

	}

	//Get all Available Rooms with count 
	public RoomsAvailable getAllAvailableRooms() {
		try {
			List<Room> allAvailableRooms  = getRoomsByStatus(availableStatus);
			return new RoomsAvailable(allAvailableRooms.size(),allAvailableRooms); 
		}
		catch(NullPointerException e) {
			logger.warn(e.getMessage());
			return new RoomsAvailable(0,null);
		}

	}

	//Get all Booked Rooms with count 
	public RoomsBooked getAllBookedRooms() {
		try {
			List<Room> allAvailableRooms  = getRoomsByStatus(bookedStatus);
			return new RoomsBooked(allAvailableRooms.size(),allAvailableRooms); 
		}
		catch(NullPointerException e) {
			logger.warn(e.getMessage());
			return new RoomsBooked(0,null);
		}
	}

	//Update Room Details
	public Show updateRoomDetails(Room room) throws RoomStatusException {
		try {

			if((!room.getStatus().equals(availableStatus)) && (!room.getStatus().equals(bookedStatus))) {
				throw new RoomStatusException("The entered status "+room.getStatus()+" is neither "+availableStatus +" nor "+bookedStatus);
			}
			if(room.getStatus().toString().toUpperCase().equals(availableStatus)) {
				room.setBookingDetails(null);
			}

			if(getRoomById(room.getId()) == null) {
				return new Show("Invalid Request! ","Enter a proper Id");
			}
			roomRepository.save(room);
			return new Show(room.getId(),"Updated successfully!");

		}
		catch(RoomStatusException e) {
			return new Show("Exception Occured",e.getLocalizedMessage());
		}
		catch(RoomTypeNotFound e) {

			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getLocalizedMessage());
		}
		catch(IllegalArgumentException e) {

			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getLocalizedMessage());
		}
		catch(Exception e) {

			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getMessage());
		}
	}

	//Delete Room By Id
	public Show deleteRoomById(String id) {
		try {
			roomRepository.deleteById(id);
			return new Show(id,"Deleted Successfully!");
		}
		catch(NoSuchElementException e) {
			logger.warn(e.getMessage());
			return new Show(id,"Room Doesn't Exist, Enter a proper Id");
		}
		catch(Exception e) {
			logger.warn(e.getMessage());
			return new Show("Exception Occured",e.getLocalizedMessage());
		}

	}
	//Generate earnings report
	public Report generateEarningsReport(){

		Report report = new Report();
		List<BookedRoomsDetails> bookedRoomsDetailsList = new ArrayList<>();

		List<Room> availableRooms = getRoomsByStatus(availableStatus);
		List<Room> bookedRooms = getRoomsByStatus(bookedStatus);

		int totalRooms = availableRooms.size() + bookedRooms.size();

		RoomType allRoomTypes = roomTypeService.getAllTypes();
		report.setTotalRooms(totalRooms);

		bookedRooms.stream().forEach(room->{
			BookedRoomsDetails bookedRoomsDetails = new BookedRoomsDetails();
			bookedRoomsDetails.setId(room.getId());
			bookedRoomsDetails.setStatus(room.getStatus());
			bookedRoomsDetails.setDateOfBooking(room.getBookingDetails().getBookingDate());
			bookedRoomsDetails.setNights(room.getBookingDetails().getNights());
			bookedRoomsDetails.setAmount(room.getBookingDetails().getNights() * (allRoomTypes.getRoomType().get(room.getRoomType())));
			bookedRoomsDetailsList.add(bookedRoomsDetails);
		});

		report.setAvailableRooms(availableRooms.size());
		report.setBookedRooms(bookedRooms.size());
		report.setBookedRoomsDetails(bookedRoomsDetailsList);
		bookedRoomsDetailsList.stream().forEach(i->{
			totalEarnings+=i.getAmount();
		});

		report.setTotalEarnings(totalEarnings);
		return report;

	}
	
}
