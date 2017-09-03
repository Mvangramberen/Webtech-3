/**
 * DataAccessService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package BLL;

public interface DataAccessService extends javax.xml.rpc.Service {
    public java.lang.String getDataAccessAddress();

    public BLL.DataAccess getDataAccess() throws javax.xml.rpc.ServiceException;

    public BLL.DataAccess getDataAccess(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
