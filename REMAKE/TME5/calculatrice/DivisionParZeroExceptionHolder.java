package calculatrice;

/**
* calculatrice/DivisionParZeroExceptionHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calculatrice.idl
* lundi 9 mai 2016 17 h 20 CEST
*/

public final class DivisionParZeroExceptionHolder implements org.omg.CORBA.portable.Streamable
{
  public calculatrice.DivisionParZeroException value = null;

  public DivisionParZeroExceptionHolder ()
  {
  }

  public DivisionParZeroExceptionHolder (calculatrice.DivisionParZeroException initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = calculatrice.DivisionParZeroExceptionHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    calculatrice.DivisionParZeroExceptionHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return calculatrice.DivisionParZeroExceptionHelper.type ();
  }

}
