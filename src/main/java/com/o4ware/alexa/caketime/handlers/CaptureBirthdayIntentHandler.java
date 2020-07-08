package com.o4ware.alexa.caketime.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class CaptureBirthdayIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("CaptureBirthdayIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        Map<String, Slot> slots = ((IntentRequest) request).getIntent().getSlots();

        String year = slots.get("year").getValue();
        String month = slots.get("month").getValue();
        String day = slots.get("day").getValue();

        AttributesManager attributesManager = input.getAttributesManager();
        Map<String, Object> sessionAttributes = attributesManager.getPersistentAttributes();

        sessionAttributes.put("year", year);
        sessionAttributes.put("month", month);
        sessionAttributes.put("day", day);

        attributesManager.setPersistentAttributes(sessionAttributes);
        attributesManager.savePersistentAttributes();
        String speechText = String.format("Thanks, I'll remember that you were born on %s %s %s.", month, day, year);
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Caketime", speechText)
                .build();
    }
}
