package calculatrice;


/**
* calculatrice/DivisionParZeroException.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calculatrice.idl
* lundi 9 mai 2016 17 h 20 CEST
*/

public final class DivisionParZeroException extends org.omg.CORBA.UserException
{

  public DivisionParZeroException ()
  {
    super(DivisionParZeroExceptionHelper.id());
  } // ctor


  public DivisionParZeroException (String $reason)
  {
    super(DivisionParZeroExceptionHelper.id() + "  " + $reason);
  } // ctor

} // class DivisionParZeroException
