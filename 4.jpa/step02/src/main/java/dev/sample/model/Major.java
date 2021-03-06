package dev.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Major {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Major_ID")
	private Long id; // 컬럼명 MAJOR_ID

	@Column(name="Major_NAME")
	private String majorName; // 컬럼명 MAJOR_NAME
	
	public Major () {}
	
	public Major(String majorName) {
		super();
		this.majorName = majorName;
	}

	public Major(Long id, String majorName) {
		super();
		this.id = id;
		this.majorName = majorName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Override
	public String toString() {
		return "Major [id=" + id + ", majorName=" + majorName + "]";
	}
	
	
	
}
