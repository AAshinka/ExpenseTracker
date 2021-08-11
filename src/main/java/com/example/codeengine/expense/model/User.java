package com.example.codeengine.expense.model;

import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="user")
public class User {

	@Id
	private Long id;
	
	private String  name;

//	@JsonIgnore
	@OneToMany
	private Set<Income> incomes;

//	public Set<Income> getIncome() {
//		return incomes;
//	}

}

