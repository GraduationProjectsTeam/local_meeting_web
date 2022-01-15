package ru.geekbrains.local_meeting_web.service;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.local_meeting_web.domain.Meeting;

import java.util.List;
import java.util.Optional;

public interface MeetingService {

    Optional<Meeting> getById(Long id);

    List<Meeting> getAll();

    List<Meeting> getByLocation(String location);

    List<Meeting> getByClientId(Long id);

    List<Meeting> getByClientMail(String mail);

    Meeting add(Meeting meeting);

    Meeting updateById(Long id);

    void deleteById(Long id);

    void deleteByLocation(String location);

    void deleteByClientId(Long clientId);

    void deleteByClientMail(String clientMail);
}
