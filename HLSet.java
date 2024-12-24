import java.util.*;
/**
 * Implements HLSet objects
 */

public class HLSet extends HLObject{

//Instance Variables

  private TreeSet value = null;
  private int len = 0;
  private Iterator iter;
  
// Class variables

  public static HLSet empty = new HLSet();

// Constructors
  
  public HLSet()
    {
	    value = new TreeSet();
	    len = value.size();
    }

  public HLSet(TreeSet lst)
    {
	    value = new TreeSet(lst);
	    len = value.size();
    }

  public HLSet(Collection lst)
    {
	    value = new TreeSet(lst);
	    len = value.size();
    }
    
  public HLSet(HLNumber firstelem, HLNumber lastelem)
    {
	    value = new TreeSet();
	    if (firstelem.value <= lastelem.value) {
		    for (int i = firstelem.value; i <= lastelem.value; i++) {
			    value.add(new HLNumber(i));
		    }
	    }
	    len = value.size();
    }
  
// Overridden  HLObject Methods

  public HLObject deepclone()
    {
	    return new HLSet(value);
    }

  public String toString()
    {
	    if (value.isEmpty()) return "{}";
	    StringBuilder sb = new StringBuilder("{");
	    Iterator<HLNumber> it = value.iterator();
	    while (it.hasNext()) {
		    sb.append(it.next());
		    if (it.hasNext()) sb.append(", ");
	    }
	    return sb.append("}").toString();
    }

  public Boolean isSame (HLObject other) 
    {
	    if (!(other instanceof HLSet)) return false;
	    return value.equals(((HLSet)other).value);
    }

  public Boolean isLessThan (HLObject other) 
    {
	    if (!(other instanceof HLSet)) return false;
	    HLSet otherSet = (HLSet)other;
	    if (value.size() >= otherSet.value.size()) return false;
	    return otherSet.value.containsAll(value);
    }
    

  public HLSet add(HLObject operand)
    {
	    if (operand instanceof HLSet) {
		    TreeSet result = new TreeSet(value);
		    result.addAll(((HLSet)operand).value);
		    return new HLSet(result);
	    }
	    return null;
    }

  public HLSet sub(HLObject operand)
    {
	    if (!(operand instanceof HLSet)) return null;
	    TreeSet result = new TreeSet(value);
	    result.removeAll(((HLSet)operand).value);
	    return new HLSet(result);
    }
  public HLSet mul(HLObject operand)
    {
	    if (operand instanceof HLSet) {
		    TreeSet result = new TreeSet(value);
		    result.addAll(value);
		    result.retainAll(((HLSet)operand).value);
		    return new HLSet(result);
	    }
	    return null;
    }
  public HLSet negate() {
	  TreeSet result = new TreeSet();
	  for (Object elem : value) {
		  if (elem instanceof HLNumber) {
			  HLNumber negated = ((HLNumber)elem).negate();
			  result.add(negated);
		  }
	  }
	  return new HLSet(result);
  }
  public HLNumber card()
    {
	    return new HLNumber(value.size());
    }

// Other Methods  
public boolean contains(HLNumber num) {
	return value.contains(num);
}

public TreeSet getElements() {
	return new TreeSet(value);
}

// Helper Methods  
}
