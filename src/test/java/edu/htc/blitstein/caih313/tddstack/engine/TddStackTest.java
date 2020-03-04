package edu.htc.blitstein.caih313.tddstack.engine;

import edu.htc.blitstein.caih313.tddstack.IStackable;
import edu.htc.blitstein.caih313.tddstack.resource.campus.Faculty;
import edu.htc.blitstein.caih313.tddstack.resource.campus.Student;
import edu.htc.blitstein.caih313.tddstack.resource.room.ComputerLab;
import edu.htc.blitstein.caih313.tddstack.resource.room.LectureRoom;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TddStackTest {
    @Test
    public void testNewStackIsEmpty() {
        TddStack tddStack = new TddStack();
        assertTrue(tddStack.isEmpty());
    }

    @Test
    public void testNewStackIsNotFull() {
        TddStack tddStack = new TddStack();
        assertFalse(tddStack.isFull());
    }

    @Test
    public void testNewStackHasDefaultDepth() {
        TddStack tddStack = new TddStack();
        assertEquals(TddStack.DEFAULT_DEPTH, tddStack.stackDepth);
    }

    @Test
    public void testFullStackIsFull() {
        TddStack tddStack =  new TddStack(3);
        Student student = new Student();
        tddStack.push(student);
        tddStack.push(student);
        tddStack.push(student);
        assertTrue(tddStack.isFull());
    }

    //some extras
    @Test
    public void testAddOneIsNotEmptyAndIsNotFull() {
        TddStack tddStack =  new TddStack(3);
        Student student = new Student();
        tddStack.push(student);
        assertFalse(tddStack.isEmpty());
        assertFalse(tddStack.isFull());
    }

    @Test
    public void testPopIsPush() {
        TddStack tddStack = new TddStack();
        //Faculty implements IStackable
        IStackable iStackableOrig = new Faculty();
        tddStack.push(iStackableOrig);
        IStackable iStackablePopped = tddStack.pop();
        assertEquals(iStackableOrig, iStackablePopped);
    }

    @Test
    public void testIsFull(){
        TddStack stack = new TddStack(4);
        for(int i = 0; i < 4; i++){
            Student myStudent = new Student();
            stack.push(myStudent);
        }assertTrue(stack.isFull());
    }

    @Test
    public void overFill(){
        TddStack stack = new TddStack(4);
        for(int i = 0; i < 6; i++){
            Student myStudent = new Student();
            stack.push(myStudent);
        }assertEquals(4, stack.stackDepth);
    }

    @Test
    public void pushPop(){
        TddStack tddStack =  new TddStack(1);
        Student student = new Student();
        tddStack.push(student);
        tddStack.pop();
        assertTrue(tddStack.isEmpty());
        assertFalse(tddStack.isFull());
    }

    @Test
    public void emptyFullStack(){
        TddStack stack = new TddStack(TddStack.DEFAULT_DEPTH);
        for(int i = 0; i < 100; i++){
            stack.pop();
        }assertTrue(stack.isEmpty());
    }

    @Test
    public void gotPushed(){
        TddStack tddStack = new TddStack();
        IStackable student = new Student();
        tddStack.push(student);
        IStackable popped = tddStack.pop();
        assertEquals(student, popped);
    }
}