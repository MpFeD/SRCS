package cache2;

/**
* cache2/DoesNotExistHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from cache2.idl
* jeudi 24 mars 2016 18 h 08 CET
*/

public final class DoesNotExistHolder implements org.omg.CORBA.portable.Streamable
{
  public cache2.DoesNotExist value = null;

  public DoesNotExistHolder ()
  {
  }

  public DoesNotExistHolder (cache2.DoesNotExist initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = cache2.DoesNotExistHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    cache2.DoesNotExistHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return cache2.DoesNotExistHelper.type ();
  }

}
