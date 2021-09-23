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

public class YesIntentRequestHandler implements RequestHandler
{
    @Override
    public boolean canHandle(HandlerInput input)
    {
        return input.matches(intentName("AMAZON.YesIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input)
    {
        if (Util.supportsApl(input))
        {
            String title = "bye bye!";

            String message = "Ok, i stopped and terminated all the tasks and conversations. If you like to speak to me again. Simply say alexa, open finder pro.";

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
            session.remove("repeat_message");
            session.remove("repeat_re_prompt_message");

            AttributesManager attributesManager = input.getAttributesManager();

            Map<String, Object> document = getDirectivesResponse("file","simpleWithHeader.json");

            Map<String, Object> dataSource = getDirectivesResponse("class", JsonHelper.convertSimpleWithHeader(title,message));

            if (document != null && dataSource != null)
            {
                attributesManager.setSessionAttributes(session);

                RenderDocumentDirective documentDirective = RenderDocumentDirective.builder()
                        .withToken("simpleToken")
                        .withDocument(document)
                        .withDatasources(dataSource)
                        .build();

                return input.getResponseBuilder()
                        .withSpeech(message)
                        .withShouldEndSession(true)
                        .addDirective(documentDirective)
                        .build();
            }
            else
            {
                return fallbackResponse(input);
            }
        }
        else
        {
            return input.getResponseBuilder()
                    .withSpeech(Util.unSupportDeviceFallbackMessage)
                    .build();
        }
    }
}
