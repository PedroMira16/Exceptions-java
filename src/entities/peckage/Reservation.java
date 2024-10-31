package entities.peckage;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import exceptions.DelusionException;

public class Reservation {
	
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) throws DelusionException {
		super();
		if (checkin.isAfter(checkout)) {
			throw new DelusionException("A data de check-in que você falou está errada");
		}
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public Reservation() {
		
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	
	
	public Integer duration() {
		
	Integer diffmilie =	getCheckin().getDayOfMonth() - getCheckout().getDayOfMonth();
	return diffmilie;
		
	}
	public void updateDate(LocalDate checkin,LocalDate checkout)throws DelusionException {
		
			if (checkout.isBefore(checkin)) {
				throw new DelusionException("Essa data não pode ser alterada. Check-out antes do Check-in");
			}
		this.checkin = checkin;
		this.checkout = checkout;
		duration();
		
	}
	@Override
	public String toString() {
		return "Update: " + " Check-in: " +getCheckin() + "," + "Check-out: " + getCheckout() + "," + duration();
	}

}
