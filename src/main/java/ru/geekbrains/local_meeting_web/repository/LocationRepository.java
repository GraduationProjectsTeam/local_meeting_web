package ru.geekbrains.local_meeting_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.local_meeting_web.domain.Location;
import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,String> {

    List<Location> getAll();

    Location add(Location location);

    void deleteByName(String name);
}
