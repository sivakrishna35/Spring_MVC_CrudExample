package com.test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.test.config.UserIdNotFoundException;
import com.test.entity.RequestFormEntity;
import com.test.entity.Dto.RequestFormReqDto;
import com.test.entity.Dto.RequestFormResDto;
import com.test.repository.RequestFormRepository;
import com.test.service.RequestFormService;
import com.test.util.CommonUtil;
import com.test.util.GenericResponse;

@Service
public class RequestFormServiceImpl implements RequestFormService {
	
	@Autowired
	private RequestFormRepository requstFormRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private Map<String, String> errorMessage;

	@Override
	public GenericResponse<String> saveRequestForm(RequestFormReqDto requestFormReqDto) {
		errorMessage= new HashMap<>();
		RequestFormEntity rfe = modelMapper.map(requestFormReqDto, RequestFormEntity.class);
		RequestFormEntity save = requstFormRepository.save(rfe);
		return  CommonUtil.getHttpResponse(false, "Form saved successfully: with id: "+save.getCustId(), errorMessage, HttpStatus.CREATED) ;
	}

	@Override
	public GenericResponse<RequestFormResDto> getByFormId(Integer custId) {
		RequestFormResDto response = new RequestFormResDto();
		Optional<RequestFormEntity> findById = requstFormRepository.findById(custId);
		if(!findById.isPresent()) {
			throw new UserIdNotFoundException("User Details not found by Id.");
		}
		response = modelMapper.map(findById.get(), RequestFormResDto.class);
		return CommonUtil.getHttpResponse(false, response, errorMessage, HttpStatus.CREATED);
	}

	@Override
	public List<RequestFormResDto> getAllRecords() {
		List<RequestFormResDto> responseList = new ArrayList<>();
		Iterable<RequestFormEntity> findAll = requstFormRepository.findAll();
		findAll.forEach(rec-> {
			responseList.add(modelMapper.map(rec,RequestFormResDto.class));
		});
		return responseList;
	}

	@Override
	public List<RequestFormResDto> getFromDataByName(String fname, String lname) {
		List<RequestFormResDto> responseList = new ArrayList<>();
		List<RequestFormEntity> findByFirstName = requstFormRepository.findByFirstNameAndLastName(fname,lname);
		findByFirstName.forEach(rec-> {
			responseList.add(modelMapper.map(rec,RequestFormResDto.class));
		});
		return responseList;
	}

	@Override
	public String updateRequestForm(RequestFormReqDto requestFormReqDto) {
		RequestFormEntity rfe = requstFormRepository.findById(requestFormReqDto.getCustId()).orElseThrow(()->new UserIdNotFoundException("Record not found."));
		
		rfe.setFirstName(requestFormReqDto.getFirstName());
		rfe.setLastName(requestFormReqDto.getLastName());
		rfe.setCompanyName(requestFormReqDto.getCompanyName());
		rfe.setEmail(requestFormReqDto.getEmail());
		rfe.setPrice(requestFormReqDto.getPrice());
		rfe.setProjDesc(requestFormReqDto.getProjDesc());
		rfe.setTimeLine(requestFormReqDto.getTimeLine());
		requstFormRepository.save(rfe);
		return "Successfully update.";
	}

	@Override
	public String deleteRequestForm(Integer custId) {
		Optional<RequestFormEntity> findById = requstFormRepository.findById(custId);
		if(!findById.isPresent()) {
			return "Record not found.";
		}
		requstFormRepository.deleteById(custId);
		return "Successfully deleted";
	}
	
	

}
