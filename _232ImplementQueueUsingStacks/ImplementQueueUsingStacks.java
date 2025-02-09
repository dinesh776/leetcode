package Github._232ImplementQueueUsingStacks;
//232. Implement Queue using Stacks
//https://leetcode.com/problems/implement-queue-using-stacks/description/
import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    public ImplementQueueUsingStacks() {

    }

    public void push(int x) {
        while(s1.size()>0){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(s2.size()>0){
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return (s1.size()==0)?true:false;
    }
}
