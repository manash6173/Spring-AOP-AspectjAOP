package com.manash.manager;

import org.springframework.beans.BeanUtils;

import com.manash.bo.UserInfoBO;
import com.manash.dao.AuthenticateDAO;
import com.manash.dto.UserInfoDTO;

public class BankAuthenticateManager {
	private AuthenticateDAO authdao;
	//create Thred Local object
	ThreadLocal<UserInfoDTO> threadlocal=new ThreadLocal<UserInfoDTO>();

	public BankAuthenticateManager(AuthenticateDAO authdao) {
		this.authdao = authdao;
	}
	public void signIN(String uname,String pwd) {
		UserInfoDTO dto=null;
		//create objecty for DTO
		dto=new UserInfoDTO();
		//set properties into dto
		dto.setUname(uname);
		dto.setPwd(pwd);
		//set object into threadLocal
		threadlocal.set(dto);
	}
	public void signOut() {
		//remove object from threadlocal
		threadlocal.remove();
	}
	public boolean validateUser() {
		UserInfoBO bo=null;
		UserInfoDTO dto=null;
		boolean flag=false;
		int count=0;
		//create bo class object
		bo=new UserInfoBO();
		//get DTO object from threadLocal
		dto=threadlocal.get();
		//copy properties from dto to bo
		BeanUtils.copyProperties(dto,bo);
		//use authdao
		count=authdao.verifyUser(bo);
		if(count==0)
			return flag;
		else
			return flag=true;
	}
	

}
