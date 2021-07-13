package com.trendyol.linkconverter.model;

import com.trendyol.linkconverter.model.request.WebLinkConversionRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


public class WebLinkConversionRequestTest {

    private static Validator validator;

    @BeforeAll()
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Valid Uri test")
    void acceptUri() {
        WebLinkConversionRequest req = new WebLinkConversionRequest("https://www.trendyol.com/test");

        Set<ConstraintViolation<WebLinkConversionRequest>> violations = validator.validate(req);
        Assertions.assertTrue(violations.isEmpty());
    }

}
