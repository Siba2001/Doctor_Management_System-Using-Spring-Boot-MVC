package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.DoctorEntity;
import com.nt.service.IDoctorMgmtService;
import com.nt.vo.DoctorVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class HospitalOperationController {
@Autowired	
	private IDoctorMgmtService doctorService;
    @GetMapping("/")
    public String showHomePage() {
        return "welcome";
    }

    @GetMapping("/report")
    public String showReport(Map<String,Object> map) {
    	System.out.println("HospitalOperationController.showReport()");
    	List<DoctorVo> lisvo=doctorService.showAllDoctro();
    	map.put("listvo", lisvo);
        return "show_report";
    }
 
    // Show form page
    @GetMapping("/add")
    public String showAddDoctorFormPage(@ModelAttribute("dvo") DoctorVo vo) {
        return "register_doctor";
    }
    
    @PostMapping("/add")
    public String registerDoctor(HttpSession ses,@ModelAttribute("dvo") DoctorVo vo) {
    	System.out.println("HospitalOperationController.registerDoctor()");
    	//Use Service
    	String msg = doctorService.registerDoctor(vo);
    	//keep the result model Attribute 
    	ses.setAttribute("resultMsg",msg);

    	return "redirect:report";
    }
    	@GetMapping("/edit")
    	public String showEditdoctorFormPage(@ModelAttribute("dvo") DoctorVo vo,@RequestParam Integer id) {
    		DoctorVo vo1 = doctorService.showDoctorById(id);
    		BeanUtils.copyProperties(vo1, vo);
    		return "edit_doctor";
    	
      } 
    	
    	@PostMapping("/edit")
    	public String updateDoctorDetails(@ModelAttribute("dvo")DoctorVo vo,RedirectAttributes attrs) {
    		String msg = doctorService.updateDoctor(vo);
    		attrs.addFlashAttribute("resultMsg",msg);
    		return "redirect:report";
    	}
    	
    	@GetMapping("/delete")
    	public String deleteDoctor(@RequestParam Integer id,RedirectAttributes attrs){
    		String msg = doctorService.removeDoctorById(id);
    		attrs.addFlashAttribute("resultMsg", msg);
    		return "redirect:report";
    	}
    	
    	@PostMapping("/report")
    	public String showDoctorReport(
    	        @PageableDefault(page = 0, size = 3, sort = "did", direction = Sort.Direction.ASC) Pageable pageable,
    	        Map<String, Object> map) {

    	    System.out.println("HospitalOperationController.showDoctorReport()");

    	    Page<DoctorEntity> page = doctorService.getDoctorReportIdByPage(pageable);

    	    map.put("doctorData", page);              // for pagination
    	    map.put("listvo", page.getContent());     // for table data

    	    return "show_report";
    	}
}