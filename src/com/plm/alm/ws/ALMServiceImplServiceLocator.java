/**
 * ALMServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.plm.alm.ws;

public class ALMServiceImplServiceLocator extends org.apache.axis.client.Service implements com.plm.alm.ws.ALMServiceImplService {

    public ALMServiceImplServiceLocator() {
    }


    public ALMServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ALMServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ALMServiceImpl
    private java.lang.String ALMServiceImpl_address = "http://inbasdlp01742.techmahindra.com:8080/ALMService/services/ALMServiceImpl";

    public java.lang.String getALMServiceImplAddress() {
        return ALMServiceImpl_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ALMServiceImplWSDDServiceName = "ALMServiceImpl";

    public java.lang.String getALMServiceImplWSDDServiceName() {
        return ALMServiceImplWSDDServiceName;
    }

    public void setALMServiceImplWSDDServiceName(java.lang.String name) {
        ALMServiceImplWSDDServiceName = name;
    }

    public com.plm.alm.ws.ALMServiceImpl getALMServiceImpl() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ALMServiceImpl_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getALMServiceImpl(endpoint);
    }

    public com.plm.alm.ws.ALMServiceImpl getALMServiceImpl(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.plm.alm.ws.ALMServiceImplSoapBindingStub _stub = new com.plm.alm.ws.ALMServiceImplSoapBindingStub(portAddress, this);
            _stub.setPortName(getALMServiceImplWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setALMServiceImplEndpointAddress(java.lang.String address) {
        ALMServiceImpl_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.plm.alm.ws.ALMServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.plm.alm.ws.ALMServiceImplSoapBindingStub _stub = new com.plm.alm.ws.ALMServiceImplSoapBindingStub(new java.net.URL(ALMServiceImpl_address), this);
                _stub.setPortName(getALMServiceImplWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ALMServiceImpl".equals(inputPortName)) {
            return getALMServiceImpl();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.alm.plm.com", "ALMServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.alm.plm.com", "ALMServiceImpl"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ALMServiceImpl".equals(portName)) {
            setALMServiceImplEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
