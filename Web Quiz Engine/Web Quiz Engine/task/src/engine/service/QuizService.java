package engine.service;

import engine.dto.QuizDto;
import engine.entity.*;
import engine.exception.QuizNotFoundException;
import engine.mapper.QuizMapper;
import engine.repository.CompletionRepository;
import engine.repository.QuizRepository;
import engine.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final CompletionRepository completionRepository;
    private final QuizMapper quizMapper;

    public QuizService(QuizRepository quizRepository, UserRepository userRepository, CompletionRepository completionRepository, QuizMapper quizMapper) {
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
        this.completionRepository = completionRepository;
        this.quizMapper = quizMapper;
    }

    public Page<QuizDto> findAll(int page, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(page, pageSize, Sort.by(sortBy));
        return quizRepository.findAll(paging)
                .map(quizMapper::toQuizDto);
//                .stream().map(quizMapper::toQuizDto).collect(Collectors.toList());
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
        if (quiz.getUser().getEmail().equals(email)) {
            quizRepository.delete(quiz);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    public Feedback solveQuiz(Long id, Answer answer, String email) {
        Quiz quiz = quizRepository.findById(id)
                .orElseThrow(() -> new QuizNotFoundException(id));
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
        if (quiz.getAnswer().equals(answer.getAnswer())) {
            completionRepository.save(new Completion(quiz, user)); // LocalDateTime.now()));
            return new Feedback(true);
        } else {
            return new Feedback(false);
        }
    }
}