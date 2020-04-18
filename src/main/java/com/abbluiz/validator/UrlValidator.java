package com.abbluiz.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@FacesValidator
public class UrlValidator implements Validator {

    public static boolean isUrlValid(String url) {

        try {

            URL obj = new URL(url);
            obj.toURI();

            return true;

        } catch(MalformedURLException | URISyntaxException e) {
            return false;
        }

    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object name) {

        String url = "";

        try {

            url = (String)name;

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!isUrlValid(url) && !url.isEmpty()) {

            FacesMessage msg = new FacesMessage(url + " is not a valid URL.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }

    }

}
