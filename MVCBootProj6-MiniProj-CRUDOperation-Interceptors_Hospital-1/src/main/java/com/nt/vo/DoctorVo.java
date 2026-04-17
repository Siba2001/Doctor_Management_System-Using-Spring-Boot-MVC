package com.nt.vo;
	import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@RequiredArgsConstructor
	public class DoctorVo {
		private Integer did;
		@NonNull
		@Column(length=20)
		private String name;
		@NonNull
		@Column(length=20)
		private String addr="Hyd";
		@NonNull
		@Column(length=20)
		private Double fees;
		private Double discount;
		private Double netfees;
		
		

	}


