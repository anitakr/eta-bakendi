package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.service.AuthorizationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


@Controller
public class MyErrorController implements ErrorController {

    private final AuthorizationService authorizationService;

    @Autowired
    public MyErrorController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        // For the menu bar
        if(this.authorizationService.isLoggedIn()) {
            model.addAttribute("usersession", this.authorizationService.getUser());
        }

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/Error-404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error/Error-500";
            }
        }

        return "error/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
