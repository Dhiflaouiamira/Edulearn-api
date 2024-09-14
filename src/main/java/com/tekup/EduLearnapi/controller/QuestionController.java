package com.tekup.EduLearnapi.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.tekup.EduLearnapi.Service.ChapitreServices;
import com.tekup.EduLearnapi.Service.QuestionServices;
import com.tekup.EduLearnapi.dto.ChapitreDTO;
import com.tekup.EduLearnapi.dto.QuestionDTO;
import com.tekup.EduLearnapi.mappers.QuestionMapper;
import com.tekup.EduLearnapi.model.Question;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuestionController {
    
    private final QuestionServices questionService;
    private final ChapitreServices chapitreServices;

    // Only ADMIN and TEACHER can create questions
    @PostMapping("/create-new-question")
    public ResponseEntity<Question> createQuestion(@Valid @RequestBody Question question){
        Question createdQuestion = questionService.createQuestion(question);
        return ResponseEntity.status(CREATED).body(createdQuestion);
    }

    // ADMIN and TEACHER can view all questions
    @GetMapping("/all-questions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    // ADMIN and TEACHER can fetch a question by ID
    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) throws EntityNotFoundException {
        Optional<Question> theQuestion = questionService.getQuestionById(id);
        return theQuestion.map(ResponseEntity::ok)
                          .orElseThrow(EntityNotFoundException::new);
    }

    // Only ADMIN and TEACHER can update a question
    @PutMapping("/question/{id}/update")
    public ResponseEntity<Question> updateQuestion(
            @PathVariable Long id, @RequestBody Question question) throws ChangeSetPersister.NotFoundException {
        Question updatedQuestion = questionService.updateQuestion(id, question);
        return ResponseEntity.ok(updatedQuestion);
    }


    // Only ADMIN can delete a question
    @DeleteMapping("/question/{id}/delete")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }

    // Students can fetch random questions for quizzes based on chapitreId
    @GetMapping("/quiz/fetch-questions-for-user")
    public ResponseEntity<List<Question>> getQuestionsForUser(@RequestParam Integer numOfQuestions, @RequestParam Long chapitreId){
        List<Question> allQuestions = questionService.getQuestionsForUser(numOfQuestions, chapitreId);
        List<Question> mutableQuestions = new ArrayList<>(allQuestions);
        Collections.shuffle(mutableQuestions);

        int availableQuestions = Math.min(numOfQuestions, mutableQuestions.size());
        List<Question> randomQuestions = mutableQuestions.subList(0, availableQuestions);
        return ResponseEntity.ok(randomQuestions);
    }

    // Only ADMIN and TEACHER can assign a question to a chapitre
    @PostMapping("/{chapitreId}/question")
    public ResponseEntity<ChapitreDTO> assignToquestion(@PathVariable long chapitreId, @RequestBody QuestionDTO questionDTO) {
        try {
            ChapitreDTO chapitreDTO = chapitreServices.assignQuestionToChapitre(chapitreId, questionDTO);
            return ResponseEntity.ok(chapitreDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Only ADMIN and TEACHER can search questions by chapitre title
    @GetMapping("/searchByChapitre")
    public ResponseEntity<List<QuestionDTO>> findCoursesByChapitre(@RequestParam String titre) {
        List<QuestionDTO> questions = questionService.findQuestionByChapitre(titre)
                                                     .stream()
                                                     .map(QuestionMapper::convertToDto)
                                                     .collect(Collectors.toList());
        if (questions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(questions);
    }
}

	 