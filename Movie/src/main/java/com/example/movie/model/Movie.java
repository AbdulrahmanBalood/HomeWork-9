package com.example.movie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Movie {
    @Id
    @NotEmpty(message = "id cannot be null")
    @Size(min = 3,message = "id cannot be less than 3 chars")
    @Column(unique = true)
    private String id;
    @NotEmpty(message = "name cannot be null")
    @Size(min = 2,message = "id cannot be less than 2 chars")
    @Column(unique = true)
    private String name;
    @Column(nullable = false)
    @NotEmpty(message = "Movie genre cannot be null")
    @Pattern(regexp = "(Drama|Action|Comedy)",message = "Movie genre can only be :(Drama, Action , Comedy)")
    private String genre;
    @NotNull(message = "rating cannot be empty")
    @Range(min = 1,max = 5,message = "Rating can be from 1-5")
    private Integer rating;
    @NotNull(message = "Duration cannot be empty")
    @Min(value = 60,message = "Movie duration must be more than 60")
    private Integer duration;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy/MM/dd")
    @NotNull(message = "Launch date cannot be null")
    private Date launchDate;

}
