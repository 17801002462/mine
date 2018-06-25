package com.xlove.bean;

import java.io.Serializable;

public class ResultApi<T> implements Serializable {
	private static final long serialVersionUID = 6657238575549774018L;
	public static final String SUCCESS_MSG = "成功";
	public static final String FAIL_MSG = "失败";
	
	private int resCode;//0：成功 1：失败
	private String resDesc;
	private T data;
	//成功
	public static final int RESP_STATUS_CODE_SUCCESS = 0;
	//失败
	public static final int RESP_STATUS_CODE_FAIL = 1;
	//错误
	public static final int RESP_STATUS_CODE_ERROR = 2;

	/**
	 * @param resCode
	 * @param resDesc
	 */
	public ResultApi(int resCode, String resDesc) {
		super();
		this.resCode = resCode;
		this.resDesc = resDesc;
	}
	
	/**
	 * @param data
	 */
	public ResultApi(T data) {
		super();
		this.data = data;
	}

	/**
	 * 
	 */
	public ResultApi() {
		super();
	}

	/**
	 * @return the resCode
	 */
	public int getResCode() {
		return resCode;
	}
	/**
	 * @param resCode the resCode to set
	 */
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	/**
	 * @return the resDesc
	 */
	public String getResDesc() {
		if(resDesc == null){
			return "";
		}
		return resDesc;
	}
	/**
	 * @param resDesc the resDesc to set
	 */
	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}
	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("ResultApi [resCode=").append(resCode).append(", resDesc=").append(resDesc).append(", data=");
		if(data != null){
			buf.append(data.toString());
		}
		return buf.toString();
	}
	

    public static ResultApi<String> buildSuccessResultApi() {
        return buildSuccessResultApi(SUCCESS_MSG);
    }

    public static <E> ResultApi<E> buildDataSuccessResultApi() {
        return buildDataSuccessResultApi(SUCCESS_MSG);
    }

    public static <E> ResultApi<E> buildDataSuccessResultApi(String message) {
    	ResultApi<E> dto = new ResultApi<E>();
        dto.resCode = RESP_STATUS_CODE_SUCCESS;
        dto.resDesc = message;
        return dto;
    }

    public static <E> ResultApi<E> buildDataSuccessResultApi(String message, E data) {
        ResultApi<E> dto = buildDataSuccessResultApi(message);
        dto.data = data;
        return dto;
    }

    public static ResultApi<String> buildSuccessResultApi(String message) {
        ResultApi<String> dto = new ResultApi<String>();
        dto.resCode = RESP_STATUS_CODE_SUCCESS;
        dto.resDesc = message;
        return dto;
    }

    public static <E> ResultApi<E> buildDataSuccessResultApi(E data) {
        ResultApi<E> dto = buildDataSuccessResultApi();
        dto.data = data;
        return dto;
    }

    /**
     * 自定义成功的code
     *
     * @param message 信息
     * @param code    code
     * @return
     */
    public static ResultApi<String> buildSuccessResultApiWithCode(String message, int code) {
        ResultApi<String> dto = new ResultApi<String>();
        dto.resCode = code;
        dto.resDesc = message;
        return dto;
    }

    public static ResultApi<String> buildFailureResultApi() {
        return buildFailureResultApi(FAIL_MSG);
    }

    public static ResultApi<String> buildFailureResultApi(String message) {
        ResultApi<String> dto = new ResultApi<String>();
        dto.resCode = RESP_STATUS_CODE_FAIL;
        dto.resDesc = message;
        return dto;
    }

    public static <E> ResultApi<E> buildDataFailureResultApi() {
        return buildDataFailureResultApi(FAIL_MSG);
    }

    public static <E> ResultApi<E> buildDataFailureResultApi(String message) {
        ResultApi<E> dto = new ResultApi<E>();
        dto.resCode = RESP_STATUS_CODE_FAIL;
        dto.resDesc = message;
        return dto;
    }
    

    public static <E> ResultApi<E> buildDataFailureResultApi(E data) {
        ResultApi<E> dto = new ResultApi<E>();
        dto.resCode =RESP_STATUS_CODE_FAIL;
        dto.data = data;
        return dto;
    }


	public static <E> ResultApi<E> buildDataFailureResultApi(String message, E data) {
		ResultApi<E> dto = buildDataSuccessResultApi(message);
		dto.data = data;
		dto.resDesc = message;
		return dto;
	}

}
