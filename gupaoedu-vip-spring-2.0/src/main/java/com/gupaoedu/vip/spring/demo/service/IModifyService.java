package com.gupaoedu.vip.spring.demo.service;

/**
 * 增删改业务
 * @author Tom
 *
 */
public interface IModifyService {

	/**
	 * 增加
	 */
	public String add(String name, String addr) throws Exception;
	
	/**
	 * 修改
	 */
	public String edit(Integer id, String name);
	
	/**
	 * 删除
	 */
	public String remove(Integer id);
	
}
