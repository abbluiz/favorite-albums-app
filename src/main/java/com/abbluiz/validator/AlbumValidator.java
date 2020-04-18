package com.abbluiz.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Arrays;

@FacesValidator
public class AlbumValidator implements Validator {

    private String[] acceptedCoverExtensions = {".jpg", ".jpeg", ".png", ".webp"};

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object name) {

        String url = (String)name;
        String extension = url.substring(url.lastIndexOf("."));

        if (!Arrays.asList(acceptedCoverExtensions).contains(extension)) {

            FacesMessage msg =
                    new FacesMessage("Album cover art image url should have one of these extensions: "
                            + Arrays.toString(acceptedCoverExtensions));
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }

    }

}
