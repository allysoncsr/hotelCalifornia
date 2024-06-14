package br.com.hotelCalifornia.api.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hotelCalifornia.domain.service.HotelCaliforniaService;
import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;


@RestController
@RequestMapping({"/api/hotelCalifornia"})
public class HotelCaliforniaController {
	
	private HotelCaliforniaService Services;

	@Autowired
	public HotelCaliforniaController(HotelCaliforniaService Services) {
		this.Services = Services;
	}
		
	
	//list all
	@GetMapping
	public List<HotelCaliforniaModel> findAll() {
		return Services.Todos();
		
	}
	
	
	//FindById
	@GetMapping(value = "/{id}")
	public ResponseEntity<HotelCaliforniaModel> find(@PathVariable UUID id){
		return Services.find(id);
	}
	
	
	//Create
	@PostMapping(value="/salvar")
	public HotelCaliforniaModel create(@RequestBody HotelCaliforniaModel hotelCalifornia) {
		return Services.SalvarService(hotelCalifornia);
	}
	
	
	//Delete
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete (@PathVariable UUID id){
		return Services.delete(id);
				
	}
	
	
	// Update
    @PutMapping("/{id}")
    public ResponseEntity<HotelCaliforniaModel> update(@PathVariable UUID id, @RequestBody HotelCaliforniaModel updatedHotel) {
        return Services.update(id, updatedHotel);
    }
	
	
}
