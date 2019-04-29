package com.project.med.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Response {

	private static final int STATUS_SUCCESS = 200;
	public static final String SUCCESS = "Success!!";
	private static final int STATUS_UN_SUCCESS = 00;
	public static final String UN_SUCCESS = "Un-Success!!";

	private long status_code;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String status_desc;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object data;

	public Response() {
		super();
	}

	public Response(int status, String msg) {
		this.status_code = status;
		this.status_desc = msg;
	}

	public static Response getFailureResponse() {
		return new Response(STATUS_UN_SUCCESS, UN_SUCCESS);
	}

	public static Response getSuccessResponse() {
		return new Response(STATUS_SUCCESS, SUCCESS);
	}

	public static Response getFailureResponse(String msg) {
		Response response = getFailureResponse();
		response.setMsg(msg);
		return response;
	}

	public static Response getSuccessResponse(String msg) {
		Response response = getSuccessResponse();
		response.setMsg(msg);
		return response;
	}

	public static Response getSuccessResponse(Object data) {
		Response response = getSuccessResponse();
		response.setData(data);
		return response;
	}

	public static Response getSuccessResponse(Object data, String msg) {
		Response response = getSuccessResponse();
		response.setData(data);
		response.setMsg(msg);
		return response;
	}

	public int getStatus() {
		return (int) status_code;
	}

	public void setStatus(int status) {
		this.status_code = status;
	}

	public String getMsg() {
		return status_desc;
	}

	public void setMsg(String msg) {
		this.status_desc = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = (Object) data;
	}

	//
	// public static Response getFailureResponse(errorMsg) {
	// String msg = error.getMessage() != null ? error.getMessage() :
	// error.name();
	// return new Response(error.getValue(), msg);
	// }
	//

}