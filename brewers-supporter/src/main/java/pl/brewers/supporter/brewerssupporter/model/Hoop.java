package pl.brewers.supporter.brewerssupporter.model;


import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@Builder
public class Hoop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private HoopType type;
    private String country;
    private String producer;
    private String name;
    private BigDecimal aminokwasy; //TODO change name
}
