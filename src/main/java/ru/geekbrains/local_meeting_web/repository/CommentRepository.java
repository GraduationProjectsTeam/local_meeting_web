package ru.geekbrains.local_meeting_web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.local_meeting_web.domain.Comment;
import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

List<Comment> getAll();

List<Comment> getByClientId(Long clientId);

Comment getById(Long id);

Comment add(Comment comment);

Comment updateById(Long id);

void deleteById(Long id);

void deleteByClientId(Long clientId);

}