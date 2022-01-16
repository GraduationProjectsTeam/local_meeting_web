package ru.geekbrains.local_meeting_web.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDto {

    private Long id;

    private String name;

    private String mail;
}


