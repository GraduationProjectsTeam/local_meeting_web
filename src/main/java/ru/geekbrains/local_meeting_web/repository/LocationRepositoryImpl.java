package ru.geekbrains.local_meeting_web.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.local_meeting_web.domain.Location;

import java.util.ArrayList;
import java.util.List;

//TODO Location Repo

@Repository
public class LocationRepositoryImpl implements LocationRepository{

    private final List<Location> list = new ArrayList<>();

    public void init() {
        for(int x = 0; x<4; x++){
            list.add(new Location("location"+x));
        }
    }

    public List<Location> getAll(){
        return list;
    }

    @Override
    public Location add(Location location) {
        list.add(location);
        return location;
    }

    @Override
    public void deleteByName(String name) {
        list.remove(list.stream().filter(x -> x.getName()==name).findAny().get());
    }
}
