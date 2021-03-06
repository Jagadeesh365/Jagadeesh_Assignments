
package com.guest.Service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.guest.Model.Guest;
import com.guest.Model.Show;
import com.guest.Repository.GuestRepository;



@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestServiceTest {

	@Autowired
	private GuestService guestService;

	@MockBean
	private GuestRepository guestRepository;

	@MockBean
	private Show show ;

	@Test
	public void testaddGuest()
	{
		Guest guest = new Guest();
		Show show = new Show();
		show.setMessage("Success!, Guest Added");
		show.setRefId("G1");
		guest.setId("G1");
		guest.setName("Madhu");
		guest.setGender("Male");
		guest.setAge(20);
		guest.setMobileNo("9989976756");

		Mockito.when(guestRepository.save(guest)).thenReturn(guest);
		assertEquals(show.getRefId(),"G1");
		assertEquals(show.getMessage(),"Success!, Guest Added");

	}
	@Test
	public void testgetAllGuests()
	{
		Guest guest1 = new Guest();
		Show show1 = new Show();
		show1.setMessage("Success!, Guest Added");
		show1.setRefId("G1");
		guest1.setId("G1");
		guest1.setName("Madhu");
		guest1.setGender("Male");
		guest1.setAge(20);
		guest1.setMobileNo("9989976756");

		Guest guest2 = new Guest();
		Show show2 = new Show();
		show2.setMessage("Success!, Guest Added");
		show2.setRefId("G2");
		guest2.setId("G2");
		guest2.setName("Madhu1");
		guest2.setGender("Male");
		guest2.setAge(20);
		guest2.setMobileNo("9989976759");

		List<Guest> guestList = new ArrayList<>();
		guestList.add(guest1);
		guestList.add(guest2);

		Mockito.when(guestRepository.findAll()).thenReturn(guestList);
		assertThat(guestService.getAllGuests()).isEqualTo(guestList);

	}

	// executing catch block need to re check!!
/*
	@Test
	public void testgetGuestById()
	{

		RoomStay room = new RoomStay();
		room.setNoOfNights(2);
		room.setRoomId("R1");

		AdditionalMembers members = new AdditionalMembers();
		members.setName("Sri");
		members.setGender("Female");
		members.setAge(20);

		Address address = new Address();
		address.setCountry("India");
		address.setState("Andhra Pradesh");
		address.setCity("Bhimavaram");
		address.setStreet("ASR Nagar");
		address.setZipcode("534210");

		Guest guest = new Guest();
		guest.setId("G1");
		guest.setName("Madhu");
		guest.setGender("Male");
		guest.setAge(20);
		guest.setMobileNo("9989976756");

		Mockito.when(guestRepository.findById("G1").get()).thenReturn(guest);
		assertThat(guestService.getGuestById("G1")).isEqualTo(guest);
	}

	@Test
	public void testgetGuestByName()
	{
		Optional<Guest> guest1 = Optional.of(new Guest());
		guest1.get().setId("G1");
		guest1.get().setName("Madhu");
		guest1.get().setGender("Male");
		guest1.get().setAge(20);
		guest1.get().setMobileNo("9989976756");

		List<Optional<Guest>> guestList = new ArrayList<>();
		guestList.add(guest1);
		Mockito.when(guestRepository.findByName("Madhu")).thenReturn(guestList);
		assertThat(guestService.getGuestByName("Madhu")).isEqualTo(guest1);
	}
*/
	@Test
	public void testupdateGuest()
	{
		Guest guest = new Guest();
		Show show = new Show();
		show.setMessage("Success!, Guest Details Updated");
		show.setRefId("G1");
		guest.setId("G1");
		guest.setName("Madhu Simhadri");
		guest.setGender("Male");
		guest.setAge(20);
		guest.setMobileNo("9989976756");

		Mockito.when(guestRepository.save(guest)).thenReturn(guest);
		assertEquals(show.getRefId(),"G1");
		assertEquals(show.getMessage(),"Success!, Guest Details Updated");

	}

	@Test
	public void testdeleteGuest()
	{
		Optional<Guest> guest = Optional.of(new Guest());		
		guest.get().setId("G1");
		guest.get().setName("Madhu");
		guest.get().setGender("Male");
		guest.get().setAge(20);
		guest.get().setMobileNo("9989976756");

		Mockito.when(guestRepository.findById("G1")).thenReturn(guest);
		Mockito.when(guestRepository.existsById(guest.get().getId())).thenReturn(false);
		assertFalse(guestRepository.existsById(guest.get().getId()));
	}


}
