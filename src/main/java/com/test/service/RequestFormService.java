package com.test.service;

import java.util.List;

import com.test.entity.Dto.RequestFormReqDto;
import com.test.entity.Dto.RequestFormResDto;

public interface RequestFormService {

	String saveRequestForm(RequestFormReqDto requestFormReqDto);

	RequestFormResDto getByFormId(Integer custId);

	List<RequestFormResDto> getAllRecords();

	List<RequestFormResDto>  getFromDataByName(String fname, String lname);

	String updateRequestForm(RequestFormReqDto requestFormReqDto);

	String deleteRequestForm(Integer custId);

}
