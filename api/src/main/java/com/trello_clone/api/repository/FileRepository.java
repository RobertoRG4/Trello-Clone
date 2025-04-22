package com.trello_clone.api.repository;

import com.trello_clone.api.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
