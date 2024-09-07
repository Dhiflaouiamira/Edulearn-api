package com.tekup.EduLearnapi.Service;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tekup.EduLearnapi.dto.BlogDTO;
import com.tekup.EduLearnapi.dto.CommentaireDTO;
import com.tekup.EduLearnapi.dto.PaiementDTO;
import com.tekup.EduLearnapi.dto.ReclamationDTO;
import com.tekup.EduLearnapi.dto.UserDTO;
import com.tekup.EduLearnapi.mappers.BlogMapper;
import com.tekup.EduLearnapi.mappers.CommentaireMapper;
import com.tekup.EduLearnapi.mappers.PaiementMapper;
import com.tekup.EduLearnapi.mappers.ReclamationMapper;
import com.tekup.EduLearnapi.mappers.UserMapper;
import com.tekup.EduLearnapi.model.Blog;
import com.tekup.EduLearnapi.model.Commentaire;
import com.tekup.EduLearnapi.model.Cours;
import com.tekup.EduLearnapi.model.Paiement;
import com.tekup.EduLearnapi.model.Reclamation;
import com.tekup.EduLearnapi.model.User;
import com.tekup.EduLearnapi.repository.BlogRepository;
import com.tekup.EduLearnapi.repository.CommentaireRepository;
import com.tekup.EduLearnapi.repository.CoursRepository;
import com.tekup.EduLearnapi.repository.ReclamationRepository;
import com.tekup.EduLearnapi.repository.UserRepository;
import com.tekup.EduLearnapi.repository.PaiementRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserServicesImpl implements UserServices {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CommentaireRepository commentaireRepository;

    @Autowired
    private final ReclamationRepository reclamationRepository;

    @Autowired
    private final PaiementRepository paiementRepository;

    @Autowired
    private final BlogRepository blogRepository;

    @Autowired
    private final CoursRepository coursRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public Page<UserDTO> getAllUsers(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserMapper::convertToDto);
    }

    @Override
    public UserDTO addOneUser(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = UserMapper.convertToEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.convertToDto(savedUser);
    }

    @Override
    public void deleteOneUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<UserDTO> findOneUser(long id) {
        return userRepository.findById(id).map(UserMapper::convertToDto);
    }

    @Override
    public UserDTO assignCommentaireToUser(long userId, CommentaireDTO commentaireDTO) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Commentaire commentaire = CommentaireMapper.convertToEntity(commentaireDTO);
        commentaire.setUser(user);

        Cours cours = coursRepository.findById(commentaireDTO.getCoursId())
            .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        commentaire.setCours(cours);

        commentaireRepository.save(commentaire);
        return UserMapper.convertToDto(user);
    }

    @Override
    public Optional<UserDTO> updateOneUser(Long id, UserDTO userDTO) {
        return userRepository.findById(id).map(user -> {
            user.setNom(userDTO.getNom());
            user.setPrenom(userDTO.getPrenom());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole());
            user.setDateDeNaissance(userDTO.getDateDeNaissance());
            user.setTelephone(userDTO.getTelephone());
            user.setCin(userDTO.getCin());
            user.setGenre(userDTO.getGenre());

            userRepository.save(user);
            return UserMapper.convertToDto(user);
        });
    }

    @Override
    public UserDTO assignPaiementToUser(long userId, PaiementDTO paiementDTO) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Paiement paiement = PaiementMapper.convertToEntity(paiementDTO);
        paiement.setUser(user);
        paiementRepository.save(paiement);
        return UserMapper.convertToDto(user);
    }

    @Override
    public Page<UserDTO> getUsersByRole(String role, Pageable pageable) {
        Page<User> usersByRole = userRepository.findByRole(role, pageable);
        return usersByRole.map(UserMapper::convertToDto);
    }

    @Override
    public UserDTO assignReclamationToUser(long userId, ReclamationDTO reclamationDTO) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Reclamation reclamation = ReclamationMapper.convertToEntity(reclamationDTO);
        reclamation.setUser(user);
        reclamationRepository.save(reclamation);
        return UserMapper.convertToDto(user);
    }

    @Override
    public UserDTO assignBlogToUser(long userId, BlogDTO blogDTO) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Blog blog = BlogMapper.convertToEntity(blogDTO);
        blog.setUser(user);
        blogRepository.save(blog);
        return UserMapper.convertToDto(user);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
 


   }

