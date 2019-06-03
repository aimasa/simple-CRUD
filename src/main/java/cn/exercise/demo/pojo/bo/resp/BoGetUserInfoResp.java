package cn.exercise.demo.pojo.bo.resp;

/**
 * 接收dao层传来的数据，并把在service层处理好的数据传去controller层
 * @author zhy
 *
 */
public class BoGetUserInfoResp {
	private Integer id;
	private String userName;
	private String sex;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
