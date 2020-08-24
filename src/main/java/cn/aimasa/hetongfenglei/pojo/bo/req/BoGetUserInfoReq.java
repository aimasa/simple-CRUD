package cn.aimasa.hetongfenglei.pojo.bo.req;

/**
 * 接收从controller层传到service层的数据，经过一定处理后传去dao层
 * @author Mloong
 *
 */

public class BoGetUserInfoReq {
    private Integer id;
    private String  userName;
    private String  sex;
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
