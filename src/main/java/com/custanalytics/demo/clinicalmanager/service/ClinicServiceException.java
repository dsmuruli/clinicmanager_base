package com.custanalytics.demo.clinicalmanager.service;

/**
 * Created by were on 8/10/2016.
 */
public class ClinicServiceException extends Exception {
    int exceptionCode;
    public ClinicServiceException(String message, int exceptionCode){
        super(message);
        this.exceptionCode=exceptionCode;
    }
}