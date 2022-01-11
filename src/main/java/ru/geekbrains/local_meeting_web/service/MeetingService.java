package ru.geekbrains.local_meeting_web.service;

import ru.geekbrains.local_meeting_web.domain.Meeting;

import java.util.List;
import java.util.Optional;

public interface MeetingService {

    List<Meeting> getAll();
    List<Meeting> getByLocation(String location);
    Optional<Meeting> getById(Long id);
    Meeting add(Meeting meeting);
    Meeting updateById(Long id);
    void deleteById(Long id);
    void deleteByLocation(String location);
}
