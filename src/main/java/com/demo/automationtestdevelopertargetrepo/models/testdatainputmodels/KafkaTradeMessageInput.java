package com.demo.automationtestdevelopertargetrepo.models.testdatainputmodels;

import com.demo.automationtestdevelopertargetrepo.annotations.PublishingInputField;
import com.demo.automationtestdevelopertargetrepo.enums.fields.SourceSystemEnum;
import com.demo.automationtestdevelopertargetrepo.enums.fields.TradeChannelEnum;
import com.demo.automationtestdevelopertargetrepo.enums.fields.TradeEventEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class KafkaTradeMessageInput extends AbstractInputModel {

    @PublishingInputField
    private String tradeId;

    @PublishingInputField
    private String insertionFileName;

    @PublishingInputField
    private SourceSystemEnum sourceSystem;

    @PublishingInputField
    private TradeChannelEnum channel;

    @PublishingInputField
    private TradeEventEnum event;

}
