package com.kkt.www.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserVO implements UserDetails {
	
	private String username;
    private String password;
	
	/**
	 * 사용자 이름
	 */
	private String userName;
	/**
	 * 사용자 아이디
	 */
	private String userId;
	/**
	 * 사용자 암호
	 */
	private String userPass;
	/**
	 * 사용자 등급
	 */
	private int userLevel;
	/**
	 * 승인 상태
	 */
	private int userAssignStatus;
	/**
	 * 본부 아이디
	 */
	private String branchId;
	/**
	 * 팀 아이디
	 */
	private String teamId;
	/**
	 * 이동전화 번호
	 */
	private String cellNumber;
	/**
	 * 유선전화 번호
	 */
	private String phoneNumber;
	/**
	 * 이메일
	 */
	private String email;
	/**
	 * 설명
	 */
	private String userDescription;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	public int getUserAssignStatus() {
		return userAssignStatus;
	}
	public void setUserAssignStatus(int userAssignStatus) {
		this.userAssignStatus = userAssignStatus;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	
	
	
    public UserVO(String userName, String password)
    {
    	this.username = userName;
    	this.password = password;
    }
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();    
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        return authorities;		
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
//		return false;
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
//		return false;
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
//		 TODO Auto-generated method stub
//		return false;
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
//		return false;
		return true;
	}
}