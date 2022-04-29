public class HpUp extends PokemonDecorator{
  /**
  Description: raising the hp 
  @param Pokemon p - is the pokemon we are raising the hp
  */
  public HpUp(Pokemon p){
    super(p,"+HP",(int)(Math.random()*2) + 1);
  }

}//end of class

