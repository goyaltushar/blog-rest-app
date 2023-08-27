package com.springboot.blog.controller;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "CRUD REST APIs for Comment Respource")
@RestController
@RequestMapping("/api/v1")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "Create Comment REST API")
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value="postId") long postId,
                                                    @Valid @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId,commentDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get all Comments by Post id REST API")
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable long postId){
        return commentService.getCommentsByPostId(postId);
    }

    @ApiOperation(value = "Get single Comment by id REST API")
    @GetMapping("/posts/{postId}/comments/{commentId}")
    public CommentDto getCommentById(@PathVariable(value="postId") long postId,
                                     @PathVariable(value="commentId") long commentId){
        return commentService.getCommentById(postId,commentId);
    }

    @ApiOperation(value = "Update Comment by id REST API")
    @PutMapping("/posts/{postId}/comments/{commentId}")
    public CommentDto updateComment(@PathVariable(value="postId") long postId,
                                    @PathVariable(value="commentId") long commentId,
                                    @Valid @RequestBody CommentDto commentDto){
        return commentService.updateComment(postId,commentId,commentDto);
    }

    @ApiOperation(value = "Delete Comment by id REST API")
    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public String deleteComment(@PathVariable(value="postId") long postId,
                                @PathVariable(value="commentId") long commentId){
        return commentService.deleteComment(postId,commentId);
    }
}
