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
        UsernamePasswordToken loginToken = (UsernamePasswordToken)authenticationToken;
        System.out.println("Username : " + loginToken.getUsername());
        return new SimpleAuthenticationInfo(loginToken, "123456" , loginToken.getPassword().toString());
    }
}