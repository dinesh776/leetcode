package Github._225ImplementStackUsingQueues;

//225. Implement Stack using Queues
//https://leetcode.com/problems/implement-stack-using-queues/description/

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q=new LinkedList<>();
    }

    public void push(int x) {
        int s=q.size();
        q.add(x);
        for(int i=0;i<s;i++){
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        int val=q.peek();
        return val;
    }

    public boolean empty() {
        return q.size()==0?true:false;
    }
}
