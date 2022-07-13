package com.demo.automationtestdevelopertargetrepo.models.testdatainputmodels;

import com.demo.automationtestdevelopertargetrepo.annotations.PublishingInputField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class AbstractInputModel {

    @PublishingInputField
    protected String identifier;

    @PublishingInputField(isOptional = true)
    protected String identifierToReuseIdFrom;

    @PublishingInputField(isOptional = true)
    protected long leadTimeDelay;

}
