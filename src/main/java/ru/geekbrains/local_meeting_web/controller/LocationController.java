package ru.geekbrains.local_meeting_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.geekbrains.local_meeting_web.domain.Location;
import ru.geekbrains.local_meeting_web.domain.Meeting;
import ru.geekbrains.local_meeting_web.service.LocationService;

import java.util.List;
@Controller
public class LocationController {

    LocationService locationService;

    @GetMapping("/locations")
    public List<Location> getAll(){
        return locationService.getAll();
    }

    @PostMapping("/locations")
    public Location add(@PathVariable Location location){
        return locationService.add(location);
    }

    @DeleteMapping("/locations/{name}")
    public void deleteByLocation(@PathVariable String name) {
        locationService.deleteByName(name);
    }

}
