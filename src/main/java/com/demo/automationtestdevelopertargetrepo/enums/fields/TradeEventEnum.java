package com.demo.automationtestdevelopertargetrepo.enums.fields;

import com.demo.automationtestdevelopertargetrepo.enums.fields.SourceSystemEnum;

import java.util.Arrays;
import java.util.List;

public enum TradeEventEnum {
    EVENT1(SourceSystemEnum.SS1, SourceSystemEnum.SS2),
    EVENT2(SourceSystemEnum.SS1);

    private final List<SourceSystemEnum> sourceSystems;

    TradeEventEnum(SourceSystemEnum... sourceSystemEnums) {
        this.sourceSystems = Arrays.asList(sourceSystemEnums);
    }

    public List<SourceSystemEnum> getSourceSystems() {
        return sourceSystems;
    }
}
