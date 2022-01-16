package ru.geekbrains.local_meeting_web.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.local_meeting_web.domain.Client;
import ru.geekbrains.local_meeting_web.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;

    @GetMapping("/clients/{id}")
    public Client getById(@PathVariable Long id) {
        if (clientService.getById(id).isPresent()) {
            return clientService.getById(id).get();
        } else {
            throw new NullPointerException("There is no element with id " + id);
        }
    }

    @GetMapping("/clients/mail/{mail}")
    public Client getByMail(@PathVariable String mail){
        if(clientService.getByMail(mail).isPresent()) {
            return clientService.getByMail(mail).get();
        }else{
            throw new NullPointerException("There is no element with e-mail: " + mail);
        }
    }

    @GetMapping("/clients")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @PostMapping("/clients")
    public Client add(@PathVariable Client client) {
        return clientService.add(client);
    }

    @PutMapping("/clients/{id}")
    public Client updateById(@PathVariable Long id) {
        if (clientService.updateById(id).isPresent()) {
            return clientService.updateById(id).get();
        } else {
            throw new NullPointerException("There is no element with id " + id);
        }
    }

    @DeleteMapping("/clients/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
    }

    @DeleteMapping("/clients/mail/{mail}")
    public void deleteByMail(@PathVariable String mail) {
        clientService.deleteByMail(mail);
    }
}

//TODO Pagging
