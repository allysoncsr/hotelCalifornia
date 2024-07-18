package br.com.hotelCalifornia.infraestructure.repository;



import org.springframework.stereotype.Repository;
import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



@Repository
public interface HotelRepository extends JpaRepository<HotelCaliforniaModel, UUID> {
	
	    
	    @Query(value= "SELECT * FROM hotel_california h WHERE h.cnpj = :cnpj", nativeQuery=true)
	    HotelCaliforniaModel encontrarCnpj(@Param("cnpj")String cnpj);
	    
	    @Query(value= "SELECT * FROM hotel_california h WHERE h.nome = :nome", nativeQuery=true)
		HotelCaliforniaModel findNome(@Param("nome")String nome);

	    @Query(value="SELECT * FROM hotel_california hc WHERE h.localizacao = :localizacao", nativeQuery=true)
	    HotelCaliforniaModel findLocalizacao(@Param("localizacao")String localizacao);
	    
	    @Query(value="SELECT * FROM hotel_california hc WHERE h.id = :id", nativeQuery = true)
	    Optional<HotelCaliforniaModel> find(@Param("id")UUID id);

	    @Query(value= "SELECT * FROM hotel_california h WHERE h.nome = :nome", nativeQuery=true)
	    HotelCaliforniaModel encontrarNome(@Param("nome")String nome);
	   

	}

		