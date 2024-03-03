package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.RequestFormEntity;
import com.test.entity.Dto.RequestFormReqDto;
import com.test.entity.Dto.RequestFormResDto;
import com.test.repository.RequestFormRepository;
import com.test.service.RequestFormService;

@Service
public class RequestFormServiceImpl implements RequestFormService {
	
	@Autowired
	private RequestFormRepository requstFormRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String saveRequestForm(RequestFormReqDto requestFormReqDto) {
//		RequestFormEntity rfe = new RequestFormEntity();
//		rfe.setFirstName(requestFormReqDto.getFirstName());
//		rfe.setLastName(requestFormReqDto.getLastName());
//		rfe.setCompanyName(requestFormReqDto.getCompanyName());
//		rfe.setEmail(requestFormReqDto.getEmail());
//		rfe.setPrice(requestFormReqDto.getPrice());
//		rfe.setProjDesc(requestFormReqDto.getProjDesc());
//		rfe.setTimeLine(requestFormReqDto.getTimeLine());
		RequestFormEntity rfe = modelMapper.map(requestFormReqDto, RequestFormEntity.class);
		RequestFormEntity save = requstFormRepository.save(rfe);
		return "Form saved successfully: with id: "+save.getCustId();
	}

	@Override
	public RequestFormResDto getByFormId(Integer custId) {
		RequestFormResDto response = new RequestFormResDto();
		Optional<RequestFormEntity> findById = requstFormRepository.findById(custId);
		if(findById.isPresent()) {
			response = modelMapper.map(findById.get(), RequestFormResDto.class);
		}
		return response;
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
		Optional<RequestFormEntity> findById = requstFormRepository.findById(requestFormReqDto.getCustId());
		if(!findById.isPresent()) {
			return "Record not found.";
		}
		RequestFormEntity rfe = findById.get();
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
