package com.epam.audiomanager.command.impl;

import com.epam.audiomanager.command.Command;
import com.epam.audiomanager.controller.Router;
import com.epam.audiomanager.entity.audio.AudioTrack;
import com.epam.audiomanager.exception.ProjectException;
import com.epam.audiomanager.logic.find.SearchLogic;
import com.epam.audiomanager.util.constant.ConstantAttributes;
import com.epam.audiomanager.util.constant.ConstantPathPages;
import com.epam.audiomanager.util.property.ConfigurationManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class SearchCommand implements Command {
    @Override
    public Router execute(HttpServletRequest httpServletRequest) throws ProjectException {
        Router router = new Router();
        List<AudioTrack> audioTracks = SearchLogic.findAllTracks();
        String page;
        if (!audioTracks.isEmpty()){
            page = ConfigurationManager.getProperty(ConstantPathPages.PATH_PAGE_MAIN_CLIENT_SEARCH);
            httpServletRequest.setAttribute(ConstantAttributes.AUDIO_TRACKS, audioTracks);
        } else {
            page = null;
        }
        router.setPagePath(page);
        return router;
    }
}
