package com.dajiang.app.common.auth;

import com.dajiang.app.base.po.dmo.UserDetailsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String targetUrl = determineTargetUrl(request, response);
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }
        SecurityContext context = SecurityContextHolder.getContext();
        UserDetailsDTO userDetailsDTO = (UserDetailsDTO) context.getAuthentication().getPrincipal();
        RequestContextHolder.getRequestAttributes().setAttribute("userSessionInfo",
                userDetailsDTO.getBaseUserDTO(), RequestAttributes.SCOPE_SESSION);
    }


}