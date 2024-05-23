package com.goorm.tricountapi.Interceptor;

import com.goorm.tricountapi.MemberContext;
import com.goorm.tricountapi.TricountApiConst;
import com.goorm.tricountapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class LoginCheckInterceptor implements HandlerInterceptor {

    private final MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Cookie[] cookies = request.getCookies();

        if(!this.containUserCookie(cookies)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }

        for (Cookie cookie: cookies) {
            if(TricountApiConst.LOGIN_MEMBER_COOKIE.equals(cookie.getName())) {
                try {
                    MemberContext.setCurrentMember(memberService.findMemberById(Long.valueOf(cookie.getValue())));
                    break;
                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                    return false;
                }

            }
        }

        return true;
    }

    private boolean containUserCookie(Cookie[] cookies) {
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if(TricountApiConst.LOGIN_MEMBER_COOKIE.equals(cookie.getName())) {
                    return true;
                }
            }
        }

        return false;
    }
}
