package com.beyond.basic.b2_board.author.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    @OneToOne
    @JoinColumn(name = "author_id",unique = true, nullable = false)
    private Author author;
}
