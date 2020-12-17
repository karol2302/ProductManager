package net.codejava.Controller;

import net.codejava.models.Produkt;
import net.codejava.models.ProduktCountry;
import net.codejava.services.ProduktCountryService;
import net.codejava.services.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

	@Autowired
	private ProduktService service;

	@Autowired
	private ProduktCountryService serviceCountry;

	@RequestMapping("/Country")
	public String viewCountryPage(Model model) {
		List<ProduktCountry> listCountry = serviceCountry.listAll();
		model.addAttribute("listCountries", listCountry);

		return "country";
	}



	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Produkt> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		model.addAttribute("CountProducts", listProducts.size());
		model.addAttribute("CountCountries", serviceCountry.listAll().size());
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Produkt product = new Produkt();
		model.addAttribute("product", product);
		
		return "new_product";
	}

	@RequestMapping("/new_Country")
	public String showNewCountryPage(Model model) {
		ProduktCountry pc = new ProduktCountry();
		model.addAttribute("productCountry", pc);

		return "new_country";
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Produkt product) {
		//System.out.println(product.getMadein_id());


		ProduktCountry pc = serviceCountry.getByName(product.getMadein_id().getName());
    	if (pc==null)
		{
			ProduktCountry p = new ProduktCountry(product.getMadein_id().getName());
			product.setMadein_id(p);
			serviceCountry.save(p);
		}
		else
		{
			product.setMadein_id(pc);
		}
		service.save(product);
		return "redirect:/";
	}

	@RequestMapping(value = "/saveCountry", method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute("productCountry") ProduktCountry pc) {
		//System.out.println(product.getMadein_id());
		ProduktCountry p;
		if (pc.getId() == null)
		{
			if (serviceCountry.getByName(pc.getName())==null)
				p = new ProduktCountry(pc.getName());
			else
				return "redirect:/Country";
		}
		else {
			 p = serviceCountry.get(pc.getId());
			p.setName(pc.getName());
		}
			//ProduktCountry p = new ProduktCountry(pc.getName());
		serviceCountry.save(p);
		return "redirect:/Country";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Produkt product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}

	@RequestMapping("/editCountry/{id}")
	public ModelAndView showEditProductCountryPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_country");
		ProduktCountry pc = serviceCountry.get(id);
		mav.addObject("productCountry", pc);
		return mav;
	}

	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}

	@RequestMapping("/deleteCountry/{id}")
	public String deleteCountryProduct(@PathVariable(name = "id") int id) {
		serviceCountry.delete(id);
		return "redirect:/";
	}
}
