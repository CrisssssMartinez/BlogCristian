package com.blog.cristian;

import com.blog.cristian.controllers.CommentController;
import com.blog.cristian.dto.CommentDTO;
import com.blog.cristian.entities.Comment;
import com.blog.cristian.services.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommentController.class)
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    @Test
    public void testAddComment() throws Exception {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setUser("User1");
        commentDTO.setMessage("This is a test comment.");

        Comment comment = new Comment();
        comment.setId(1L);
        comment.setUser("User1");
        comment.setMessage("This is a test comment.");

        when(commentService.saveComment(any(CommentDTO.class))).thenReturn(comment);

        mockMvc.perform(post("/comments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"user\":\"User1\",\"message\":\"This is a test comment.\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"user\":\"User1\",\"message\":\"This is a test comment.\"}"));
    }

    @Test
    public void testGetAllComments() throws Exception {
        Comment comment1 = new Comment();
        comment1.setId(1L);
        comment1.setUser("User1");
        comment1.setMessage("This is a test comment.");

        Comment comment2 = new Comment();
        comment2.setId(2L);
        comment2.setUser("User2");
        comment2.setMessage("This is another test comment.");

        List<Comment> comments = Arrays.asList(comment1, comment2);

        when(commentService.getAllComments()).thenReturn(comments);

        mockMvc.perform(get("/comments"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"user\":\"User1\",\"message\":\"This is a test comment.\"},{\"id\":2,\"user\":\"User2\",\"message\":\"This is another test comment.\"}]"));
    }
}
