package vn.hcmut.ap.pim.web;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.hcmut.ap.pim.response.ResponseCode;
import vn.hcmut.ap.pim.response.ResponseMessage;

@ControllerAdvice
public class GlobalExceptionController {
    static final Logger logger = Logger.getLogger(GlobalExceptionController.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> handleAllException(Exception e) {
        logger.error("Unexpected technical error: " + e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseMessage(ResponseCode.INTERNAL_SERVER_ERROR, e.getCause().getMessage()));
    }
}