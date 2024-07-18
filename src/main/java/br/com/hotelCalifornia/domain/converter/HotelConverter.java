package br.com.hotelCalifornia.domain.converter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import br.com.hotelCalifornia.api.dto.HotelCaliforniaDto;
import br.com.hotelCalifornia.infraestructure.model.HotelCaliforniaModel;




@Component
public class HotelConverter {

	
	 public HotelCaliforniaDto toDto(HotelCaliforniaModel hotel) {
	        HotelCaliforniaDto dto = new HotelCaliforniaDto();
	        dto.setNome(hotel.getNome());
	        dto.setLocalizacao(hotel.getLocal());
	        dto.setCnpj(hotel.getCnpj());
	        BeanUtils.copyProperties(hotel, dto);
	        return dto;
	    }

	 	 	
	    
		public HotelCaliforniaModel toModel(HotelCaliforniaDto dto) {
	        HotelCaliforniaModel hotel = new HotelCaliforniaModel();
	        hotel.setNome(dto.getNome());
	        hotel.setLocal(dto.getLocalizacao());
	        hotel.setCnpj(dto.getCnpj());
	        BeanUtils.copyProperties(dto, hotel);
	        return hotel;
	    }

	  
		public List<HotelCaliforniaDto> toDtoList(List<HotelCaliforniaModel> listaModel) {
	        return listaModel.stream().map(this::toDto).collect(Collectors.toList());

	    }
	
	
	
}

	


