package net.xdclass.service;


import org.springframework.web.multipart.MultipartFile;

/**
 * @author tangxuefei
 */
public interface FileService {


     String uploadUserImg(MultipartFile file);
}
