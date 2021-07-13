package com.trendyol.linkconverter.model;

import com.trendyol.linkconverter.model.request.DeepLinkConversionRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DeepLinkConversionTest {

    private static Validator validator;

    @BeforeAll()
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("Valid DeepLink test")
    void acceptUri() {

        DeepLinkConversionRequest req = new DeepLinkConversionRequest("ty://?test");

        Set<ConstraintViolation<DeepLinkConversionRequest>> violations = validator.validate(req);
        Assertions.assertTrue(violations.isEmpty());
    }
}
