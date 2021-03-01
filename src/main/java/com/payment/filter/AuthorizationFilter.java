package com.payment.filter;

import com.payment.model.User;
import com.payment.model.enums.Role;
import com.payment.service.UserService;
import com.payment.service.impl.UserServiceImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class AuthorizationFilter implements Filter {
    private static final String USER_ID = "user_id";
    private static final Logger LOGGER = Logger.getLogger(AuthorizationFilter.class);
    private final UserService userService = new UserServiceImpl();
    private final Map<String, List<Role>> protectedUrls = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        protectedUrls.put("/user/all", List.of(Role.ADMIN));
        protectedUrls.put("/ticket/all", List.of(Role.ADMIN));
        protectedUrls.put("/bill/all", List.of(Role.ADMIN));
        protectedUrls.put("/card/all", List.of(Role.ADMIN));

        protectedUrls.put("/card/allByUser", List.of(Role.CLIENT));
        protectedUrls.put("/ticket/allByUser", List.of(Role.CLIENT));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String requestedUrl = req.getServletPath();

        if (protectedUrls.get(requestedUrl) == null) {
            chain.doFilter(req, resp);
            return;
        }

        Long userId = (Long) req.getSession().getAttribute(USER_ID);
        User user = userService.get(userId).get();
        if (isAuthorized(user, protectedUrls.get(requestedUrl))) {
            chain.doFilter(req, resp);
        } else {
            LOGGER.warn("User with id: " + userId + " tries to access forbidden page");
            req.getRequestDispatcher("/WEB-INF/views/accessDenied.jsp")
                    .forward(req, resp);
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isAuthorized(User user, List<Role> authorizedRoles) {
        for (Role authorizedRole : authorizedRoles) {
            if (authorizedRole.equals(Role.getRole(user))) {
                return true;
            }
        }
        return false;
    }
}
