package com.demo.automationtestdevelopertargetrepo.enums.inputparsers.modelclassnames;

import com.demo.automationtestdevelopertargetrepo.enums.inputparsers.ModelClassName;
import com.demo.automationtestdevelopertargetrepo.models.testdatainputmodels.TradeEvent;

public enum DbModelClassNamesEnum implements ModelClassName {
    TradeEvent(TradeEvent.class);

    private final Class<?> clazz;

    DbModelClassNamesEnum(Class<?> clazz) {
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
