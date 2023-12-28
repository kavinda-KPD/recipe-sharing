package com.kpd.recipesharing.Controllers;

import com.kpd.recipesharing.Models.Recipe;
import com.kpd.recipesharing.Models.User;
import com.kpd.recipesharing.Repositories.UserRepository;
import com.kpd.recipesharing.Services.RecipeService;
import com.kpd.recipesharing.Services.UserService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public Recipe createRecipe(@RequestBody Recipe recipe, @RequestHeader("Authorization")String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);

        return recipeService.createRecipe(recipe,user);
    }

    @GetMapping(path = "")
    public List<Recipe> findAllRecipe() throws Exception {

        return recipeService.findAllRecipe();
    }

    @DeleteMapping(path = "/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) throws Exception {

        recipeService.deleteRecipe(recipeId);

        return "recipe Deleted Successfully";
    }

    @PutMapping(path = "/{recipeId}")
    public Recipe updateRecipe(@RequestBody Recipe recipe,@PathVariable Long recipeId) throws Exception {

        return recipeService.updateRecipe(recipe,recipeId);

    }

    @PutMapping(path = "/{recipeId}/like")
    public Recipe likeRecipe(@PathVariable Long recipeId, @RequestHeader("Authorization")String jwt) throws Exception {

        User user = userService.findUserByJwt(jwt);

        return recipeService.likeRecipe(recipeId,user);

    }
}
