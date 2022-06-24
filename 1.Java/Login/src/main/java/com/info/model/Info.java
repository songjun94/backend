package com.info.model;

public class Info {
	
	// 멤버 필드(멤버 변수)
	private Long info_number; // 할 일 번호
	private String name; // 이름
	private Long age; // 나이
	private String gender; // 성별
	private String address;
	private String phone;
	private String id;
	private Long password;
	private Boolean isCompleted; // 진행 여부

	// 생성자
	public Info(Long info_number, String name, Long age, String gender, String address, String phone, String id, Long password, boolean isCompleted) {
		this.info_number = info_number;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.id = id;
		this.password = password;
		this.isCompleted = false; // 기본값은 false
	}

	//+ 생성자 오버로딩
	public Info( String name, Long age, String gender, String address, String phone, String id, Long password) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.id = id;
		this.password = password;
	}
	//생성자 오버로딩
	public Info(Long info_number, String name, Long age, String gender, String address, String phone, String id, Long password, Boolean isCompleted) {
		super();
		this.info_number = info_number;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.id = id;
		this.password = password;
		this.isCompleted = isCompleted;
	}

	// Builder 적용
		public Info(Builder builder) {
			this.info_number = builder.info_number;
			this.name = builder.name;
			this.age = builder.age;
			this.gender = builder.gender;
			this.address = builder.address;
			this.phone = builder.phone;
			this.id = builder.id;
			this.password = builder.password;
	        this.isCompleted = builder.isCompleted;
		}

		// 정적인 클래스 Builder 생성
	    public static class Builder {
	    	private Long info_number; // 할 일 번호
	    	private String name; // 이름
	    	private Long age; // 나이
	    	private String gender; // 성별
	    	private String address;
	    	private String phone;
	    	private String id;
	    	private Long password;
	    	private Boolean isCompleted; // 진행 여부
	    	
	        // 필수적인 필드 : id
	        public Builder(Long info_number) {
	            this.info_number = info_number;
	        }
	    
	        public Builder name(String name) {
	            this.name = name;
	            return this;
	        }
	    
	        public Builder age(Long age) {
	            this.age = age;
	            return this;
	        }
	    
	        public Builder gender(String gender) {
	            this.gender = gender;
	            return this;
	        }
	        
	        public Builder address(String address) {
	            this.address = address;
	            return this;
	        }
	        
	        public Builder phone(String phone) {
	            this.phone = phone;
	            return this;
	        }
	        
	        public Builder id(String id) {
	            this.id = id;
	            return this;
	        }
	        
	        public Builder password(Long password) {
	            this.password = password;
	            return this;
	        }
	        
	        public Builder isCompleted(Boolean isCompleted) {
	            this.isCompleted = isCompleted;
	            return this;
	        }
	    
	        public Info build() {
	            return new Info(this);
	        }

	    }
	
	
	// getter, setter 정의
	public Long getInfo_number() {
		return info_number;
	}


	public void setInfo_number(Long info_number) {
		this.info_number = info_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String Id) {
		this.id = id;
	}
	
	public Long getPassword() {
		return password;
	}

	public void setPassword(Long Password) {
		this.password = password;
	}
	
	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public String toString() {
		return "Info [info_number =" + info_number + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", phone=" + phone + ", id=" + id + ", password = " + password + ", isCompleted=" + isCompleted + "]";
	}
	
}
