package cn.itcast.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryVo {
	
	private User user;
	
	private List<User> users;
	
	private Map<String,Object> maps = new HashMap<String, Object>();
	
	
	
	
		

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
