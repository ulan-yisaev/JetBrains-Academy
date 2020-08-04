package engine.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Quiz {

    private long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Text is mandatory")
    private String text;

    @NotEmpty
    @NotNull
    @Size(min = 2, message = "an array of strings should contain at least 2 items")
    private List<String> options;

    //https://medium.com/@bhanuchaddha/using-jsonignore-or-jsonproperty-to-hide-sensitive-data-in-json-response-ad12b1aacbf3
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Integer> answer;
//    private int answer;

    public Quiz() {
    }

    public Quiz(String title, String text, List<String> options) {
        this.title = title;
        this.text = text;
        this.options = options;
    }

    public Quiz(long id, String title, String text, List<String> options, Set<Integer> answer) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /*
Daeryss 10 days ago
ok, some hints for this stage:

tests 100% contain someone like this (for simple view i write [quizzes answer] : [solving answer]):
[2, 0] : [2] - false (check all int in arrays)
[2, 0] : [0, 2] - true (sort! you can use bubble sort, its very simple!)
null : null - true
[] : null - true
null: [] - true
[] : [] - true
all variants with null i fixed in: */
    public Set<Integer> getAnswer() {
        Set<Integer> x = null;
        if (Objects.equals(x, answer)) {
            Set<Integer> emptySet = new HashSet<>();
            return emptySet;
        }
        return answer;
    }

    public void setAnswer(Set<Integer> answer) {
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", options=" + options +
                ", answer=" + answer +
                '}';
    }
}
