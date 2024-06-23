package com.handmade.atelie.backend.models.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "adresses")
@Entity(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private String id;

    @Getter @Setter
    @Column(nullable = false, length = 9)
    private String zipCode;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "FK_state_id", nullable = false)
    private State state;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String street;

    @Getter @Setter
    @Column(nullable = false, length = 20)
    private String number;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String neighborhood;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String city;

    @Getter @Setter
    @Column(nullable = true, length = 100)
    private String complement;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "FK_user_id", nullable = false)
    private User user;

    public Address(String zipCode, State state, String street, String number, String neighborhood, String city, String complement, User user) {
        this.zipCode = zipCode;
        this.state = state;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.complement = complement;
        this.user = user;
    }

}
