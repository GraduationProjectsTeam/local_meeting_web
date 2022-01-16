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
    private Meeting meeting;

    @NotNull
    @ManyToOne
    @Column(name = "author")
    private Client client;

//    TODO Date in service logic
//    TODO Date Stamp

    @Column(name = "comment_date")
    private Date date;

    @NotNull
    @Column(name = "comment_text")
    private String commentText;


//    TODO укороченную сущность, чтобы json не циклило
}
