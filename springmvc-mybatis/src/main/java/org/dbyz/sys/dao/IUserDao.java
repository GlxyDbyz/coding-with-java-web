package org.dbyz.sys.dao;

import org.dbyz.sys.model.SysUser;

/**
 * @ClassName: ILoginDao
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
 * @version: V1.0
 */
public interface IUserDao {

	SysUser check(SysUser user);

	int deleteByPrimaryKey(Long id);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	SysUser selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);
}
