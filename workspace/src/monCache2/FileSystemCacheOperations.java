package monCache2;


/**
* monCache2/FileSystemCacheOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from monCache2.idl
* jeudi 24 mars 2016 18 h 08 CET
*/

public interface FileSystemCacheOperations 
{
  boolean lireM (String ref, org.omg.CORBA.StringHolder data) throws Exception;
  boolean ecrireM (String ref, String data) throws Exception;
  boolean majCache (String ref, String data) throws Exception;
} // interface FileSystemCacheOperations
