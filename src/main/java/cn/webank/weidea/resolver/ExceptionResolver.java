package cn.webank.weidea.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import cn.webank.weidea.dao.exception.BlockChainException;
import cn.webank.weidea.dao.exception.CheckException;
import cn.webank.weidea.model.Result;
import cn.webank.weidea.util.CodeUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 异常解析器
 * 
 * @author gmr
 *
 */
@Component
@ResponseBody
public class ExceptionResolver implements HandlerExceptionResolver {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception e) {
		ModelAndView modelAndView = new ModelAndView();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
		if (e instanceof CheckException) {
			CheckException validateException = (CheckException) e;
			// writeMsg(response, new Gson().toJson(validateException.getResult()));
			writeMsg(response, new Gson().toJson(new Result<String>(CodeUtil.UNKNOW_ERROR, null, "检查错误")));
		} else if (e instanceof BlockChainException) {
			writeMsg(response, new Gson().toJson(new Result<String>(CodeUtil.UNKNOW_ERROR, null, "区块链错误")));
			LOGGER.info("----区块链错误", e);
			e.printStackTrace();
		} else {
			writeMsg(response, new Gson().toJson(new Result<String>(CodeUtil.UNKNOW_ERROR, null, "未知错误")));
			LOGGER.info("----未知错误", e);
			e.printStackTrace();

		}
		return modelAndView;
	}

	private void writeMsg(HttpServletResponse response, String message) {
		try {
			response.getWriter().write(message);
		} catch (IOException e1) {
		}
	}

}
