package com.inspur.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * User: YANG
 * Date: 2019/7/18-23:57
 * Description: No Description
 */
@Data
public class UserEntity implements Serializable{
	private static final long serialVersionUID = 4839704829163683871L;
	private String name;
	private int age;
}
