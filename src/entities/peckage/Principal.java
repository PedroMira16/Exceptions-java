package entities.peckage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

import exceptions.DelusionException;

public class Principal {
	
	public static void main(String args[]) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner teclado = new Scanner(System.in);
		
		try {
		System.out.println("Room Number: ");
		int quartin = teclado.nextInt();
		teclado.nextLine();
		
		System.out.println("Check-in date (dd/MM/yyyy): ");
		String chek1 = teclado.nextLine();
		LocalDate checkin = LocalDate.parse(chek1, formatter);
		
		System.out.println("Check-out date (dd/MM/yyyy): ");
		String check2 = teclado.nextLine();
		 LocalDate checkout = LocalDate.parse(check2, formatter);
		
		Reservation cc = new Reservation(quartin,checkin,checkout);
		
		System.out.println("Reservation: " + "Room: "+ cc.getRoomNumber() + "Check-in: " +cc.getCheckin() + "Check-out: " + cc.getCheckout() +" "+ cc.duration()+ " nights");
		
		System.out.println("Enter data to update the reservation(dd/MM/yyyy): ");
		int h = teclado.nextInt();
		cc.setRoomNumber(h);
		
		System.out.println("Enter data to update the Check-in: ");
		String upd = teclado.next();
		LocalDate update = LocalDate.parse(upd, formatter);
		
		System.out.println("Enter data to update the Check-out:");
		String upd2 = teclado.next();
		LocalDate update2 = LocalDate.parse(upd2, formatter);
		
		cc.updateDate(update, update2);
		
		} 
		catch(DelusionException e) {
			System.out.println(e.getMessage());
		}
		catch(DateTimeParseException e) {
			System.out.println(e.getMessage());
		}
	}

}
