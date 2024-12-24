/**
 * Implements HLNumber
 */

public class HLNumber extends HLObject  implements Comparable<HLNumber> {

//Instance Variables
// I have found it simpler to wrap HLNumber around a primitive int value
// but it could also be wrapped around an Integer value.

  int value;
  
// Class variables

  public static HLNumber zero = new HLNumber(0);

// Constructors
  
  public HLNumber(int value)
    {
	    this.value = value;
    }                
  
  public HLNumber(Integer num)
    {
	    this.value = num;
    }

//Overridden compareTo

  public int compareTo(HLNumber to)
    {
	    return Integer.compare(this.value, to.value);
    }                
  
// Overridden  HLObject Methods

  public HLObject deepclone()
    {
	    return new HLNumber(value);
    }

  public String toString()
    {
	    return String.valueOf(value);
    }

  public Boolean isSame (HLObject other) 
    {
	    if (!(other instanceof HLNumber)) return false;
	    return value == ((HLNumber)other).value;
    }

  public Boolean isLessThan (HLObject other) 
    {
	    if (!(other instanceof HLNumber)) return false;
	    return value < ((HLNumber)other).value;
    }
    
  public HLNumber negate()
    {
	    return new HLNumber(-value);
    }

  public HLNumber add(HLObject operand)
    {
	    if (!(operand instanceof HLNumber)) return null;
	    return new HLNumber(value + ((HLNumber)operand).value);
    }

  public HLNumber sub(HLObject operand)
    {
	    if (!(operand instanceof HLNumber)) return null;
	    return new HLNumber(value - ((HLNumber)operand).value);
    }

  public HLNumber mul(HLObject operand)
    {
	    if (!(operand instanceof HLNumber)) return null;
	    return new HLNumber(value * ((HLNumber)operand).value);
    }

  public HLNumber mod(HLObject operand)
    {
	    if (!(operand instanceof HLNumber)) return null;
	    return new HLNumber(value % ((HLNumber)operand).value);
    }

  public HLNumber div(HLObject operand)
    {
	    if (!(operand instanceof HLNumber)) return null;
	    return new HLNumber(value / ((HLNumber)operand).value);
    }

  public HLNumber card()
    {
	    return new HLNumber(1);
    }

// Other Methods  


// Helper Methods  
public Boolean isGreaterThan(HLObject other) {
    if (!(other instanceof HLNumber)) return false;
    return this.value > ((HLNumber)other).value;
}

public Boolean isEqualTo(HLObject other) {
    if (!(other instanceof HLNumber)) return false;
    return this.value == ((HLNumber)other).value;
}

public Boolean isLessThanOrEqualTo(HLObject other) {
    if (!(other instanceof HLNumber)) return false;
    return this.value <= ((HLNumber)other).value;
}

public Boolean isGreaterThanOrEqualTo(HLObject other) {
    if (!(other instanceof HLNumber)) return false;
    return this.value >= ((HLNumber)other).value;
}   
  
}
