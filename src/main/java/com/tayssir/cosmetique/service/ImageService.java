package com.tayssir.cosmetique.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.tayssir.cosmetique.entities.Image;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;

	Image getImageDetails(Long id) throws IOException;

	ResponseEntity<byte[]> getImage(Long id) throws IOException;

	void deleteImage(Long id);
	
	Image uplaodImageCosm(MultipartFile file,Long idCosm) throws IOException;
	List<Image> getImagesParCosm(Long cosmId);
}
