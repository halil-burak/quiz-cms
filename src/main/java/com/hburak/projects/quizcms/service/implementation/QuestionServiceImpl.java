package com.hburak.projects.quizcms.service.implementation;

import com.hburak.projects.quizcms.domain.dto.question.QuestionCreateDTO;
import com.hburak.projects.quizcms.domain.dto.question.QuestionGetDTO;
import com.hburak.projects.quizcms.domain.entity.Question;
import com.hburak.projects.quizcms.domain.entity.Quiz;
import com.hburak.projects.quizcms.repository.LanguageRepository;
import com.hburak.projects.quizcms.repository.QuestionRepository;
import com.hburak.projects.quizcms.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository repository;
    private final LanguageRepository languageRepository;

    @Override
    public List<QuestionGetDTO> getAll() {
        return repository.findAll().stream().map(question -> {
                QuestionGetDTO questionGetDTO = new QuestionGetDTO();
                questionGetDTO.setContent(question.getContent());
                questionGetDTO.setHint(question.getHint());
                questionGetDTO.setId(question.getId());
                questionGetDTO.setLangId(question.getLanguage().getId());
                questionGetDTO.setAnswers(question.getAnswers());
                questionGetDTO.setQuizIds(question.getQuizzes().stream().map(Quiz::getId).collect(Collectors.toList()));
                return questionGetDTO;
            }
        ).collect(Collectors.toList());
    }

    @Override
    public Long save(QuestionCreateDTO questionCreateDTO) {
        Question question = Question.builder()
                .answers(questionCreateDTO.getAnswers())
                .content(questionCreateDTO.getContent())
                .hint(questionCreateDTO.getHint())
                // new Language(questionCreateDTO.getLangId()
                // )
                .language(languageRepository.getOne(questionCreateDTO.getLangId()))
                .quizzes(questionCreateDTO.getQuizIds().stream().map(aLong -> {
                    Quiz quiz = new Quiz();
                    quiz.setId(aLong);
                    return quiz;
                }).collect(Collectors.toList()))
                .build();

        return repository.save(question).getId();
    }

    @Override
    public void update(Long id, QuestionCreateDTO platformUpdateDTO) {

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public QuestionGetDTO getOne(Long id) {
        QuestionGetDTO questionGetDTO = new QuestionGetDTO();
        Question question = repository.getOne(id);
        questionGetDTO.setId(question.getId());
        questionGetDTO.setQuizIds(question.getQuizzes().stream().map(Quiz::getId).collect(Collectors.toList()));
        questionGetDTO.setAnswers(question.getAnswers());
        questionGetDTO.setLangId(question.getLanguage().getId());
        questionGetDTO.setHint(question.getHint());
        questionGetDTO.setContent(question.getContent());
        return questionGetDTO;
    }
}
