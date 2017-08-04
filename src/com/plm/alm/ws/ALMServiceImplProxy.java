package com.plm.alm.ws;

public class ALMServiceImplProxy implements com.plm.alm.ws.ALMServiceImpl {
  private String _endpoint = null;
  private com.plm.alm.ws.ALMServiceImpl aLMServiceImpl = null;
  
  public ALMServiceImplProxy() {
    _initALMServiceImplProxy();
  }
  
  public ALMServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initALMServiceImplProxy();
  }
  
  private void _initALMServiceImplProxy() {
    try {
      aLMServiceImpl = (new com.plm.alm.ws.ALMServiceImplServiceLocator()).getALMServiceImpl();
      if (aLMServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)aLMServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)aLMServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (aLMServiceImpl != null)
      ((javax.xml.rpc.Stub)aLMServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.plm.alm.ws.ALMServiceImpl getALMServiceImpl() {
    if (aLMServiceImpl == null)
      _initALMServiceImplProxy();
    return aLMServiceImpl;
  }
  
  public java.lang.String createHWPart(java.lang.String project, java.lang.String title, java.lang.String description, java.lang.String attachmentFileName, java.lang.String attachmentFilePath, java.lang.String attachmentMimeType, boolean pkg) throws java.rmi.RemoteException{
    if (aLMServiceImpl == null)
      _initALMServiceImplProxy();
    return aLMServiceImpl.createHWPart(project, title, description, attachmentFileName, attachmentFilePath, attachmentMimeType, pkg);
  }
  
  public java.lang.String createDefect(java.lang.String HWPart, java.lang.String SWPart, java.lang.String defectTitle, java.lang.String defectDetails) throws java.rmi.RemoteException{
    if (aLMServiceImpl == null)
      _initALMServiceImplProxy();
    return aLMServiceImpl.createDefect(HWPart, SWPart, defectTitle, defectDetails);
  }
  
  
}