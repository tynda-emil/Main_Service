package org.example.main_service.Service;

import org.example.main_service.Entity.Album;
import org.example.main_service.Repo.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    AlbumRepo albumRepo;
           public  List<Album> get10Albums(){
               List<Album> albums = albumRepo.findTop10ByIsPlaylistFalseOrderByIdAsc();
               return albums.isEmpty() ? Collections.emptyList() : albums;
            }
}
