package example;

import annotation.Author;
import annotation.ExecutionPriority;
import annotation.PrintPriority;
import annotation.Test;

/**
 * Created by dbati on 13.07.2016.
 */
@Author(createdBy = "Dmitri", priority = Author.Priority.MEDIUM, tags = {"Grads", "Training"})
@ExecutionPriority(priority = ExecutionPriority.Priority.MEDIUM)
public class TestExample3 {

    @PrintPriority()
    public void print() {
        System.out.println("Priority " + ExecutionPriority.Priority.MEDIUM);
    }

    @Test(enabled = true)
    public void testC() {
        if (10 > 1) {
            // do nothing, this test always passed.
        }
    }

    @Test
    public void testA() {
        if(true) {
            throw new RuntimeException("This test always failed");
        }
    }

    @Test(enabled = false)
    public void testB() {
        if (false)
            throw new RuntimeException("This test always passed");
    }

}
