//package com.example.demo;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Profile;
//import org.springframework.web.socket.WebSocketSession;
//
//import me.ramswaroop.jbot.core.common.Controller;
//import me.ramswaroop.jbot.core.common.EventType;
//import me.ramswaroop.jbot.core.common.JBot;
//import me.ramswaroop.jbot.core.slack.Bot;
//import me.ramswaroop.jbot.core.slack.models.Event;
//import me.ramswaroop.jbot.core.slack.models.Message;
//@JBot 
//@Profile("slack")
//
//public class SlackBot extends Bot {
//	
//    private static final Logger logger = LoggerFactory.getLogger(SlackBot.class);
//
//    @Value("${slackBotToken}")
//    private String slackToken;
//
//    @Override
//    public String getSlackToken() {
//        return slackToken;
//    }
//
//    @Override
//    public Bot getSlackBot() {
//        return this;
//    }
//    
//    @Controller(events = {EventType.DIRECT_MENTION, EventType.DIRECT_MESSAGE})
//    public void onReceiveDM(WebSocketSession session, Event event) {
//        reply(session, event, new Message("Hi, I am " + slackService.getCurrentUser().getName()));
//    }
//    
//    @Controller(pattern = "(setup meeting)", next = "confirmTiming")
//    public void setupMeeting(WebSocketSession session, Event event) {
//        startConversation(event, "confirmTiming");   // start conversation
//        reply(session, event, "Cool! At what time (ex. 15:30) do you want me to set up the meeting?");
//    }
//
//    @Controller(next = "askTimeForMeeting")
//    public void confirmTiming(WebSocketSession session, Event event) {
//        reply(session, event, "Your meeting is set at " + event.getText() +
//                ". Would you like to repeat it tomorrow?");
//        nextConversation(event);    // jump to next question in conversation
//    }
//    
//    @Controller(next = "askWhetherToRepeat")
//    public void askTimeForMeeting(WebSocketSession session, Event event) {
//        if (event.getText().contains("yes")) {
//            reply(session, event, "Okay. Would you like me to set a reminder for you?");
//            nextConversation(event);    // jump to next question in conversation  
//        } else {
//            reply(session, event, "No problem. You can always schedule one with 'setup meeting' command.");
//            stopConversation(event);    // stop conversation only if user says no
//        }
//    }
//    
//    @Controller
//    public void askWhetherToRepeat(WebSocketSession session, Event event) {
//        if (event.getText().contains("yes")) {
//            reply(session, event, "Great! I will remind you tomorrow before the meeting.");
//        } else {
//            reply(session, event, "Okay, don't forget to attend the meeting tomorrow :)");
//        }
//        stopConversation(event);    // stop conversation
//    }
//	
//}