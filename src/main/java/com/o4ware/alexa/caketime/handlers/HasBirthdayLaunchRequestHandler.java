package com.o4ware.alexa.caketime.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;

import java.util.Map;
import java.util.Optional;

public class HasBirthdayLaunchRequestHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        Map<String, Object> persistentAttributes = input.getAttributesManager().getPersistentAttributes();
        return persistentAttributes.containsKey("year") && persistentAttributes.containsKey("month") && persistentAttributes.containsKey("day");
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Map<String, Object> persistentAttributes = input.getAttributesManager().getPersistentAttributes();
        String year = (String) persistentAttributes.get("year");
        String month = (String) persistentAttributes.get("month");
        String day = (String) persistentAttributes.get("day");

        String speechText = String.format("You were born on %s %s %s.", month, day, year);
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Caketime", speechText)
                .build();
    }
}
