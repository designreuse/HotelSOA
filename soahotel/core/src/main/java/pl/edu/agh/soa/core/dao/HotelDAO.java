package pl.edu.agh.soa.core.dao;

import java.util.List;

import javax.ejb.Local;

import pl.edu.agh.soa.core.bean.Hotel;
import pl.edu.agh.soa.core.bean.Room;
import pl.edu.agh.soa.core.bean.RoomType;

@Local
public interface HotelDAO {
	public void saveHotel(Hotel hotel);
	public List<Hotel> list();
	public void addRoom(Room room);
	public void addRoomType(RoomType roomType);
	public List<Room> listRoom(Long id);
	public Hotel getHotelById(Long id);
	public List<RoomType> getRoomTypes();
	public RoomType getRoomTypeById(Long id);
	public List<RoomType> getRoomTypes(Long id);
	public void updateHotel(Hotel hotel);
	public void deleteHotel(Long id);
}
