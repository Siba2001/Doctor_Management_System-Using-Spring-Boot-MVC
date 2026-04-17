package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class DoctorEntity {
	@Id
	@SequenceGenerator(name="gen1",sequenceName="DID_SEQ1",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer did;
	@NonNull
	@Column(length=20)
	private String name;
	@NonNull
	@Column(length=20)
	private String addr;
	@NonNull
	@Column(length=20)
	private Double fees;
	
	//Meta Data
	@Version
	private Integer updatecount;
	@CreationTimestamp
	@Column(length=30,insertable=true,updatable=false)
	private LocalDateTime registeredOn;
	@UpdateTimestamp
	@Column(insertable=false,updatable=true)
	private LocalDateTime lastUpdateOn;
	@Column(length=30,insertable=true,updatable=false)
	private String createdBy;
	@Column(length=30,insertable=false,updatable=true)
	private String updateBy;
	@Column(length=30)
	private String active_SW="active";
	
	
	

}
