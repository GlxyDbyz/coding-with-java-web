package org.dbyz.common.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.dbyz.common.util.ConstantUtil.SYS_SESSION_USER;
import org.dbyz.sys.model.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @ClassName: OperationInterceptor
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
 * @version: V1.0
 */
public class OperationInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory
			.getLogger(OperationInterceptor.class);

	/**
	 * 重写 preHandle()方法，在业务处理器处理请求之前对该请求进行拦截处理
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.debug("=========pre request==============");

		String url = request.getRequestURI();

		if (isStaticWebResourse(url)) {
			// 静态资源不拦截
			return true;

		} else if (url.indexOf("/sys/login/") > -1) {
			// 管理后台登录不拦截
			return true;

		} else if (url.indexOf("/sys") > -1) {
			// 管理后台
			HttpSession sysSession = request.getSession(false);
			if (sysSession != null
					&& (SysUser) sysSession.getAttribute(SYS_SESSION_USER) == null) {
				// 管理后台没有登录
				response.sendRedirect(request.getContextPath() + "/sys/login/");
				return false;
				
			} else {
				// 管理后台已经登录
				return true;
				
			}
		}
		
		//前台
		
		return true;
	}

	/**
	 * 重写 afterCompletion()方法，在业务处理器处理请求后处理数据(日志)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logUerOperation(request, response, ex);

		logger.debug("test debug logger ");
		logger.info("test info logger ");
		logger.warn("test warn logger ");
		logger.error("test error logger ");

		logger.debug("========= after request ==============");
	}

	/**
	 * 用户操作记载日志
	 */
	private void logUerOperation(HttpServletRequest request,
			HttpServletResponse response, Exception ex) {
		String url = request.getRequestURI();
		HttpSession session = request.getSession(false);
		String platformUserName = "";
		if (session != null) {
			platformUserName = (String) session.getAttribute("openId");
		}

		if (url.indexOf("/images") == -1 && url.indexOf("/css") == -1
				&& url.indexOf("/js") == -1 && url.indexOf("static") == -1
				&& url.indexOf("favicon.ico") == -1
				&& url.indexOf("error") == -1) {
			if (platformUserName != null && !platformUserName.trim().equals("")) {
				// LogUtil.writeVisitLog(request);
			}
		}// 日志记录方法
		logger.debug("=========you can write log here ==============");
	}

	/**
	 * 是否为静态WEB资源
	 * 
	 * @Title: isWebStaticResourse
	 * @param url 访问路径
	 * @return: boolean
	 * @since V1.0
	 */
	private boolean isStaticWebResourse(String url) {
		return (url.indexOf("/images") > -1 || url.indexOf("/css") > -1
				|| url.indexOf("/fonts") > -1 || url.indexOf("/js") > -1 || url
				.indexOf("/error") > -1);
	}

}
