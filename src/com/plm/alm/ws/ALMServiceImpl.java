/**
 * ALMServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.plm.alm.ws;

public interface ALMServiceImpl extends java.rmi.Remote {
    public java.lang.String createHWPart(java.lang.String project, java.lang.String title, java.lang.String description, java.lang.String attachmentFileName, java.lang.String attachmentFilePath, java.lang.String attachmentMimeType, boolean pkg) throws java.rmi.RemoteException;
    public java.lang.String createDefect(java.lang.String HWPart, java.lang.String SWPart, java.lang.String defectTitle, java.lang.String defectDetails) throws java.rmi.RemoteException;
}
