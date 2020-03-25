package com.employee.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeedata.pojo.EmpDao;
import com.employeedata.pojo.EmpPojo;
import com.sun.tools.javac.util.List;

@Controller
public class EmployeeController {
	@Autowired
	EmpDao dao;//will inject dao from XML file  

	public EmpDao getDa() {
		return dao;
	}
	public void setDa(EmpDao dao) {
		this.dao = dao;
	}

	/*It displays a form to input data, here "command" is a reserved request attribute  
	 *which is used to display object data into form  
	 */  

	@RequestMapping(value = {"/addinformation","/edit/addinformation"})
	public String insertData(Model m)
	{
		m.addAttribute("command", new EmpPojo());
		return "empform";
	}

	/*It saves object into database. The @ModelAttribute puts request data  
	 *  into model object. You need to mention RequestMethod.POST method   
	 *  because default request is GET*/

	@RequestMapping(value= {"/savedata","/edit/savedata"},method = RequestMethod.POST)    
	public String saveData(@ModelAttribute("emp") EmpPojo emp,@RequestParam ("name") String name,@RequestParam ("email") String email,@RequestParam ("company") String company,@RequestParam ("salary") String salary,@RequestParam ("designation") String designation,@RequestParam ("id") int id,Model m){ 
		dao.insert(emp);
		m.addAttribute("namevalue",name);
		m.addAttribute("emailvalue",email);
		m.addAttribute("companyvalue",company);
		m.addAttribute("salaryvalue", salary);
		m.addAttribute("designationvalue",designation);
		m.addAttribute("idvalue",id);
		if(id > 0 && id < 1000)
		{
			// Need to connect with dao.getEmployees() to validate duplicate ID entries;

			return "addsuccess";
		}
		else
		{

			// Need to handle Error page

			return ""; 
		}

	}

	/* It provides list of employees in model object */   

	@RequestMapping ("/viewemp")
	public String viewData(Model m)
	{
		java.util.List<EmpPojo> list = dao.getEmployees();
		m.addAttribute("list", list);
		return "viewform";
	}

	/* It deletes record for the given id in URL and redirects to /registrationform.com/viewemp */

	@RequestMapping (value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteData(@PathVariable int id)
	{
		dao.delete(id);
		return "redirect:/registrationform.com/viewemp";
	}

	/* It displays object data into form for the given id.   
	 * The @PathVariable puts URL data into variable.*/

	@RequestMapping (value = "/edit/{id}")
	public String editData(@PathVariable int id,Model m)
	{
		EmpPojo emp = dao.empDetailById(id);
		m.addAttribute("command",emp);
		return "empeditform";
	}

	/* It updates model object. */

	@RequestMapping (value = "edit/editsave", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("emp") EmpPojo emp)
	{
		int status = dao.update(emp);
		System.out.println(status);
		return "redirect:/registrationform.com/editsuccessfully";
	}

	@RequestMapping ("/editsuccessfully")
	public String editSuccess()
	{
		return "editsuccess";
	}

	@RequestMapping ("/edit/getinformpage")
	public String editGetinformAdd()
	{
		return "redirect:/registrationform.com/getinformpage";
	}

	@RequestMapping ("/edit/viewemp")
	public String editGetinformView()
	{
		return "redirect:/registrationform.com/viewemp";
	}

	@RequestMapping (value = {"/admin_addemployee","/edit/admin_addemployee"})
	public String adminAddEmp(Model m)
	{
		m.addAttribute("command", new EmpPojo());
		return "admin_empform";
	}

	@RequestMapping (value = {"admin_savedata","/edit/admin_savedata"} ,method = RequestMethod.POST)
	public String adminSaveData(@ModelAttribute("emp") EmpPojo emp){ 
		dao.insert(emp);  
		return "redirect:/registrationform.com/admin_addsuccesfully"; //will redirect to admin_addsuccesfully request mapping      
	}

	@RequestMapping ("/admin_addsuccesfully")
	public String adminAddSuccess()
	{
		return "admin_addsuccess";
	}

	@RequestMapping (value = "/employee_search" ,method = RequestMethod.POST)
	public String searchEmp(@RequestParam ("freetext") String freetext,Model m)
	{
		java.util.List<EmpPojo> emp = dao.empSearch(freetext);
		System.out.println(emp);
		m.addAttribute("command",emp);
		return "searched_emp";
	}
}