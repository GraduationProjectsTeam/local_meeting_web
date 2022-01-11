package ru.geekbrains.local_meeting_web.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "meeting_id")
    private Long meetingId;

    @NotNull
    private Long author;

//    TODO Date in service logic
    //TODO Date Stamp

    @Column(name = "comment_date")
    private Date date;

    @NotNull
    @Column(name = "comment_text")
    private String commentText;

//    TODO @JoinColumn
//    TODO @JoinColumn
// TODO укороченную сущность, чтобы json не циклило
}
