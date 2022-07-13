package com.demo.automationtestdevelopertargetrepo.enums.inputparsers;

import com.demo.automationtestdevelopertargetrepo.models.testdatainputmodels.KafkaTradeMessageInput;

public enum InputTypeEnum implements ModelClassName {
    KAFKA_TRADE_INPUT(KafkaTradeMessageInput.class),
    NO_INPUT(null);

    private final Class<?> clazz;

    InputTypeEnum(Class<?> clazz) {
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
