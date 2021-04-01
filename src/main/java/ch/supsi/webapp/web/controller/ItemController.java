package ch.supsi.webapp.web.controller;

import ch.supsi.webapp.web.model.Author;
import ch.supsi.webapp.web.model.Item;
import ch.supsi.webapp.web.service.impl.AuthorService;
import ch.supsi.webapp.web.service.impl.ItemService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.util.Date;
import java.util.stream.Collectors;


@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private AuthorService authorService;

    @PostMapping(value = "/item/new")
    public String postItem(Item item){
        itemService.add(item);
        return "redirect:/";
    }
    @PutMapping(value = "/item/new")
    public String putItem(Item item){
        itemService.add(item);
        return "redirect:/";
    }
    @GetMapping(value="/item/new")
    public String newItem(@ModelAttribute("item") Item item, Model model){
        model.addAttribute("authors", authorService.getAll());
        model.addAttribute("editMode", false);
        item.setDate(Date.from(Instant.now()));
        return "createItemForm";
    }

    @GetMapping
    public String get(Model model){
        final var all=itemService.getAll();
        final var first3= all.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("items",first3);
        return "index";
    }


    @GetMapping(value="item/{id}/delete")
    public String deleteItem(@PathVariable int id, HttpServletResponse response){
        final var item=itemService.get(id);
        if(item==null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        itemService.delete(id);
        return "redirect:/";
    }

    @GetMapping(value="/item/{id}/edit")
    public String editItem(@PathVariable int id,Model model,  HttpServletResponse response){
        final var item=itemService.get(id).get();
        if(item==null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        model.addAttribute("editMode", true);
        model.addAttribute("item", item);
        model.addAttribute("authors", authorService.getAll());
        item.setAuthor(new Author());
        return "createItemForm";
    }

    @PutMapping(value="item/{id}/edit")
    public String putItem(@PathVariable int id,Item item, HttpServletResponse response){
        final var oldItem=itemService.get(id).get();
        if(oldItem==null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        oldItem.setTitle(item.getTitle());
        oldItem.setDescription(item.getDescription());
        oldItem.setCategory(item.getCategory());
        oldItem.setAuthor(item.getAuthor());
        oldItem.setDate(item.getDate());
        oldItem.setType(item.getType());
        itemService.add(oldItem);
        return "redirect:/";
    }

    @GetMapping(value="item/{id}")
    public String getItem(@PathVariable int id, Model model, HttpServletResponse response){
        final var item=itemService.get(id);
        if(item==null)
            response.setStatus(HttpStatus.NOT_FOUND.value());
        model.addAttribute("item", item.get());
        model.addAttribute("editMode", false);
        return "item1Details";
    }

//    @PatchMapping(value="item/{id}")
//    public ResponseEntity patchItem(@RequestBody Item updatedItem, @PathVariable int id){
//        final var item=itemService.get(id).get();
//        if(item==null)
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        item.setAuthor(updatedItem.getAuthor()==null?item.getAuthor():updatedItem.getAuthor());
//        item.setDescription(updatedItem.getDescription()==null?item.getDescription():updatedItem.getDescription());
//        item.setTitle(updatedItem.getTitle()==null?item.getTitle():updatedItem.getTitle());
//        item.setCategory(updatedItem.getCategory()==null?item.getCategory():updatedItem.getCategory());
//        itemService.add(item);
//        return new ResponseEntity(item, HttpStatus.ACCEPTED);
//    }
}
