package com.github.mmalaquias1.swarm.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Auction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private BigDecimal initialValue;
    @Column(nullable = false)
    private LocalDate openDate;
    private Boolean finised;
    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    public Auction() {   }

    public Auction(String title, BigDecimal initialValue, LocalDate openDate) {
        this.title = title;
        this.initialValue = initialValue;
        this.openDate = openDate;
    }


}
