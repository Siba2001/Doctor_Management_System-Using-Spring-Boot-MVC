package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.entity.DoctorEntity;
import com.nt.vo.DoctorVo;

public interface IDoctorMgmtService {
public String registerDoctor(DoctorVo vo);
public List<DoctorVo> showAllDoctro();
public DoctorVo showDoctorById(int id);
public String updateDoctor(DoctorVo vo);
public String removeDoctorById(int id);
public Page<DoctorEntity> getDoctorReportIdByPage(Pageable pageable);
}
