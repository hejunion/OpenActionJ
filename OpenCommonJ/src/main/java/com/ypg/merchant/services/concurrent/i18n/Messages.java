package com.ypg.merchant.services.concurrent.i18n;

import java.util.MissingResourceException;

/**
 * Provides methods for retrieving i18n messages.
 *
 * @author Ian P. Springer <ian_springer@hp.com>
 */
public interface Messages
{
   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key The resource key
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key,
                      String arg0 )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key,
                      Object arg0 )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key,
                      String arg0,
                      String arg1 )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key,
                      Object arg0,
                      Object arg1 )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    * @param arg2 The argument to place in variable {2}
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key,
                      String arg0,
                      String arg1,
                      String arg2 )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    * @param arg2 The argument to place in variable {2}
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key,
                      Object arg0,
                      Object arg1,
                      Object arg2 )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    * @param arg2 The argument to place in variable {2}
    * @param arg3 The argument to place in variable {3}
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key,
                      String arg0,
                      String arg1,
                      String arg2,
                      String arg3 )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    * @param arg2 The argument to place in variable {2}
    * @param arg3 The argument to place in variable {3}
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key,
                      Object arg0,
                      Object arg1,
                      Object arg2,
                      Object arg3 )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    * @param arg2 The argument to place in variable {2}
    * @param arg3 The argument to place in variable {3}
    * @param arg4 The argument to place in variable {4}
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key,
                      String arg0,
                      String arg1,
                      String arg2,
                      String arg3,
                      String arg4 )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param arg0 The argument to place in variable {0}
    * @param arg1 The argument to place in variable {1}
    * @param arg2 The argument to place in variable {2}
    * @param arg3 The argument to place in variable {3}
    * @param arg4 The argument to place in variable {4}
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String key,
                      Object arg0,
                      Object arg1,
                      Object arg2,
                      Object arg3,
                      Object arg4 )
   throws MissingResourceException;

   /**
    * Get a message from resource.properties from the package of the given object.
    *
    * @param key  The resource key
    * @param args An array of objects to place in corresponding variables
    *
    * @return The formatted message
    *
    * @throws MissingResourceException
    */
   String getMessage( String   key,
                      String[] args )
   throws MissingResourceException;
}