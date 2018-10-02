package com.epam.audiomanager.logic.find;

import com.epam.audiomanager.database.dao.DAOManager;
import com.epam.audiomanager.database.dao.impl.audio.AudioTrackDAO;
import com.epam.audiomanager.entity.audio.AudioTrack;
import com.epam.audiomanager.exception.ProjectException;
import java.util.List;

public class SearchLogic {
    public static List<AudioTrack> findAllTracks() throws ProjectException {
        List<AudioTrack> audioTracks = null;

        DAOManager daoManager = new DAOManager();
        AudioTrackDAO audioTrackDAO = new AudioTrackDAO();
        try {
            daoManager.startDAO(audioTrackDAO);
            audioTracks = audioTrackDAO.findAll();
        } finally {
            daoManager.endDAO();
        }
        return audioTracks;
    }
}
