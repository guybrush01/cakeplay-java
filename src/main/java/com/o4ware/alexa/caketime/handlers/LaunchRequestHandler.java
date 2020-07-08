package com.o4ware.alexa.caketime.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Hello! Welcome to Caketime. What is your birthday?";
        String repromptText = "I was born Nov. 6th, 2014. When were you born?";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Caketime", speechText)
                .withReprompt(repromptText)
                .build();
    }

}