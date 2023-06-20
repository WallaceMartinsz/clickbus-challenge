package br.com.wallace.clickbus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Table
@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Place {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String city;
    private String state;
    @CreatedDate
    LocalDateTime createdAt;
    @LastModifiedDate
    LocalDateTime updatedAt;

    public Place(PlaceRequest data){
        this.name = data.name();
        this.slug = data.slug();
        this.city = data.city();
        this.state = data.state();
    }
    public void updatePlace(PlaceUpdate data) {
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.slug() != null){
            this.slug = data.slug();
        }
        if(data.city() != null){
            this.city = data.city();
        }
        if(data.state() != null){
            this.state = data.state();
        }
        if(data.updatedAt() != null){
            this.updatedAt = data.updatedAt();
        }
    }
}
