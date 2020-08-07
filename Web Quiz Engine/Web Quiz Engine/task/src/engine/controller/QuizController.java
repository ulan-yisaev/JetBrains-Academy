package engine.controller;

import engine.dto.QuizDto;
import engine.entity.Answer;
import engine.entity.Feedback;
import engine.exception.QuizNotFoundException;
import engine.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
//@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {this.quizService = quizService;}

    /*    int id = 0;
    Map<Integer, Quiz> quizzes = new HashMap<>();
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
    private QuizDto createQuiz(@Valid @RequestBody QuizDto quizDto, Principal principal) {
        return quizService.save(quizDto, principal.getName());
    }

    @PostMapping("/api/quizzes/{id}/solve")
    private Feedback solveQuiz(@PathVariable Long id, @RequestBody Answer answer) {

        if (quizService.getById(id).getAnswer().equals(answer.getAnswer())) {
            return new Feedback(true);
        } else {
            return new Feedback(false);
        }
    }

    @DeleteMapping("/api/quizzes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)  //Wrong answer in test #153 :: DELETE /api/quizzes/3 should respond with status code 204, responded: 200
    private void deleteQuiz(@PathVariable Long id, Principal principal) {
        quizService.delete(id, principal.getName());
    }
}

//Principal: refers to the authenticated user object provided by Spring Security