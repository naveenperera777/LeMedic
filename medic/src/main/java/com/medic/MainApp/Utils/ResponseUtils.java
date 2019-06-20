package com.medic.MainApp.Utils;

import com.medic.MainApp.Response.MedicResponse;
import com.medic.MainApp.Response.ResponseMessages;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {

    @Deprecated
    public ResponseEntity successSaving(){
        return ResponseEntity.ok().body(new MedicResponse(HttpStatus.OK));
    }

    //User Response Entities
    public ResponseEntity successRetrieval(Object object){
        return ResponseEntity.ok().body(new MedicResponse(HttpStatus.OK , object , ResponseMessages.SUCCESS_DATA_RETRIEVAL));
    }

    public ResponseEntity FailedRetrieval(Object object){
        MedicResponse notFoundResponse = new MedicResponse(HttpStatus.NOT_FOUND , object , ResponseMessages.NO_USERS_FOUND);
        return new ResponseEntity (notFoundResponse, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity successDelete(){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity userNotFound(String id){
        MedicResponse userNotFound = new MedicResponse(HttpStatus.NOT_FOUND , id , ResponseMessages.NO_USER_FOUND );
        return new ResponseEntity(userNotFound , HttpStatus.NOT_FOUND);
    }

    //Patient Response Entities
//    public ResponseEntity


}
