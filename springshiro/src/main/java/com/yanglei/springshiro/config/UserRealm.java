package com.yanglei.springshiro.config;

import com.yanglei.springshiro.entity.User;
import com.yanglei.springshiro.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

//自定义的realm对象
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl service;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("===>执行了授权 doGetAuthorizationInfo");

        SimpleAuthorizationInfo authorization = new SimpleAuthorizationInfo();

        //拿到当前登录对象
        Subject subject = SecurityUtils.getSubject();
        //这里能拿到user是因为下面认证放进去了    new SimpleAuthenticationInfo(user, user.getPassword(),"");
        User currentUser = (User) subject.getPrincipal();

        //设置当前用户的权限
        authorization.addStringPermission(currentUser.getPerms());
        return authorization;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("===>执行了认证 doGetAuthenticationInfo");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //认证用户名、密码 数据库中取
        User user = service.queryByName(token.getUsername());

        if(null == user){
            return null;//会抛出异常 UnknownAccountException
        }

        //密码认证不用自己做，shiro自动帮忙做(防止密码泄露)

        return new SimpleAuthenticationInfo(user, user.getPassword(),"");
    }
}
