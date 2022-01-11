package ru.geekbrains.local_meeting_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.local_meeting_web.domain.Location;
import ru.geekbrains.local_meeting_web.domain.Meeting;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
    List<Meeting> getAll();
    List<Meeting> getByLocation(Location location);
    Meeting getById(Long id);
    Meeting add(Meeting meeting);
    Meeting updateById(Long id);
    void deleteById(Long id);
    void deleteByLocation(Location location);
}
