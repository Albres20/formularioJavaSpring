package com.example.demo.validation;

import com.example.demo.models.domain.usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class usuarioValidador implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
         usuario usuario=(usuario)target;

        //ValidationUtils.rejectIfEmpty(errors, "identificador", "nop");
    }
}
