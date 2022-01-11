package ru.geekbrains.local_meeting_web.repository;

import ru.geekbrains.local_meeting_web.domain.Location;

import java.util.List;

public interface LocationRepository {
    List<Location> getAll();
}
