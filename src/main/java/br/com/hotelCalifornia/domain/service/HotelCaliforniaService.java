package br.com.hotelCalifornia.domain.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import br.com.hotelCalifornia.infraestructure.repository.HotelRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HotelCaliforniaService {
	

	private HotelRepository repository;
	
	@Autowired
	public HotelCaliforniaService(HotelRepository repository) {
		this.repository = repository;
	}

	@Autowired
	public List<HotelCaliforniaModel> Todos() {
		return repository.findAll();
		
	}

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<HotelCaliforniaModel> find(@PathVariable UUID id){
		return repository.findById(id)
				.map(mapping -> ResponseEntity.ok().body(mapping))
				.orElse(ResponseEntity.notFound().build());
	}

	
	  @PutMapping("/{id}")
	    public ResponseEntity<HotelCaliforniaModel> update(@PathVariable UUID id, @RequestBody HotelCaliforniaModel updatedHotel) {
	        return repository.findById(id)
	            .map(existingHotel -> {
	                existingHotel.setNome(updatedHotel.getNome()); 
	                existingHotel.setLocal(updatedHotel.getLocal()); 
	                existingHotel.setCapacidade(updatedHotel.getCapacidade()); 
	              
	                HotelCaliforniaModel savedHotel = repository.save(existingHotel);
	                return ResponseEntity.ok().body(savedHotel);
	            })
	            .orElse(ResponseEntity.notFound().build());
	    }
	  
	  
	  //Delete
		@DeleteMapping(value = "/{id}")
		public ResponseEntity<?> delete (@PathVariable UUID id){
			return repository.findById(id)
					.map(mapping -> { 
					repository.deleteById(id);
						
					return ResponseEntity.ok().body("DELETADO COM SUCESSO!");
					}).orElse(ResponseEntity.notFound().build());
		}
	
	
	  public HotelCaliforniaModel  SalvarService(HotelCaliforniaModel hotel) {
		return repository.save(hotel);
	  }
	
	

	
	
	
	
	
}
