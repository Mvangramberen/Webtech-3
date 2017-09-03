package BLL;

public class DataAccessProxy implements BLL.DataAccess {
  private String _endpoint = null;
  private BLL.DataAccess dataAccess = null;
  
  public DataAccessProxy() {
    _initDataAccessProxy();
  }
  
  public DataAccessProxy(String endpoint) {
    _endpoint = endpoint;
    _initDataAccessProxy();
  }
  
  private void _initDataAccessProxy() {
    try {
      dataAccess = (new BLL.DataAccessServiceLocator()).getDataAccess();
      if (dataAccess != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dataAccess)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dataAccess)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dataAccess != null)
      ((javax.xml.rpc.Stub)dataAccess)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public BLL.DataAccess getDataAccess() {
    if (dataAccess == null)
      _initDataAccessProxy();
    return dataAccess;
  }
  
  public java.lang.String[] getAllStudents() throws java.rmi.RemoteException{
    if (dataAccess == null)
      _initDataAccessProxy();
    return dataAccess.getAllStudents();
  }
  
  
}