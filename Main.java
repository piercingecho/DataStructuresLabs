import java.util.concurrent.TimeUnit;
/*
//Points where refactoring is possible:
- Consumer can be passed in as a variable instead of being initialized in BFS, DFS. This
  helped with testing purposes but can better use the generality of nodes if it is independent.
- recursiveOutput does not need an integer as an argument, as it just has zero passed into it.
*/

public class Main
{
   public static void main(String [] args)
   {
   /*
        System.out.println("Trials for Iterative Deepening of Unknown Length");
       try
            {
            long iterStart = System.nanoTime();
            TheLock lock = new TheLock("Pierce");
               
            Tree iterTree = new Tree(lock);
            Node n = iterTree.IterDeep();
            iterTree.outputInfo(n);      
            long iterEnd = System.nanoTime();
            long iterDiff = iterEnd - iterStart;
            System.out.println("Time: " + TimeUnit.NANOSECONDS.toMillis(iterDiff));
            }
        catch(OutOfMemoryError E)
            {
               System.out.println("This trial could not be completed as the system ran out of memory.");
            }
            
       System.out.println("Trial for Breadth-First Search of Unknown Length");
       try
            {
            long bfsStart = System.nanoTime();
            TheLock lock = new TheLock("Pierce");
               
            Tree bfsT = new Tree(lock);
            Node n = bfsT.BFS();
            bfsT.outputInfo(n);      
            long bfsEnd = System.nanoTime();
            long bfsDiff = bfsEnd - bfsStart;
            System.out.println("Time: " + TimeUnit.NANOSECONDS.toMillis(bfsDiff));
            }
        catch(OutOfMemoryError E)
            {
               System.out.println("This trial could not be completed as the system ran out of memory.");
            }
            */
        //
        //Tests for varying length
        //
            
      for(int length = 11; length <= 11; length += 1)
      {
         System.out.println("Trials for Iterative Deepening of Length " + length);
         for (int trial = 0; trial < 5; trial++)
         {
            try
            {
            System.out.println("Trial " + trial);
            long start = System.nanoTime();
            TheLock lock = new TheLock("Pierce" + trial, length);
            //run your tests on the lock
               
            Tree T = new Tree(lock);
            Node n = T.IterDeep();
            T.outputInfo(n);      
            long end = System.nanoTime();
            long diff = end - start;
            System.out.println("Time: " + TimeUnit.NANOSECONDS.toMillis(diff));
            }
            catch(OutOfMemoryError E)
            {
               System.out.println("This trial could not be completed as the system ran out of memory.");
            }
         }
      }

      for(int length = 11; length <= 11; length += 1)
      {
         System.out.println("Trials for Breadth-First Search of Length " + length);
         for (int trial = 0; trial < 5; trial++)
         {
            try
            {
            System.out.println("Trial " + trial);
            long start = System.nanoTime();
            TheLock lock = new TheLock("Pierce" + trial, length);
            //run your tests on the lock
               
            Tree T = new Tree(lock);
            Node n = T.BFS();
            T.outputInfo(n);      
            long end = System.nanoTime();
            long diff = end - start;
            System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
            }
            catch(OutOfMemoryError E)
            {
               System.out.println("This trial could not be completed as the system ran out of memory.");
            }

         }
      }
            for(int length = 11; length <= 11; length += 1)
      {
         System.out.println("Trials for Depth Limited Search of Length " + length);
         for (int trial = 0; trial < 5; trial++)
         {
            try
            {
            System.out.println("Trial " + trial);
            long start = System.nanoTime();
            TheLock lock = new TheLock("Pierce" + trial, length);
            //run your tests on the lock
               
            Tree T = new Tree(lock);
            Node n = T.DLS(length);
            //T.outputInfo(n);      
            long end = System.nanoTime();
            long diff = end - start;
            System.out.println(TimeUnit.NANOSECONDS.toMillis(diff));
            }
            catch(OutOfMemoryError E)
            {
               System.out.println("This trial could not be completed as the system ran out of memory.");
            }

         }

      }
        
}
}