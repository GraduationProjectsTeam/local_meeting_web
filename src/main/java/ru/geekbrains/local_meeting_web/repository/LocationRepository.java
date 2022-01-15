package ru.geekbrains.local_meeting_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.local_meeting_web.domain.Location;

import java.util.List;


//TODO delete Loc Repo Impl, ext JPA

//public interface LocationRepository extends JpaRepository<Location,String> {
public interface LocationRepository {
    List<Location> getAll();

    Location add(Location location);

    void deleteByName(String name);
}
