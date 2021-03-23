package com.work.working_project_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Farms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String farmName;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @OneToOne(targetEntity = FarmIndicators.class, cascade = CascadeType.ALL)
    private FarmIndicators farmIndicators;
}
