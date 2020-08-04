package engine.mapper;

import engine.dto.QuizDto;
import engine.entity.Quiz;
import org.springframework.stereotype.Service;

@Service
public class QuizMapper {

    public QuizDto toQuizDto(Quiz quiz) {
        QuizDto quizDto = new QuizDto();
        quizDto.setId(quiz.getId());
        quizDto.setTitle(quiz.getTitle());
        quizDto.setText(quiz.getText());
        quizDto.setOptions(quiz.getOptions());
        quizDto.setAnswer(quiz.getAnswer());
        return quizDto;
    }

    public Quiz toQuiz(QuizDto quizDto) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizDto.getTitle());
        quiz.setText(quizDto.getText());
        quiz.setOptions(quizDto.getOptions());
        quiz.setAnswer(quizDto.getAnswer());
        return quiz;
    }
}
