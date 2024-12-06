package org.example.main_service;

import lombok.RequiredArgsConstructor;
import org.example.main_service.DTO.AlbumDTO;
import org.example.main_service.Entity.Album;
import org.example.main_service.Entity.Artist;
import org.example.main_service.Service.AlbumService;
import org.example.main_service.Service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class Controller {
    @Autowired
ArtistService artistService;
    @Autowired
    AlbumService albumService;


    @GetMapping
    public Map<String, Object> getMusicData() {
        List<Artist> artists = artistService.getTop10VerifiedArtists();
        List<Map<String, String>> artistDTOs = artists.stream()
                .map(artist -> {
                    Map<String, String> artistMap = new HashMap<>();
                    artistMap.put("name", artist.getUsername());
                    return artistMap;
                })
                .collect(Collectors.toList());
        List<Album> albums = albumService.get10Albums();
        List<AlbumDTO> albumDTOs = albums.stream()
                .map(album -> new AlbumDTO(album.getTitle(), album.getArtist().getUsername()))
                .collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
        response.put("artists", artistDTOs);
        response.put("albums", albumDTOs);

        return response;
    }

}
