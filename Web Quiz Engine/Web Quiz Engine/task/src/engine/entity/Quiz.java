package engine.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String text;

    @ElementCollection
    private List<String> options;

    @ElementCollection
    // means that the collection is not a collection of entities, but a collection of simple types (Strings, etc.)
// It also means that the elements are completely owned by the containing entities: they're modified when the entity is modified, deleted when the entity is deleted, etc. They can't have their own lifecycle.
    private Set<Integer> answer;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Completion> completions;

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
//        Set<Integer> x = null;
//        if (Objects.equals(x, answer)) {
//            Set<Integer> emptySet = new HashSet<>();
//            return emptySet;
//        }
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Completion> getCompletions() {
        return completions;
    }

    public void setCompletions(List<Completion> completions) {
        this.completions = completions;
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
