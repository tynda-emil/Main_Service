package org.example.main_service.Repo;

import org.example.main_service.Entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepo extends JpaRepository<Artist, Long> {
    List<Artist> findTop10ByIsverifiedartistTrueOrderByIdAsc();
    @Query("SELECT a.username FROM Artist a WHERE a.id = :id")
    String findUsernameById(Long id);
}
