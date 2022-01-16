package ru.geekbrains.local_meeting_web.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDto {

    private Long id;

    private Long meeting_id;

    private Long client_id;

    private Date date;               //??

    private String commentText;

}
