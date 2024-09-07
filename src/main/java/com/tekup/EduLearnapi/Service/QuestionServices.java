package com.tekup.EduLearnapi.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.crossstore.ChangeSetPersister;

import com.tekup.EduLearnapi.model.Question;

public interface QuestionServices {

	
    Question createQuestion(Question question);

    List<Question> getAllQuestions();

    Optional<Question> getQuestionById(Long id);

    List<String> getAllSubjects();

    Question updateQuestion(Long id, Question question) throws ChangeSetPersister.NotFoundException;

    void  deleteQuestion(Long id);

    public List<Question> getQuestionsForUser(Integer numOfQuestions, Long chapitreId);
}
