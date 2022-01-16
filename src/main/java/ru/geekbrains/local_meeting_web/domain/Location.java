package ru.geekbrains.local_meeting_web.domain;

import com.sun.istack.NotNull;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
public class Location {

    @NotNull
    private String name;

    @OneToMany(mappedBy = "location")
    List<Meeting> meetings;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
