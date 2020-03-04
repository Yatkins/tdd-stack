package edu.htc.blitstein.caih313.tddstack.engine;

import edu.htc.blitstein.caih313.tddstack.IStackable;

public class TddStack {
    static final int DEFAULT_DEPTH = 100;

    int stackDepth;

    private IStackable[] stack;
    private int currentOccupancy;

    TddStack(int stackDepth) {
        this.stackDepth = stackDepth;
        stack = new IStackable[stackDepth];
        currentOccupancy = -1;
    }

    public TddStack() {
        this(DEFAULT_DEPTH);
    }

    boolean isEmpty(){
        return currentOccupancy  == -1;
    }

    boolean isFull() {
        return currentOccupancy == (stackDepth-1);}

    IStackable pop() {
        IStackable retval = null;
        if (!isEmpty()) {
            retval = stack[currentOccupancy];
            currentOccupancy -= 1;
        }
        return retval;
    }

    void push(IStackable iStackable) {
        if (!isFull()) {
            currentOccupancy += 1;
            stack[currentOccupancy] = iStackable;
        }
    }


}
//add a couple of more tests to demonstrate the stack is working as expected, that would be sufficient. For example, add an id field to the classes that implement IStackable and demonstrate that precisely the objects you pushed onto the stack were the same ones pop'd and in the right order.  Please let me know if you need more clarification.