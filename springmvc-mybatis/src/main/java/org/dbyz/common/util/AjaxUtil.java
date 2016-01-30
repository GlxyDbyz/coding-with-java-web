package org.dbyz.common.util;

import javax.servlet.http.HttpServletResponse;

/**
 * 定义全局ajax返回标准(数据格式:JSON)
 *
 * @ClassName: AjaxUtil
 * @author: 作者 E-mail <a href="mailto:glxydbyz@gmail.com">Dbyz</a>
 * @version: V1.0
 */
public final class AjaxUtil {
	/**
	 * 请求是否成功返回数据
	 */
	private boolean success;
	/**
	 * 附带消息
	 */
	private String msg;
	/**
	 * 返回的数据对象
	 */
	private Object data;
	/**
	 * 报错对象
	 */
	private Throwable throwable;

	private AjaxUtil(boolean success, String msg, Object data,
			Throwable throwable) {
		super();
		this.success = success;
		this.msg = msg;
		this.data = data;
		this.throwable = throwable;
	}

	/**
	 * 成功(只有数据)
	 * 
	 * @Title: Success
	 * @param @param data
	 * @param @return
	 * @return: AjaxUtil
	 * @since V1.0
	 */
	public static AjaxUtil Success(Object data) {
		return new AjaxUtil(true, null, data, null);
	}

	/**
	 * 成功(包含数据和附带消息)
	 * 
	 * @Title: Success
	 * @param @param data
	 * @param @param msg
	 * @param @return
	 * @return: AjaxUtil
	 * @since V1.0
	 */
	public static AjaxUtil Success(Object data, String msg) {
		return new AjaxUtil(true, msg, data, null);
	}

	/**
	 * 失败(附带消息)
	 * 
	 * @Title: Fail
	 * @param @param msg
	 * @param @return
	 * @return: AjaxUtil
	 * @since V1.0
	 */
	public static AjaxUtil Fail(String msg) {
		return new AjaxUtil(false, msg, null, null);
	}

	/**
	 * 失败(附带消息和异常)
	 * 
	 * @Title: Fail
	 * @param @param msg
	 * @param @param throwable
	 * @param @return
	 * @return: AjaxUtil
	 * @since V1.0
	 */
	public static AjaxUtil Fail(String msg, Throwable throwable) {
		return new AjaxUtil(false, msg, null, throwable);
	}

	/**
	 * response返回JSON数据
	 * 
	 * @Title: send
	 * @param @param response
	 * @return: void
	 * @since V1.0
	 */
	public void send(HttpServletResponse response) {
		// HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.setHeader("Cache-Control", "no-cache");
			response.setContentType("text/json;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.flushBuffer();
			response.getOutputStream().write(this.toJson().getBytes("UTF-8"));
			;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * JSON格式化
	 * 
	 * @Title: toJson
	 * @param @return
	 * @return: String
	 * @since V1.0
	 */
	public String toJson() {
		return JsonUtil.objectToJson(this);
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public static void main(String[] args) {
		System.out.println(Success(new Integer(1)).toJson());
		System.out.println(Success(1, "删除成功").toJson());

		System.out.println(Fail("数据库异常").toJson());
		System.out.println(Fail("数据库异常", new RuntimeException("日期格式错误")).toJson());
		
	}
}
