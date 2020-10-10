package com.bdqn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bdqn.constants.EmpConstants;

public class PathInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		String uri = arg0.getRequestURI();
		HttpSession session = arg0.getSession();
		String isChargeStr = (String) session.getAttribute(EmpConstants.CURRENT_USER_ISCHARGE);
		if(isChargeStr!=null){
			String path = arg0.getContextPath();
			int isCharge =Integer.parseInt(isChargeStr);
			if(isCharge==0){
				if(uri.contains("dept")){
					arg0.getRequestDispatcher("/jsp/index.jsp").forward(arg0, arg1);
					return false;
				}
			}else if(isCharge==1){
				if(uri.contains("dept")||uri.contains("emp")){
					arg0.getRequestDispatcher("/jsp/index.jsp").forward(arg0, arg1);
					return false;
				}
			}
			return true;
		}
		
		return false;
	}

}
