package ru.geekbrains.local_meeting_web.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MeetingDto {

    private Long id;

    private Long clientId;

    private String address;

    private String location;

    private String title;

    private String about;

    private Date date;                  //??

    private Double beginning;

    private Double over;

    private String link;
}
