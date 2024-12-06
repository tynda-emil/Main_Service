package org.example.main_service.Service;

import org.example.main_service.Entity.Artist;
import org.example.main_service.Repo.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ArtistService {
    @Autowired
    ArtistRepo artistRepo;

    public List<Artist> getTop10VerifiedArtists() {
        List<Artist> artists = artistRepo.findTop10ByIsverifiedartistTrueOrderByIdAsc();
        return artists.isEmpty() ? Collections.emptyList() : artists;
    }
public String getUsernameById(Long id){
        return artistRepo.findUsernameById(id);
}
}
