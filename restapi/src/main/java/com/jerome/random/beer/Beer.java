package com.jerome.random.beer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Immutable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Beer {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double abv;

    @Column(nullable = false)
    private String breweryLocation;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime created;

}
