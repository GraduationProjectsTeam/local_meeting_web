package ru.geekbrains.local_meeting_web.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.local_meeting_web.domain.Meeting;
import ru.geekbrains.local_meeting_web.service.MeetingService;

import java.util.List;

@RestController
public class MeetingController {

    private MeetingService meetingService;

    @GetMapping("/meetings/{id}")
    public Meeting getById(@PathVariable Long id) {
        if (meetingService.getById(id).isPresent()) {
            return meetingService.getById(id).get();
        } else {
            throw new NullPointerException("There is no element with id " + id);
        }
    }

    @GetMapping("/meetings/")
    public List<Meeting> getAll() {
        return meetingService.getAll();
    }

    @GetMapping("/meetings/loc/{location}")
    public List<Meeting> getByLocation(@PathVariable String location) {
        return meetingService.getByLocation(location);
    }

    @GetMapping("/meetings/client/{id}")
    public List<Meeting> getByClientId(Long id){
        return meetingService.getByClientId(id);
    }

    @GetMapping("/meetings/client/mail/{mail}")
    public List<Meeting> getByClientMail(String mail){
        return meetingService.getByClientMail(mail);
    }

    @PostMapping("/meetings/")
    public Meeting add(@PathVariable Meeting meeting) {
        return meetingService.add(meeting);
    }

    @PutMapping("/meetings/{id}")
    public Meeting updateById(@PathVariable Long id) {
        return meetingService.updateById(id);
    }

    @DeleteMapping("/meetings/{id}")
    public void deleteById(@PathVariable Long id) {
        meetingService.deleteById(id);
    }

    @DeleteMapping("/meetings/loc/{location}")
    public void deleteByLocation(@PathVariable String location) {
        meetingService.deleteByLocation(location);
    }

    @DeleteMapping("/meetings/client/{id}")
    public void deleteByClientId(@PathVariable Long clientId) {
        meetingService.deleteByClientId(clientId);
    }

    @DeleteMapping("/meetings/client/mail/{clientMail}")
    public void deleteByClientMail(@PathVariable String clientMail) {
        meetingService.deleteByClientMail(clientMail);
    }
}

//TODO Pagging