public class Node
{
   Node parent;
   Action a;
   int level;
   
   public Node(Node parent, Action a, int level)
   {
      this.parent = parent;
      this.a = a;
      this.level = level;   
   }
/*
   public void initChildren()
   {
      this.twistNode = new Node(this, new twistAction(), this.level + 1);
      this.pullNode = new Node(this, new pullAction(), this.level + 1);
      this.shakeNode = new Node(this, new shakeAction(), this.level + 1);
      this.pokeNode = new Node(this, new pokeAction(), this.level + 1);
      
      
   }
*/
   //calls the action [twist, pull, shake, poke] that is relevant at the time.
   public void doAction(TheLock l)
   {
      this.a.doAction(l);
   }
   
   //assuming this is a Node we wish to test, this will get us into the
   //order we want.
   protected void traverseUp(TheLock l)
   {
      if(this.parent.a != null)
      {
         this.parent.traverseUp(l);
      }
      a.doAction(l);
   }
   
   //Outputs order & returns # of nodes in correct sequence.
   protected int recursiveOutput(int height)
   {
      if(this.a == null) return 0;
      height = this.parent.recursiveOutput(height);
      height += 1;
      //System.out.println("Action " + height + ": " + this.a.toString());
      return height;
   }
}