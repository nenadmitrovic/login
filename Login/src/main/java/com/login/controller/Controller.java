
package com.login.controller;

import com.login.domen.Company;
import com.login.domen.Descriptor;
import com.login.domen.Document;
import com.login.domen.Role;
import com.login.domen.User; 
import com.login.service.CompanyService;
import com.login.service.DescriptorService;
import com.login.service.DocumentService;
import com.login.service.RoleService;
import com.login.service.UserService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@MultipartConfig
@org.springframework.stereotype.Controller
public class Controller {
    
    
    @Autowired
    UserService userService;
    
    @Autowired
    CompanyService companyService;
    
    @Autowired
    RoleService roleService;
    
    @Autowired
    DescriptorService descriptorService;
    
    @Autowired
    DocumentService documentService;
    
    
    
    

    
    @RequestMapping("/")
    public ModelAndView start(){
        
        return new ModelAndView("login"); 
    } 
    
    
    
    @RequestMapping("/looseSearch")
    public @ResponseBody List<User> performLooseSearch(@RequestParam("CHARS") String chars){
        
        return userService.getUse(chars);
    }
    
   
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(defaultValue = "1") Integer page, HttpServletRequest request, String username, String password, ModelMap model){
        User user = userService.login(username, password);
        List<Company> companies = companyService.findByPage(page - 1);
        Long totalCompanies = companyService.pages();
        model.addAttribute("totalCompanies", totalCompanies);
        model.addAttribute("companies", companies);
        model.addAttribute("user", user);
        
        if(userService.isSuperAdmin(user)){
            request.getSession().setAttribute("superadmin", user);
            return "show_companies";
            
        }else if(userService.isDefault(user)){
            request.getSession().setAttribute("default", user);
            int companyId = user.getCompanyId();
            Company company = companyService.getById(companyId);
            return showUsersDefault(model, companyId);
            
        }else if(userService.isUser(user)){
            request.getSession().setAttribute("others", user);
            List<Document> documents = documentService.getAll();
            model.addAttribute("documents", documents);
            return "welcome_user";
        }
        
        return "login";
    }
    
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request){
        
        request.getSession().removeAttribute("ulogovan_superadmin");
        
        return new ModelAndView("login");
    }
    
    @RequestMapping("/logout_user")
    public ModelAndView logoutUser(HttpServletRequest request){
        
        
        request.getSession().removeAttribute("others");
        
        return new ModelAndView("login");
        
    }
    
    @RequestMapping("/logout_default")
    public ModelAndView logoutDefault(HttpServletRequest request){
        
        request.getSession().removeAttribute("default");
        
        return new ModelAndView("login");
    }
    
    //prikazuje stranu za dodavanje nove kompanije
    @RequestMapping(value = "/add_company", method = RequestMethod.GET)
    public ModelAndView addCompany(){
        return new ModelAndView("add_company");
    }
    
    //strana za dodavanje nove kompanije
    @RequestMapping(value = "/add_companyy", method = RequestMethod.POST)
    public ModelAndView addCompany(String name, String adress, String id_number){
        companyService.save(name, adress, id_number);
        List<Company> companies = companyService.getAll();
        
        return new ModelAndView("show_companies","companies",companies);
    }
    
    //strana prikauje sve kompanije
    @RequestMapping("/show_companies")
    public String showCompanies(@RequestParam(defaultValue = "1") Integer page, ModelMap model){
        List<Company> companies = companyService.findByPage(page - 1);
        model.addAttribute("companies", companies);
        Long totalCompanies = companyService.pages();
        model.addAttribute("totalCompanies", totalCompanies);
        
        
        
        return "show_companies";
    }
    
    @RequestMapping("/show_companies/{page}")
    public String choosePage(@RequestParam(defaultValue = "1") Integer page, ModelMap model){ 
        List<Company> companies = companyService.findByPage(page - 1);
        model.addAttribute("companies", companies);
        Long totalCompanies = companyService.pages();
        model.addAttribute("totalCompanies", totalCompanies);
        
        return "show_companies";
    }
    
    //prikazuje stranu za dodavanje novog user-a
    @RequestMapping("/add_user/{companyId}")
    public ModelAndView addUser(ModelMap model, @PathVariable int companyId){
        
        Company company = companyService.getById(companyId);
        List<Role> roles = roleService.getAll();
        model.addAttribute("roles", roles);
        return new ModelAndView("add_user","company", company);
    }
    
    @RequestMapping(value = "/add_user_default_get/{companyId}")
    public String add_user_default(ModelMap model, @PathVariable Integer companyId){
        Company company = companyService.getById(companyId);
        model.addAttribute("company", company);
        return "add_user_default";
    }
    
    @RequestMapping(value = "/add_user_default", method = RequestMethod.POST)
    public String saveUserDefault(String username, String password, String name, String surname, String email, @RequestParam(required = true) Integer companyId, ModelMap model){
        userService.saveUser(username, password, name, surname, email, companyId);
        Company company = companyService.getById(companyId);
        List<User> users = userService.getByCompany(companyId);
        model.addAttribute("users", users);
        model.addAttribute("company", company);
        return "show_users_default";
        
    }
    
    
    //metoda vrsi dodavanje novog user-a
    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public ModelAndView addUser(ModelMap model, String username, String password, String name, String surname, String email, @RequestParam(required = true) Integer companyId,@RequestParam(required = true) Integer roleId){
        userService.save(username, password, name, surname, email, companyId, roleId);
        Company company = companyService.getById(companyId);
        List<User> users = userService.getByCompany(companyId);
        model.addAttribute("company", company);
        model.addAttribute("users", users);
        return new ModelAndView("show_company");
    }
    
    
    
    @RequestMapping("/update_user/{userId}/{companyId}")
    public ModelAndView updateUser(@PathVariable int userId,@PathVariable int companyId,  ModelMap model){
        User user = userService.getById(userId);
        List<Role> roles = roleService.getAll();
        Company company = companyService.getById(companyId);
        model.addAttribute("company", company);
        model.addAttribute("roles", roles);
        return new ModelAndView("update_user", "user", user);
    }
    
   
    
    @RequestMapping("/update_user/{userId}")
    public ModelAndView updateUser(ModelMap model, @PathVariable int userId, String username, String password,
        String name, String surname, String email, @RequestParam(required = true) Integer companyId, @RequestParam(required = true) Integer roleId){
        userService.update(userId, username, password, name, surname, email, companyId, roleId);
        Company company = companyService.getById(companyId);
        model.addAttribute("company", company);
        List<User> users = userService.getByCompany(companyId);
        model.addAttribute("users", users);
        
        return showCompany(companyId, model);
    }
    
    @RequestMapping("/update_default_user/{userId}/{companyId}")
    public String updateDefaultUser(@PathVariable Integer userId, @PathVariable Integer companyId, ModelMap model){
        
        User user = userService.getById(userId);
        Company company = companyService.getById(companyId);
        model.addAttribute("user", user);
        model.addAttribute("company", company);
        return "update_default_user";
        
    }
    
    @RequestMapping("/update_default_user/{userId}")
    public String updateDefaultUser(String username, String password, String name, String surname, String email,
                                    @PathVariable Integer userId, @RequestParam (required = true) Integer companyId, ModelMap model){
        
        userService.updateDefaultUser(userId, username, password, name, surname, email, companyId);
        
        return showUsersDefault(model, companyId);
        
    }
    
    @RequestMapping("/delete_user/{userId}/{page}")
    public String deleteUser(@RequestParam(defaultValue = "1") Integer page, ModelMap model, @PathVariable Integer userId){
        userService.delete(userId);
        List<User> users = userService.findByPage(page-1);
        Long totalPages = userService.pages();
        model.addAttribute("users", users);
        model.addAttribute("totalPages", totalPages);
        
        return "show_users";
    }
    
    @RequestMapping("/delete_user_from_company/{userId}")
    public String deleteUserFromCompany(@PathVariable Integer userId, ModelMap model){
        User user = userService.getById(userId);
        Company company = companyService.getById(user.getCompanyId());
        userService.delete(userId);
        List<User> users = userService.getByCompany(company.getCompanyId());
        
        model.addAttribute("users", users);
        model.addAttribute("company", company);
        
        
        return "show_company"; 
         
    }
    
    @RequestMapping("/delete_default_user/{userId}")
    public String deleteDefaultUser(ModelMap model, @PathVariable Integer userId){
        User user = userService.getById(userId);
        Company company = companyService.getById(user.getCompanyId());
        userService.delete(userId);
        List<User> users = userService.getByCompany(company.getCompanyId());
        model.addAttribute("company", company);
        model.addAttribute("users", users);
        
        return "show_users_default";
    }
    
    
    @RequestMapping("/show_company/{companyId}")
    public ModelAndView showCompany(@PathVariable int companyId, ModelMap model){
        Company company = companyService.getById(companyId);
        List<User> users = userService.getByCompany(companyId);
        model.addAttribute("users", users);
        model.addAttribute("company", company);
        return new ModelAndView("show_company"); 
    }
    
    @RequestMapping("/edit_company/{companyId}")
    public ModelAndView editCompany(ModelMap model, @PathVariable int companyId){
        Company company = companyService.getById(companyId);
        List<User> users = userService.getByCompany(companyId);
        model.addAttribute("users", users);
        
        return new ModelAndView("edit_company","company", company);
    }
   
    @RequestMapping("/update_company/{companyId}")
    public ModelAndView editCompany1(ModelMap model, @PathVariable int companyId, String name, String adress, String idNumber){
        companyService.update(companyId, name, adress, idNumber);
        Company company = companyService.getById(companyId);
        List<User> users = userService.getByCompany(companyId);
        model.addAttribute("users", users);
       return new ModelAndView("show_company","company", company);
    }
    
    @RequestMapping("/delete_company/{companyId}")
    public ModelAndView deleteCompany(@PathVariable int companyId){
        companyService.delete(companyId);
        List<Company> companies = companyService.getAll();
        return new ModelAndView("show_companies","companies", companies); 
    }
    
    @RequestMapping("/search_company")
    public ModelAndView searchCompanies(ModelMap model, @RequestParam String name){
        Company c = companyService.search(name);
        model.addAttribute("c", c);
        return new ModelAndView("search_company");
    }
    
    @RequestMapping("/show_users")
    public ModelAndView showUsers(@RequestParam(defaultValue = "1") Integer page, ModelMap model){
        List<User> users = userService.findByPage(page-1);
        Long totalPages = userService.pages();
        model.addAttribute("users", users);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("page", page);
        return new ModelAndView("show_users");
    }
    
    @RequestMapping("/show_users/{currentPage}")
    public ModelAndView nextUsers(@RequestParam Integer currentPage, ModelMap model){
        List<User> users = userService.findByPage(currentPage+1);
        Long totalPages = userService.pages();
        model.addAttribute("users", users);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("page", currentPage);
        return new ModelAndView("show_users");
    }
    
    
    
    @RequestMapping("/show_users_default/{companyId}")
    public String showUsersDefault(ModelMap model, @PathVariable Integer companyId){
        
        List<User> users = userService.getByCompany(companyId);
        model.addAttribute("users", users);
        Company company = companyService.getById(companyId);
        model.addAttribute("company", company);
        
        return "show_users_default";
    }
    
    @RequestMapping("/search_users")
    public ModelAndView searchUsers(ModelMap model, @RequestParam String username){
   
        User user = userService.searchUser(username);
        model.addAttribute("user", user);
        return new ModelAndView("show_user");
    }
    
    @RequestMapping("add_document")
    public String add_document(Model model){
            
            List<Class> types = descriptorService.types();
            model.addAttribute("types", types);
        
        return "start_user";
    }
    
    @RequestMapping("/save_descriptor")
    public String saveDescriptor(HttpServletRequest request,
                                       @RequestParam (required = true) String mark, 
                                       @RequestParam (required = true) String name, 
                                       @RequestParam (required = true) String type,
                                       Model model){
        HttpSession session = request.getSession();
        List<Descriptor> descriptors;
        if(session.getAttribute("descriptors") == null){
            session.setAttribute("descriptors", new ArrayList<Descriptor>());
        }
        descriptors = (List<Descriptor>) session.getAttribute("descriptors");
        
        descriptorService.makeDescriptors(mark, name, type, descriptors);
        
        
        model.addAttribute("descriptors", descriptors);
        
        List<Class> types = descriptorService.types();
        model.addAttribute("types", types);
        
        return "start_user";
    }
    
    @RequestMapping(value = "/save_document_type", method = RequestMethod.POST)
    public String saveDocument(@RequestParam (required = true) String mark,
                               @RequestParam (required = true) String name,
                               @RequestParam (required = true) String description,
                               HttpServletRequest request,
                               Model model){
        
        HttpSession session = request.getSession();
        
        List<Descriptor> descriptors = (List<Descriptor>) session.getAttribute("descriptors");
        Integer id = documentService.saveDocument(mark, name, description);
        
        descriptorService.saveDescriptors(descriptors, id);
        
        List<Class> types = descriptorService.types();
        model.addAttribute("types", types);
        
        List<Document> documents = documentService.getAll();
        model.addAttribute("documents", documents);
        
        return "welcome_user";
        
    }
    
    @RequestMapping(value = "delete_document/{id}")
    public String deleteDocument(Model model, @PathVariable Integer id){
        documentService.deleteDocument(id);
        List<Document> documents = documentService.getAll();
        model.addAttribute("documents", documents);
        return "welcome_user";
    }
    
    @RequestMapping(value = "edit_document/{documentId}")
    public String editDocument(Model model, @PathVariable Integer documentId){
        Document document = documentService.getById(documentId);
        model.addAttribute("document", document);
        
        return "edit_document";
    }
    
   @RequestMapping(value = "save_doc_after_edit/{documentId}", method = RequestMethod.POST)
   public String saveDocAfterEdit(@PathVariable Integer documentId, @RequestParam String mark, @RequestParam String name, @RequestParam String description, Model model){
       documentService.editDocument(documentId, mark, name, description);
       Document document = documentService.getById(documentId);
       model.addAttribute("document", document);
       
       
       List<Descriptor> descriptors = descriptorService.getDescriptorsByDocument(documentId);
       
       
       model.addAttribute("descriptors", descriptors);
       
       List<Class> types = descriptorService.types();
        model.addAttribute("types", types);
       
       return "edit_descriptors";
   }
    
    @RequestMapping("delete_descriptor/{id}/{documentId}")
    public String deleteUpdateDescriptor(Model model , @PathVariable Integer id, @PathVariable Integer documentId){
        descriptorService.deleteDescriptor(id);
        
        Document document = documentService.getById(documentId);
        model.addAttribute("document", document);
        
        List<Descriptor> descriptors = descriptorService.getDescriptorsByDocument(documentId);
        model.addAttribute("descriptors", descriptors);
        
        return "edit_descriptors";
        
    }
    
    @RequestMapping("edit_descriptor/{id}/{documentId}")
    public String editDescriptor(@PathVariable Integer id, @PathVariable Integer documentId, Model model){
        Descriptor descriptor = descriptorService.getById(id);
        model.addAttribute("descriptor", descriptor);
        Document document = documentService.getById(documentId);
        model.addAttribute("document", document);
        List<Class> types = descriptorService.types();
        model.addAttribute("types", types);
        
        return "edit_descriptor";
    }
    
    
    @RequestMapping("save_desc_after_edit/{id}/{documentId}")
    public String saveDescAfterEdit(Model model, @PathVariable Integer documentId, @PathVariable Integer id, @RequestParam String mark, @RequestParam String name, @RequestParam String type){
        descriptorService.editDescriptor(id, mark, name, type);
        
        Document document = documentService.getById(documentId);
        model.addAttribute("document", document);
        
        List<Descriptor> descriptors = descriptorService.getDescriptorsByDocument(documentId);
        model.addAttribute("descriptors", descriptors);
        List<Class> types = descriptorService.types();
        model.addAttribute("types", types);
       
        
        return "edit_descriptors";
    }
    
    @RequestMapping("save_descriptor_after_edit/{id}/{document.documentId}")
    public String saveDescForCurrDoc(Model model, @PathVariable Integer id, @PathVariable Integer documentId, @RequestParam String mark, @RequestParam String name, @RequestParam String type){
        descriptorService.addDescriptor(mark, name, type, documentId);
        List<Class> types = descriptorService.types();
        model.addAttribute("types", types);
        Descriptor descriptor = descriptorService.getById(id);
        model.addAttribute("descriptor", descriptor);
        List<Descriptor> descriptors = descriptorService.getDescriptorsByDocument(documentId);
        model.addAttribute("descriptors", descriptors);
        Document document = documentService.getById(documentId);
        model.addAttribute("document", document);
        System.out.println(types);
        return "edit_descriptors";
    }
    
    @RequestMapping("add_new_descriptor/{documentId}")
    public String addNewDescriptor(@PathVariable Integer documentId, @RequestParam String mark, @RequestParam String name, @RequestParam String type,
                                    Model model){
        descriptorService.addDescriptor(mark, name, type, documentId);
        
        List<Descriptor> descriptors = descriptorService.getDescriptorsByDocument(documentId);
        model.addAttribute("descriptors", descriptors);
        
        Document document = documentService.getById(documentId);
        model.addAttribute("document", document);
        
        List<Class> types = descriptorService.types();
        model.addAttribute("types", types);
        
        return "edit_descriptors";
        
    }
    
    @RequestMapping("show_documents")
    public String showDocuments(Model model){
        List<Document> documents = documentService.getAll();
        model.addAttribute("documents", documents);
        
        
        return "show_documents";
    }
    
    
    @RequestMapping("documents_of_type")
    public String listDocuments(Model model){
        List<Document> documentTypes = documentService.getAll();
        model.addAttribute("documentTypes", documentTypes);
        
        return "document_types";
    }
    
    
    
     
     
    
    
  
    

}
