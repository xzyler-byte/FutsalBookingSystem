package com.ncit.minor.futsalbookingapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String bookingStat;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Future
	private Date bookDate;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	private Futsal futsal;
}
