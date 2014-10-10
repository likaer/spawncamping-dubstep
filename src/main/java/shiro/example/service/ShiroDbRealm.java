package shiro.example.service;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.io.Serializable;

public class ShiroDbRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //表单信息存储在authenticationToken,对于默认的用户密码采用强转内置的UsernamePasswordToken.
        //对于特殊的用户名密码，需要自建相应的token，因此可见俊杰为了兼容域名增加了一个MyAuthenticationToken
        UsernamePasswordToken formData = (UsernamePasswordToken)authenticationToken;
        //
        System.out.println("Username : " + formData.getUsername());
        //
        return new SimpleAuthenticationInfo(formData, "123456" , "AnyThing else");
    }
}