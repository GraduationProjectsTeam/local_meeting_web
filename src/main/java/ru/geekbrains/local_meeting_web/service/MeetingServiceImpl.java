package ru.geekbrains.local_meeting_web.service;
import ru.geekbrains.local_meeting_web.domain.Meeting;
import ru.geekbrains.local_meeting_web.repository.LocationRepository;
import ru.geekbrains.local_meeting_web.repository.MeetingRepository;
import java.util.List;
import java.util.Optional;

public class MeetingServiceImpl {

    private MeetingRepository meetingRepository;
    private LocationRepository locationRepository;

    public List<Meeting> getAll() {
        return meetingRepository.getAll();
    }

    public List<Meeting> getByLocation(String location){
        return meetingRepository.getByLocation(locationRepository.getAll().stream().filter(x -> x.getName().startsWith("location")).findAny().get());
    }

    public Optional<Meeting> getById(Long id){
        return Optional.of(meetingRepository.getById(id));
    }

    public Meeting add(Meeting meeting){
        return meetingRepository.add(meeting);
    }

    public Meeting updateById(Long id){
        return meetingRepository.updateById(id);
    }

    public void deleteById(Long id){
        meetingRepository.deleteById(id);
    }

    public void deleteByLocation(String location){
        meetingRepository.deleteByLocation(locationRepository.getAll().stream().filter(x -> x.getName().startsWith("location")).findAny().get());
    }
}

