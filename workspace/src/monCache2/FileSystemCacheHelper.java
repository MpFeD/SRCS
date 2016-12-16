package monCache2;


/**
* monCache2/FileSystemCacheHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from monCache2.idl
* jeudi 24 mars 2016 18 h 08 CET
*/

abstract public class FileSystemCacheHelper
{
  private static String  _id = "IDL:monCache2/FileSystemCache:1.0";

  public static void insert (org.omg.CORBA.Any a, monCache2.FileSystemCache that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static monCache2.FileSystemCache extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (monCache2.FileSystemCacheHelper.id (), "FileSystemCache");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static monCache2.FileSystemCache read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_FileSystemCacheStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, monCache2.FileSystemCache value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static monCache2.FileSystemCache narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof monCache2.FileSystemCache)
      return (monCache2.FileSystemCache)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      monCache2._FileSystemCacheStub stub = new monCache2._FileSystemCacheStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static monCache2.FileSystemCache unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof monCache2.FileSystemCache)
      return (monCache2.FileSystemCache)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      monCache2._FileSystemCacheStub stub = new monCache2._FileSystemCacheStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
