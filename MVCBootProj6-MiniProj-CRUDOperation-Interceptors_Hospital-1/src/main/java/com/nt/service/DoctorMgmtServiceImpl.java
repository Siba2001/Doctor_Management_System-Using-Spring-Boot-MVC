package com.nt.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nt.entity.DoctorEntity;
import com.nt.error.DoctorNotFoundException;
import com.nt.repository.IDoctorRepository;
import com.nt.repository.IDoctorRepositoryP;
import com.nt.vo.DoctorVo;
@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
@Autowired
	private IDoctorRepository doctorRepo;
@Autowired
private IDoctorRepositoryP doctorRepoP;
	@Override
	public String registerDoctor(DoctorVo vo) {
		//Convert DoctorVo to Doctor Entity
		DoctorEntity entity = new DoctorEntity();
		BeanUtils.copyProperties(vo, entity);
		entity.setCreatedBy(System.getProperty("user.name"));
		//Register Doctor
		int idVal  =doctorRepo.save(entity).getDid();
		return "Doctor object  is saved with the id Value"+idVal;
	}
	@Override
	public List<DoctorVo> showAllDoctro() {
		List<DoctorEntity> listEntites = doctorRepo.findAll();
		//Convert ListEntites to ListVo
		List<DoctorVo> listvo = new ArrayList<DoctorVo>();
		listEntites.forEach(entity->{
			DoctorVo vo = new DoctorVo();
			BeanUtils.copyProperties(entity, vo);
			//Calculate final fees
			if(vo.getFees()<500.0)
				vo.setDiscount(10.0);
			
			else
				vo.setDiscount(20.0);
			vo.setNetfees(vo.getFees()-(vo.getFees()*vo.getDiscount()/100.0f));
			listvo.add(vo);
		});
		return listvo;
	}
	@Override
	public DoctorVo showDoctorById(int id) {
		DoctorEntity entity = doctorRepo.findById(id).orElseThrow(()->new DoctorNotFoundException("Invalid ID"));
		DoctorVo vo = new DoctorVo();
		// convert Entity object to vo object
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}
	@Override
	public String updateDoctor(DoctorVo vo) {
		DoctorEntity entity = doctorRepo.findById(vo.getDid()).orElseThrow(()->new DoctorNotFoundException("Invalid ID"));

		BeanUtils.copyProperties(vo, entity);
		//update the Object
		doctorRepo.save(entity);
		return vo.getDid()+"Doctor Details are Update";
	}
	@Override
	public String removeDoctorById(int id) {
		DoctorEntity entity = doctorRepo.findById(id).orElseThrow(()->new DoctorNotFoundException("Invalid ID"));
		//delete the object
		doctorRepo.deleteById(id);
		return id +"Doctor Details are deleted";
	}
	@Override
	public Page<DoctorEntity> getDoctorReportIdByPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return doctorRepo.findAll(pageable);
	}
	
}
