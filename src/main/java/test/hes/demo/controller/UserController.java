package test.hes.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import test.hes.demo.entity.UserAccount;
import test.hes.demo.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/list")
    public ModelAndView listAllUsers (
                                        ModelAndView modelAndView
    ) {
        modelAndView.addObject("userLIst", userService.getAll());
        modelAndView.setViewName("list");
        return modelAndView;
    }

    @GetMapping(path = "/view/{id}")
    public ModelAndView viewUserDetails (
                                        @PathVariable("id") long id,
                                        ModelAndView modelAndView
    ) {
        modelAndView.addObject("userById", userService.getUserById(id));
        modelAndView.setViewName("view");
        return modelAndView;
    }

    @GetMapping(path = "/new")
    public ModelAndView createNewUserGet (
//                                          @ModelAttribute("newUser") UserAccount userAccount,
                                            ModelAndView modelAndView
    ) {
        modelAndView.addObject("newUser", new UserAccount());
        modelAndView.setViewName("new");
        return modelAndView;
    }

    @PostMapping(path = "/new")
    public ModelAndView createNewUserPost (
                                            @ModelAttribute("newUser") @Valid UserAccount userAccount,
                                            BindingResult bindingResult,
                                            ModelAndView modelAndView
    ) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("new");
        } else {
            userService.createUser(userAccount);
            modelAndView.setViewName("redirect:/user/view/" + userAccount.getId());
        }
        return modelAndView;
    }

    @GetMapping(path = "/edit/{id}")
    public ModelAndView showEditUserPage (
                                    @PathVariable("id") Long id,
                                    ModelAndView modelAndView
    ) {
        modelAndView.addObject("editUser", userService.getUserById(id));
        modelAndView.addObject("editableUser", new UserAccount());
        modelAndView.setViewName("edit");
        return modelAndView;
    }


    @PostMapping(path = "/edit/{id}")
    public ModelAndView updateUser (
                                @PathVariable("id") Long id,
                                @ModelAttribute("editableUser") @Valid UserAccount editableUser,
                                BindingResult bindingResult,
                                ModelAndView modelAndView
    ) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("/user/view/" + id);
        } else {
            modelAndView.setViewName("redirect:/user/list");
            userService.updateUserById(id, editableUser);
        }
        return modelAndView;
    }


}
