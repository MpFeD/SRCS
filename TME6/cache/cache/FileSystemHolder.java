package cache;

/**
* cache/FileSystemHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from cache.idl
* vendredi 13 mai 2016 15 h 06 CEST
*/

public final class FileSystemHolder implements org.omg.CORBA.portable.Streamable
{
  public cache.FileSystem value = null;

  public FileSystemHolder ()
  {
  }

  public FileSystemHolder (cache.FileSystem initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = cache.FileSystemHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    cache.FileSystemHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return cache.FileSystemHelper.type ();
  }

}
