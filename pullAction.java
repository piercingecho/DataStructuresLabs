public class pullAction implements Action
{
   public void doAction(TheLock l)
   {
      l.pullIt();
   }
   
   public String toString()
   {
      return "Pull it";
   }
}