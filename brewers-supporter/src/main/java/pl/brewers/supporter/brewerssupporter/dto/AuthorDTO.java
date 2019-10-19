package pl.brewers.supporter.brewerssupporter.dto;

import lombok.Data;

@Data
public class AuthorDTO {
    private String email;
    private String username;
    private String password;
}