package ru.geekbrains.local_meeting_web.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Meeting {

    @Id
    @Generated
    private Long id;

    @NotNull
    private Long organizer;

    @NotNull
    private String address;

    @NotNull
    private String location;

    @NotNull
    private String title;

    private String about;

    @Column(name = "registration_date")
    private Calendar regDate;
    @NotNull
    @Column(name = "meeting_date")
    private Calendar date;

    @Column(name = "meeting_beginning")
    private Double beginning;

    @Column(name = "meeting_over")
    private Double over;

    @Column(name = "image_link")
    private String link;


// TODO @JoinColumn
    // TODO @JoinColumn
    //TODO укороченную сущность
}