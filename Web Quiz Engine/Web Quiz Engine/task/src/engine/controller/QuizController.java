package engine.controller;

import engine.entity.Answer;
import engine.entity.Feedback;
import engine.entity.Quiz;
import engine.exception.QuizNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
//@RequestMapping("/api/quiz")
public class QuizController {

//    int id = 0;
    Map<Integer, Quiz> quizzes = new HashMap<>();

    /*public QuizController() {
        quizzes.put(id, new Quiz(id++, "Coffee drinks", "Select only coffee drinks.",
                new ArrayList<>(List.of("Americano", "Tea", "Cappuccino", "Sprite")),
                new HashSet<>(Set.of(0, 2))));
        quizzes.put(id, new Quiz(id++, "Coffee drinks", "Select only coffee drinks.",
                new ArrayList<>(List.of("Americano", "Tea", "Cappuccino", "Sprite")),
                new HashSet<>(Set.of(0, 2))));
//        quizzes.entrySet().forEach(System.out::println);
    }*/

    @GetMapping("/api/quizzes/{id}")
    private Quiz getQuizById(@PathVariable int id) throws QuizNotFoundException {
        if (!quizzes.containsKey(id)) throw new QuizNotFoundException(id);
        return quizzes.get(id);
    }

    @GetMapping("/api/quizzes")
    private Collection<Quiz> getAllQuizzes() {
        return quizzes.values();
    }

    @PostMapping("/api/quizzes")
    private Quiz createQuiz(@Valid @RequestBody Quiz quiz) {
        int id = quizzes.size();
        quiz.setId(id);
        quizzes.put(id, quiz);
//        quizzes.entrySet().forEach(System.out::println);
//        id++;
        return quizzes.get(id);
    }

    // removed @RequestBody due to
// {"timestamp":"2020-03-03T10:30:44.119+0000","status":415,"error":"Unsupported Media Type","message":"Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported","path":"/api/quiz"}
    @PostMapping("/api/quizzes/{id}/solve")
    private Feedback solveQuiz(@PathVariable int id, @RequestBody Answer answer) {

        if (!quizzes.containsKey(id)) throw new QuizNotFoundException(id);

        Feedback feedback = new Feedback();
//        System.out.println("quizzes.get(id).getAnswer(): " + quizzes.get(id).getAnswer());
//        System.out.println("answer.getAnswer(): " + answer.getAnswer());

        if (quizzes.get(id).getAnswer().equals(answer.getAnswer())) {
            feedback.setSuccess(true);
            feedback.setFeedback("Congratulations, you're right!");
        } else {
            feedback.setSuccess(false);
            feedback.setFeedback("Wrong answer! Please, try again.");
        }

        return feedback;
    }
}