package de.swe.d1.restsqlite.Controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/uploadapi")
public class UploadController {

    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "F://temp//";

    @GetMapping("/up")
    public String index() {
        return "upload";
    }
//,consumes = MULTIPART_FORM_DATA_VALUE,produces = APPLICATION_JSON_VALUE
   // @RequestMapping(name="/upload", method = RequestMethod.POST,consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
   // //new annotation since 4.3
    @CrossOrigin
  @PostMapping(value = "/upload", consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
   // @RequestMapping(name="/upload", method = RequestMethod.POST,consumes = MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
          //  redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "{\"status\":\"" + false + "\", \"msg\":\"Datei leer!.\"}";
           // return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            /*redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");*/
            return "{\"status\":\"" + true + "\", \"msg\":\"Upload erfolgreich.\"}";

        } catch (IOException e) {
            //e.printStackTrace();
        }
        return "{\"status\":\"" + false + "\", \"msg\":\"Ein Fehler ist aufgetreten!.\"}";
      //  return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}