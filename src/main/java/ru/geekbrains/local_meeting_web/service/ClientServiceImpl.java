package ru.geekbrains.local_meeting_web.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.local_meeting_web.domain.Client;
import ru.geekbrains.local_meeting_web.repository.ClientRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public Optional<Client> getById(Long id) {
        return Optional.of(clientRepository.getById(id));
    }

    @Override
    public Optional<Client> getByMail(String mail) {
        return Optional.of(clientRepository.getByMail(mail));
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    @Override
    public Client add(Client client) {
        return clientRepository.add(client);
    }

    @Override
    public Optional<Client> updateById(Long id) {
        return Optional.of(clientRepository.updateById(id));
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void deleteByMail(String mail) {
        clientRepository.deleteByMail(mail);
    }

    @Override
    public Long getId(Client client){
        return client.getId();
    }
}
