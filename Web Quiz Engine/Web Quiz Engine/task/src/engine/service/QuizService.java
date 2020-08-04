package engine.service;

import engine.dto.QuizDto;
import engine.entity.Quiz;
import engine.exception.QuizNotFoundException;
import engine.mapper.QuizMapper;
import engine.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.quizMapper = quizMapper;
    }

    public List<QuizDto> findAll() {
        return quizRepository.findAll()
                .stream()
                .map(quizMapper::toQuizDto)
                .collect(Collectors.toList());
    }

    public QuizDto getById(Long id) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id));
        return quizMapper.toQuizDto(quiz);
    }

    public QuizDto save(QuizDto quizDto) {
        Quiz quiz = quizMapper.toQuiz(quizDto);
        Quiz savedQuiz = quizRepository.save(quiz);
        return quizMapper.toQuizDto(savedQuiz);
    }
}
