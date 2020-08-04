package engine.controller;

import engine.dto.QuizDto;
import engine.entity.Answer;
import engine.entity.Feedback;
import engine.entity.Quiz;
import engine.exception.QuizNotFoundException;
import engine.service.QuizService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {this.quizService = quizService;}

    //    int id = 0;
    /*Map<Integer, Quiz> quizzes = new HashMap<>();
    public QuizController() {
        quizzes.put(id, new Quiz(id++, "Coffee drinks", "Select only coffee drinks.",
                new ArrayList<>(List.of("Americano", "Tea", "Cappuccino", "Sprite")),
                new HashSet<>(Set.of(0, 2))));
        quizzes.put(id, new Quiz(id++, "Coffee drinks", "Select only coffee drinks.",
                new ArrayList<>(List.of("Americano", "Tea", "Cappuccino", "Sprite")),
                new HashSet<>(Set.of(0, 2))));
//        quizzes.entrySet().forEach(System.out::println);
    }*/

    @GetMapping("/api/quizzes/{id}")
    private QuizDto getQuizById(@PathVariable Long id) throws QuizNotFoundException {
        return quizService.getById(id);
    }

    @GetMapping("/api/quizzes")
    private List<QuizDto> getAllQuizzes() {
        return quizService.findAll();
    }

    @PostMapping("/api/quizzes")
    private QuizDto createQuiz(@Valid @RequestBody QuizDto quizDto) {
        return quizService.save(quizDto);
    }

    // removed @RequestBody due to
// {"timestamp":"2020-03-03T10:30:44.119+0000","status":415,"error":"Unsupported Media Type","message":"Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported","path":"/api/quiz"}
    @PostMapping("/api/quizzes/{id}/solve")
    private Feedback solveQuiz(@PathVariable Long id, @RequestBody Answer answer) {

        Feedback feedback = new Feedback();

        if (quizService.getById(id).getAnswer().equals(answer.getAnswer())) {
            feedback.setSuccess(true);
            feedback.setFeedback("Congratulations, you're right!");
        } else {
            feedback.setSuccess(false);
            feedback.setFeedback("Wrong answer! Please, try again.");
        }

        return feedback;
    }
}