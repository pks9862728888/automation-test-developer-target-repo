package com.demo.automationtestdevelopertargetrepo.models.verificationmodels;

import com.demo.automationtestdevelopertargetrepo.annotations.HideTransientFieldFromYaml;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TradeEvent extends AbstractVerificationModel {

    private String id;
    private String upi;
    private String reportingPurpose;

    @HideTransientFieldFromYaml
    private String messageId;

}
