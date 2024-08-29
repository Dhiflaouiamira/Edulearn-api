package com.tekup.EduLearnapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.tekup.EduLearnapi.Service.ChapitreServices;
import com.tekup.EduLearnapi.dto.SupportDTO;
import com.tekup.EduLearnapi.dto.ChapitreDTO;


//Java standard libraries
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

//Custom classes


@RestController
@RequestMapping("/api/chapitres")
public class ChapitreController {

    @Autowired
    private ChapitreServices chapitreServices;

    @GetMapping
    public Page<ChapitreDTO> getChapitres(Pageable pageable) {
        return chapitreServices.getAllChapitres(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChapitreDTO> getOneChapitre(@PathVariable long id) {
        return chapitreServices.findOneChapitre(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ChapitreDTO addOneChapitre(@RequestBody ChapitreDTO chapitreDTO) {
        return chapitreServices.addOneChapitre(chapitreDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChapitreDTO> updateChapitre(@PathVariable long id, @RequestBody ChapitreDTO chapitreDTO) {
        return chapitreServices.updateOneChapitre(id, chapitreDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteOneChapitre(@PathVariable long id) {
        chapitreServices.deleteOneChapitre(id);
    }
    
    @PostMapping("/support/{id}")
    public ResponseEntity<ChapitreDTO> assignToSupport(
            @PathVariable long id,
            @RequestParam("file") MultipartFile file,
            @RequestParam("titre") String titre,
            @RequestParam("description") String description,
            @RequestParam("dateCreation") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date dateCreation) {

        String fileUrl = saveFileAndGetUrl(file);

        SupportDTO supportDTO = new SupportDTO();
        supportDTO.setTitre(titre);
        supportDTO.setDescription(description);
        supportDTO.setFichierURL(fileUrl);
        supportDTO.setDateCreation(dateCreation);

        ChapitreDTO chapitreDTO = chapitreServices.assignSupportToChapitre(id, supportDTO);

        return ResponseEntity.ok(chapitreDTO);
    }

    private String saveFileAndGetUrl(MultipartFile file) {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get("C:/Users/user/Edulearn-api/uploads/" + fileName);

        try {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception properly
        }

        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/uploads/")
                .path(fileName)
                .toUriString();
    }
    
    

    @GetMapping("/cours/titre/{titre}")
    public List<ChapitreDTO> getChapitresByCoursTitre(@PathVariable("titre") String titre) {
        return chapitreServices.findChapitresByCoursTitre(titre);
    }
    
    
}
