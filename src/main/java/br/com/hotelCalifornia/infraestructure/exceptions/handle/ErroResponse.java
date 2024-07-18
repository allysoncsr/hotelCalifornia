package br.com.hotelCalifornia.infraestructure.exceptions.handle;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class ErroResponse {

	
	
 //atributos

	private String message;
	private LocalDateTime data;
	private int status;
	private String path;
	
 //construtores	
	public ErroResponse(String message, LocalDateTime data, int status, String path) {
		this.message = message;
		this.data = data;
		this.status = status;
		this.path = path;
	}
	
	
	public ErroResponse() {
	}
	
 	
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	
	
}
