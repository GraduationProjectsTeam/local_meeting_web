package ru.geekbrains.local_meeting_web.service;

import ru.geekbrains.local_meeting_web.domain.Location;
import ru.geekbrains.local_meeting_web.domain.Meeting;

import java.util.List;

public interface LocationService {
    List<Location> getAll();
    Location add(Location location);
    void deleteByName(String name);
}
