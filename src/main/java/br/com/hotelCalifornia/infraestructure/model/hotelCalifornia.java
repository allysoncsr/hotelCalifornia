package br.com.hotelCalifornia.infraestructure.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "hotel_california_ally")


public class hotelCalifornia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "local")
	private String local;
	
	@Column(name = "capacidade")
	private int capacidade;

}
