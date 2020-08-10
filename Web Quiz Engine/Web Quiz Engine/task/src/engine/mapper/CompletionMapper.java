package engine.mapper;

import engine.dto.CompletionDto;
import engine.entity.Completion;
import org.springframework.stereotype.Service;

@Service
public class CompletionMapper {

    public CompletionDto toCompletionDto(Completion completion) {
        CompletionDto cDto = new CompletionDto();
//        cDto.setId(completion.getId());  <- Wrong answer in test #42 ;;; The element at path "/content/0/id" should equal to 3
        cDto.setId(completion.getQuiz().getId());
        cDto.setCompletedAt(completion.getCompletedAt());
        return cDto;
    }
}