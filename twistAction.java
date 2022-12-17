public class twistAction implements Action
{
   public void doAction(TheLock l)
   {
      l.twistIt();
   }
   
   public String toString()
   {
      return "Twist it";
   }
}