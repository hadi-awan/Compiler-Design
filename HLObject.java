/**
 * HLObject is an abstract superclass for HLNumber and HLSet
 * @author Sophie Quigley
 */
public abstract class HLObject
{
/**
 * Creates a deep clone of HLObject
 * @return a deep clone  of HLObject
 */

  public HLObject deepclone()
    {
    return null;
    }

/**
 * Creates String representation of HLObject
 * @return String representation of HLObject
 */
  public String toString()
    {
    return null;
    }
  /**
   * Checks whether other is the same object
   * @param other The other object
   * @return TRUE iff other is the same as the HLObject
   */
  public Boolean isSame (HLObject other) 
    {
    return Boolean.FALSE;
    }
  /**
   * Checks whether other is a different object
   * @param other The other object
   * @return TRUE iff other is different from the HLObject
   */
  public Boolean isDifferent (HLObject other) 
    {
    if (this.isSame(other).booleanValue())
      return Boolean.FALSE;
    else
      return Boolean.TRUE;
    }
  /**
   * Checks whether the HLObject is strictly less than other
   * @param other The other object
   * @return TRUE iff the HLObject < other
   */
  public Boolean isLessThan (HLObject other) 
    {
    return Boolean.FALSE;
    }
  /**
   * Checks whether the HLObject is less than or equal to other
   * @param other The other object
   * @return TRUE iff the HLObject <= other
   */
  public Boolean isLessEqual (HLObject other) 
    {
    if (this.isLessThan(other).booleanValue())
      return Boolean.TRUE;
    if (this.isSame(other).booleanValue())
      return Boolean.TRUE;
    return Boolean.FALSE;
    }

/**
 * Calculates the negation of an HLObject
 * @return - HLObject
 */
  public HLObject negate()
    {
    return null;
    }
/**
 * Add operand to HLObject
 * @param operand The second operand in addition
 * @return HLObject + operand
 */
  public HLObject add(HLObject operand)
    {
    return null;
    }
/**
 * Subtract operand from HLObject
 * @param operand The second operand in subtraction
 * @return HLObject - operand
 */
  public HLObject sub(HLObject operand)
    {
    return null;
    }
/**
 * Multiplies HLObject by operand
 * @param operand The second operand in multiplication
 * @return HLObject * operand
 */
  public HLObject mul(HLObject operand)
    {
    return null;
    }
/**
 * Calculates remainder of HLObject divided by operand 
 * @param operand The second operand in remainder
 * @return remainder of HLObject / operand
 */
  public HLObject mod(HLObject operand)
    {
    return null;
    }
/**
 * Calculates quotient of HLObject divided by operand 
 * @param operand The second operand in quotient
 * @return quotient of HLObject / operand
 */
  public HLObject div(HLObject operand)
    {
    return null;
    }
/**
 * Calculates the cardinality of an HLSet or the absolute value of an HLNumber
 * @return - HLNumber
 */
  public HLNumber card()
    {
    return null;
    }

}