package com.edvinas.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {
	@Autowired
	PersonDAO personDAO;
	
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ModelAndView getPersons(@RequestParam("street") String street){
		List<Person> persons;
		if(street.isEmpty()){
			persons=personDAO.getAll();
		}else{
			persons = personDAO.getPersonsInStreet(street);
		}
		ModelAndView model = new ModelAndView("find");
		model.addObject("persons", persons);
		model.addObject("street", street);
		return model;
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getAllPersons(){
		List<Person> persons;
		persons = personDAO.getAll();
		ModelAndView model = new ModelAndView("index");
		model.addObject("persons", persons);
		return model;
	}
	
	
	@RequestMapping(value = "/delete/{personID}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable String personID) {
        personDAO.deletePerson(Integer.parseInt(personID));
        return "redirect:/";
    }
	@RequestMapping(value = "/edit/{personID}", method = RequestMethod.GET)
    public ModelAndView editPerson(@PathVariable String personID) {
        ModelAndView model = new ModelAndView("edit");
        Person pers = personDAO.getPerson(Integer.parseInt(personID));
        model.addObject("selectedPerson", pers);
        model.addObject("person", new Person());
        return model;  
    }
	@RequestMapping(value = "/edit/{personID}", method = RequestMethod.POST)
    public String updatePerson(@ModelAttribute("person") Person person) {
		 personDAO.updatePerson(person);
		return "redirect:/";
	}
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView createPerson() {
        ModelAndView model = new ModelAndView("create");
        model.addObject("person", new Person());
        return model;  
    }
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPerson(@ModelAttribute("person") Person person) {
		if(person.getBirthYear().isEmpty() || person.getStreet().isEmpty() || person.getGender().isEmpty()){
			return "create";
		}
        personDAO.createPerson(person);
        return "redirect:/";
    }
}
