package Handlers;

import Utils.JsonHelper;
import Utils.Util;
import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.interfaces.alexa.presentation.apl.RenderDocumentDirective;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static Utils.Util.*;
import static com.amazon.ask.request.Predicates.intentName;

public class NoIntentRequestHandler implements RequestHandler
{
    @Override
    public boolean canHandle(HandlerInput input)
    {
        return input.matches(intentName("AMAZON.NoIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input)
    {
        if (Util.supportsApl(input))
        {
            String title = "don't worry!";

            String message = "Ok, don't worry. We can continue the conversation. " +
                    "The all tasks has been terminated. " +
                    "So, please say the task name with keyword task name. ";

            Map<String,Object> session = new HashMap<>();

            session.remove("task_name");
            session.remove("bucket_name");
            session.remove("file_name");
            session.remove("file_format");
            session.remove("target_bucket_name");
            session.remove("target_file_name");
            session.remove("target_file_format");
            session.remove("search_text");
            session.remove("search_object");
            session.put("repeat_message",message);
            session.put("repeat_re_prompt_message",message);


            return getSimpleResponse(input,title,message,message,message,session);
        }
        else
        {
            return input.getResponseBuilder()
                    .withSpeech(Util.unSupportDeviceFallbackMessage)
                    .build();
        }
    }
}
