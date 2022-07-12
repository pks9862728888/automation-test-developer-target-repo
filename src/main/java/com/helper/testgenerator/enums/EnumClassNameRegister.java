package com.helper.testgenerator.enums;

import com.demo.automationtestdevelopertargetrepo.enums.fields.JurisdictionRegimeEnum;
import com.demo.automationtestdevelopertargetrepo.enums.fields.SourceSystemEnum;
import com.demo.automationtestdevelopertargetrepo.enums.fields.TRReportingEligibilityStatusEnum;
import com.demo.automationtestdevelopertargetrepo.enums.fields.TradeChannelEnum;
import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.InputTypeEnum;
import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.VerificationTypeEnum;
import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.modelclassnames.DbModelClassNamesEnum;
import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.modelclassnames.XmlVerificationModelClassNamesEnum;

public enum EnumClassNameRegister {
    // Input parsers
    InputTypeEnum(InputTypeEnum.class),
    VerificationTypeEnum(VerificationTypeEnum.class),

    // Model class name enum
    DbModelClassNamesEnum(DbModelClassNamesEnum.class),
    XmlVerificationModelClassNamesEnum(XmlVerificationModelClassNamesEnum.class),

    // Field enums
    JurisdictionRegimeEnum(JurisdictionRegimeEnum.class),
    SourceSystemEnum(SourceSystemEnum.class),
    TradeChannelEnum(TradeChannelEnum.class),
    TRReportingEligibilityStatusEnum(TRReportingEligibilityStatusEnum.class);

    private final Class<? extends Enum<?>> enumClazz;

    EnumClassNameRegister(Class<? extends Enum<?>> enumClazz) {
        this.enumClazz = enumClazz;
    }

    public Class<? extends Enum<?>> getEnumClazz() {
        return enumClazz;
    }
}
