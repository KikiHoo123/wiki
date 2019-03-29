package com.bsc.common.persistence;
//package com.qdu.music.common.persistence;
//
//import java.io.IOException;
//import java.util.logging.Logger;
//
//import javax.servlet.http.HttpServletResponse;
//
//
//
//
///**
// * 控制器支持类
// * @author lilinzhen
// * @version 2017年12月13日
// */
//public abstract class BaseForAppController {
//
//	/**
//	 * 日志对象
//	 */
//	protected Logger logger = LoggerFactory.getLogger(getClass());
//
//	/**
//	 * 客户端返回JSON字符串
//	 * @param response
//	 * @param object
//	 * @return
//	 */
//	protected String renderString(HttpServletResponse response, Object object) {
//		return renderString(response, JsonMapper.toJsonString(object));
//	}
//
//	/**
//	 * 客户端返回字符串
//	 * @param response
//	 * @param string
//	 * @return
//	 */
//	protected String renderString(HttpServletResponse response, String string) {
//		try {
//			response.reset();
//	        response.setContentType("application/json");
//	        response.setCharacterEncoding("utf-8");
//			response.getWriter().print(string);
//			return null;
//		} catch (IOException e) {
//			return null;
//		}
//	}
//
//
//	/**
//	 * 接口错误
//	 * @param string
//	 * @return
//	 */
//	protected void setAjaxJsonError0(AjaxJson j) {
//		j.setSuccess(false);
//		j.setErrorCode("0");
//		j.setMsg("接口异常!");
//	}
//
//	/**
//	 * 缺少参数
//	 * @param string
//	 * @return
//	 */
//	protected void setAjaxJsonError1(AjaxJson j) {
//		j.setSuccess(false);
//		j.setErrorCode("1");
//		j.setMsg("缺少参数");
//	}
//
//}