package org.dbyz.sys.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.dbyz.sys.dao.IUserDao;
import org.dbyz.sys.model.SysUser;
import org.dbyz.sys.service.ILoginService;
import org.springframework.stereotype.Service;
/**
 * 
 * @ClassName: LoginService
 * @Description: 
 * @author  作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a> 
 * @version 创建时间：2014年12月11日下午5:39:35
 */
@Service(value="loginService")
public class LoginService implements ILoginService{

	@Resource
	IUserDao userDao;
	
	public SysUser check(SysUser user) {
		return userDao.check(user);
	}

}
