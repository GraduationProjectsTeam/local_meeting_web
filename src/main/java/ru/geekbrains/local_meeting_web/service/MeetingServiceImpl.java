package ru.geekbrains.local_meeting_web.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.local_meeting_web.domain.Meeting;
import ru.geekbrains.local_meeting_web.repository.LocationRepository;
import ru.geekbrains.local_meeting_web.repository.MeetingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingServiceImpl implements MeetingService{

    private MeetingRepository meetingRepository;
    private LocationRepository locationRepository;
    private ClientService clientService;

    @Override
    public Optional<Meeting> getById(Long id) {
        return Optional.of(meetingRepository.getById(id));
    }

    @Override
    public List<Meeting> getAll() {
        return meetingRepository.getAll();
    }

    @Override
    public List<Meeting> getByLocation(String location) {
        return meetingRepository.getByLocation(locationRepository.getAll().stream().filter(x -> x.getName().startsWith("location")).findAny().get());
    }

    @Override
    public List<Meeting> getByClientId(Long id) {
        return meetingRepository.getByClientId(id);
    }

    @Override
    public List<Meeting> getByClientMail(String mail) {
        return getByClientId(clientService.getId(clientService.getByMail(mail).get()));
    }

    @Override
    public Meeting add(Meeting meeting) {
        return meetingRepository.add(meeting);
    }

    @Override
    public Meeting updateById(Long id) {
        return meetingRepository.updateById(id);
    }

    @Override
    public void deleteById(Long id) {
        meetingRepository.deleteById(id);
    }

    @Override
    public void deleteByLocation(String location) {
        meetingRepository.deleteByLocation(locationRepository.getAll().stream().filter(x -> x.getName().startsWith("location")).findAny().get());
    }

    @Override
    public void deleteByClientId(Long clientId) {
        meetingRepository.deleteByClientId(clientId);
    }

    @Override
    public void deleteByClientMail(String clientMail) {
        Long clientId = null;
        if(clientService.getByMail(clientMail).isPresent()) {
            meetingRepository.deleteByClientId(clientService.getId(clientService.getByMail(clientMail).get()));
        }
    }
}

