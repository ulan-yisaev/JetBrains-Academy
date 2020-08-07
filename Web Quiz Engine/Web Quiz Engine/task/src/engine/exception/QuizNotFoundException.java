package engine.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Quiz not found")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class QuizNotFoundException extends RuntimeException{

    long id;

    public QuizNotFoundException(long id){
        this.id = id;
        getMessage();
    }

//    public QuizNotFoundException(Quiz quiz){
//        this.id = quiz.getId();
//        getMessage();
//    }

   @Override
    public String getMessage(){
       return "There is no quiz with id " + id;
   }
}
