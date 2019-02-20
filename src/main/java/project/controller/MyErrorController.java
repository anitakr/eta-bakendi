package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.service.AuthorizationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


@RestController
public class MyErrorController implements ErrorController {

    private final AuthorizationService authorizationService;

    @Autowired
    public MyErrorController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "Error-404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "Error-500";
            }
        }

        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
