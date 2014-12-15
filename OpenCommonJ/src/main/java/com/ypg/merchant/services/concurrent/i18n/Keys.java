package com.ypg.merchant.services.concurrent.i18n;

/**
 * i18n message keys and messages for the {@link org.apache.ws.util} package
 * and all its subpackages.
 *
 * @author Ian P. Springer
 */
public interface Keys
{
   /**
    * @msg Getting an InputSource from the URI: {0} using username: {1} and password: {2}
    */
   String INPUT_SRC_FRM_URI = "INPUT_SRC_FRM_URI";

   /**
    * @msg Null parameter not allowed.
    */
   String NULL_PARAM_NOT_ALLOWED = "NULL_PARAM_NOT_ALLOWED";

   /**
    * @msg Parameter must be an instance of one of the following types: XmlObject, Node, String, InputStream, Reader, File, or URL
    */
   String PARAM_MUST_BE_TYPE = "PARAM_MUST_BE_TYPE";

   /**
    * @msg  parameter may not be null
    */
   String PARAM_MAY_NOT_BE_NULL = "PARAM_MAY_NOT_BE_NULL";

   /**
    * @msg text node has null value
    */
   String TEXT_NODE_IS_NULL = "TEXT_NODE_IS_NULL";

   /**
    * @msg Building a prefix for the namespace: {0}
    */
   String BLD_PREFIX_FOR_NAMESPC = "BLD_PREFIX_FOR_NAMESPC";

   /**
    * @msg Creating a Name from localpart: {0} prefix: {1} uri: {2}
    */
   String CREATING_NAME = "CREATING_NAME";

   /**
    * @msg Converting QName to Name.  QName: {0}
    */
   String CONVRT_QNAME_TO_NAME = "CONVRT_QNAME_TO_NAME";

   /**
    * @msg Converting Name to QName.  Name: {0}
    */
   String CONVRT_NAME_TO_QNAME = "CONVRT_NAME_TO_QNAME";

   /**
    * @msg Attempting to load xml string: {0} into a DOM.
    */
   String LOAD_XML_STRING = "LOAD_XML_STRING";

   /**
    * @msg InputStream parameter must not be null.
    */
   String INPUTSTRM_MST_NOT_B_NULL = "INPUTSTRM_MST_NOT_B_NULL";

   /**
    * @msg OutputStream parameter must not be null.
    */
   String OUTSTRM_MST_NOT_B_NULL = "OUTSTRM_MST_NOT_B_NULL";

   /**
    * @msg Attempting to copy an InputStream to the file: {0}
    */
   String COPY_OUTPUTSTRM_TO_FILE = "COPY_OUTPUTSTRM_TO_FILE";

   /**
    * @msg copy
    */
   String COPY = "COPY";

   /**
    * @msg Failed to copy input stream to {0}.  Rename of temporary file {1} failed.
    */
   String FAILED_TO_COPY_INPUTSTRM = "FAILED_TO_COPY_INPUTSTRM";

   /**
    * @msg Attempting to copy the file: {0} to the file: {1}
    */
   String ATTMPT_COPY_FILE_TO_FILE = "ATTMPT_COPY_FILE_TO_FILE";

   /**
    * @msg Failed to copy {0} to {1} Cause: {2}
    */
   String FAILED_TO_CPY_FILE_TO_FILE = "FAILED_TO_CPY_FILE_TO_FILE";

   /**
    * @msg Attempting to delete directory: {0}
    */
   String ATTMPT_DEL_DIR = "ATTMPT_DEL_DIR";

   /**
    * @msg Attempting to convert a String to an InputStream. String: {0}
    */
   String ATTMPT_CNVRT_STRING_TO_INPTSTRM = "ATTMPT_CNVRT_STRING_TO_INPTSTRM";

   /**
    * @msg Work object cannot be null.
    */
   String NULL_WORK = "NULL_WORK";

   /**
    * @msg Setting WorkManager maxPoolSize to: {0}
    */
   String WRK_MGR_POOL_SIZE = "WRK_MGR_POOL_SIZE";

   /**
    * @msg Creating WorkManager with maxPoolSize: {0}
    */
   String CREATE_WRK_MGR_POOL_SZE = "CREATE_WRK_MGR_POOL_SZE";

   /**
    * @msg Cancelling.
    */
   String CANCELLING = "CANCELLING";

   /**
    * @msg Setting pool size to: {0}
    */
   String SET_POOL_SIZE = "SET_POOL_SIZE";

   /**
    * @msg Resuming.
    */
   String RESUMING = "RESUMING";

   /**
    * @msg Stopping.
    */
   String STOPPING = "STOPPING";

   /**
    * @msg Suspending.
    */
   String SUSPENDING = "SUSPENDING";

   /**
    * @msg Removing task: {0}
    */
   String REMOVING_TASK = "REMOVING_TASK";

   /**
    * @msg The serviceURL attribute is required.
    */
   String SRVC_URL_REQ = "SRVC_URL_REQ";

   /**
    * @msg The requestFile attribute is required.
    */
   String RQST_FILE_REQ = "RQST_FILE_REQ";

   /**
    * @msg SOAP request failed with HTTP status: {0} {1}
    */
   String SOAP_REQ_FAILED_HTTP_STATUS = "SOAP_REQ_FAILED_HTTP_STATUS";

   /**
    * @msg  Usage:  java {0} http://serviceURL soapEnvelope.xml [SOAPAction]
    */
   String SOAPCLIENT_USAGE = "SOAPCLIENT_USAGE";

   /**
    * @msg  SOAPAction is optional.
    */
   String SOAPACITON_OPTIONAL = "SOAPACITON_OPTIONAL";

   /**
    * @msg Getting Lock for key: {0}
    */
   String GET_LOCK_FOR_KEY = "GET_LOCK_FOR_KEY";

   /**
    * @msg Removing Lock for key: {0}
    */
   String REMOVING_LCK_FOR_KEY = "REMOVING_LCK_FOR_KEY";

   /**
    * @msg Acquiring lock.
    */
   String ACQUIRE_LCK = "ACQUIRE_LCK";

   /**
    * @msg Releasing lock.
    */
   String RELEASE_LCK = "RELEASE_LCK";

   /**
    * @msg project has not been set
    */
   String PRJ_NOT_SET = "PRJ_NOT_SET";

   /**
    * @msg You must specify a property name.
    */
   String MST_SPECIFY_PROP_NAME = "MST_SPECIFY_PROP_NAME";

   /**
    * @msg You must specify a location.
    */
   String MST_SPECIFY_LOCATION = "MST_SPECIFY_LOCATION";

   /**
    * @msg value is null
    */
   String NULL_VALUE = "NULL_VALUE";
}