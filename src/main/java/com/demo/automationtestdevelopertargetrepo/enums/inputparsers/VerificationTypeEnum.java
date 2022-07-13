package com.demo.automationtestdevelopertargetrepo.enums.inputparsers;

import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.modelclassnames.DbModelClassNamesEnum;
import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.modelclassnames.XmlVerificationModelClassNamesEnum;

public enum VerificationTypeEnum {
    DB(DbModelClassNamesEnum.class),
    XML(XmlVerificationModelClassNamesEnum.class),
    NO_VERIFICATION(null);

    private final Class<? extends Enum<? extends ModelClassName>> enumClazzz;

    VerificationTypeEnum(Class<? extends Enum<? extends ModelClassName>> enumClazzz) {
        this.enumClazzz = enumClazzz;
    }

    public Class<? extends Enum<? extends ModelClassName>> getEnumClazzz() {
        return enumClazzz;
    }
}
