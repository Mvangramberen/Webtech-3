package webservice;

public class UpperProxy implements webservice.Upper {
  private String _endpoint = null;
  private webservice.Upper upper = null;
  
  public UpperProxy() {
    _initUpperProxy();
  }
  
  public UpperProxy(String endpoint) {
    _endpoint = endpoint;
    _initUpperProxy();
  }
  
  private void _initUpperProxy() {
    try {
      upper = (new webservice.UpperServiceLocator()).getUpper();
      if (upper != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)upper)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)upper)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (upper != null)
      ((javax.xml.rpc.Stub)upper)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservice.Upper getUpper() {
    if (upper == null)
      _initUpperProxy();
    return upper;
  }
  
  public java.lang.String toUpper(java.lang.String lower) throws java.rmi.RemoteException{
    if (upper == null)
      _initUpperProxy();
    return upper.toUpper(lower);
  }
  
  
}