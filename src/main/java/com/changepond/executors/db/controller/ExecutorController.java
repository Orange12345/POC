package com.changepond.executors.db.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.changepond.executors.db.message.ResponseFile;
import com.changepond.executors.db.service.ExecutorBussinessService;

@Controller
@CrossOrigin("http://localhost:8080")
public class ExecutorController {

  @Autowired
  private ExecutorBussinessService executorBussinessService;
  
  @GetMapping("/jobGroup/{jobGroubId}")
  public ResponseEntity<ResponseFile> getFile(@PathVariable int jobGroubId) throws IllegalStateException, IOException {
     executorBussinessService.executeComands(jobGroubId);

     String executorUri = ServletUriComponentsBuilder
             .fromCurrentContextPath()
             .path("/jobGroup/")
             .path(String.valueOf(jobGroubId))
             .toUriString();
     
    ResponseFile res= new ResponseFile(
             jobGroubId,
             executorUri,
             "success");
       
    return ResponseEntity.ok()
        .body(res);
  }
}
