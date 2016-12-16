package cache;


/**
* cache/FileSystemPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from cache/cache.idl
* jeudi 24 mars 2016 16 h 50 CET
*/

public abstract class FileSystemPOA extends org.omg.PortableServer.Servant
 implements cache.FileSystemOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("lire", new java.lang.Integer (0));
    _methods.put ("ecrire", new java.lang.Integer (1));
    _methods.put ("majCache", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // cache/FileSystem/lire
       {
         String ref = cache.ReferenceHelper.read (in);
         org.omg.CORBA.StringHolder data = new org.omg.CORBA.StringHolder ();
         boolean $result = false;
         try {
			$result = this.lire (ref, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         out = $rh.createReply();
         out.write_boolean ($result);
         cache.DonneeHelper.write (out, data.value);
         break;
       }

       case 1:  // cache/FileSystem/ecrire
       {
         String ref = cache.ReferenceHelper.read (in);
         String data = cache.DonneeHelper.read (in);
         boolean $result = false;
         try {
			$result = this.ecrire (ref, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // cache/FileSystem/majCache
       {
         String ref = cache.ReferenceHelper.read (in);
         String data = cache.DonneeHelper.read (in);
         boolean $result = false;
         try {
			$result = this.majCache (ref, data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:cache/FileSystem:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public FileSystem _this() 
  {
    return FileSystemHelper.narrow(
    super._this_object());
  }

  public FileSystem _this(org.omg.CORBA.ORB orb) 
  {
    return FileSystemHelper.narrow(
    super._this_object(orb));
  }


} // class FileSystemPOA
