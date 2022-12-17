import java.util.function.*;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Tree
{
   TheLock l;
   Node head;
   
   public Tree(TheLock l)
   {
      this.l = l;
      this.head = new Node(null, null, 0);
   }
   
   //When we have our correct answer, this will output the node order and height.
   public void outputInfo(Node n)
   {
      int height = 0;
      if(n == null)
      {
         System.out.println("Depth limited search could not find the node.");
         return;
      }
      height = n.recursiveOutput(height);
      System.out.println("Total actions to reach solution: " + height);
   }
   
   public Node BFS()
   {
      Queue<Node> q = new LinkedList<>();
      q.offer(this.head);
      Node curr;
      TryConsumer t = new TryConsumer(this.l);
      //stop condition is returning correct node.
      while(true)
      {
         curr = q.poll();
         
         
         if(curr != head)
         {
            t.accept(curr);
         }
         if(this.l.isUnlocked()) 
         {
            System.out.println("Number of nodes traversed: " + t.numNodes);
            System.out.println("Number of items in queue at end: " + q.size());
            return curr;
         }
         
         Node twistNode = new Node(curr, new twistAction(), curr.level + 1);
         Node pullNode = new Node(curr, new pullAction(), curr.level + 1);
         Node shakeNode = new Node(curr, new shakeAction(), curr.level + 1);
         Node pokeNode = new Node(curr, new pokeAction(), curr.level + 1);

         q.offer(twistNode);
         q.offer(pokeNode);
         q.offer(pullNode);
         q.offer(shakeNode);
      }
   }
      
   public Node DLS(int height)
   {
      Stack<Node> s = new Stack<Node>();
      s.push(this.head);
      Node curr;
      TryConsumer t = new TryConsumer(this.l);
      //stop condition is returning correct node.
      while(!s.empty())
      {
         curr = s.pop();
         
         
         if(curr != head)
         {
            t.accept(curr);
         }
         if(this.l.isUnlocked()) 
         {
            System.out.println("Number of nodes traversed: " + t.numNodes);
            System.out.println("Number of items in stack at end: " + s.size());
            return curr;
         }
         if(curr.level < height)
         {
            Node twistNode = new Node(curr, new twistAction(), curr.level + 1);
            Node pullNode = new Node(curr, new pullAction(), curr.level + 1);
            Node shakeNode = new Node(curr, new shakeAction(), curr.level + 1);
            Node pokeNode = new Node(curr, new pokeAction(), curr.level + 1);

            s.push(twistNode);
            s.push(pokeNode);
            s.push(pullNode);
            s.push(shakeNode);
         }
      }
      System.out.println("Number of nodes traversed [failed]: " + t.numNodes);
      return null;
   }
   
   public Node IterDeep()
   {
      Node curr = null;
      int i=1;
      while(curr == null)
      {
         curr = this.DLS(i);
         i++;
      }
      return curr;
   }
   
   
   
   //consumer for going through the tree to find a given node.
   class TryConsumer implements Consumer<Node>
   {
      TheLock m;
      int numNodes;
      
      //We pass in the lock as we create the consumer.
      //Expected: They will have the same pointer if we
      //pass in the tree's lock.
      public TryConsumer(TheLock m)
      {
         this.m = m;
         this.numNodes = 0;
      }
      
      public void accept(Node n)
      {
         this.numNodes++;
         this.m.resetLock();
         n.traverseUp(this.m);
         return;
      }
   }
}