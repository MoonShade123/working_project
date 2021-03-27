package com.work.working_project_1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Table(name = "farm")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "farm_id")
    private Long id;

    @Column(unique = true)
    private String farmName;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @OneToOne(mappedBy = "farm", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FarmIndicators farmIndicators;


}
