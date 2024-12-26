/**
 * Describes STRING tokens
 */

public class StringToken extends Token {

  /**
   * The String value of the token is also stored for STRING tokens
   */
  public String value;
  
  public String toString()
  {
  	return value.toString();
  }

  public Object getValue()
  {
	  return value;
  }
 
  public StringToken(String image)
  {
    this.kind = HLConstants.STRING  ;
    this.image = image;
	  value = image.substring(1,image.length()-1);
  }

}
