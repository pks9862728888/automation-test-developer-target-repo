package com.demo.automationtestdevelopertargetrepo.models.verificationmodels;

import com.demo.automationtestdevelopertargetrepo.annotations.MandatoryVerificationField;
import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.VerificationTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class AbstractVerificationModel {

    @MandatoryVerificationField
    protected VerificationTypeEnum type;

    @MandatoryVerificationField
    protected String identifier;

}
