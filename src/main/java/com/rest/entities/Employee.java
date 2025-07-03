package com.rest.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//Child
@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Employee {
	@Id
	private int eno;
	@Column
	private String ename;
	@Column
	private String role;
	@ManyToOne
	@JoinColumn(name = "dno")
	@JsonIgnore
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	Department department;
}
