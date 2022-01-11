package ru.geekbrains.local_meeting_web.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Location {
    @NotNull
    private String name;

    public Location(String name) {
        this.name = name;
    }
}
