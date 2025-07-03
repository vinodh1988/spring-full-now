package com.rest.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "departments")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Department {
@Id
private int dno;
@Column(name = "dname")	
private String dname;
@OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
@ToString.Exclude
@EqualsAndHashCode.Exclude
Set<Employee> employees;
}
