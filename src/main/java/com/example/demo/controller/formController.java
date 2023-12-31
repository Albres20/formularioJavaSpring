package com.example.demo.controller;


import com.example.demo.models.domain.usuario;
import com.example.demo.validation.usuarioValidador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("usuario")
public class formController {
    /*@Autowired
    private usuarioValidador validacion;*/
    @GetMapping("/form")
    public String form(Model model){



        usuario user = new usuario();
        user.setNombre("David");
        user.setApellido("Pablo");
        user.setIdentificador("123.456.789-K");
        model.addAttribute("usuario", user);

        return "form";
    }
    //@RequestParam lo que hará será obtener del name del form.html los nombres, password, email
    /*@PostMapping("/form")
    public String procesar(Model model,
                           @RequestParam(name="username") String username,
                           @RequestParam String password,
                           @RequestParam String email){
        usuario user=new usuario();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);

        model.addAttribute("titulo", "Resultado Formulario");
        model.addAttribute("user", user);

        return "resultado";
    }*/
    @PostMapping("/form")
    public String procesar(Model model,
                           @Valid usuario user, BindingResult result, SessionStatus status){
         /*validacion.validate(user, result);*/



        if(result.hasErrors()){
            Map<String, String> errores= new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
            });

            //Asume la ,muestra a travs de model
            model.addAttribute("errorPasante", errores);
            return "form";
        }

        model.addAttribute("titulo", "Resultado Formulario");

            model.addAttribute("user", user);
        status.setComplete();//cierra la sesión
        return "resultado";
    }

}
