package sse.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("Student")
public class Student extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1793927958183962063L;
	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="TEACHER_ID")
	private Teacher teacher;
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	

}
