package com.demo.automationtestdevelopertargetrepo.enums.inputparsers.modelclassnames;

import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.ModelClassName;
import com.demo.automationtestdevelopertargetrepo.models.verificationmodels.XmlVerificationModel;

public enum XmlVerificationModelClassNamesEnum implements ModelClassName {
    XmlVerificationModel(XmlVerificationModel.class);

    private final Class<?> clazz;

    XmlVerificationModelClassNamesEnum(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    @Override
    public Class<?> getClassName() {
        return this.getClazz();
    }
}
