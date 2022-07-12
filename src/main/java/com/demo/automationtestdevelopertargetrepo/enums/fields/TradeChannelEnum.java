package com.demo.automationtestdevelopertargetrepo.enums.fields;

public enum TradeChannelEnum {
    CHANNEL1("\\p{Alnum}+"),
    CHANNEL2("\\p{Alnum}+");

    private final String regex;

    TradeChannelEnum(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
