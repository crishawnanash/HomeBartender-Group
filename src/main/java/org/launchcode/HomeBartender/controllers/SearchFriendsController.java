package org.launchcode.HomeBartender.controllers;

import org.launchcode.HomeBartender.data.UserRepository;
import org.launchcode.HomeBartender.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("searchFriends")
public class SearchFriendsController {

    @Autowired
    UserRepository userRepository;

    private String friendName;

    private ArrayList<User> userFriends = new ArrayList<>();

    @GetMapping("")
    public String search(Model model){
//        model.addAttribute("name", userRepository.findAll());
        model.addAttribute("friendName", friendName);
        return "friends/search";
    }

    @PostMapping("results")
    public String displaySearchFriendsResults(Model model, @RequestParam String friendName){
        Iterable<User> usersList;
        usersList = userRepository.findAll();

        for(User userFriend: usersList){
            if(friendName.toLowerCase().equals(userFriend.getUserName().toLowerCase())){
                userFriends.add(userFriend);
            }
//            if(friendName.toLowerCase() != friend.getUserName()){
//                return ""
//            }
            if(friendName.isBlank()){
                return "redirect: /searchFriends";
            }
        }
//        if(friendName.toLowerCase().equals("searchTerm")){
//            for(User friend : friendsList) {
//                friends.add(friend);
//            }
//            model.addAttribute("friends", friends);
//            return "friends/results";
//        }
//        else{
//            user = User.findByValue(searchTerm, userRepository.findAll());
//        }


        model.addAttribute("userFriends", userFriends);
        return "friends/results";
    }
}
