package com.rvmagrini.springdatajpa.guardian;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// If we only want to use the properties of this class for the Student table,
// this class should not be an Entity.
// Embeddable & Embedded allows us to to so:

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
	@AttributeOverride(
			name = "name",
			column = @Column(name = "guardian_name")
			),
	@AttributeOverride(
			name = "email",
			column = @Column(name = "guardian_email")
			),
	@AttributeOverride(
			name = "mobilePhone",
			column = @Column(name = "guardian_mobile")
			)
})
public class Guardian {
	
	private String name;
	private String email;
	private String mobilePhone;

}
