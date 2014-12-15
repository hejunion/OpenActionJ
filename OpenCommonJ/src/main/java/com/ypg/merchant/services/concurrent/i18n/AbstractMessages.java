package com.ypg.merchant.services.concurrent.i18n;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Each project should implement this abstract class.
 *
 * @author Ian P. Springer
 */
public abstract class AbstractMessages
   implements Messages
{
   /** DOCUMENT_ME */
   private static final String DEFAULT_RESOURCE_NAME = "resource";

   /** DOCUMENT_ME */
   private static final Locale LOCALE = null;

   /** DOCUMENT_ME */
   private static final String ROOT_PROJECT_NAME = "com.ypg.merchant.services.concurrent.i18n";

   /** DOCUMENT_ME */
   private static final String ROOT_PACKAGE_NAME = "com.ypg.merchant.services.concurrent.i18n";

   /** DOCUMENT_ME */
   private static final ResourceBundle ROOT_RESOURCE_BUNDLE =
      ProjectResourceBundle.getBundle( ROOT_PROJECT_NAME,
                                       ROOT_PACKAGE_NAME,
                                       DEFAULT_RESOURCE_NAME,
                                       LOCALE,
                                       AbstractMessages.class.getClassLoader(  ),
                                       null );
   private MessageBundle               m_messageBundle;

   /**
    * Creates a new {@link AbstractMessages} object.
    */
   protected AbstractMessages(  )
   {
      this( DEFAULT_RESOURCE_NAME );
   }

   /**
    * Creates a new {@link AbstractMessages} object.
    *
    * @param resourceName DOCUMENT_ME
    */
   protected AbstractMessages( final String resourceName )
   {
      m_messageBundle =
         new MessageBundle( getProjectPackageName(  ),
                            getResourcePackageName(  ),
                            resourceName,
                            LOCALE,
                            this.getClass(  ).getClassLoader(  ),
                            ROOT_RESOURCE_BUNDLE );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param arg0 DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key,
                             String arg0 )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key, arg0 );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param arg0 DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key,
                             Object arg0 )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key,
                                         String.valueOf( arg0 ) );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param arg0 DOCUMENT_ME
    * @param arg1 DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key,
                             String arg0,
                             String arg1 )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key, arg0, arg1 );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param arg0 DOCUMENT_ME
    * @param arg1 DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key,
                             Object arg0,
                             Object arg1 )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key,
                                         String.valueOf( arg0 ),
                                         String.valueOf( arg1 ) );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param arg0 DOCUMENT_ME
    * @param arg1 DOCUMENT_ME
    * @param arg2 DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key,
                             String arg0,
                             String arg1,
                             String arg2 )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key, arg0, arg1, arg2 );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param arg0 DOCUMENT_ME
    * @param arg1 DOCUMENT_ME
    * @param arg2 DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key,
                             Object arg0,
                             Object arg1,
                             Object arg2 )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key,
                                         String.valueOf( arg0 ),
                                         String.valueOf( arg1 ),
                                         String.valueOf( arg2 ) );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param arg0 DOCUMENT_ME
    * @param arg1 DOCUMENT_ME
    * @param arg2 DOCUMENT_ME
    * @param arg3 DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key,
                             String arg0,
                             String arg1,
                             String arg2,
                             String arg3 )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key, arg0, arg1, arg2, arg3 );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param arg0 DOCUMENT_ME
    * @param arg1 DOCUMENT_ME
    * @param arg2 DOCUMENT_ME
    * @param arg3 DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key,
                             Object arg0,
                             Object arg1,
                             Object arg2,
                             Object arg3 )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key,
                                         String.valueOf( arg0 ),
                                         String.valueOf( arg1 ),
                                         String.valueOf( arg2 ),
                                         String.valueOf( arg3 ) );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param arg0 DOCUMENT_ME
    * @param arg1 DOCUMENT_ME
    * @param arg2 DOCUMENT_ME
    * @param arg3 DOCUMENT_ME
    * @param arg4 DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key,
                             String arg0,
                             String arg1,
                             String arg2,
                             String arg3,
                             String arg4 )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key, arg0, arg1, arg2, arg3, arg4 );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param arg0 DOCUMENT_ME
    * @param arg1 DOCUMENT_ME
    * @param arg2 DOCUMENT_ME
    * @param arg3 DOCUMENT_ME
    * @param arg4 DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String key,
                             Object arg0,
                             Object arg1,
                             Object arg2,
                             Object arg3,
                             Object arg4 )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key,
                                         String.valueOf( arg0 ),
                                         String.valueOf( arg1 ),
                                         String.valueOf( arg2 ),
                                         String.valueOf( arg3 ),
                                         String.valueOf( arg4 ) );
   }

   /**
    * DOCUMENT_ME
    *
    * @param key DOCUMENT_ME
    * @param args DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    *
    * @throws MissingResourceException DOCUMENT_ME
    */
   public String getMessage( String   key,
                             String[] args )
   throws MissingResourceException
   {
      return m_messageBundle.getMessage( key, args );
   }

   /**
    * DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   public String toString(  )
   {
      return "i18n messages for project " + getProjectPackageName(  );
   }

   /**
    * DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   protected abstract String getProjectPackageName(  );

   /**
    * DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   protected abstract String getResourcePackageName(  );

   /**
    * DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   protected MessageBundle getMessageBundle(  )
   {
      return m_messageBundle;
   }

   /**
    * DOCUMENT_ME
    *
    * @param name DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   protected static final String getPackage( String name )
   {
      return name.substring( 0,
                             name.lastIndexOf( '.' ) ).intern(  );
   }

   /**
    * DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   protected ResourceBundle getResourceBundle(  )
   {
      return m_messageBundle.getResourceBundle(  );
   }
}
