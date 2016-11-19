package com.example.smalu.policebank.utils;

public class ResponseObject <T> {

	
	private String msg;
	private int state=1;//1:成功  0：失败
	private T datas;//存放我真正需要解析的数据
	private int page;
	private int size;
	private int count;

	public ResponseObject(int state,String msg,T datas){
		this.datas=datas;
		this.msg=msg;
		this.state=state;
		
	}
	//成功不返回提示结果的
	public ResponseObject(int state,T datas){
		this.datas=datas;
		
		this.state=state;
		
	}
	//用于失败是返回失败的信息
	public ResponseObject(int state,String msg){
		
		this.msg=msg;
		this.state=state;
		
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public T getDatas() {
		return datas;
	}
	public void setDatas(T datas) {
		this.datas = datas;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
