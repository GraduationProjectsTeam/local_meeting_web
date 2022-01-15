package ru.geekbrains.local_meeting_web.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.local_meeting_web.domain.Client;
import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {
    List<Client> getAll();

    Optional<Client> getById(Long id);

    Client add(Client client);

    Optional<Client> updateById(Long id);

    void deleteById(Long id);

    void deleteByMail(String mail);
}
