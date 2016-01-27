package org.dbyz.sys.service;

import java.util.Map;

import org.dbyz.sys.model.SysUser;
/**
 * @ClassName: ILoginService
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a> 
 * @version: V1.0
 */
public interface ILoginService {

	SysUser check(SysUser user);

}
