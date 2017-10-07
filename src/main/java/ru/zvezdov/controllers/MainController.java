package ru.zvezdov.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author Dmitry Zvezdov
 *         06.10.17.
 */
@Controller
public class MainController {
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/hello")
    public String hello(Map<String,Object> model) {
        log.info("Method /hello");
        return "welcome";
    }

}
