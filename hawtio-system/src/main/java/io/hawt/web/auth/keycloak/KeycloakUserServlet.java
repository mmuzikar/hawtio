package io.hawt.web.auth.keycloak;

import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.hawt.system.AuthHelpers;
import io.hawt.system.Authenticator;
import io.hawt.web.auth.UserServlet;

public class KeycloakUserServlet extends UserServlet {

    private static final long serialVersionUID = 1734127369954899957L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected String getUsername(HttpServletRequest req, HttpServletResponse resp) {
        if (authConfiguration.isKeycloakEnabled()) {
            return getKeycloakUsername(req);
        } else {
            return super.getUsername(req, resp);
        }
    }

    /**
     * With Keycloak integration, the Authorization header is available in the request to the UserServlet.
     */
    protected String getKeycloakUsername(final HttpServletRequest req) {
        AtomicReference<String> username = new AtomicReference<>();
        new Authenticator(req, authConfiguration).authenticate(
            subject -> {
                username.set(AuthHelpers.getUsername(subject));

                // Start httpSession
                req.getSession(true);
            }
        );
        return username.get();
    }

}
