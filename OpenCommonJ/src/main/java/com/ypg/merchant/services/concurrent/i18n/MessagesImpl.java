package com.ypg.merchant.services.concurrent.i18n;

/**
 * Singleton used by all classes below the {@link org.apache.ws.util} package
 * for retrieving i18n messages.
 *
 * @author Ian P. Springer
 */
public class MessagesImpl
   extends AbstractMessages
{
   /** DOCUMENT_ME */
   public static final String PROJECT_PACKAGE_NAME = "com.ypg.merchant.services.concurrent.i18n";

   /** DOCUMENT_ME */
   public static final String RESOURCE_PACKAGE_NAME = "com.ypg.merchant.services.concurrent.i18n";
   private static Messages    s_ourInstance = new MessagesImpl(  );

   /**
    * DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   public static Messages getInstance(  )
   {
      return s_ourInstance;
   }

   /**
    * DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   protected String getProjectPackageName(  )
   {
      return PROJECT_PACKAGE_NAME;
   }

   /**
    * DOCUMENT_ME
    *
    * @return DOCUMENT_ME
    */
   protected String getResourcePackageName(  )
   {
      return RESOURCE_PACKAGE_NAME;
   }
}