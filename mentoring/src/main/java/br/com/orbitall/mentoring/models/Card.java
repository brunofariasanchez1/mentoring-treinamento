package br.com.orbitall.mentoring.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="CARDS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Card {
    //@Id = Primary key
    @Id private UUID id;
    @Version private int version;
    private String fullName;
    private String number;
    private String cvv2;
    private String validThru;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean status;

}
