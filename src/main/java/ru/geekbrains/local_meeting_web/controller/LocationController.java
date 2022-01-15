package ru.geekbrains.local_meeting_web.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.local_meeting_web.domain.Location;
import ru.geekbrains.local_meeting_web.service.LocationService;

import java.util.List;

@RestController
public class LocationController {

    LocationService locationService;

    @GetMapping("/locations")
    public List<Location> getAll() {
        return locationService.getAll();
    }

    @PostMapping("/locations")
    public Location add(@PathVariable Location location) {
        return locationService.add(location);
    }

    @DeleteMapping("/locations/{name}")
    public void deleteByName(@PathVariable String name) {
        locationService.deleteByName(name);
    }

}
