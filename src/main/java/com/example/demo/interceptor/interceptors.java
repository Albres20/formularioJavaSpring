package com.example.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Component("tiempoTranscurridoInterceptor")
public class interceptors implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(interceptors.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Tiempor transcurrido: preHandle() ingresando....");
        long timeCurrent=System.currentTimeMillis();
        request.setAttribute("tiempoInicio", timeCurrent);
        Random random=new Random();
        Integer demora= random.nextInt(500);
        Thread.sleep(demora);
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    long tiempoFin=System.currentTimeMillis();
    long tiempoInicio= (long) request.getAttribute("tiempoInicio");
    long timeTranscurrido=tiempoFin-tiempoInicio;
    if(handler instanceof HandlerMethod){
        modelAndView.addObject("tiempoTranscurrido", timeTranscurrido);

    }
    logger.info("Tiempo trascurrido:"+ timeTranscurrido + "milisegundos.");
    logger.info("Tiempo trascurrido Inteceptor: PostHandle() saliendo ....");

    }

}
