package test.facade;

import facade.CommentFacade;
import models.Comment;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by benjaminafonso on 30/03/2017.
 */
public class CommentFacadeTest {
    @Test
    public void updateComment() throws Exception {
        // Async
    }

    @Test
    public void isCommentValide() throws Exception {
        CommentFacade facade = new CommentFacade();

        // Valid comments
        Comment comment1 = new Comment(0, "blabla", "title", 5, new Date(), 0, 0);
        assertTrue(facade.isCommentValide(comment1));
        Comment comment2 = new Comment(0, "blabla", "title", 0, new Date(), 0, 0);
        assertTrue(facade.isCommentValide(comment2));

        // Not valid comments
        Comment comment3 = new Comment(0, "blabla", "title", 6, new Date(), 0, 0);
        assertFalse(facade.isCommentValide(comment3));
        Comment comment4 = new Comment(0, "blabla", "title", -2, new Date(), 0, 0);
        assertFalse(facade.isCommentValide(comment4));


    }

    @Test
    public void addComment() throws Exception {
        // Async
    }

    @Test
    public void canAddComment() throws Exception {
    }

    @Test
    public void getCommentsOf() throws Exception {
        // Async
    }

}