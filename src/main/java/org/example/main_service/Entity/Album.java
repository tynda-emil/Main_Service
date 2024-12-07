package org.example.main_service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "album_id", nullable = false)
    private Long id;

    @Getter
    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Artist artist;


    @Column(name = "isPlaylist")
    private boolean isPlaylist;
    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public Long getId() {
        return id;
    }
}
