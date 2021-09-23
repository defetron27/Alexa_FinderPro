package Handlers;

import Utils.Util;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static Utils.Util.fallbackResponse;
import static Utils.Util.getSimpleResponse;
import static com.amazon.ask.request.Predicates.intentName;

public class TaskNameIntentRequestHandler implements RequestHandler
{

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("TaskNameIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input)
    {
        if (Util.supportsApl(input))
        {
            if (input.getRequestEnvelope().getRequest().getType().equals("IntentRequest"))
            {
                Intent intent = ((IntentRequest)input.getRequestEnvelope().getRequest()).getIntent();

                if (intent != null)
                {
                    String intentName = intent.getName();

                    if (intentName != null)
                    {
                        String taskName = intent.getSlots().get("task_name").getValue();

                        String sMessage  = "If you don't know what is s3 storage, simply say storage helper. " +
                                "Otherwise, say the bucket name,file name and file format one by one. " +
                                "If you don't know how to say the bucket name,file name and file format to me. " +
                                "Simply say file helper. " +
                                "Otherwise, say the bucket name with the keyword bucket name.";

                        if (taskName != null)
                        {
                            String rePrompt = "Otherwise, say the bucket name with the keyword bucket name.";

                            switch (taskName) {
                                case "image text extract": {
                                    String title = "IMAGE TEXT EXTRACT";

                                    String message = "Okay, you choose image text extract task. " +
                                            "This task is useful to extract the handwritten or typed texts from the image. " +
                                            "Okay, we want s3 storage to handle the image files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                case "image object extract": {
                                    String title = "IMAGE OBJECT EXTRACT";

                                    String message = "Okay, you choose image object extract task. " +
                                            "This task is useful to extract the objects from the image. " +
                                            "Okay, we want s3 storage to handle the image files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                case "find a text in image": {
                                    String title = "FIND A TEXT IN IMAGE";

                                    String message = "Okay, you choose find a text in image task. " +
                                            "This task is useful to search some particular text is present or not in image. " +
                                            "Okay, we want s3 storage to handle the image files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                case "find a object in image": {
                                    String title = "FIND A OBJECT IN IMAGE";

                                    String message = "Okay, you choose find a object in image task. " +
                                            "This task is useful to search some particular object is present or not in image. " +
                                            "Okay, we want s3 storage to handle the image files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                case "find a adult in image": {
                                    String title = "FIND A ADULT IN IMAGE";

                                    String message = "Okay, you choose find a adult in image task. " +
                                            "This task is useful to detect any adult content is present or not image. " +
                                            "Okay, we want s3 storage to handle the image files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                case "find a face in image": {
                                    String title = "FIND A FACE IN IMAGE";

                                    String message = "Okay, you choose find a face in image task. " +
                                            "This task is useful to search some particular face image is present or not in image. " +
                                            "Okay, we have two image files. " +
                                            "First one is source image file. " +
                                            "Second one is target image file. " +
                                            "The source image file must contain only one face. " +
                                            "And the target image file contains more than one face or one face, that not limit. " +
                                            "Okay, we want s3 storage to handle the image files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                case "video text extract": {
                                    String title = "VIDEO TEXT EXTRACT";

                                    String message = "Okay, you choose video text extract task. " +
                                            "This task is useful to extract the texts from the video. " +
                                            "Okay, we want s3 storage to handle the video files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                case "video object extract": {
                                    String title = "VIDEO OBJECT EXTRACT";

                                    String message = "Okay, you choose video object extract task. " +
                                            "This task is useful to extract the objects from the video. " +
                                            "Okay, we want s3 storage to handle the video files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                case "find a text in video": {
                                    String title = "FIND A TEXT IN VIDEO";

                                    String message = "Okay, you choose find a text in video task. " +
                                            "This task is useful to search some particular text is present or not in video. " +
                                            "Okay, we want s3 storage to handle the video files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                case "find a object in video": {
                                    String title = "FIND A OBJECT IN VIDEO";

                                    String message = "Okay, you choose find a object in video task. " +
                                            "This task is useful to search some particular object is present or not in video. " +
                                            "Okay, we want s3 storage to handle the video files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                case "find a adult in video": {
                                    String title = "FIND A ADULT IN VIDEO";

                                    String message = "Okay, you choose find a adult in video task. " +
                                            "This task is useful to detect any adult content is present or not video. " +
                                            "Okay, we want s3 storage to handle the video files. " +
                                            sMessage;

                                    Map<String, Object> session = new HashMap<>();

                                    session.put("task_name", taskName);
                                    session.put("repeat_message", message);
                                    session.put("repeat_re_prompt_message", message);

                                    return getSimpleResponse(input,title,message,message,rePrompt,session);
                                }
                                default:
                                    return fallbackResponse(input);
                            }
                        }
                        else
                        {
                            return fallbackResponse(input);
                        }

                    }
                    else
                    {
                        return fallbackResponse(input);
                    }
                }
                else
                {
                    return fallbackResponse(input);
                }
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
