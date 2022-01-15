package ru.geekbrains.local_meeting_web.controller;

import org.springframework.web.bind.annotation.*;
import ru.geekbrains.local_meeting_web.domain.Comment;
import ru.geekbrains.local_meeting_web.service.CommentService;
import java.util.List;

@RestController
public class CommentController {

    private CommentService commentService;

    @GetMapping("/comments/")
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/comments/client/mail/{clientMail}")
    public List<Comment> getByClientMail(@PathVariable String clientMail){
        return commentService.getByClientMail(clientMail);
    }

    @GetMapping("/comments/client/{clientId}")
    public List<Comment> getByClientId(@PathVariable Long clientId){
        return commentService.getByClientId(clientId);
    }

    @GetMapping("/comments/{id}")
    public Comment getById(@PathVariable Long id) {
        if (commentService.getById(id).isPresent()) {
            return commentService.getById(id).get();
        } else {
            throw new NullPointerException("There is no element with id " + id);
        }
    }

    @PostMapping("/comments/")
    public Comment add(@PathVariable Comment comment) {
        return commentService.add(comment);
    }

    @PutMapping("/comments/{id}")
    public Comment updateById(@PathVariable Long id) {
        if (commentService.updateById(id).isPresent()) {
            return commentService.updateById(id).get();
        } else {
            throw new NullPointerException("There is no element with id " + id);
        }
    }

    @DeleteMapping("/comments/{id}")
    public void deleteById(@PathVariable Long id) {
        commentService.deleteById(id);
    }

    @DeleteMapping("/comments/client/mail/{clientMail}")
    public void deleteByClientMail(@PathVariable String clientMail) {
        commentService.deleteByClientMail(clientMail);
    }

    @DeleteMapping("/comments/client/{clientId}")
    public void deleteByClientId(@PathVariable Long clientId) {
        commentService.deleteByClientId(clientId);
    }

}