package com.medic.MainApp.Response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

//@Component
public class MedicResponse {


    private HttpStatus httpStatus;
    private Object data;
    private String response_message;
    private Date date_modified;

    public MedicResponse(){

    }

    public MedicResponse(HttpStatus httpStatus){
        this.httpStatus = httpStatus;
    }

    public MedicResponse(HttpStatus httpStatus, Object data, String response_message) {
        this.httpStatus = httpStatus;
        this.data = data;
        this.response_message = response_message;
        this.date_modified = new Date();
    }

    public Object setObject(Object object){
        return object;
    }


    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getResponse_message() {
        return response_message;
    }

    public void setResponse_message(String response_message) {
        this.response_message = response_message;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }

    @Override
    public String toString(){
        return "res " + httpStatus + data + response_message;
    }

}
