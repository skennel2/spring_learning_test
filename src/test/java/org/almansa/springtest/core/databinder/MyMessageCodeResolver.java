package org.almansa.springtest.core.databinder;

import org.springframework.stereotype.Component;
import org.springframework.validation.MessageCodesResolver;

/*
 * MessageCodesResolver 
 * DataBinder에서 사용하는 전략 인터페이스
 * 유효성 에러코드로 부터 메시지 코드를 빌드한다. 
 */
@Component
public class MyMessageCodeResolver implements MessageCodesResolver{

	@Override
	public String[] resolveMessageCodes(String errorCode, String objectName) {

		return null;
	}

	/*
	 * 에러코드로 메시지코드를 빌드한다.
	 */
	@Override
	public String[] resolveMessageCodes(String errorCode, String objectName, String fieldName, Class<?> fieldType) {
		if(errorCode.equals("name.empty")) {
			return new String[] {"name.empty"};
		}
		return null;
	}

}
