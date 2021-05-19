package tech.itpark.jdbc.manager;

import org.springframework.stereotype.Component;
import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;
import tech.itpark.jdbc.domain.Media;
import tech.itpark.jdbc.exception.InitializationException;
import tech.itpark.jdbc.exception.MediaUploadException;
import tech.itpark.jdbc.exception.UnsupportedContentTypeException;

import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;


@Component
public class MediaManager {
    private final Path mediaPath = Path.of("./static/media");
    private final Tika tika =new Tika();
    private final Map <String, String > extensions = Map.of(
            "image/jpeg", ".jpeg"
            );

    public MediaManager() {
        try {
            Files.createDirectories(mediaPath);
        } catch (IOException e) {
            throw new InitializationException("can not create directories", e);
        }
    }

    public Media save(MultipartFile file) {
        try {
            String name = UUID.randomUUID().toString();
            String contentType = tika.detect(file.getInputStream());
            String extension = extensions.get(contentType);
            if (extension == null) {
                throw new UnsupportedContentTypeException(contentType);
            }
            String fullname = name + extension;
            file.transferTo(mediaPath.resolve(fullname));
            return new Media("/media/" + fullname);
        } catch (IOException e) {
            throw new MediaUploadException(e);
        }
    }
}
