package ru.geekbrains.local_meeting_web.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocationDto {

    private String name;

    List<Long> meetings;

}




