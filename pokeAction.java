public class pokeAction implements Action
{
   public void doAction(TheLock l)
   {
      l.pokeIt();
   }
   
   public String toString()
   {
      return "Poke it";
   }
}