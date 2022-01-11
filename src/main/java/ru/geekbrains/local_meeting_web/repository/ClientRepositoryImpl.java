package ru.geekbrains.local_meeting_web.repository;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.geekbrains.local_meeting_web.domain.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO Client Repo

@NoArgsConstructor
@Repository
public class ClientRepositoryImpl implements ClientRepository {
    private final List<Client> list = new ArrayList<>();

    public List<Client> getAll() {
        return list;
    }

    public Optional<Client> getById(Long id){
        return Optional.of(list.stream().filter(x -> x.getId()==id).findAny().get());
    }

    public Client add(Client client){
        list.add(client);
        return client;
    }

}
