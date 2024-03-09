package com.test.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Dto.RequestFormReqDto;
import com.test.entity.Dto.RequestFormResDto;
import com.test.service.RequestFormService;
import com.test.util.GenericResponse;

@RestController
@RequestMapping("/request")
public class RequestFormController {
	
	@Autowired
	private RequestFormService requestFormService;
	
	@PostMapping("/save")
	public ResponseEntity<GenericResponse<String>> saveRequestForm(@RequestBody RequestFormReqDto requestFormReqDto){
		GenericResponse<String> response = requestFormService.saveRequestForm(requestFormReqDto);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/get-by-id/{custId}")
	public ResponseEntity<GenericResponse<RequestFormResDto>> getByFormId(@PathVariable("custId") Integer custId){
		return new ResponseEntity<>(requestFormService.getByFormId(custId),HttpStatus.OK);
	}
	
	@GetMapping("/get-by-id")
	public ResponseEntity<GenericResponse<RequestFormResDto>> getByFormIdUsingQueryParam(@PathParam("custId") Integer custId){
		return new ResponseEntity<>(requestFormService.getByFormId(custId),HttpStatus.OK);
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<List<RequestFormResDto>> getAllRecords(){
		return new ResponseEntity<>(requestFormService.getAllRecords(),HttpStatus.OK);
	}
	
	
	@GetMapping("/find-by-name/{fname}/{lname}")
	public ResponseEntity<List<RequestFormResDto>> getFromDataByName(@PathVariable("fname") String fname, @PathVariable("lname") String lname){
		return new ResponseEntity<>(requestFormService.getFromDataByName(fname, lname),HttpStatus.OK);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateRequestForm(@RequestBody RequestFormReqDto requestFormReqDto){
		return new ResponseEntity<>(requestFormService.updateRequestForm(requestFormReqDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-by-id/{custId}")
	public ResponseEntity<String> deleteRequestForm(@PathVariable("custId") Integer custId){
		return new ResponseEntity<>(requestFormService.deleteRequestForm(custId), HttpStatus.OK);
	}
	
	

}
