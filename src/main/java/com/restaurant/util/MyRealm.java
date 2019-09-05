package com.restaurant.util;

import com.restaurant.entity.Account;
import com.restaurant.mapper.AccountMapper;
import com.restaurant.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class MyRealm  extends AuthorizingRealm{
	@Autowired
	AccountMapper accountMapper;
	
	/**
	 * 用于验证用户是否登陆
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//获取口令中的用户名
		String accountname = (String) token.getPrincipal();
		//通过数据库链接获取用户信息
		Account account = accountMapper.getAccount(accountname);
		if(account != null){
			//设置认证信息
			AuthenticationInfo info =
					new SimpleAuthenticationInfo(account.getAccountpwd(), account.getAccountpwd(), "myRealm");
			return info;
		}
		return null;
	}

	/**
	 * 在登陆成功之后，设置用户的角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//获取用户名
		String accountname = (String) principals.getPrimaryPrincipal();
		//设置授权信息
		SimpleAuthorizationInfo  info = new SimpleAuthorizationInfo ();
		String role = Integer.toString(accountMapper.getRole(accountname));
		Set<String> roles = new HashSet<String>();
		roles.add(role);
		//设置角色
		info.setRoles(roles);
		return info;
	}
	

}
