package br.com.hotelCalifornia.domain.service;
 
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hotelCalifornia.api.dto.HotelCaliforniaDto;
import br.com.hotelCalifornia.domain.converter.HotelConverter;
import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;
import br.com.hotelCalifornia.infraestructure.repository.HotelRepository;
 
 
@Service
public class HotelCaliforniaService {

	private HotelConverter hotelConverter;
		
    private HotelRepository repository;
    @Autowired
    public HotelCaliforniaService(HotelRepository repository, HotelConverter hotelConverter) {
        this.repository = repository;
        this.hotelConverter = hotelConverter;
    }

    public List<HotelCaliforniaModel> findTodos(){
        return repository.findAll();
    }

    public Optional<HotelCaliforniaModel> find(UUID id){
        return repository.findById(id);
    }


    
    public  HotelCaliforniaDto create(HotelCaliforniaDto hotelCalifornia){    
        	HotelCaliforniaModel hotel = hotelConverter.toModel(hotelCalifornia);  
        	HotelCaliforniaModel hotelSalvo = repository.save(hotel);             
        
        return hotelConverter.toDto(hotelSalvo);                            
        
    }
    

     
    public HotelCaliforniaDto deletar(String cnpj){
    	HotelCaliforniaModel hotel = repository.encontrarCnpj(cnpj);
    	HotelCaliforniaDto conversaoDto = hotelConverter.toDto(hotel);
    
    	repository.delete(hotel);
    	
    	return conversaoDto;
    }
    
   
    
          
     public HotelCaliforniaDto updateHotelCalifornia(UUID id, HotelCaliforniaDto dto) {
         HotelCaliforniaModel hotel = repository.findById(id)
                 .orElseThrow(() -> new NoSuchElementException("Hotel não encontrado"));
 
         hotel.setNome(dto.getNome());
         hotel.setLocal(dto.getLocalizacao());
         hotel.setCnpj(dto.getCnpj());
 
         return toDto(repository.save(hotel));
     }

     private HotelCaliforniaDto toDto(HotelCaliforniaModel hotelCalifornia) {
         HotelCaliforniaDto dto = new HotelCaliforniaDto();
         BeanUtils.copyProperties(hotelCalifornia, dto);
         return dto;
     }

     public HotelCaliforniaModel encontrarNome(String nome) {
         return repository.encontrarNome(nome);
     }
}