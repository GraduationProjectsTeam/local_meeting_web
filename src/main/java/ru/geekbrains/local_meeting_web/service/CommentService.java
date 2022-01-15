package ru.geekbrains.local_meeting_web.service;

import ru.geekbrains.local_meeting_web.domain.Comment;
import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getAll();

    List<Comment> getByClientMail(String mail);

    List<Comment> getByClientId(Long clientId);

    Optional<Comment> getById(Long id);

    Comment add(Comment comment);

    Optional<Comment> updateById(Long id);

    void deleteById(Long id);

    void deleteByClientMail(String clientMail);

    void deleteByClientId(Long clientId);
}