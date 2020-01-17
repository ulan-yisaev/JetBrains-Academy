package com.sboot.controllers;

import com.sboot.form.PersonForm;
import com.sboot.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    private static List<Person> persons = new ArrayList<>();

    /* Static block (also called static clause). This code inside static block is executed only once: the first time you make an object
    of that class or the first time you access a static member of that class (even if you never make an object of that class).
    Also, static blocks are executed before constructors.*/
    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }

    //We can use @Value for injecting property values into beans. It's compatible with constructor, setter, and field injection.
    //Of course, injecting static values isn't useful. Therefore, we can use placeholder strings in @Value to wire values
    // defined in external sources, for example, in .properties or .yaml files. (//application.properties in this case:)
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    //    MVC (Model-View-Controller) is a software architecture pattern, which separates application into three parts: model, view, and controller. The model
    //    represents a Java object carrying data. The view visualizes the data that the model contains. The controller manages the data flow into model object
    //    and updates the view whenever data changes; it keeps view and model separate.
    //    Spring MVC is the original web framework built on the Servlet API. It is build on the MVC design pattern. Spring Framework 5.0 introduced a parallel
    //    reactive stack web framework called Spring WebFlux.

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        // the model can supply attributes used for rendering views.
        //To provide a view with usable data, we simply add this data to its Model object.
        //All the data, we place within this model, is used by a view – in general, a templated view to render the web page.
        //If we have a Thymeleaf template file targeted by our controller's methods as their view. A parameter passed through
        // the model will be accessible from within the thymeleaf HTML code
        model.addAttribute("message", message);
        //The return keyword returns the name of the view
        return "index";
    }

    //The @GetMapping maps the /personList URL pattern to the personList() method.
    //In the personList() method, we use the Model. It receives a message attribute with the addAttribute() method.
    // Model defines a holder for model attributes and is primarily designed for adding attributes to the model.
    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String personList(Model model) {

        model.addAttribute("persons", persons);
        //The return keyword returns the name of the view
        return "personList";
    }

    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);

        return "addPerson";
    }

    //The @ModelAttribute is an annotation that binds a method parameter or method return value to a named model attribute and then exposes it to a web view.
    //When used as a method argument, it indicates the argument should be retrieved from the model.
    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.POST)
    public String savePerson(Model model, //
                             @ModelAttribute("personForm") PersonForm personForm) {

        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();

        if (firstName != null && firstName.length() > 0 //
                && lastName != null && lastName.length() > 0) {
            Person newPerson = new Person(firstName, lastName);
            persons.add(newPerson);

            return "redirect:/personList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }

}
