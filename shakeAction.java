public class shakeAction implements Action
{
   public void doAction(TheLock l)
   {
      l.shakeIt();
   }
   
   public String toString()
   {
      return "Shake it";
   }
}