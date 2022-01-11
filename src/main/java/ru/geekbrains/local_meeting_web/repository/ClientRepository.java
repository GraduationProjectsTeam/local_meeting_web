package ru.geekbrains.local_meeting_web.repository;

import ru.geekbrains.local_meeting_web.domain.Client;

import java.util.List;
import java.util.Optional;

//TODO CRUD ext


public interface ClientRepository {
    List<Client> getAll();
    Optional<Client> getById(Long id);
    Client add(Client client);
}
