package com.hburak.projects.quizcms.service.implementation;

import com.hburak.projects.quizcms.domain.dto.question.QuestionGetDTO;
import com.hburak.projects.quizcms.domain.dto.quiz.*;
import com.hburak.projects.quizcms.domain.entity.*;
import com.hburak.projects.quizcms.repository.QuizRepository;
import com.hburak.projects.quizcms.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {
    private final QuizRepository repository;

    @Override
    public List<QuizGetDTO> getAll() {
        return repository.findAll().stream().map(quiz -> {
            QuizGetDTO quizGetDTO = new QuizGetDTO();
            quizGetDTO.setId(quiz.getId());
            quizGetDTO.setName(quiz.getName());
            quizGetDTO.setDescription(quiz.getDescription());
            quizGetDTO.setLanguageId(quiz.getLanguage().getId());
            quizGetDTO.setPlatformId(quiz.getPlatform().getId());
            return quizGetDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public List<QuizGetExtendedDTO> getAllExtended() {
        return repository.findAll().stream().map(quiz -> {
            QuizGetExtendedDTO quizGetDTO = new QuizGetExtendedDTO();
            quizGetDTO.setId(quiz.getId());
            quizGetDTO.setName(quiz.getName());
            quizGetDTO.setDescription(quiz.getDescription());
            quizGetDTO.setLanguageId(quiz.getLanguage().getId());
            quizGetDTO.setPlatformId(quiz.getPlatform().getId());
            quizGetDTO.setQuestions(quiz.getQuestions().stream().map(question -> {
                QuestionGetDTO questionGetDTO = new QuestionGetDTO();
                questionGetDTO.setAnswers(question.getAnswers());
                questionGetDTO.setContent(question.getContent());
                questionGetDTO.setHint(question.getHint());
                questionGetDTO.setId(question.getId());
                questionGetDTO.setLangId(question.getLanguage().getId());
                return questionGetDTO;
            }).collect(Collectors.toList()));
            return quizGetDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public Long save(QuizCreateDTO quizCreateDTO) {
        Quiz quiz = Quiz.builder()
                .name(quizCreateDTO.getName())
                .description(quizCreateDTO.getDescription())
                .language(new Language(quizCreateDTO.getLanguageId()))
                .platform(new Platform(quizCreateDTO.getPlatformId()))
                .categories(quizCreateDTO.getCategoryIds().stream().map(Category::new).collect(Collectors.toList()))
                .questions(quizCreateDTO.getQuestionIds().stream().map(Question::new).collect(Collectors.toList()))
                .build();
        return repository.save(quiz).getId();
    }

    @Override
    public void update(Long id, QuizCreateDTO quizCreateDTO) {
        if (repository.existsById(id)) {
            Quiz quiz = repository.getOne(id);
            quiz.setName(quizCreateDTO.getName());
            quiz.setDescription(quizCreateDTO.getDescription());
            quiz.setPlatform(new Platform(quizCreateDTO.getPlatformId()));
            quiz.setLanguage(new Language(quizCreateDTO.getLanguageId()));
            quiz.setCategories(quizCreateDTO.getCategoryIds().stream().map(aLong -> {
                return new Category(aLong);
            }).collect(Collectors.toList()));
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public QuizGetDTO getOne(Long id) {
        Quiz quiz = repository.getOne(id);
        QuizGetDTO quizGetDTO = new QuizGetDTO();
        quizGetDTO.setId(quiz.getId());
        quizGetDTO.setName(quiz.getName());
        quizGetDTO.setDescription(quiz.getDescription());
        quizGetDTO.setPlatformId(quiz.getPlatform().getId());
        quizGetDTO.setLanguageId(quiz.getLanguage().getId());
        return quizGetDTO;
    }

    @Override
    public void updateQuestionsOfQuiz(Long id, QuizQuestionUpdateDTO platformCategoryUpdateDTO) {
        Quiz quiz = repository.getOne(id);
        List<Question> questions = quiz.getQuestions();
        for (Long q : platformCategoryUpdateDTO.getQuestionIds()) {
            Question q1 = new Question(q);
            questions.add(q1);
        }
        repository.save(quiz);
    }

    @Override
    public void updatePlatformOfQuiz(Long id, QuizPlatformUpdateDTO quizPlatformUpdateDTO) {
        Quiz quiz = repository.getOne(id);
        Platform platform = new Platform(quizPlatformUpdateDTO.getPlatform());
        quiz.setPlatform(platform);
        platform.getQuizzes().add(quiz);
    }

    @Override
    public void updateLanguageOfQuiz(Long id, QuizLanguageUpdateDTO quizLanguageUpdateDTO) {
        Quiz quiz = repository.getOne(id);
        Language language = new Language(quizLanguageUpdateDTO.getLanguageId());
        quiz.setLanguage(language);
    }
}
