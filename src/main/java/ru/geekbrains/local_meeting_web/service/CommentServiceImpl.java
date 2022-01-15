package ru.geekbrains.local_meeting_web.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.local_meeting_web.domain.Comment;
import ru.geekbrains.local_meeting_web.repository.CommentRepository;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAll() {
        return commentRepository.getAll();
    }

    @Override
    public List<Comment> getByClientMail(String mail){
        Long clientId = null;
        //TODO логика на получение id клиента !вынести в отдельный метод!
        return commentRepository.getByClientId(clientId);
    }

    @Override
    public List<Comment> getByClientId(Long clientId){
        return commentRepository.getByClientId(clientId);
    }

    @Override
    public Optional<Comment> getById(Long id) {
        return Optional.of(commentRepository.getById(id));
    }

    @Override
    public Comment add(Comment comment) {
        return commentRepository.add(comment);
    }

    @Override
    public Optional<Comment> updateById(Long id) {
        return Optional.of(commentRepository.updateById(id));
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteByClientMail(String clientMail) {
        Long clientId = null;
        //TODO логика на получение id клиента !вынести в отдельный метод!
        commentRepository.deleteByClientId(clientId);
    }

    public void deleteByClientId(Long clientId) {

        commentRepository.deleteByClientId(clientId);
    }

}
