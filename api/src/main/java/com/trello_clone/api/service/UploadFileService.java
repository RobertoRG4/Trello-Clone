package com.trello_clone.api.service;

import com.trello_clone.api.entity.File;
import com.trello_clone.api.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class UploadFileService {

    private final FileRepository fileRepository;

    public void saveFile(MultipartFile file) throws IOException {
        File newFile = new File(file.getOriginalFilename(), file.getBytes());
        fileRepository.save(newFile);
    }
}

