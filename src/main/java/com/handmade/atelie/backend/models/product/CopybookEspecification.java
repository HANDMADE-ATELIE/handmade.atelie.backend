package com.handmade.atelie.backend.models.product;


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

@Table(name = "copy_book_especifications")
@Entity(name = "copy_book_especifications")
@AllArgsConstructor
@NoArgsConstructor
public class CopybookEspecification {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Getter
    private String id;

    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String title;

    @Column(nullable = false, length = 100)
    @Getter @Setter
    private String content;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name = "FK_copy_book_id", nullable = false)
    private Copybook copyBook;

    public CopybookEspecification(String title, String content, Copybook copyBook) {
        this.title = title;
        this.content = content;
        this.copyBook = copyBook;
    }

}
