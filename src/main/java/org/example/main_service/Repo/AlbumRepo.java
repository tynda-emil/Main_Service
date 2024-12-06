package org.example.main_service.Repo;

import org.example.main_service.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepo extends JpaRepository<Album, Long> {
    List<Album> findTop10ByIsPlaylistFalseOrderByIdAsc();
}
