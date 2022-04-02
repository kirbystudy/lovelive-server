package com.lovelive.repository;

import com.lovelive.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author 小埋
 * @version 1.0
 * @Description TODO
 * @Date 2022/4/1 18:06
 */
public interface FileRepository extends JpaRepository<FileEntity, String> {
}
