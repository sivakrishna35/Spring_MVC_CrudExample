package com.test.service;

import java.util.List;

import com.test.entity.Dto.RequestFormReqDto;
import com.test.entity.Dto.RequestFormResDto;
import com.test.util.GenericResponse;

public interface RequestFormService {

	GenericResponse<String> saveRequestForm(RequestFormReqDto requestFormReqDto);

	GenericResponse<RequestFormResDto> getByFormId(Integer custId);

	List<RequestFormResDto> getAllRecords();

	List<RequestFormResDto>  getFromDataByName(String fname, String lname);

	String updateRequestForm(RequestFormReqDto requestFormReqDto);

	String deleteRequestForm(Integer custId);

}
