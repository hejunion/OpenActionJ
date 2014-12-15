package com.ypg.merchant.services.concurrent.i18n;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
/**
 * Accept parameters for ProjectResourceBundle,
 * but defer object instantiation (and therefore
 * resource bundle loading) until required.
 *
 * @author Richard A. Sitze (rsitze@us.ibm.com)
 * @author Karl Moss (kmoss@macromedia.com)
 * @author Glen Daniels (gdaniels@apache.org)
 */
public class MessageBundle
{
   private final ClassLoader     m_classLoader;
   private final Locale          m_locale;
   private ProjectResourceBundle m_resourceBundle = null;
   private final ResourceBundle  m_parent;
   private final String          m_packageName;
   private final String          m_projectName;
   private final String          m_resourceName;
   private boolean               m_loaded;

   /**
    * Construct a new ExtendMessages
    */
   public MessageBundle( String         projectName,
                         String         packageName,
                         String         resourceName,
                         Locale         locale,
                         ClassLoader    classLoader,
                         ResourceBundle parent )
   throws MissingResourceException
   {
      this.m_projectName     = projectName;
      this.m_packageName     = packageName;
      this.m_resourceName    = resourceName;
      this.m_locale          = locale;
      this.m_classLoader     = classLoader;
      this.m_parent          = parent;
   }

   /**
    * DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   public final ProjectResourceBundle getResourceBundle(  )
   {
      if ( !m_loaded )
      {
         m_resourceBundle =
            ProjectResourceBundle.getBundle( m_projectName, m_packageName, m_resourceName, m_locale,
                                             m_classLoader, m_parent );
         m_loaded = true;
      }

      return m_resourceBundle;
   }

   /**
    * Gets a string message from the resource bundle for the given key
    *
    * @param key The resource key
    *
    * @return The message
    */
   public String getMessage( String key )
   throws MissingResourceException
   {
      return getMessage( key, (String[]) null );
   }

   /**
    * <p>Gets a string message from the resource bundle for the given key. The message may contain variables that will
    * be substituted with the given arguments. Variables have the format:</p> <dir> This message has two variables: {0}
    * and {1} </dir>
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    *
    * @return The message
    */
   public String getMessage( String key,
                             String arg0 )
   throws MissingResourceException
   {
      return getMessage( key,
                         new String[]
                         {
                            arg0
                         } );
   }

   /**
    * <p>Gets a string message from the resource bundle for the given key. The message may contain variables that will
    * be substituted with the given arguments. Variables have the format:</p> <dir> This message has two variables: {0}
    * and {1} </dir>
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    *
    * @return The message
    */
   public String getMessage( String key,
                             String arg0,
                             String arg1 )
   throws MissingResourceException
   {
      return getMessage( key,
                         new String[]
                         {
                            arg0,
                            arg1
                         } );
   }

   /**
    * <p>Gets a string message from the resource bundle for the given key. The message may contain variables that will
    * be substituted with the given arguments. Variables have the format:</p> <dir> This message has two variables: {0}
    * and {1} </dir>
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    * @param arg2 The argument to place in variable {2}
    *
    * @return The message
    */
   public String getMessage( String key,
                             String arg0,
                             String arg1,
                             String arg2 )
   throws MissingResourceException
   {
      return getMessage( key,
                         new String[]
                         {
                            arg0,
                            arg1,
                            arg2
                         } );
   }

   /**
    * <p>Gets a string message from the resource bundle for the given key. The message may contain variables that will
    * be substituted with the given arguments. Variables have the format:</p> <dir> This message has two variables: {0}
    * and {1} </dir>
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    * @param arg2 The argument to place in variable {2}
    * @param arg3 The argument to place in variable {3}
    *
    * @return The message
    */
   public String getMessage( String key,
                             String arg0,
                             String arg1,
                             String arg2,
                             String arg3 )
   throws MissingResourceException
   {
      return getMessage( key,
                         new String[]
                         {
                            arg0,
                            arg1,
                            arg2,
                            arg3
                         } );
   }

   /**
    * <p>Gets a string message from the resource bundle for the given key. The message may contain variables that will
    * be substituted with the given arguments. Variables have the format:</p> <dir> This message has two variables: {0}
    * and {1} </dir>
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    * @param arg2 The argument to place in variable {2}
    * @param arg3 The argument to place in variable {3}
    * @param arg4 The argument to place in variable {4}
    *
    * @return The message
    */
   public String getMessage( String key,
                             String arg0,
                             String arg1,
                             String arg2,
                             String arg3,
                             String arg4 )
   throws MissingResourceException
   {
      return getMessage( key,
                         new String[]
                         {
                            arg0,
                            arg1,
                            arg2,
                            arg3,
                            arg4
                         } );
   }

   /**
    * <p>Gets a string message from the resource bundle for the given key. The message may contain variables that will
    * be substituted with the given arguments. Variables have the format:</p> <dir> This message has two variables: {0}
    * and {1} </dir>
    *
    * @param key   The resource key
    * @param array An array of objects to place in corresponding variables
    *
    * @return The message
    */
   public String getMessage( String   key,
                             String[] array )
   throws MissingResourceException
   {
      String msg = null;

      if ( getResourceBundle(  ) != null )
      {
         msg = getResourceBundle(  ).getString( key );
      }

      if ( msg == null )
      {
         throw new MissingResourceException( "Cannot find resource key \"" + key + "\" in base name "
                                             + getResourceBundle(  ).getResourceName(  ),
                                             getResourceBundle(  ).getResourceName(  ), key );
      }

      return MessageFormat.format( msg, array );
   }
}
