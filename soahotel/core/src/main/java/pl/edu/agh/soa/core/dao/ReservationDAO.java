package pl.edu.agh.soa.core.dao;

import pl.edu.agh.soa.core.bean.Reservation;

import javax.ejb.Local;

import java.util.List;

@Local
public interface ReservationDAO {

    public Reservation getReservation(Long id);
    public List<Reservation> getReservations(Long id);
    public List<Reservation> getReservationsForHotel(Long hotelId);
    public void addReservation(Reservation reservation);
    public void removeReservation(Long id);
    public void updateReservation(Reservation reservation);
	public List<Reservation> getReservations();
	public List<Reservation> getReservations(Long hotelID, Long roomTypeID, Integer year);

}
