package monCache2;


/**
* monCache2/DoesNotExistHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from monCache2.idl
* jeudi 24 mars 2016 18 h 08 CET
*/

abstract public class DoesNotExistHelper
{
  private static String  _id = "IDL:monCache2/DoesNotExist:1.0";

  public static void insert (org.omg.CORBA.Any a, monCache2.DoesNotExist that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static monCache2.DoesNotExist extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_wstring_tc (0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (monCache2.ReferenceHelper.id (), "Reference", _tcOf_members0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "r",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_exception_tc (monCache2.DoesNotExistHelper.id (), "DoesNotExist", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static monCache2.DoesNotExist read (org.omg.CORBA.portable.InputStream istream)
  {
    monCache2.DoesNotExist value = new monCache2.DoesNotExist ();
    // read and discard the repository ID
    istream.read_string ();
    value.r = istream.read_wstring ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, monCache2.DoesNotExist value)
  {
    // write the repository ID
    ostream.write_string (id ());
    ostream.write_wstring (value.r);
  }

}
