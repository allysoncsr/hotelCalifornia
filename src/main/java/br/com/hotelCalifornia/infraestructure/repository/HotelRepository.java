package br.com.hotelCalifornia.infraestructure.repository;



import org.springframework.stereotype.Repository;
import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;



@Repository
public interface HotelRepository extends JpaRepository<HotelCaliforniaModel, UUID> {

}
