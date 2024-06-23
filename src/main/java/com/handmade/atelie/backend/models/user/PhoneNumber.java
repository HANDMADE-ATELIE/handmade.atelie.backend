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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "phone_numbers")
@Entity(name = "phone_numbers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PhoneNumber {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private String id;

    @Getter @Setter
    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "FK_user_id", nullable = false)
    private User user;

    public PhoneNumber(String phoneNumber, User user) {
        this.phoneNumber = phoneNumber;
        this.user = user;
    }
}
