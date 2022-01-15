package ru.geekbrains.local_meeting_web.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.local_meeting_web.domain.Location;
import ru.geekbrains.local_meeting_web.repository.LocationRepository;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationRepository locationRepository;

    @Override
    public List<Location> getAll() {
        return locationRepository.getAll();
    }

    @Override
    public Location add(Location location) {
        return locationRepository.add(location);
    }

    @Override
    public void deleteByName(String name) {
        locationRepository.deleteByName(name);
    }
}
