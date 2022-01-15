package ru.geekbrains.local_meeting_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.local_meeting_web.domain.Client;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> getAll();

    Client getById(Long id);

    Client add(Client client);

    Client updateById(Long id);

    void deleteById(Long id);

    void deleteByMail(String mail);
}
