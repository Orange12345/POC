package com.changepond.executors.db.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.changepond.executors.db.message.ResponseMessage;

@ControllerAdvice
public class ExecutorExceptionAdvice extends ResponseEntityExceptionHandler {

  @ExceptionHandler(IOException.class)
  public ResponseEntity<ResponseMessage> handleScriptExecutionException(IOException exc) {
    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Error during script execution!"));
  }
}
