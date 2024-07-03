package com.handmade.atelie.backend.models.product;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "copy_books")
@Entity(name = "copy_books")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Copybook {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private String id;

    @Getter @Setter
    @Column(nullable = false, length = 100)
    private String name;

    @Getter @Setter
    @Column(nullable = false, length = 300)
    private String description;

    @Getter @Setter
    @Column(nullable = false, length = 200)
    private String imageUrl;

    @Getter @Setter
    @Column(nullable = false)
    private double price;

    @Getter @Setter
    @OneToMany(mappedBy = "copyBook", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CopybookEspecification> especifications;

    public Copybook(String name, String description, String imageUrl, double price) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

}
