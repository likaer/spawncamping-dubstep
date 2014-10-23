package shiro.example.service;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ShiroDbRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        final String username = (String) principalCollection.getPrimaryPrincipal();
        //final Set<String> roles = this.emailToRoles.get(username);
        //return new SimpleAuthorizationInfo(roles);
        final Set<String> roles = new HashSet<String>(){
            {
                this.add("admin");
            }
        };
        //TODO roleService.findRolesByUsername();
        //TODO addRoles to Set<String>roles
        return new SimpleAuthorizationInfo(roles);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //表单信息存储在authenticationToken,对于默认的用户密码采用强转内置的UsernamePasswordToken.
        //对于特殊的用户名密码，需要自建相应的token，因此可见俊杰为了兼容域名增加了一个MyAuthenticationToken
        UsernamePasswordToken formData = (UsernamePasswordToken)authenticationToken;
        //
        System.out.println("Username : " + formData.getUsername());
        String password = "123456";
        //从数据库获取该用户的密码。
        //password = UserService.getUserByUserName(formData.getUsername()).getPassword();
        //Shiro会调用内部方法去匹配formData中的密码是否等于password参数
        //其中"AnyThing else"是凭证名，一般填用户名，但是并无明确校验！
        return new SimpleAuthenticationInfo(formData, password, "AnyThing else");
    }
}
