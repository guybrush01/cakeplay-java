package com.o4ware.alexa.caketime.handlers;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;
import com.amazon.ask.SkillStreamHandler;

public class SimpleAlexaSkillStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new HasBirthdayLaunchRequestHandler(),
                        new CancelandStopIntentHandler(),
                        new CaptureBirthdayIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler())

                // Add your skill id below
                //.withSkillId("")
                .withTableName("caketime")
                .withAutoCreateTable(true)
                .build();
    }

    public SimpleAlexaSkillStreamHandler() {
        super(getSkill());
    }

}