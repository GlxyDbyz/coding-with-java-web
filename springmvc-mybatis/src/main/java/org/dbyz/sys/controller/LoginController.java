package org.dbyz.sys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.dbyz.common.base.BaseController;
import org.dbyz.common.util.AjaxUtil;
import org.dbyz.sys.model.SysUser;
import org.dbyz.sys.service.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 *
 * @ClassName: LoginController
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
 * @version: V1.0
 */
@Controller
@RequestMapping("/sys/login")
public class LoginController extends BaseController {

	@Resource
	ILoginService loginService;

	@RequestMapping//("/")
	public String index() {
		return "sys/login_index";
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public void check(HttpServletResponse resp,@RequestParam(required=false) SysUser user) {
		AjaxUtil.Fail("用户名无效").send(resp);
	}
}
