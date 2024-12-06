package org.example.main_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArtistDTO {
    private String name;
    public ArtistDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
