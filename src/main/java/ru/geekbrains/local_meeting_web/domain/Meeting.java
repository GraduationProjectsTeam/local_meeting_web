package ru.geekbrains.local_meeting_web.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id")
    @Column(name = "organizer")
    private Client client;

    @NotNull
    private String address;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "name")
    private Location location;

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


//   TODO укороченную сущность
}