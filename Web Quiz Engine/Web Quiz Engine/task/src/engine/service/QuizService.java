package engine.service;

import engine.dto.QuizDto;
import engine.entity.Quiz;
import engine.entity.User;
import engine.exception.QuizNotFoundException;
import engine.mapper.QuizMapper;
import engine.repository.QuizRepository;
import engine.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, UserRepository userRepository, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
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

    public QuizDto save(QuizDto quizDto, String author) {
        User user = userRepository.findByEmail(author)
                .orElseThrow(() -> new UsernameNotFoundException(author));
        Quiz quiz = quizMapper.toQuiz(quizDto);
        quiz.setUser(user);
        Quiz savedQuiz = quizRepository.save(quiz);
        return quizMapper.toQuizDto(savedQuiz);
    }

    public void delete(Long id, String email) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id));
//        System.out.println("----- String email: " + email);
//        System.out.println("----- quiz.getUser().getEmail(): " + quiz.getUser().getEmail());
        if (quiz.getUser().getEmail().equals(email)) {
            quizRepository.delete(quiz);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
}
