import java.util.*;
/**
 * Describes IDENTIFER tokens
 * The name table is a static ArrayList<String>
 */

public class IdentifierToken extends Token {
/**
 * nameTable contains all the names of all identifiers in HL
 */
	private static ArrayList<String> nameTable = new ArrayList<>();

/**
 * Returns the name of the identifier with the specified key
 * @param key int key of identifier
 * @return the name of the identifier with the specified key
 */  
  public static String getName(int key)
    {
	    return nameTable.get(key);
    }

/**
 * Returns the name of the identifier with the specified key
 * @param key Integer key of identifier
 * @return the name of the identifier with the specified key
 */      
  public static String getName(Integer key)
    {
	    return nameTable.get(key);
    }

/**
 * Returns the number of names of identifiers in HL
 * @return the number of names of identifiers in HL
 */      
  public static int totalIdentifiers()
    {
	    return nameTable.size();
    }

/**
 * A unique key is stored for each identifier name to be used later in symbol tables
 */ 
  public int key;
/**
 * The key is also stored as an Integer to be stored in ASTIdentifier nodes
 */ 
  public Integer Key;

/**
 * Creates a new IdentifierToken with the specified name.
 * If not already there, name is added to nameTable.
 * this will keep a key into nameTable for its name.
 * For C and B learning objectives, this method should trigger a static call to
 * something like HLSymbTab.newIdName(key)
 * @param name name of the identifier (just scanned)
 * @return a new IdentifierToken with the specified name
 */      
  public IdentifierToken(int type, String name)
    {
      this.kind = type;
      this.image = name;

      // Check if name already exists in nameTable
      int index = nameTable.indexOf(name);
      if (index == -1) {
	      // Add new name and get its index
	      nameTable.add(name);
	      index = nameTable.size() - 1;
	      // Notify symbol table of new identifier
	      HLSymbTab.newIdName(index);
      }

      // Store both primitive and object keys
      this.key = index;
      this.Key = Integer.valueOf(index);
    }

/**
 * Returns String name of identifier
 * @return String name of identifier
 */     
  public String toString()
    {
    return image;
    }
  
/**
 * Retrieves key of identifier to be stored in ASTIdentifer nodes
 * @return Integer key of identifier
 */     
  public Integer getValue()
    {
	  return Key;
    }

/**
 * Retrieves key of identifier
 * @return int key of identifier
 */  
  public int getKey()
    {
	    return key;
    }
    
}
