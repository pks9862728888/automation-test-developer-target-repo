package com.demo.automationtestdevelopertargetrepo.enums.inputparsers.modelclassnames;

import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.ModelClassName;

public enum XmlVerificationModelClassNamesEnum implements ModelClassName {
    DbModelClassNamesEnum(DbModelClassNamesEnum.class);

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
